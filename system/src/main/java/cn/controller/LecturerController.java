package cn.controller;

import cn.aop.MyLog;
import cn.entity.Lecturer;
import cn.service.LecturerService;
import cn.vo.LecturerVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 讲师信息(Lecturer)表控制层
 *
 * @author makejava
 * @since 2020-05-13 15:40:00
 */
@RestController
@RequestMapping("user/lecturer")
@Api(description = "讲师管理",value = "LecturerController")
public class LecturerController {
    /**
     * 服务对象
     */
    @Resource
    private LecturerService lecturerService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @ApiOperation(value="根据id教师",httpMethod = "GET")
    @MyLog(value = "根据id教师")
    @GetMapping("selectOne")
    public Lecturer selectOne(Long id) {
        return this.lecturerService.queryById(id);
    }


    @ApiOperation(value="修改讲师",httpMethod = "POST")
    //登录映射
    @MyLog(value = "修改讲师")
    @PostMapping("update")
    public Lecturer update(@RequestBody Lecturer lecturer) {
        Lecturer lecturer1=null;
        try{
            lecturer1=lecturerService.update(lecturer);
        }catch (Exception e){
            e.printStackTrace();
        }
        return lecturer1;
    }


    @ApiOperation(value="根据名称和手机号查询",httpMethod = "POST")
    //登录映射
    @MyLog(value = "根据客服端名称查询")
    @PostMapping("selectByLecturer_name")
    public List<Lecturer> getCommentList(@RequestBody LecturerVo lecturerVo){
        List<Lecturer> lecturers=null;
        Map<String,Object> param=new HashMap<String,Object>();
        if(lecturerVo.getLecturerMobile()==null || lecturerVo.getLecturerMobile().equals("string")){
            lecturerVo.setLecturerMobile(null);
        }
        if(lecturerVo.getLecturerName()==null || lecturerVo.getLecturerName().equals("string")){
            lecturerVo.setLecturerName(null);
        }
        param.put("lecturerName",lecturerVo.getLecturerName());
        param.put("lecturerMobile",lecturerVo.getLecturerMobile());
        param.put("statusId",lecturerVo.getStatusId());
        try{
            lecturers=lecturerService.queryLecturerPageByMap(param,lecturerVo.getPageNo(),lecturerVo.getPageSize());
        }catch (Exception e){
            e.printStackTrace();
        }
        return lecturers;
    }
}