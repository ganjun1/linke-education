package cn.service;




import cn.entity.Msg;

import java.util.List;

/**
 * 站内信息表(Msg)表服务接口
 *
 * @author makejava
 * @since 2020-05-08 15:59:37
 */
public interface MsgService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Msg queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Msg> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param msg 实例对象
     * @return 实例对象
     */
    Msg insert(Msg msg);

    /**
     * 修改数据
     *
     * @param msg 实例对象
     * @return 实例对象
     */
    Msg update(Msg msg);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}