package cn.service;




import cn.entity.Website;

import java.util.List;

/**
 * 站点信息(Website)表服务接口
 *
 * @author makejava
 * @since 2020-05-12 21:06:29
 */
public interface WebsiteService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Website queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Website> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param website 实例对象
     * @return 实例对象
     */
    Website insert(Website website);

    /**
     * 修改数据
     *
     * @param website 实例对象
     * @return 实例对象
     */
    Website update(Website website);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}