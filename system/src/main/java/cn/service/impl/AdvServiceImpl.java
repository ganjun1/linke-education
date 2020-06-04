package cn.service.impl;

import cn.entity.Adv;
import cn.mapper2.AdvDao;
import cn.service.AdvService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 广告信息(Adv)表服务实现类
 *
 * @author makejava
 * @since 2020-05-14 15:35:35
 */
@Service("advService")
public class AdvServiceImpl implements AdvService {
    @Resource
    private AdvDao advDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Adv queryById(Long id) {
        return this.advDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Adv> queryAllByLimit(int offset, int limit) {
        return this.advDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param adv 实例对象
     * @return 实例对象
     */
    @Override
    public Adv insert(Adv adv) {
        this.advDao.insert(adv);
        return adv;
    }

    /**
     * 修改数据
     *
     * @param adv 实例对象
     * @return 实例对象
     */
    @Override
    public Adv update(Adv adv) {
        this.advDao.update(adv);
        return this.queryById(adv.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.advDao.deleteById(id) > 0;
    }
}