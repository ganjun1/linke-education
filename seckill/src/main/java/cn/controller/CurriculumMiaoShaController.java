package cn.controller;


import cn.config.RedisApi;
import cn.config.ValidationToken;
import cn.entity.Curriculum;
import cn.entity.User;
import cn.mapper3.UserDao;
import cn.service.CurriculumService;
import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Api(description = "课程秒杀接口",value = "CurriculumMiaoShaController")
@RestController
public class CurriculumMiaoShaController {

    @Autowired
    CurriculumService curriculumService;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    RedisApi redisApi;

    @Autowired
    ValidationToken validationToken;

    @Autowired
    RabbitTemplate rabbitTemplate;



    @Resource
    UserDao userDao;

    @ApiOperation(value = "根据课程ID设置课程秒杀上架",notes = "根据课程ID设置课程秒杀上架")
    @PostMapping(value = "/curriculum/CurriculumSetUp")
    public String CurriculumSetUp(Integer id,Integer num){
        JSONObject object = new JSONObject();
        Curriculum curriculum = new Curriculum();
        curriculum=curriculumService.queryById(id);
        System.out.println(curriculum.getId());
        if(curriculum!=null){
           Boolean flag = redisApi.set(id.toString(),900,num.toString());
           if(flag){
               object.put("message","设置课程秒杀成功，你设置的课程ID为"+curriculum.getId()+"数量为"+num.toString());
           }else{
               object.put("message","设置课程秒杀失败");
           }
        }else{
            object.put("message","课程信息不存在，请重新输入");
        }

        return object.toString();
    }

    @ApiOperation(value = "根据课程ID进行课程秒杀",notes = "根据课程ID进行课程秒杀")
    @PostMapping(value = "/curriculum/CurriculumMiaosha")
    public String CurriculumMiaosha(Integer id, Long userid){
        JSONObject object = new JSONObject();
            User user=new User();
            user.setUserNo(userid);
            List<User> list= userDao.queryAll(user);
            if(list==null||list.size()<1){
                object.put("message","找不到该用户");
            }else {
                System.out.println(id);
                if (Integer.parseInt(redisApi.get(id.toString())) > 0) {
                    Curriculum curriculum = new Curriculum();
                    curriculum = curriculumService.queryById(id);
                    curriculum.setUserId(user.getUserNo());
                    rabbitTemplate.convertAndSend("hello-queue", curriculum);
                    object.put("message", "秒杀成功");
                } else {
                    object.put("message", "秒杀失败");
                }

            }

        return object.toString();
    }
}
