package cn.controller;

import cn.aop.MyLog;
import cn.entity.Adv;
import cn.service.AdvService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 广告信息(Adv)表控制层
 *
 * @author makejava
 * @since 2020-05-14 15:35:35
 */
@RestController
@RequestMapping("user/adv")
@Api(description = "广告管理",value = "AdvController")
public class AdvController {
    /**
     * 服务对象
     */
    @Resource
    private AdvService advService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    @ApiOperation(value="根据id查询广告",httpMethod = "GET")
    //登录映射
    @MyLog(value = "根据id查询广告")
    public Adv selectOne(Long id) {
        return this.advService.queryById(id);
    }

    @DeleteMapping("deleteById")
    @ApiOperation(value="根据id删除广告",httpMethod = "DELETE")
    //登录映射
    @MyLog(value = "根据id删除广告")
    public Boolean deleteById(Long id) {
        Boolean bool=false;
        try{
            bool=this.advService.deleteById(id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return bool;
    }

    @PostMapping("addAdv")
    @ApiOperation(value="添加广告",httpMethod = "POST")
    //登录映射
    @MyLog(value = "添加广告")
    public Adv insertAdv(@RequestBody Adv adv) {
        Adv adv1=null;
        try{
            adv1=advService.insert(adv);
        }catch (Exception e){
            e.printStackTrace();
        }
        return adv1;
    }

}