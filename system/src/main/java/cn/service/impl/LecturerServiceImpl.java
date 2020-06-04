package cn.service.impl;

import cn.common.Constants;
import cn.common.EmptyUtils;
import cn.common.Page;
import cn.entity.Lecturer;
import cn.mapper3.LecturerDao;
import cn.service.LecturerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 讲师信息(Lecturer)表服务实现类
 *
 * @author makejava
 * @since 2020-05-13 15:40:00
 */
@Service("lecturerService")
public class LecturerServiceImpl implements LecturerService {
    @Resource
    private LecturerDao lecturerDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Lecturer queryById(Long id) {
        return this.lecturerDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Lecturer> queryAllByLimit(int offset, int limit) {
        return this.lecturerDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param lecturer 实例对象
     * @return 实例对象
     */
    @Override
    public Lecturer insert(Lecturer lecturer) {
        this.lecturerDao.insert(lecturer);
        return lecturer;
    }

    /**
     * 修改数据
     *
     * @param lecturer 实例对象
     * @return 实例对象
     */
    @Override
    public Lecturer update(Lecturer lecturer) {
        this.lecturerDao.update(lecturer);
        return this.queryById(lecturer.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.lecturerDao.deleteById(id) > 0;
    }

//    @Override
//    public int getLecturerCountByMap(Map<String, Object> param) {
//         return this.lecturerDao.getLecturerCountByMap(param);
//    }

    @Override
    public List<Lecturer> queryLecturerPageByMap(Map<String, Object> param, Integer pageNo, Integer pageSize) {
        Integer total = lecturerDao.getLecturerCountByMap(param);
        pageNo = EmptyUtils.isEmpty(pageNo) ? Constants.DEFAULT_PAGE_NO : pageNo;
        pageSize = EmptyUtils.isEmpty(pageSize) ? Constants.DEFAULT_PAGE_SIZE : pageSize;
        Page page = new Page(pageNo, pageSize, total);
        param.put("offset", page.getBeginPos());
        param.put("limit", page.getPageSize());
        List<Lecturer> lecturers = lecturerDao.getListByMap(param);
//        page.setRows(lecturers);
        return lecturers;
    }

//    @Override
//    public List<Lecturer> queryByLecturer(Lecturer lecturer,int offset,int limit) {
//        return this.lecturerDao.queryAll(lecturer,offset,limit);
//    }
}