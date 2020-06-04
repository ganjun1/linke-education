package cn.service;


import cn.entity.Curriculum;
import cn.mapper2.CurriculumDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CurriculumService {

    @Resource
    CurriculumDao curriculumDao;

    public Curriculum queryById(Integer id) {
        return curriculumDao.queryById(id);
    }

    public List<Curriculum> queryAllByLimit(int offset, int limit) {
        return curriculumDao.queryAllByLimit(offset, limit);
    }

    public List<Curriculum> queryAll(Curriculum curriculum) {
        return curriculumDao.queryAll(curriculum);
    }

    public int insert(Curriculum curriculum) {
        return curriculumDao.insert(curriculum);
    }

    public int update(Curriculum curriculum) {
        return curriculumDao.update(curriculum);
    }

    public int deleteById(Integer id) {
        return curriculumDao.deleteById(id);
    }
}
