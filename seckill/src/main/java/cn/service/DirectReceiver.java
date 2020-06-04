package cn.service;


import cn.config.RedisApi;
import cn.entity.Curriculum;
import cn.entity.OrderInfo;
import cn.mapper2.OrderInfoDao;
import cn.util.DateUtil;
import cn.util.MD5;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.text.ParseException;
import java.util.Date;

@Component
public class DirectReceiver {

    @Resource
    RedisApi redisApi;

    @Resource
    OrderInfoDao orderInfoDao;

    @RabbitListener(queues = "hello-queue")
    public void handerl(Curriculum curriculum) throws ParseException {
        Integer nums =Integer.parseInt(redisApi.get(curriculum.getId().toString()))-1;
        redisApi.set(curriculum.getId().toString(),1000,nums.toString());
        OrderInfo order = new OrderInfo();
//        StringBuilder builder = new StringBuilder();//生成订单号
//        try {
//            builder.append(DateUtil.format(new Date(),"yyyyMMddHHmmss"));
//            builder.append(MD5.getMd5(builder.toString(),6));
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
        StringBuilder orderNo = new StringBuilder();
        StringBuilder random=new StringBuilder();
        random.append(Math.random() * 1000000);
        orderNo.append(DateUtil.format(new Date(), "yyyyMMddHHmmss"));
        orderNo.append(MD5.getRandomCode());
        order.setOrderNo(Long.valueOf(orderNo.toString()));
        order.setPricePaid(new Double(curriculum.getCurriculumprice()));
        order.setGmtCreate(new Date());
        order.setOrderStatus(1);
        order.setCourseName(curriculum.getCurriculumname());
        order.setUserNo(Long.valueOf(curriculum.getUserId()));
        order.setCourseId(Long.valueOf(curriculum.getId()));
        order.setPriceDiscount(new Double(curriculum.getCurriculumprice()));
        order.setPricePayable(new Double(curriculum.getCurriculumprice()));
        System.out.println("消息::::::::::::::::"+curriculum.getCurriculumprice());
        int num = orderInfoDao.insert(order);
        if(num>0){
            System.out.println("抢购成功");
        }else{
            System.out.println("抢购失败");
        }
    }
}
