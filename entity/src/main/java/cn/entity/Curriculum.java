package cn.entity;

import java.io.Serializable;

/**
 * (Curriculum)实体类
 *
 * @author makejava
 * @since 2020-05-13 00:21:46
 */
public class Curriculum implements Serializable {
    private static final long serialVersionUID = 178807740249654199L;
    /**
    * 课程表id
    */
    private Integer id;
    /**
    * 课程名称
    */
    private String curriculumname;
    /**
    * 课程价格
    */
    private Integer curriculumprice;
    /**
    * 课程教师id
    */
    private Integer curriculumteacherid;
    /**
    * 课程介绍
    */
    private Object curriculumintroduce;
    /**
    * 课程创建时间
    */
    private Object curriculumcreatetime;
    /**
    * 课程创建者id
    */
    private Integer curriculumcreateid;
    /**
    * 课程修改者id
    */
    private Integer curriculummodifyid;
    /**
    * 课程修改时间
    */
    private Object curriculummodifytime;
    /**
    * 录屏文件
    */
    private String curriculumscreencap;
    /**
    * 是否免费:(1:免费,0收费)
    */
    private Integer isfree;
    /**
    * 是否上架:(1:上架,0下架)
    */
    private Integer isputaway;
    /**
    * 购买人数
    */
    private Integer countbuy;
    /**
    * 学习人数
    */
    private Integer countstudy;
    /**
    * 总课时数
    */
    private Integer periodtotal;
    /**
    * 审核状态(1:审核进行中2:审核未通过3:审核已通过)
    */
    private Integer curriculumstatus;

    private Long userId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCurriculumname() {
        return curriculumname;
    }

    public void setCurriculumname(String curriculumname) {
        this.curriculumname = curriculumname;
    }

    public Integer getCurriculumprice() {
        return curriculumprice;
    }

    public void setCurriculumprice(Integer curriculumprice) {
        this.curriculumprice = curriculumprice;
    }

    public Integer getCurriculumteacherid() {
        return curriculumteacherid;
    }

    public void setCurriculumteacherid(Integer curriculumteacherid) {
        this.curriculumteacherid = curriculumteacherid;
    }

    public Object getCurriculumintroduce() {
        return curriculumintroduce;
    }

    public void setCurriculumintroduce(Object curriculumintroduce) {
        this.curriculumintroduce = curriculumintroduce;
    }

    public Object getCurriculumcreatetime() {
        return curriculumcreatetime;
    }

    public void setCurriculumcreatetime(Object curriculumcreatetime) {
        this.curriculumcreatetime = curriculumcreatetime;
    }

    public Integer getCurriculumcreateid() {
        return curriculumcreateid;
    }

    public void setCurriculumcreateid(Integer curriculumcreateid) {
        this.curriculumcreateid = curriculumcreateid;
    }

    public Integer getCurriculummodifyid() {
        return curriculummodifyid;
    }

    public void setCurriculummodifyid(Integer curriculummodifyid) {
        this.curriculummodifyid = curriculummodifyid;
    }

    public Object getCurriculummodifytime() {
        return curriculummodifytime;
    }

    public void setCurriculummodifytime(Object curriculummodifytime) {
        this.curriculummodifytime = curriculummodifytime;
    }

    public String getCurriculumscreencap() {
        return curriculumscreencap;
    }

    public void setCurriculumscreencap(String curriculumscreencap) {
        this.curriculumscreencap = curriculumscreencap;
    }

    public Integer getIsfree() {
        return isfree;
    }

    public void setIsfree(Integer isfree) {
        this.isfree = isfree;
    }

    public Integer getIsputaway() {
        return isputaway;
    }

    public void setIsputaway(Integer isputaway) {
        this.isputaway = isputaway;
    }

    public Integer getCountbuy() {
        return countbuy;
    }

    public void setCountbuy(Integer countbuy) {
        this.countbuy = countbuy;
    }

    public Integer getCountstudy() {
        return countstudy;
    }

    public void setCountstudy(Integer countstudy) {
        this.countstudy = countstudy;
    }

    public Integer getPeriodtotal() {
        return periodtotal;
    }

    public void setPeriodtotal(Integer periodtotal) {
        this.periodtotal = periodtotal;
    }

    public Integer getCurriculumstatus() {
        return curriculumstatus;
    }

    public void setCurriculumstatus(Integer curriculumstatus) {
        this.curriculumstatus = curriculumstatus;
    }

    @Override
    public String toString() {
        return "Curriculum{" +
                "id=" + id +
                ", curriculumname='" + curriculumname + '\'' +
                ", curriculumprice=" + curriculumprice +
                ", curriculumteacherid=" + curriculumteacherid +
                ", curriculumintroduce=" + curriculumintroduce +
                ", curriculumcreatetime=" + curriculumcreatetime +
                ", curriculumcreateid=" + curriculumcreateid +
                ", curriculummodifyid=" + curriculummodifyid +
                ", curriculummodifytime=" + curriculummodifytime +
                ", curriculumscreencap='" + curriculumscreencap + '\'' +
                ", isfree=" + isfree +
                ", isputaway=" + isputaway +
                ", countbuy=" + countbuy +
                ", countstudy=" + countstudy +
                ", periodtotal=" + periodtotal +
                ", curriculumstatus=" + curriculumstatus +
                '}';
    }
}