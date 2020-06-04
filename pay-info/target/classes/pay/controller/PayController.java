package pay.controller;

//import cn.cn.cn.dao.order.OrderDao;
//import cn.entity.Order;

import cn.entity.OrderInfo;

import cn.mapper2.OrderInfoDao;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pay.config.AlipayConfig;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.*;

@Controller
public class PayController {

    @Resource
    AlipayConfig alipayConfig;
    @Resource
    OrderInfoDao orderInfoDao;
    //订单确认
    @RequestMapping(value = "/pay/prepay/{orderNo}",method = RequestMethod.GET)
    public ModelAndView  prePay(@PathVariable String orderNo, ModelMap model){
        ModelAndView mv = new ModelAndView();
        try{
            OrderInfo orderInfo=new OrderInfo();
            orderInfo.setOrderNo(Long.valueOf(orderNo));
            System.out.println(Long.valueOf(orderNo));
                List<OrderInfo> orderList = orderInfoDao.queryAll(orderInfo);
            System.out.println(orderList.size());
                if(orderList.size()>0){
                    mv.addObject("orderNo",orderNo);
                    mv.addObject("orderPrice",orderList.get(0).getPricePaid());
                    mv.addObject("curricName",orderList.get(0).getCourseName());
                    System.out.println(orderList.get(0).getPricePaid());
                    mv.setViewName("pay");
                }else{
                    mv.setViewName("error");
                }
        }catch (Exception e){
            e.printStackTrace();
            mv.setViewName("error");
        }
        return mv;
    }
    @RequestMapping(value = "/pay/success")
    public ModelAndView success(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("success");
        return mv;
    }
    @RequestMapping(value = "/pay/failure")
    public ModelAndView failure(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("failure");
        return mv;
    }
    @RequestMapping(value = "/pay/index")
    public ModelAndView index(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        return mv;
    }
    @RequestMapping(value = "/pay/union")
    public ModelAndView union(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("union");
        return mv;
    }
    @RequestMapping(value = "/pay/pays",method = RequestMethod.POST)
    public void payController(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(alipayConfig.getURL(), alipayConfig.getAPPID(), alipayConfig.getRSA_PRIVATE_KEY(),alipayConfig.getFORMAT(), alipayConfig.getCHARSET(), alipayConfig.getALIPAY_PUBLIC_KEY(), alipayConfig.getSIGNTYPE());

        //设置请求参数
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl(alipayConfig.getReturn_url());
        alipayRequest.setNotifyUrl(alipayConfig.getNotify_url());

        //商户订单号，商户网站订单系统中唯一订单号，必填
        String out_trade_no = new String(request.getParameter("WIDout_trade_no").getBytes("ISO-8859-1"),"UTF-8");
        //付款金额，必填
        String total_amount = new String(request.getParameter("WIDtotal_amount").getBytes("ISO-8859-1"),"UTF-8");
        //订单名称，必填
        String subject = new String(request.getParameter("WIDsubject"));
        //商品描述，可空
        String body = new String("1");

        alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","
                + "\"total_amount\":\""+ total_amount +"\","
                + "\"subject\":\""+ subject +"\","
                + "\"body\":\""+ body +"\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");

        //若想给BizContent增加其他可选请求参数，以增加自定义超时时间参数timeout_express来举例说明
        //alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","
        //		+ "\"total_amount\":\""+ total_amount +"\","
        //		+ "\"subject\":\""+ subject +"\","
        //		+ "\"body\":\""+ body +"\","
        //		+ "\"timeout_express\":\"10m\","
        //		+ "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
        //请求参数可查阅【电脑网站支付的API文档-alipay.trade.page.pay-请求参数】章节

        //请求
        String form="";
        try {
            form = alipayClient.pageExecute(alipayRequest).getBody(); //调用SDK生成表单
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        response.setContentType("text/html;charset=" + alipayConfig.getCHARSET());
        response.getWriter().write(form);//直接将完整的表单html输出到页面
        response.getWriter().flush();
        response.getWriter().close();
    }

    //支付宝回调
    @RequestMapping(value = "/pay/notify",method = RequestMethod.POST)
    public void notify(HttpServletRequest request,HttpServletResponse response) throws IOException, AlipayApiException {
        //获取支付宝POST过来反馈信息
        Map<String,String> params = new HashMap<String,String>();
        Map requestParams = request.getParameterMap();
        for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }
            //乱码解决，这段代码在出现乱码时使用。如果mysign和sign不相等也可以使用这段代码转化
            //valueStr = new String(valueStr.getBytes("ISO-8859-1"), "gbk");
            params.put(name, valueStr);
        }
        //获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以下仅供参考)//
        //商户订单号

        String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"),"UTF-8");
        //支付宝交易号

        String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"),"UTF-8");

        //交易状态
        String trade_status = new String(request.getParameter("trade_status").getBytes("ISO-8859-1"),"UTF-8");

        //获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以上仅供参考)//
        //计算得出通知验证结果
        //boolean AlipaySignature.rsaCheckV1(Map<String, String> params, String publicKey, String charset, String sign_type)
        boolean verify_result = AlipaySignature.rsaCheckV1(params, alipayConfig.getALIPAY_PUBLIC_KEY(), alipayConfig.getCHARSET(), "RSA2");

        if(verify_result){//验证成功
            //////////////////////////////////////////////////////////////////////////////////////////
            //请在这里加上商户的业务逻辑程序代码

            //——请根据您的业务逻辑来编写程序（以下代码仅作参考）——

            if(trade_status.equals("TRADE_FINISHED")){
                //判断该笔订单是否在商户网站中已经做过处理
                //如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
                //请务必判断请求时的total_fee、seller_id与通知时获取的total_fee、seller_id为一致的
                //如果有做过处理，不执行商户的业务程序
                try {
                    OrderInfo order = new OrderInfo();
                    order.setOrderNo(Long.valueOf(out_trade_no));//订单号
                    List<OrderInfo>orderList = orderInfoDao.queryAll(order);
                    order.setOrderStatus(2);
                    order.setPayTime(new Date());
                    order.setPayType(2);
                    order.setPayno(trade_no);
                    order.setId(orderList.get(0).getId());
                    orderInfoDao.update(order);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                //注意：
                //如果签约的是可退款协议，退款日期超过可退款期限后（如三个月可退款），支付宝系统发送该交易状态通知
                //如果没有签约可退款协议，那么付款完成后，支付宝系统发送该交易状态通知。
            } else if (trade_status.equals("TRADE_SUCCESS")){
                //判断该笔订单是否在商户网站中已经做过处理
                //如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
                //请务必判断请求时的total_fee、seller_id与通知时获取的total_fee、seller_id为一致的
                //如果有做过处理，不执行商户的业务程序
                try {
                    OrderInfo order = new OrderInfo();
                    order.setOrderNo(Long.valueOf(out_trade_no));//订单号
                    List<OrderInfo>orderList = orderInfoDao.queryAll(order);
                    order.setOrderStatus(2);
                    order.setPayTime(new Date());
                    order.setPayType(2);
                    order.setPayno(trade_no);

                    order.setId(orderList.get(0).getId());
                    orderInfoDao.update(order);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                //注意：
                //如果签约的是可退款协议，那么付款完成后，支付宝系统发送该交易状态通知。
            }

            //——请根据您的业务逻辑来编写程序（以上代码仅作参考）——
            response.getWriter().println("success");	//请不要修改或删除

            //////////////////////////////////////////////////////////////////////////////////////////
        }else{//验证失败
            try {
                OrderInfo order = new OrderInfo();
                order.setOrderNo(Long.valueOf(out_trade_no));//订单号
                List<OrderInfo>orderList = orderInfoDao.queryAll(order);
                order.setOrderStatus(3);
                order.setPayTime(new Date());
                order.setPayType(2);
                order.setId(orderList.get(0).getId());
                orderInfoDao.update(order);
            } catch (Exception e) {
                e.printStackTrace();
            }
            response.getWriter().println("fail");
        }
    }
    //
    @RequestMapping(value = "/pay/returnUrl",method = RequestMethod.GET)
    public void returnUrl(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException {
        //获取支付宝GET过来反馈信息
        try {
            Map<String,String> params = new HashMap<String,String>();
            Map requestParams = request.getParameterMap();
            for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
                String name = (String) iter.next();
                String[] values = (String[]) requestParams.get(name);
                String valueStr = "";
                for (int i = 0; i < values.length; i++) {
                    valueStr = (i == values.length - 1) ? valueStr + values[i]
                            : valueStr + values[i] + ",";
                }
                //乱码解决，这段代码在出现乱码时使用。如果mysign和sign不相等也可以使用这段代码转化
                valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
                params.put(name, valueStr);
            }

            //获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以下仅供参考)//
            //商户订单号

            String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"),"UTF-8");

            //支付宝交易号

            String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"),"UTF-8");

            //获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以上仅供参考)//
            //计算得出通知验证结果
            //boolean AlipaySignature.rsaCheckV1(Map<String, String> params, String publicKey, String charset, String sign_type)
            boolean verify_result = AlipaySignature.rsaCheckV1(params, alipayConfig.getALIPAY_PUBLIC_KEY(), alipayConfig.getCHARSET(), "RSA2");

            if(verify_result){//验证成功
                //////////////////////////////////////////////////////////////////////////////////////////
                //请在这里加上商户的业务逻辑程序代码
                //该页面可做页面美工编辑

                response.sendRedirect(alipayConfig.getPaymentSuccessUrl());

                //——请根据您的业务逻辑来编写程序（以上代码仅作参考）——

                //////////////////////////////////////////////////////////////////////////////////////////
            }else{
                //该页面可做页面美工编辑
                response.sendRedirect(alipayConfig.getPaymentFailureUrl());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
