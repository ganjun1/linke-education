package cn.service.impl;

import cn.common.Constants;
import cn.common.EmptyUtils;
import cn.common.Page;
import cn.entity.CourseAudit;
import cn.mapper2.CourseAuditDao;
import cn.service.CourseAuditService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 课程信息-审核(CourseAudit)表服务实现类
 *
 * @author makejava
 * @since 2020-05-14 15:06:39
 */
@Service("courseAuditService")
public class CourseAuditServiceImpl implements CourseAuditService {
    @Resource
    private CourseAuditDao courseAuditDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public CourseAudit queryById(Long id) {
        return this.courseAuditDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<CourseAudit> queryAllByLimit(int offset, int limit) {
        return this.courseAuditDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param courseAudit 实例对象
     * @return 实例对象
     */
    @Override
    public CourseAudit insert(CourseAudit courseAudit) {
        this.courseAuditDao.insert(courseAudit);
        return courseAudit;
    }

    /**
     * 修改数据
     *
     * @param courseAudit 实例对象
     * @return 实例对象
     */
    @Override
    public CourseAudit update(CourseAudit courseAudit) {
        this.courseAuditDao.update(courseAudit);
        return this.queryById(courseAudit.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.courseAuditDao.deleteById(id) > 0;
    }

    @Override
    public List<CourseAudit> queryCourseAuditPageByMap(Map<String, Object> param, Integer pageNo, Integer pageSize) {
        Integer total = courseAuditDao.getCountByMap(param);
        pageNo = EmptyUtils.isEmpty(pageNo) ? Constants.DEFAULT_PAGE_NO : pageNo;
        pageSize = EmptyUtils.isEmpty(pageSize) ? Constants.DEFAULT_PAGE_SIZE : pageSize;
        Page page = new Page(pageNo, pageSize, total);
        param.put("offset", page.getBeginPos());
        param.put("limit", page.getPageSize());
        List<CourseAudit> courseAudits = courseAuditDao.getListByMap(param);
        return courseAudits;
    }
}