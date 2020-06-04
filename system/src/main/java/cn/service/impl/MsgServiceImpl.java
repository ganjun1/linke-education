package cn.service.impl;


import cn.entity.Msg;
import cn.mapper1.MsgDao;
import cn.service.MsgService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 站内信息表(Msg)表服务实现类
 *
 * @author makejava
 * @since 2020-05-08 15:59:37
 */
@Service("msgService")
public class MsgServiceImpl implements MsgService {
    @Resource
    private MsgDao msgDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Msg queryById(Long id) {
        return this.msgDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Msg> queryAllByLimit(int offset, int limit) {
        return this.msgDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param msg 实例对象
     * @return 实例对象
     */
    @Override
    public Msg insert(Msg msg) {
        this.msgDao.insert(msg);
        return msg;
    }

    /**
     * 修改数据
     *
     * @param msg 实例对象
     * @return 实例对象
     */
    @Override
    public Msg update(Msg msg) {
        this.msgDao.update(msg);
        return this.queryById(msg.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.msgDao.deleteById(id) > 0;
    }
}