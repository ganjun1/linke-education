package cn.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class RedisApi {


    @Autowired
    StringRedisTemplate stringRedisTemplate;



    public boolean set(String key,int seconds,String value){
        try{
            stringRedisTemplate.opsForValue().set(key,value,seconds, TimeUnit.SECONDS);
            return true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public String get(String key){
        String s="";
        try{
          s =  stringRedisTemplate.opsForValue().get(key);
        }catch(Exception e){
            e.printStackTrace();
        }
        return s;
    }

    /**
     * 删除
     * @param key
     */
    public void delete(String key){
        try{
           stringRedisTemplate.delete(key);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
