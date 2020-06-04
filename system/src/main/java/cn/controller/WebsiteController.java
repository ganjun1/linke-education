package cn.controller;

import cn.aop.MyLog;
import cn.entity.Website;
import cn.service.WebsiteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 站点信息(Website)表控制层
 *
 * @author makejava
 * @since 2020-05-12 21:06:29
 */
@RestController
@RequestMapping("user")
@Api(description = "站点管理",value = "WebsiteController")
public class WebsiteController {
    /**
     * 服务对象
     */
    @Resource
    private WebsiteService websiteService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @ApiOperation(value="根据id查询站点信息",httpMethod = "GET")
    //登录映射
    @MyLog(value = "根据id查询用户")
    @GetMapping("/user/selectOne")
    public Website selectOne(Long id) {
        return this.websiteService.queryById(id);
    }

    @ApiOperation(value="新增站点",httpMethod = "POST")
    //登录映射
    @MyLog(value = "新增站点")
    @PostMapping("/user/insert")
    public Website insert(@RequestBody Website website) {
        Website website1=null;
        try{
            website1=websiteService.insert(website);
        }catch (Exception e){
            e.printStackTrace();
        }
        return website1;
    }

}