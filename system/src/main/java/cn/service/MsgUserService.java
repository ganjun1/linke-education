package cn.service;


import cn.entity.MsgUser;

import java.util.List;

/**
 * 站内信用户记录表(MsgUser)表服务接口
 *
 * @author makejava
 * @since 2020-05-08 15:25:29
 */
public interface MsgUserService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    MsgUser queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<MsgUser> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param msgUser 实例对象
     * @return 实例对象
     */
    MsgUser insert(MsgUser msgUser);

    /**
     * 修改数据
     *
     * @param msgUser 实例对象
     * @return 实例对象
     */
    MsgUser update(MsgUser msgUser);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}