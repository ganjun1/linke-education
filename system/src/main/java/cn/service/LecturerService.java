package cn.service;

import cn.entity.Lecturer;

import java.util.List;
import java.util.Map;

/**
 * 讲师信息(Lecturer)表服务接口
 *
 * @author makejava
 * @since 2020-05-13 15:40:00
 */
public interface LecturerService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Lecturer queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Lecturer> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param lecturer 实例对象
     * @return 实例对象
     */
    Lecturer insert(Lecturer lecturer);

    /**
     * 修改数据
     *
     * @param lecturer 实例对象
     * @return 实例对象
     */
    Lecturer update(Lecturer lecturer);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

    /**
     *查询总页数
     * @param param
     * @return 总页数
     */
//    int getLecturerCountByMap(Map<String, Object> param);

    /**
     * 分页查询
     * @param param
     * @param pageNo
     * @param pageSize
     * @return
     */
    List<Lecturer> queryLecturerPageByMap(Map<String, Object> param, Integer pageNo, Integer pageSize);

//    List<Lecturer> queryByLecturer(Lecturer lecturer,int offset,int limit);

}