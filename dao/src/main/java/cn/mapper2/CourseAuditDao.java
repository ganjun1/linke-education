package cn.mapper2;

import cn.entity.CourseAudit;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


import java.util.List;
import java.util.Map;

/**
 * 课程信息-审核(CourseAudit)表数据库访问层
 *
 * @author makejava
 * @since 2020-05-14 15:06:39
 */
@Mapper
public interface CourseAuditDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    CourseAudit queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<CourseAudit> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param courseAudit 实例对象
     * @return 对象列表
     */
    List<CourseAudit> queryAll(CourseAudit courseAudit);

    /**
     * 新增数据
     *
     * @param courseAudit 实例对象
     * @return 影响行数
     */
    int insert(CourseAudit courseAudit);

    /**
     * 修改数据
     *
     * @param courseAudit 实例对象
     * @return 影响行数
     */
    int update(CourseAudit courseAudit);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

    List<CourseAudit> getListByMap(Map<String, Object> param);

    /**
     * 查询总页数
     * @param param
     * @return
     */
    int getCountByMap(Map<String, Object> param);
}