package cn.util;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel(value = "UserVo",description = "前台用户VO")
public class UserVo {


    /**
     * 主键
     */
    @ApiModelProperty("[非必填] 主键")
    private Long id;
    /**
     * 创建时间
     */
    @ApiModelProperty("[非必填] 创建时间")
    private Date gmtCreate;
    /**
     * 修改时间
     */
    @ApiModelProperty("[非必填] 修改时间")
    private Date gmtModified;
    /**
     * 状态(1:正常，0:禁用)
     */
    @ApiModelProperty("[非必填] 状态(1:正常，0:禁用)")
    private Boolean statusId;
    /**
     * 用户编号
     */
    @ApiModelProperty("[非必填] 用户编号")
    private Integer userNo;
    /**
     * 手机号码
     */
    @ApiModelProperty("[非必填] 手机号码")
    private String mobile;
    /**
     * 密码盐
     */
    @ApiModelProperty("[非必填] 密码盐")
    private String mobileSalt;
    /**
     * 登录密码
     */
    @ApiModelProperty("[非必填] 登录密码")
    private String mobilePsw;
    /**
     * 用户来源(client_id)
     */
    @ApiModelProperty("[非必填] 用户来源(client_id)")
    private String userSource;

    /**
     * 用户名称
     */
    @ApiModelProperty("[非必填] 用户名称")
    private String username;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public Integer getUserNo() {
        return userNo;
    }

    public void setUserNo(Integer userNo) {
        this.userNo = userNo;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getMobileSalt() {
        return mobileSalt;
    }

    public void setMobileSalt(String mobileSalt) {
        this.mobileSalt = mobileSalt;
    }

    public String getMobilePsw() {
        return mobilePsw;
    }

    public void setMobilePsw(String mobilePsw) {
        this.mobilePsw = mobilePsw;
    }

    public String getUserSource() {
        return userSource;
    }

    public void setUserSource(String userSource) {
        this.userSource = userSource;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
