package cn.service.impl;

import cn.common.Constants;
import cn.common.EmptyUtils;
import cn.common.Page;
import cn.entity.Course;
import cn.mapper2.CourseDao;
import cn.service.CourseService;


import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 课程信息(Course)表服务实现类
 *
 * @author makejava
 * @since 2020-05-14 14:20:10
 */
@Service("courseService")
public class CourseServiceImpl implements CourseService {
    @Resource
    private CourseDao courseDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Course queryById(Long id) {
        return this.courseDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Course> queryAllByLimit(int offset, int limit) {
        return this.courseDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param course 实例对象
     * @return 实例对象
     */
    @Override
    public Course insert(Course course) {
        this.courseDao.insert(course);
        return course;
    }

    /**
     * 修改数据
     *
     * @param course 实例对象
     * @return 实例对象
     */
    @Override
    public Course update(Course course) {
        this.courseDao.update(course);
        return this.queryById(course.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.courseDao.deleteById(id) > 0;
    }


    @Override
    public List<Course> queryCoursePageByMap(Map<String, Object> param, Integer pageNo, Integer pageSize) {
        Integer total = courseDao.getCourseCountByMap(param);
        pageNo = EmptyUtils.isEmpty(pageNo) ? Constants.DEFAULT_PAGE_NO : pageNo;
        pageSize = EmptyUtils.isEmpty(pageSize) ? Constants.DEFAULT_PAGE_SIZE : pageSize;
        Page page = new Page(pageNo, pageSize, total);
        param.put("offset", page.getBeginPos());
        param.put("limit", page.getPageSize());
        List<Course> courses = courseDao.getListByMap(param);
        return courses;
    }
}