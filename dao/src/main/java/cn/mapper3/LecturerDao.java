package cn.mapper3;

import cn.entity.Lecturer;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 讲师信息(Lecturer)表数据库访问层
 *
 * @author makejava
 * @since 2020-05-13 15:40:00
 */
public interface LecturerDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Lecturer queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Lecturer> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param lecturer 实例对象
     * @return 对象列表
     */
    List<Lecturer> queryAll(Lecturer lecturer, @Param("offset") int offset, @Param("limit") int limit);

    /**
     * 新增数据
     *
     * @param lecturer 实例对象
     * @return 影响行数
     */
    int insert(Lecturer lecturer);

    /**
     * 修改数据
     *
     * @param lecturer 实例对象
     * @return 影响行数
     */
    int update(Lecturer lecturer);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

    /**
     * 分页查询
     * @param param
     * @return
     */
    List<Lecturer> getListByMap(Map<String, Object> param);

    /**
     * 查询总页数
     * @param param
     * @return
     */
    int getLecturerCountByMap(Map<String, Object> param);

}