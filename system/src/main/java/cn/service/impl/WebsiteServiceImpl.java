package cn.service.impl;


import cn.entity.Website;
import cn.mapper1.WebsiteDao;
import cn.service.WebsiteService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 站点信息(Website)表服务实现类
 *
 * @author makejava
 * @since 2020-05-12 21:06:29
 */
@Service("websiteService")
public class WebsiteServiceImpl implements WebsiteService {
    @Resource
    private WebsiteDao websiteDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Website queryById(Long id) {
        return this.websiteDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Website> queryAllByLimit(int offset, int limit) {
        return this.websiteDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param website 实例对象
     * @return 实例对象
     */
    @Override
    public Website insert(Website website) {
        this.websiteDao.insert(website);
        return website;
    }

    /**
     * 修改数据
     *
     * @param website 实例对象
     * @return 实例对象
     */
    @Override
    public Website update(Website website) {
        this.websiteDao.update(website);
        return this.queryById(website.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.websiteDao.deleteById(id) > 0;
    }
}