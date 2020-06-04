package cn.service.impl;

import cn.service.SmsService;
import com.cloopen.rest.sdk.CCPRestSmsSDK;
import org.springframework.stereotype.Service;

import java.util.HashMap;
@Service
public class SmsServiceImpl implements SmsService {
    @Override
    public void SendTo(String to, String templateId, String[] datas) throws Exception {
        CCPRestSmsSDK sdk =new CCPRestSmsSDK();
        sdk.init("app.cloopen.com","8883");
        sdk.setAccount("8aaf07087051bcec0170802a750a1aab","ccc07035079a404da5eb3ac586334b40");
        sdk.setAppId("8aaf07087051bcec0170802a75711ab2");
        HashMap result=sdk.sendTemplateSMS(to,templateId,datas);
        if("000000".equals(result.get("statusCode"))) {
            System.out.println("短信发送成功");
        }else{
            throw new Exception(result.get("statusCode").toString()+":"+result.get("statusMsg"));
        }
    }
    }

