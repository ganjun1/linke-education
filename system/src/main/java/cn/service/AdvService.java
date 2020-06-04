package cn.service;


import cn.entity.Adv;


import java.util.List;

/**
 * 广告信息(Adv)表服务接口
 *
 * @author makejava
 * @since 2020-05-14 15:35:35
 */
public interface AdvService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Adv queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Adv> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param adv 实例对象
     * @return 实例对象
     */
    Adv insert(Adv adv);

    /**
     * 修改数据
     *
     * @param adv 实例对象
     * @return 实例对象
     */
    Adv update(Adv adv);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}