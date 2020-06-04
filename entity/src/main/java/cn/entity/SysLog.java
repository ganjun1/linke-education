package cn.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 后台操作日志表(SysLog)实体类
 *
 * @author makejava
 * @since 2020-05-11 17:09:18
 */
public class SysLog implements Serializable {
    private static final long serialVersionUID = -20477007765938850L;
    /**
    * 主键
    */
    private Long id;
    /**
    * 创建时间
    */
    private Date gmtCreate;
    /**
    * 操作人
    */
    private Integer userNo;
    /**
    * 真实姓名
    */
    private String realName;
    /**
    * IP地址
    */
    private String ip;
    /**
    * 用户操作
    */
    private String operation;
    /**
    * 请求方法
    */
    private String method;
    /**
    * 请求路径
    */
    private String path;
    /**
    * 请求参数
    */
    private String content;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Integer getUserNo() {
        return userNo;
    }

    public void setUserNo(Integer userNo) {
        this.userNo = userNo;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}