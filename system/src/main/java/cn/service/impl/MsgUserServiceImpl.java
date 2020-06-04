package cn.service.impl;


import cn.entity.MsgUser;
import cn.mapper1.MsgUserDao;
import cn.service.MsgUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 站内信用户记录表(MsgUser)表服务实现类
 *
 * @author makejava
 * @since 2020-05-08 15:25:29
 */
@Service("msgUserService")
public class MsgUserServiceImpl implements MsgUserService {
    @Resource
    private MsgUserDao msgUserDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public MsgUser queryById(Long id) {
        return this.msgUserDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<MsgUser> queryAllByLimit(int offset, int limit) {
        return this.msgUserDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param msgUser 实例对象
     * @return 实例对象
     */
    @Override
    public MsgUser insert(MsgUser msgUser) {
        this.msgUserDao.insert(msgUser);
        return msgUser;
    }

    /**
     * 修改数据
     *
     * @param msgUser 实例对象
     * @return 实例对象
     */
    @Override
    public MsgUser update(MsgUser msgUser) {
        this.msgUserDao.update(msgUser);
        return this.queryById(msgUser.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.msgUserDao.deleteById(id) > 0;
    }
}