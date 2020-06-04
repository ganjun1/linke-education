package cn.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 课程信息(Course)实体类
 *
 * @author makejava
 * @since 2020-05-14 14:20:10
 */
public class Course implements Serializable {
    private static final long serialVersionUID = 808122788504599803L;
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
    * 讲师用户编码
    */
    private Long lecturerUserNo;
    /**
    * 一级分类ID
    */
    private Long categoryId1;
    /**
    * 二级分类ID
    */
    private Long categoryId2;
    /**
    * 三级分类ID
    */
    private Long categoryId3;
    /**
    * 课程名称
    */
    private String courseName;
    /**
    * 课程封面
    */
    private String courseLogo;
    /**
    * 课程介绍ID
    */
    private Long introduceId;
    /**
    * 是否免费：1免费，0收费
    */
    private Boolean isFree;
    /**
    * 原价
    */
    private Double courseOriginal;
    /**
    * 优惠价
    */
    private Double courseDiscount;
    /**
    * 是否上架(1:上架，0:下架)
    */
    private Boolean isPutaway;
    /**
    * 课程排序(前端显示使用)
    */
    private Integer courseSort;
    /**
    * 购买人数
    */
    private Integer countBuy;
    /**
    * 学习人数
    */
    private Integer countStudy;
    /**
    * 总课时数
    */
    private Integer periodTotal;


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

    public Long getCategoryId1() {
        return categoryId1;
    }

    public void setCategoryId1(Long categoryId1) {
        this.categoryId1 = categoryId1;
    }

    public Long getCategoryId2() {
        return categoryId2;
    }

    public void setCategoryId2(Long categoryId2) {
        this.categoryId2 = categoryId2;
    }

    public Long getCategoryId3() {
        return categoryId3;
    }

    public void setCategoryId3(Long categoryId3) {
        this.categoryId3 = categoryId3;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseLogo() {
        return courseLogo;
    }

    public void setCourseLogo(String courseLogo) {
        this.courseLogo = courseLogo;
    }

    public Long getIntroduceId() {
        return introduceId;
    }

    public void setIntroduceId(Long introduceId) {
        this.introduceId = introduceId;
    }

    public Boolean getIsFree() {
        return isFree;
    }

    public void setIsFree(Boolean isFree) {
        this.isFree = isFree;
    }

    public Double getCourseOriginal() {
        return courseOriginal;
    }

    public void setCourseOriginal(Double courseOriginal) {
        this.courseOriginal = courseOriginal;
    }

    public Double getCourseDiscount() {
        return courseDiscount;
    }

    public void setCourseDiscount(Double courseDiscount) {
        this.courseDiscount = courseDiscount;
    }

    public Boolean getIsPutaway() {
        return isPutaway;
    }

    public void setIsPutaway(Boolean isPutaway) {
        this.isPutaway = isPutaway;
    }

    public Integer getCourseSort() {
        return courseSort;
    }

    public void setCourseSort(Integer courseSort) {
        this.courseSort = courseSort;
    }

    public Integer getCountBuy() {
        return countBuy;
    }

    public void setCountBuy(Integer countBuy) {
        this.countBuy = countBuy;
    }

    public Integer getCountStudy() {
        return countStudy;
    }

    public void setCountStudy(Integer countStudy) {
        this.countStudy = countStudy;
    }

    public Integer getPeriodTotal() {
        return periodTotal;
    }

    public void setPeriodTotal(Integer periodTotal) {
        this.periodTotal = periodTotal;
    }

}