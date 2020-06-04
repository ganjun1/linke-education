package cn.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "CourseVo",description = "课程列表VO")
public class CourseVo {
    @ApiModelProperty("[非必填] 课程名称")
    private String courseName;

    @ApiModelProperty("[非必填] 是否免费")
    private Boolean isFree;

    @ApiModelProperty("[必非填] 是否上架")
    private Boolean isPutaway;

    @ApiModelProperty("[必非填] 状态")
    private Boolean statusId;

    @ApiModelProperty("[必填] 页面容量")
    private Integer pageSize;

    @ApiModelProperty("[必填] 页码）")
    private Integer pageNo;

    public Boolean getStatusId() {
        return statusId;
    }

    public void setStatusId(Boolean statusId) {
        this.statusId = statusId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Boolean getFree() {
        return isFree;
    }

    public void setFree(Boolean free) {
        isFree = free;
    }

    public Boolean getPutaway() {
        return isPutaway;
    }

    public void setPutaway(Boolean putaway) {
        isPutaway = putaway;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }
}
