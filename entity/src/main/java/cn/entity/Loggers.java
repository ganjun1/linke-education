package cn.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * (Loggers)实体类
 *
 * @author makejava
 * @since 2020-05-11 17:31:53
 */
public class Loggers implements Serializable {
    private static final long serialVersionUID = 674815218623980045L;
    /**
    * 日志表id
    */
    private Integer id;
    /**
    * 操作URL
    */
    private String loggerurl;
    /**
    * 日志创建者id
    */
    private Integer loggercreateid;
    /**
    * 日志创建时间
    */
    private Date loggercreatetime;
    /**
    * 日志ip
    */
    private String loggerip;
    /**
    * 日志请求类型
    */
    private String loggertype;
    /**
    * 日志参数名
    */
    private String loggerparameter;
    /**
    * 日志方法名
    */
    private String loggerclass;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoggerurl() {
        return loggerurl;
    }

    public void setLoggerurl(String loggerurl) {
        this.loggerurl = loggerurl;
    }

    public Integer getLoggercreateid() {
        return loggercreateid;
    }

    public void setLoggercreateid(Integer loggercreateid) {
        this.loggercreateid = loggercreateid;
    }

    public Date getLoggercreatetime() {
        return loggercreatetime;
    }

    public void setLoggercreatetime(Date loggercreatetime) {
        this.loggercreatetime = loggercreatetime;
    }

    public String getLoggerip() {
        return loggerip;
    }

    public void setLoggerip(String loggerip) {
        this.loggerip = loggerip;
    }

    public String getLoggertype() {
        return loggertype;
    }

    public void setLoggertype(String loggertype) {
        this.loggertype = loggertype;
    }

    public String getLoggerparameter() {
        return loggerparameter;
    }

    public void setLoggerparameter(String loggerparameter) {
        this.loggerparameter = loggerparameter;
    }

    public String getLoggerclass() {
        return loggerclass;
    }

    public void setLoggerclass(String loggerclass) {
        this.loggerclass = loggerclass;
    }

}