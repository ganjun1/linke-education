package cn.controller;

import cn.entity.User;
import cn.mapper3.UserDao;
import cn.service.MailService;
import cn.service.SmsService;
import cn.service.impl.SmsServiceImpl;
import cn.util.Dto;
import cn.util.DtoUtil;
import cn.util.MD5;
import cn.util.error.ErrorCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

@Api(description = "用户的注册",value = "RegisterController")
@RestController
public class RegisterController {
    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Resource
    TemplateEngine templateEngine;
    @Resource
    SmsServiceImpl smsService;
    @Resource
    UserDao userDao;
    //邮箱验证
    private boolean validEmail(String email){
        String regex="^\\s*\\w+(?:\\.{0,1}[\\w-]+)*@[a-zA-Z0-9]+(?:[-.][a-zA-Z0-9]+)*\\.[a-zA-Z]+\\s*$";
        return Pattern.compile(regex).matcher(email).find();
    }
    //手机验证
    private boolean validPhone(String phone) {
        String regex="^1[3578]{1}\\d{9}$";
        return Pattern.compile(regex).matcher(phone).find();
    }
    @Resource
    MailService mailService;
    @PostMapping("/user/sendmail")
    @ApiImplicitParams({@ApiImplicitParam(value = "注册邮箱",name = "email",required = true,dataType = "String"),
            @ApiImplicitParam(value = "注册密码",name = "password",required = true,dataType = "String")})
    @ApiOperation(value ="邮箱注册发送激活码",notes = "使用json 格式返回发送状态")
    public Dto sendmail(String email, String password){
        System.out.println(email+""+password);
        //1.邮箱验证
        if(!this.validEmail(email)){
            return DtoUtil.returnFail("请使用正确的邮箱地址", ErrorCode.AUTH_ILLEGAL_USERCODE);
        }
        try{
            User user=new User();
            user.setMobile(email);
//            user.setId((long) (Math.random()*10+1));
            User user1=userDao.queryAll2(user);
            if(user1!=null){
                return DtoUtil.returnFail("用户已存在",ErrorCode.AUTH_USER_ALREADY_EXISTS);
            }else {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date start = sdf.parse(sdf.format(new Date()));
                user.setGmtCreate(start);
                user.setGmtModified(start);
                String activationCode = MD5.getMd5(new Date().toLocaleString(), 32);
                Context ctx = new Context();
                ctx.setVariable("username", user.getMobile());
                ctx.setVariable("jihuoma", activationCode);
                String mail = templateEngine.process("mailtemplate.html", ctx);
                mailService.sendHtmlMail("2630199217@qq.com", "2630199217@qq.com",
                        "领课教育激活", mail);
                ValueOperations<String, String> ops1 = stringRedisTemplate.opsForValue();
                ops1.set("activation:" + user.getMobile(), activationCode, 180, TimeUnit.SECONDS);
                user.setMobilePsw(MD5.getMd5(password,32));
                user.setMobileSalt(MD5.getMd5(password,32));
                user.setStatusId(false);
                SimpleDateFormat sdf1=new SimpleDateFormat("yyyyMMddHHmmss");
                String userno=sdf1.format(new Date());
                String sjcode=String.valueOf(MD5.getRandomCode()).substring(0,2);
                userno+=sjcode;
                user.setUserNo(Long.valueOf(userno));
                userDao.insert(user);
                return DtoUtil.returnSuccess("发送邮件成功！");
            }
        }catch (Exception e){
            e.printStackTrace();
            return DtoUtil.returnFail("出现异常",ErrorCode.AUTH_UNKNOWN);
        }
    }
    @PostMapping("/user/activateuserBymail")
    @ApiImplicitParams({@ApiImplicitParam(value = "注册邮箱",name = "mail",required = true,dataType = "String"),
            @ApiImplicitParam(value = "激活码",name = "code",required = true,dataType = "String")})
    @ApiOperation(value ="邮箱激活前端用户",notes = "使用json 格式返回发送状态")
    public Dto activateuserBymail(String mail,String code){
        System.out.println(mail+""+code);
        ValueOperations<String,String> ops1=stringRedisTemplate.opsForValue();
        String value=ops1.get("activation:"+mail);
        if(code.equals(value)){
            User user=new User();
            user.setMobile(mail);
           User user1=userDao.queryAll2(user);
            if(user1!=null){
                user1.setStatusId(true);
                int num=userDao.update(user1);
                if(num>0){
                    return DtoUtil.returnSuccess("激活成功！");
                }else{
                    return DtoUtil.returnFail("激活失败！",ErrorCode.AUTH_UNKNOWN);
                }
            }else{
                return  DtoUtil.returnFail("请输入正确的激活邮箱",ErrorCode.AUTH_UNKNOWN);
            }
        }else{
            return  DtoUtil.returnFail("请输入正确的激活码",ErrorCode.AUTH_UNKNOWN);
        }
    }
    @PostMapping("/user/sendphone")
    @ApiImplicitParams({@ApiImplicitParam(value = "注册手机号",name = "mobile",required = true,dataType = "String"),
            @ApiImplicitParam(value = "注册密码",name = "password",required = true,dataType = "String")})
    @ApiOperation(value ="手机注册发送激活码",notes = "使用json 格式返回发送状态")
    public Dto sendphone(String mobile,String password){
        //1.手机验证
        if(!this.validPhone(mobile)){
            return DtoUtil.returnFail("请使用正确的手机号码", ErrorCode.AUTH_ILLEGAL_USERCODE);
        }
        try{
            User user=new User();
            user.setMobile(mobile);
            user.setMobilePsw(password);
            User list=userDao.queryAll2(user);
            if(list!=null){
                return  DtoUtil.returnFail("用户已存在",ErrorCode.AUTH_USER_ALREADY_EXISTS);
            }else {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date start = sdf.parse(sdf.format(new Date()));
                user.setGmtCreate(start);
                user.setGmtModified(start);
                //2.生成验证码(1111-9999)
                int activationCode=MD5.getRandomCode();
                //3.发送验证码
                smsService.SendTo(user.getMobile(),"1",new String[]{String.valueOf(activationCode),"1"});
                ValueOperations<String, String> ops1 = stringRedisTemplate.opsForValue();
                ops1.set("activation:" + user.getMobile(), String.valueOf(activationCode), 180, TimeUnit.SECONDS);
                user.setMobilePsw(MD5.getMd5(user.getMobilePsw(),32));
                user.setMobileSalt(MD5.getMd5(user.getMobilePsw(),32));
                user.setStatusId(false);
                SimpleDateFormat sdf1=new SimpleDateFormat("yyyyMMddHHmmss");
                String userno=sdf1.format(new Date());
                String sjcode=String.valueOf(MD5.getRandomCode()).substring(0,2);
                userno+=sjcode;
                user.setUserNo(Long.valueOf(userno));
                userDao.insert(user);
                return DtoUtil.returnSuccess("发送短信成功！");
            }
        }catch (Exception e){
            e.printStackTrace();
            return DtoUtil.returnFail("出现异常",ErrorCode.AUTH_UNKNOWN);
        }
    }
    @PostMapping("/user/activateuserByphone")
    @ApiImplicitParams({@ApiImplicitParam(value = "注册手机号",name = "mobile",required = true,dataType = "String"),
            @ApiImplicitParam(value = "激活码",name = "code",required = true,dataType = "String")})
    @ApiOperation(value ="手机激活前端用户",notes = "使用json 格式返回发送状态")
    public Dto activateuserByphone(String mobile,String code){
        ValueOperations<String,String> ops1=stringRedisTemplate.opsForValue();
        String value=ops1.get("activation:"+mobile);
        System.out.println("value:"+value);
        System.out.println("code:"+code);
        if(code.equals(value)){
           User user=new User();
            user.setMobile(mobile);
            User list=userDao.queryAll2(user);
            if(list!=null){
                list.setStatusId(true);
                int num=userDao.update(list);
                if(num>0){
                    return DtoUtil.returnSuccess("激活成功！");
                }else{
                    return DtoUtil.returnFail("激活失败！",ErrorCode.AUTH_UNKNOWN);
                }
            }else {
                return  DtoUtil.returnFail("请输入正确的手机号码",ErrorCode.AUTH_UNKNOWN);
            }
        }else{
            return  DtoUtil.returnFail("请输入正确的激活码", ErrorCode.AUTH_UNKNOWN);
        }
    }
}
