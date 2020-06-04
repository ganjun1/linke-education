/*
package pay.controller;


import cn.dao.OrderInfoMapper;
import cn.dao.OrderPayDao;
import cn.entity.OrderInfo;
import cn.entity.OrderPay;
import cn.pay.config.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

*/
/*
微信
 *//*

@Controller
public class WxPayController {

    @Resource
    OrderInfoMapper orderDao;

    private String trade_no;

    //生成微信支付二维码
    @RequestMapping(value = "/pay/createCode/{orderNo}",method = RequestMethod.GET)
    @ResponseBody
    public Dto createCode(@PathVariable String orderNo) throws Exception {

        //查询订单
        OrderInfo order = new OrderInfo();
        order.setOrderNo(orderNo);//订单号
        System.out.println(orderNo);
        List<OrderInfo>orderList = orderDao.queryAll(order);
        System.out.println(orderList+"---");
        System.out.println("调用方法");

        //1.构造参数
        Map<String,String> data = new HashMap<String,String>();
        data.put("body",orderList.get(0).getCourseName());
        System.out.println(orderList.get(0).getCourseName());
        data.put("trade_type","NATIVE");
        float price = 1;
        data.put("total_fee","1");
        data.put("appid","wx171686d5566aae60");
        data.put("mch_id","1510700851");
        data.put("sign_type","MD5");
        data.put("sign","");
        data.put("fee_type","CNY");
        data.put("notify_url","http://ganjun.wezoz.com/notifys");
        data.put("out_trade_no",orderNo);
        data.put("nonce_str",String.valueOf(System.currentTimeMillis()));
        data.put("spbill_create_ip","127.0.0.1");
        try{
            //2.转成XML请求微信平台
            String requestXml = WXPayUtil.generateSignedXml(data,"yueyanghainaruanjiankeji86055555", WXPayConstants.SignType.MD5);

            //3.请求微信支付平台获取预支付交易链接(url=同一下单URL)
            String responseXml = WXPayRequest.requestWx("https://api.mch.weixin.qq.com/pay/unifiedorder",requestXml);
            //XML转换未map
            Map<String,String> resultMap = WXPayUtil.xmlToMap(responseXml);
            if(resultMap.get("return_code").equals("SUCCESS") && resultMap.get("result_code").equals("SUCCESS")){
                Map<String,String> result = new HashMap<String, String>();
                result.put("code_url",resultMap.get("code_url"));
                System.out.println("成功");
                trade_no = resultMap.get("prepay_id");//获取订单号
                System.out.println(":::::::"+DtoUtil.returnDataSuccess(result));
                return DtoUtil.returnDataSuccess(result);
            }else{
                System.out.println("出错------"+resultMap.get("return_msg"));
                return DtoUtil.returnFail(resultMap.get("return_msg"),"100002");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        //3.获取Code_url
        return DtoUtil.returnFail("发生错误" , "1000");
    }

    //接收微信的异步通知
    @RequestMapping("/pay/notifys")
    public void wxNotify(HttpServletRequest request , HttpServletResponse response){
        //从request获取XML流 转换为MAP数据
        System.out.println("成功被调用");
        try{
            //接收数据
            StringBuffer sb = new StringBuffer();

            InputStream inputStream = request.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream , "UTF-8"));
            String temp;
            while ((temp=reader.readLine()) != null){
                sb.append(temp);
            }
            reader.close();
            inputStream.close();

            //转化成map
            Map<String , String > resultMap = WXPayUtil.xmlToMap(sb.toString());
            //验证是否合法
            Boolean flag = WXPayUtil.isSignatureValid(resultMap , "yueyanghainaruanjiankeji86055555" , WXPayConstants.SignType.MD5);
            if(flag){
                System.out.println("签名验证成功");
                //当前支付状态是否成功
                if(resultMap.get("return_code").equals("SUCCESS") && resultMap.get("result_code").equals("SUCCESS")){
                    System.out.println("订单支付成功");
                    String out_trade_no = resultMap.get("out_trade_no");//获取订单号

                    OrderInfo order = new OrderInfo();
                    order.setOrderNo(out_trade_no);//订单号
                    List<OrderInfo> orderList = orderDao.queryAll(order);
                    order.setOrderStatus(2);
                    order.setPayTime(new Date());
                    order.setPayType(1);
                    order.setPayno(trade_no);
                    order.setId(orderList.get(0).getId());
                    orderDao.update(order);
                }
            }

        } catch (Exception e){
            e.printStackTrace();
        } finally {
            System.out.println("成功返回数据");
            Map<String , String > map = new HashMap<>();
            map.put("return_code" , "success");
            map.put("return_msg" , "success");

            try{
                String mapXml = WXPayUtil.generateSignedXml(map , "yueyanghainaruanjiankeji86055555");

                //返回数据
                response.getWriter().write(mapXml);
                response.getWriter().flush();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    //查询订单状态
    @RequestMapping(value = "/pay/queryOrderStatus/{orderNo}" , method = RequestMethod.GET)
    @ResponseBody
    public Dto queryOrderStatus(@PathVariable String orderNo){
        try{
            //查询订单
            OrderInfo order = new OrderInfo();
            order.setOrderNo(orderNo);//订单号
            List<OrderInfo> orderList = orderDao.queryAll(order);
            System.out.println(orderList);
            if(Integer.valueOf(orderList.get(0).getOrderStatus().toString())!=2){
                System.out.println(orderList.get(0).getOrderStatus());
                orderList=null;
            }
            return DtoUtil.returnDataSuccess(orderList.get(0));
        }catch (Exception e){
            e.printStackTrace();
        }

        return DtoUtil.returnFail("查询失败" , ErrorCode.AUTH_UNKNOWN);
    }

}
*/
