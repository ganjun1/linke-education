package cn.mapper1;

import cn.entity.SysRole;
import cn.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;

/**
 * 用户接口
 */
@Mapper
public interface SysUserDao {

    SysUser getSysUserByUsername(String username);

    List<SysRole> listGetSysRoleById(Long id);
}
