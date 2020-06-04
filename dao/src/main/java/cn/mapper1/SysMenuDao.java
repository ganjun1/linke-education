    package cn.mapper1;

import cn.entity.Menu;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;

/**
 *资源接口
 */
@Mapper
public interface SysMenuDao {

    List<Menu> listSysmenuBySysRole();
}
