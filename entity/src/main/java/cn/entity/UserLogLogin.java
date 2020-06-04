package cn.entity;

import java.io.Serializable;

/**
 * (UserLogLogin)实体类
 *
 * @author makejava
 * @since 2020-05-17 22:27:54
 */
public class UserLogLogin implements Serializable {
    private static final long serialVersionUID = -44007592688314706L;
    
    private Integer id;
    /**
    * 创建时间
    */
    private Object gmtCreate;
    /**
    * 用户id
    */
    private Integer userId;
    /**
    * 登录状态(1成功，0失败)
    */
    private Object loginStatus;
    /**
    * 登陆ip
    */
    private String loginIp;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Object getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Object gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Object getLoginStatus() {
        return loginStatus;
    }

    public void setLoginStatus(Object loginStatus) {
        this.loginStatus = loginStatus;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

}