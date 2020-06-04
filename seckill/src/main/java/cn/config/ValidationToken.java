package cn.config;

import cn.entity.User;
import com.alibaba.fastjson.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

/**
 * Token验证
 * Created by hanlu on 2017/5/7.
 */
@Component
public class ValidationToken {


    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    public StringRedisTemplate stringRedisTemplate;

    public User getCurrentUser(String tokenString){
        //根据token从redis中获取用户信息
			/*
			 test token:
			 key : token:1qaz2wsx
			 value : {"id":"100078","userCode":"myusercode","userPassword":"78ujsdlkfjoiiewe98r3ejrf","userType":"1","flatID":"10008989"}

			*/
        User user = null;
        ValueOperations<String,String> ops1 = stringRedisTemplate.opsForValue();

        if(null == tokenString || "".equals(tokenString)){
            return null;
        }
        try{
            String userInfoJson = ops1.get(tokenString);
            user = JSONObject.parseObject(userInfoJson, User.class);
        }catch(Exception e){
            user = null;
        }
        return user;
    }

}
