package cn.mapper1;

import cn.entity.MsgUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


import java.util.List;

/**
 * 站内信用户记录表(MsgUser)表数据库访问层
 *
 * @author makejava
 * @since 2020-05-08 15:37:02
 */
@Mapper
public interface MsgUserDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    MsgUser queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<MsgUser> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param msgUser 实例对象
     * @return 对象列表
     */
    List<MsgUser> queryAll(MsgUser msgUser);

    /**
     * 新增数据
     *
     * @param msgUser 实例对象
     * @return 影响行数
     */
    int insert(MsgUser msgUser);

    /**
     * 修改数据
     *
     * @param msgUser 实例对象
     * @return 影响行数
     */
    int update(MsgUser msgUser);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}