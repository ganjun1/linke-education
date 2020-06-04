package cn.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 讲师信息(Lecturer)实体类
 *
 * @author makejava
 * @since 2020-05-13 15:40:00
 */
public class Lecturer implements Serializable {
    private static final long serialVersionUID = 775875501867609499L;
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
    * 状态(1:正常，0:禁用)
    */
    private Boolean statusId;
    /**
    * 排序
    */
    private Integer sort;
    /**
    * 讲师用户编号
    */
    private Long lecturerUserNo;
    /**
    * 讲师名称
    */
    private String lecturerName;
    /**
    * 讲师手机
    */
    private String lecturerMobile;
    /**
    * 讲师邮箱
    */
    private String lecturerEmail;
    /**
    * 职位
    */
    private String position;
    /**
    * 头像
    */
    private String headImgUrl;
    /**
    * 简介
    */
    private String introduce;
    /**
    * 讲师分成比例
    */
    private Double lecturerProportion;


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

    public Boolean getStatusId() {
        return statusId;
    }

    public void setStatusId(Boolean statusId) {
        this.statusId = statusId;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Long getLecturerUserNo() {
        return lecturerUserNo;
    }

    public void setLecturerUserNo(Long lecturerUserNo) {
        this.lecturerUserNo = lecturerUserNo;
    }

    public String getLecturerName() {
        return lecturerName;
    }

    public void setLecturerName(String lecturerName) {
        this.lecturerName = lecturerName;
    }

    public String getLecturerMobile() {
        return lecturerMobile;
    }

    public void setLecturerMobile(String lecturerMobile) {
        this.lecturerMobile = lecturerMobile;
    }

    public String getLecturerEmail() {
        return lecturerEmail;
    }

    public void setLecturerEmail(String lecturerEmail) {
        this.lecturerEmail = lecturerEmail;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getHeadImgUrl() {
        return headImgUrl;
    }

    public void setHeadImgUrl(String headImgUrl) {
        this.headImgUrl = headImgUrl;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public Double getLecturerProportion() {
        return lecturerProportion;
    }

    public void setLecturerProportion(Double lecturerProportion) {
        this.lecturerProportion = lecturerProportion;
    }

}