package cn.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 站内信用户记录表(MsgUser)实体类
 *
 * @author makejava
 * @since 2020-05-08 15:25:29
 */
public class MsgUser implements Serializable {
    private static final long serialVersionUID = 982662443638449724L;

    @Override
    public String toString() {
        return "MsgUser{" +
                "id=" + id +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                ", statusId=" + statusId +
                ", sort=" + sort +
                ", msgId=" + msgId +
                ", userNo=" + userNo +
                ", mobile='" + mobile + '\'' +
                ", msgType=" + msgType +
                ", msgTitle='" + msgTitle + '\'' +
                ", isRead=" + isRead +
                ", isTop=" + isTop +
                '}';
    }

    /**
    * 主键
    */
    private Long id;
    /**
    * 创建时间
    */
    private Date gmtCreate;
    /**
    * 修改时间
    */
    private Date gmtModified;
    /**
    * 状态(1有效, 0无效)
    */
    private int statusId;
    /**
    * 排序
    */
    private Integer sort;
    /**
    * 短信ID
    */
    private Long msgId;
    /**
    * 用户编号
    */
    private Long userNo;
    /**
    * 手机号
    */
    private String mobile;
    /**
    * 短信类型(1系统消息,2其他)
    */
    private int msgType;
    /**
    * 短信标题
    */
    private String msgTitle;
    /**
    * 是否阅读(1是;0否)
    */
    private int isRead;
    /**
    * 是否置顶(1是;0否)
    */
    private int isTop;


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

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public Object getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Long getMsgId() {
        return msgId;
    }

    public void setMsgId(Long msgId) {
        this.msgId = msgId;
    }

    public Long getUserNo() {
        return userNo;
    }

    public void setUserNo(Long userNo) {
        this.userNo = userNo;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Object getMsgType() {
        return msgType;
    }

    public void setMsgType(int msgType) {
        this.msgType = msgType;
    }

    public String getMsgTitle() {
        return msgTitle;
    }

    public void setMsgTitle(String msgTitle) {
        this.msgTitle = msgTitle;
    }

    public Object getIsRead() {
        return isRead;
    }

    public void setIsRead(int isRead) {
        this.isRead = isRead;
    }

    public Object getIsTop() {
        return isTop;
    }

    public void setIsTop(int isTop) {
        this.isTop = isTop;
    }

}