package pay.controller;


//import cn.cn.cn.dao.order.OrderDao;
//import cn.entity.Order;

import cn.entity.OrderInfo;

import cn.mapper2.OrderInfoDao;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import unionpay.acp.sdk.AcpService;
import unionpay.acp.sdk.LogUtil;
import unionpay.acp.sdk.SDKConstants;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

@RestController
public class NotifyUrlController {
    /**
     * 后台异步通知路径
     * @param req
     * @return
     */
    @Resource
    OrderInfoDao orderDao;
    @PostMapping("/pay/notifyurl")
    public ResponseEntity<Object> back(HttpServletRequest req){

        LogUtil.writeLog("BackRcvResponse接收后台通知开始");
        String encoding = req.getParameter(SDKConstants.param_encoding);

        // 获取银联通知服务器发送的后台通知参数
        Map<String, String> reqParam = getAllRequestParam(req);

        Map<String, String> valideData = null;
        if (null != reqParam && !reqParam.isEmpty()) {

            Iterator<Map.Entry<String, String>> it = reqParam.entrySet().iterator();
            valideData = new HashMap<String, String>(reqParam.size());

            while (it.hasNext()) {

                Map.Entry<String, String> e = it.next();
                String key = (String) e.getKey();
                String value = (String) e.getValue();
                valideData.put(key, value);
            }
        }

        //重要！验证签名前不要修改reqParam中的键值对的内容，否则会验签不过
        if (!AcpService.validate(valideData, encoding)) {
            LogUtil.writeLog("验证签名结果[失败].");

            //验签失败，需解决验签问题
        } else {
            LogUtil.writeLog("验证签名结果[成功].");

            //【注：为了安全验签成功才应该写商户的成功处理逻辑】交易成功，更新商户订单状态
            System.out.println("1111111111111111111111111111111111111111111111111111111111111支付成功");


            String orderId =valideData.get("orderId"); //获取后台通知的数据，其他字段也可用类似方式获取
            String respCode = valideData.get("respCode");

            OrderInfo order = new OrderInfo();
            order.setOrderNo(Long.valueOf(orderId));//订单号
            List<OrderInfo> orderList = orderDao.queryAll(order);
            order.setOrderStatus(2);
            order.setPayTime(new Date());
            order.setPayType(3);
            order.setPayno(orderId);
            order.setId(orderList.get(0).getId());
            System.out.println(orderList.get(0).getId());
            orderDao.update(order);

            System.out.println(orderId+respCode);
        }

        LogUtil.writeLog("BackRcvResponse接收后台通知结束");

        //返回给银联服务器http 200  状态码
        return new ResponseEntity<Object>(HttpStatus.OK);
    }

    /**
     * 获取参数集合
     * @param request
     * @return
     */
    public static Map<String, String> getAllRequestParam(
            final HttpServletRequest request) {
        Map<String, String> res = new HashMap<String, String>();
        Enumeration<?> temp = request.getParameterNames();
        if (null != temp) {
            while (temp.hasMoreElements()) {
                String en = (String) temp.nextElement();
                String value = request.getParameter(en);
                res.put(en, value);
                // 在报文上送时，如果字段的值为空，则不上送<下面的处理为在获取所有参数数据时，判断若值为空，则删除这个字段>
                if (res.get(en) == null || "".equals(res.get(en))) {
                    // System.out.println("======为空的字段名===="+en);
                    res.remove(en);
                }
            }
        }
        return res;
    }

}
