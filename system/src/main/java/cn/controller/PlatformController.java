package cn.controller;

import cn.aop.MyLog;
import cn.entity.Platform;
import cn.service.PlatformService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 平台信息(Platform)表控制层
 *
 * @author makejava
 * @since 2020-05-12 21:52:48
 */
@RestController
@RequestMapping("user/platform")
@Api(description = "平台管理",value = "PlatformController")
public class PlatformController {
    /**
     * 服务对象
     */
    @Resource
    private PlatformService platformService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @ApiOperation(value="根据id查询平台",httpMethod = "GET")
    //登录映射
    @MyLog(value = "根据id查询平台")
    @GetMapping("selectOne")
    public Platform selectOne(Long id) {
        Platform platform=null;
        try{
            platform=platformService.queryById(id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return platform;
    }

    @ApiOperation(value="添加平台",httpMethod = "POST")
    //登录映射
    @MyLog(value = "添加平台")
    @PostMapping("insert")
    public Platform insert(@RequestBody Platform platform) {
        Platform platform1=null;
        try{
            platform1=platformService.insert(platform);
        }catch (Exception e){
            e.printStackTrace();
        }
        return platform1;
    }

    @ApiOperation(value="删除平台",httpMethod = "DELETE")
    //登录映射
    @MyLog(value = "删除平台")
    @DeleteMapping("delete")
    public Boolean delete(Long id) {
        Boolean bool=false;
        try{
            bool=platformService.deleteById(id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return bool;
    }

    @ApiOperation(value="修改平台",httpMethod = "POST")
    //登录映射
    @MyLog(value = "修改平台")
    @PostMapping("update")
    public Platform update(@RequestBody Platform platform) {
        Platform platform1=null;
        try{
            platform1=platformService.update(platform);
        }catch (Exception e){
            e.printStackTrace();
        }
        return platform1;
    }

    @ApiOperation(value="根据客服端名称查询",httpMethod = "POST")
    //登录映射
    @MyLog(value = "根据客服端名称查询")
    @PostMapping("selectByClientName")
    public List<Platform> selectByClientName(String clientName) {
        Platform platform=new Platform();
        platform.setClientName(clientName);
        List<Platform> platform1=null;
        try{
            platform1=platformService.queryAll(platform);
        }catch (Exception e){
            e.printStackTrace();
        }
        return platform1;
    }
}