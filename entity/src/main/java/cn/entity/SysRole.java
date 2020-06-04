package cn.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 角色信息(SysRole)实体类
 *
 * @author makejava
 * @since 2020-05-10 13:53:53
 */
public class SysRole implements Serializable {
    private static final long serialVersionUID = 261543766796888575L;
    /**
    * 主键
    */
    private Long id;
    /**
    * 名称
    */
    private String roleName;
    /**
    * 排序
    */
    private Integer sort;
    /**
    * 状态(1:正常，0:禁用)
    */
    private Integer statusId;
    /**
    * 创建时间
    */
    private Date gmtCreate;
    /**
    * 修改时间
    */
    private Date gmtModified;
    /**
    * 备注
    */
    private String remark;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}