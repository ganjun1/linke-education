package cn.controller;

import cn.aop.MyLog;
import cn.entity.OrderInfo;
import cn.entity.User;
import cn.service.OrderInfoService;
import cn.util.DateUtil;
import cn.util.Dto;
import cn.util.DtoUtil;
import cn.util.MD5;
import cn.util.error.ErrorCode;
import cn.vo.AddOrderInfoVo;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 订单信息表(OrderInfo)表控制层
 *
 * @author makejava
 * @since 2020-05-14 15:46:41
 */
@RestController
@RequestMapping("user/orderInfo")
@Api(description = "订单管理",value = "OrderInfoController")
public class OrderInfoController {
    /**
     * 服务对象
     */
    @Resource
    private OrderInfoService orderInfoService;

    @Resource
    StringRedisTemplate stringRedisTemplate;
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @ApiOperation(value="根据id查询订单",httpMethod = "GET")
    //登录映射
    @MyLog(value = "根据id查询订单")
    @GetMapping("selectOne")
    public OrderInfo selectOne(Long id) {
        return this.orderInfoService.queryById(id);
    }

//    @PostMapping("/insertOrderInfo")
//    @ApiOperation(value ="插入一个新订单信息",notes = "使用json 格式返回发送状态")
//    public Dto insertLecturer(AddOrderInfoVo addOrderInfoVo) throws ParseException {
//        ordernum.add(0);
//        orderlist.add(addOrderInfoVo.getOrderNo().toString());
//        addOrderInfoVo.setGmtCreate(new Date());
//        int num=orderInfoService.insert(addOrderInfoVo);
//        if(num>0){
//            return DtoUtil.returnSuccess("插入订单信息成功！");
//        }else{
//            return DtoUtil.returnFail("插入订单信息失败！", ErrorCode.AUTH_UNKNOWN);
//        }
//    }

    @PostMapping(value = "/insertorderinfo",produces = "application/json",headers = "token")
    @ApiOperation(value ="根据信息新增订单",notes = "使用json 格式返回发送状态")
    public Dto insertorderinfo(AddOrderInfoVo addOrderInfoVo, HttpServletRequest request) throws ParseException {
        try{
            String token=request.getHeader("token");
            if(null==token){
                return DtoUtil.returnFail("请先登陆", ErrorCode.AUTH_UNKNOWN);
            }
            ValueOperations<String, String> ops1 = stringRedisTemplate.opsForValue();
            String userjson=ops1.get(token);
            User user=new User();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date start = sdf.parse(sdf.format(new Date()));
            addOrderInfoVo.setGmtCreate(start);
            addOrderInfoVo.setOrderStatus(1);
            StringBuilder orderNo = new StringBuilder();
            StringBuilder random=new StringBuilder();
            random.append(Math.random() * 1000000);
            orderNo.append(DateUtil.format(new Date(), "yyyyMMddHHmmss"));
            orderNo.append(MD5.getRandomCode());
            addOrderInfoVo.setOrderNo(Long.valueOf(orderNo.toString()));
            addOrderInfoVo.setUserNo(user.getUserNo());
            addOrderInfoVo.setMobile(user.getMobile());
            int num=0;
            try{
                num=orderInfoService.insert(addOrderInfoVo);
                if(num>0)
                {
                    orderlist.add(orderNo.toString());
                    ordernum.add(0);
                    return DtoUtil.returnSuccess("订单添加成功,订单号为+"+orderNo.toString());
                }else{
                    return DtoUtil.returnFail("订单添加失败！", ErrorCode.AUTH_UNKNOWN);
                }
            }catch (Exception e){
                e.printStackTrace();
                return DtoUtil.returnFail("订单添加失败！", ErrorCode.AUTH_UNKNOWN);
            }
        }catch (Exception e){
            e.printStackTrace();
            return DtoUtil.returnFail("订单添加失败！", ErrorCode.AUTH_UNKNOWN);
        }

    }






    @DeleteMapping("/deleteOrderInfo")
    @ApiOperation(value ="根据id删除一个订单信息",notes = "使用json 格式返回发送状态")
    public Dto deleteLecturer(String id){
        Boolean num=orderInfoService.deleteById(Long.valueOf(id));
        if(num){
            return DtoUtil.returnSuccess("删除订单信息成功！");
        }else{
            return DtoUtil.returnFail("删除订单信息失败！", ErrorCode.AUTH_UNKNOWN);
        }
    }
    @PostMapping("/updateOrderInfo")
    @ApiOperation(value ="根据对象修改一个订单信息",notes = "使用json 格式返回发送状态")
    public Dto updateLecturer(OrderInfo orderInfo) throws ParseException {
        orderInfo.setGmtModified(new Date());
        OrderInfo orderInfo1=orderInfoService.update(orderInfo);
        if(orderInfo1!=null){
            return DtoUtil.returnSuccess("修改订单信息成功！");
        }else{
            return DtoUtil.returnFail("修改订单信息失败！", ErrorCode.AUTH_UNKNOWN);
        }
    }
    @GetMapping("/getAllOrderInfo")
    @ApiOperation(value ="根据对象条件获取订单信息",notes = "使用json 格式返回发送状态")
    public Dto getAllLecturer(OrderInfo orderInfo){
        List<OrderInfo> orderInfos=orderInfoService.queryAll(orderInfo);
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("msg",orderInfos);
        return DtoUtil.returnDataSuccess(jsonObject);
    }

    //订单号循坏次数
    private  int num=0;
    //订单号次数
    private List<Integer> ordernum=new ArrayList<Integer>();
    //订单号
    private List<String> orderlist=new ArrayList<String>();
    @Scheduled(fixedRate = 30000)
    public void flushCancelOrderStatus() {
        try{
            for(int i=0;i<orderlist.size();i++){
                System.err.println("当前循坏订单为"+orderlist.get(i)+"当前循坏次数为"+ordernum.get(i));
                ordernum.set(i,ordernum.get(i)+1);
                if(ordernum.get(i)==3){
                    OrderInfo orderInfo=new OrderInfo();
                    orderInfo.setOrderNo(Long.valueOf(orderlist.get(i)));
                    List<OrderInfo> orderInfolist=new ArrayList<OrderInfo>();
                    orderInfolist=orderInfoService.queryAll(orderInfo);
                    if(orderInfolist.size()>0){
                        orderInfo=orderInfolist.get(0);
                        if(orderInfo.getOrderStatus()==1){
                            orderInfo.setGmtModified(new Date());
                            orderInfo.setOrderStatus(4);
                            orderInfoService.update(orderInfo);
                        }
                    }
                    orderlist.remove(i);
                    ordernum.remove(i);
                    i=i-1;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}