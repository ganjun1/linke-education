package cn.service.impl;

import cn.entity.Platform;
import cn.mapper3.PlatformDao;
import cn.service.PlatformService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 平台信息(Platform)表服务实现类
 *
 * @author makejava
 * @since 2020-05-12 21:52:47
 */
@Service("platformService")
public class PlatformServiceImpl implements PlatformService {
    @Resource
    private PlatformDao platformDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Platform queryById(Long id) {
        return this.platformDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Platform> queryAllByLimit(int offset, int limit) {
        return this.platformDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param platform 实例对象
     * @return 实例对象
     */
    @Override
    public Platform insert(Platform platform) {
        this.platformDao.insert(platform);
        return platform;
    }

    /**
     * 修改数据
     *
     * @param platform 实例对象
     * @return 实例对象
     */
    @Override
    public Platform update(Platform platform) {
        this.platformDao.update(platform);
        return this.queryById(platform.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.platformDao.deleteById(id) > 0;
    }

    @Override
    public List<Platform> queryAll(Platform platform) {
        return this.platformDao.queryAll(platform);
    }
}