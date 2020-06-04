package cn.controller;

import cn.config.WebSocketServer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;

@Api(description = "消息推送",value = "SocketController")
@RestController
public class SocketController {

    @Resource
    private WebSocketServer webSocketServer;

    /**
     * 给指定用户推送消息
     *
     * @param userName 用户名
     * @param message  消息
     * @throws IOException
     */
    @ApiOperation(value = "向用户推送信息")
    @RequestMapping(value = "/socket", method = RequestMethod.GET)
    public void testSocket1(@RequestParam String userName, @RequestParam String message) {
        System.err.println("username:"+userName);
        System.err.println("message"+message);
        webSocketServer.sendInfo(userName, message);
    }

    /**
     * 访问页面http://localhost:8085/index
     * 给所有用户推送消息
     *
     * @param message 消息
     * @throws IOException
     */
    @ApiOperation(value = "给所有用户推送消息")
    @RequestMapping(value = "/socket/all", method = RequestMethod.GET)
    public void testSocket2(@RequestParam String message) {
        try {
            webSocketServer.onMessage(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    @GetMapping("index")
//    public ModelAndView index(){
//        ModelAndView mo=new ModelAndView();
//        mo.setViewName("index");
//        return mo;
//    }
//
//    @GetMapping("client")
//    public ModelAndView client(){
//        ModelAndView mo=new ModelAndView();
//        mo.setViewName("client");
//        return mo;
//    }
}
