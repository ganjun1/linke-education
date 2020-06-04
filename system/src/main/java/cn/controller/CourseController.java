package cn.controller;

import cn.aop.MyLog;
import cn.entity.Course;
import cn.entity.CourseAudit;
import cn.service.CourseAuditService;
import cn.service.CourseService;
import cn.vo.CourseAuditVo;
import cn.vo.CourseVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 课程信息(Course)表控制层
 *
 * @author makejava
 * @since 2020-05-14 14:20:10
 */
@RestController
@RequestMapping("user/course")
@Api(description = "课程管理",value = "CourseController")
public class CourseController {
    /**
     * 服务对象
     */
    @Resource
    private CourseService courseService;

    @Resource
    private CourseAuditService courseAuditService;


    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @ApiOperation(value="根据id查询课程",httpMethod = "GET")
    //登录映射
    @MyLog(value = "根据id查询课程")
    @GetMapping("selectOne")
    public Course selectOne(Long id) {
        return this.courseService.queryById(id);
    }

    @ApiOperation(value="查询课程列表",httpMethod = "POST")
    //登录映射
    @MyLog(value = "查询课程列表")
    @PostMapping("listCourse")
    public List<Course> listCourse(@RequestBody CourseVo courseVo) {
        List<Course> courses=null;
        Map<String,Object> param=new HashMap<String,Object>();
        if(courseVo.getCourseName()==null || courseVo.getCourseName().equals("string")){
            courseVo.setCourseName(null);
        }
        param.put("courseName",courseVo.getCourseName());
        param.put("isFree",courseVo.getFree());
        param.put("statusId",courseVo.getStatusId());
        param.put("isPutaway",courseVo.getPutaway());
        try{
            courses=courseService.queryCoursePageByMap(param,courseVo.getPageNo(),courseVo.getPageSize());
        }catch (Exception e){
            e.printStackTrace();
        }
        return courses;
    }

    @ApiOperation(value="查询课程审核列表",httpMethod = "POST")
    //登录映射
    @MyLog(value = "查询课程审核列表")
    @PostMapping("listCourseAudit")
    public List<CourseAudit> listCourseAudit(@RequestBody CourseAuditVo courseAuditVo) {
        List<CourseAudit> courses=null;
        Map<String,Object> param=new HashMap<String,Object>();
        if(courseAuditVo.getCourseName()==null || courseAuditVo.getCourseName().equals("string")){
            courseAuditVo.setCourseName(null);
        }
        param.put("auditStatus",courseAuditVo.getAuditStatus());
        param.put("courseName",courseAuditVo.getCourseName());
        param.put("isFree",courseAuditVo.getFree());
        param.put("statusId",courseAuditVo.getStatusId());
        param.put("isPutaway",courseAuditVo.getPutaway());
        try{
            courses=courseAuditService.queryCourseAuditPageByMap(param,courseAuditVo.getPageNo(),courseAuditVo.getPageSize());
        }catch (Exception e){
            e.printStackTrace();
        }
        return courses;
    }


}