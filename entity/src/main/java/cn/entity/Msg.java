package cn.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 站内信息表(Msg)实体类
 *
 * @author makejava
 * @since 2020-05-08 15:59:37
 */
public class Msg implements Serializable {
    private static final long serialVersionUID = -97706450680607662L;
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
    * 短信类型(1系统消息,2其他)
    */
    private int msgType;
    /**
    * 短信标题
    */
    private String msgTitle;
    /**
    * 短信内容
    */
    private String msgText;
    /**
    * 是否定时发送（1是，0否）
    */
    private int isTimeSend;
    /**
    * 发送时间
    */
    private Date sendTime;
    /**
    * 是否已发送(1是;0否)
    */
    private int isSend;
    /**
    * 是否置顶(1是;0否)
    */
    private int isTop;
    /**
    * 后台备注
    */
    private String backRemark;


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

    public String getMsgText() {
        return msgText;
    }

    public void setMsgText(String msgText) {
        this.msgText = msgText;
    }

    public Object getIsTimeSend() {
        return isTimeSend;
    }

    public void setIsTimeSend(int isTimeSend) {
        this.isTimeSend = isTimeSend;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public int getIsSend() {
        return isSend;
    }

    public void setIsSend(int isSend) {
        this.isSend = isSend;
    }

    public Object getIsTop() {
        return isTop;
    }

    public void setIsTop(int isTop) {
        this.isTop = isTop;
    }

    public String getBackRemark() {
        return backRemark;
    }

    public void setBackRemark(String backRemark) {
        this.backRemark = backRemark;
    }

    @Override
    public String toString() {
        return "Msg{" +
                "id=" + id +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                ", statusId=" + statusId +
                ", sort=" + sort +
                ", msgType=" + msgType +
                ", msgTitle='" + msgTitle + '\'' +
                ", msgText='" + msgText + '\'' +
                ", isTimeSend=" + isTimeSend +
                ", sendTime=" + sendTime +
                ", isSend=" + isSend +
                ", isTop=" + isTop +
                ", backRemark='" + backRemark + '\'' +
                '}';
    }
}