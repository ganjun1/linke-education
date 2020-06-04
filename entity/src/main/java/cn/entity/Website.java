package cn.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 站点信息(Website)实体类
 *
 * @author makejava
 * @since 2020-05-12 21:06:29
 */
public class Website implements Serializable {
    private static final long serialVersionUID = 766949730310346172L;
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
    private Boolean statusId;
    /**
    * 排序
    */
    private Integer sort;
    /**
    * org_logo_ico
    */
    private String logoIco;
    /**
    * org_logo_img
    */
    private String logoImg;
    /**
    * 站点标题
    */
    private String websiteTitle;
    /**
    * 站点关键词
    */
    private String websiteKeyword;
    /**
    * 站点描述
    */
    private String websiteDesc;
    /**
    * 站点版权
    */
    private String copyright;
    /**
    * 备案号
    */
    private String icp;
    /**
    * 公安备案号
    */
    private String prn;
    /**
    * 站点微信
    */
    private String weixin;
    /**
    * 小程序二维码
    */
    private String weixinXcx;
    /**
    * 站点微博
    */
    private String weibo;
    /**
    * 是否开启统计
    */
    private Boolean isEnableStatistics;
    /**
    * 统计代码
    */
    private String statisticsCode;
    /**
    * 是否显示客服信息
    */
    private Boolean isShowService;
    /**
    * 客服信息1
    */
    private String service1;
    /**
    * 客服信息2
    */
    private String service2;
    /**
    * 用户协议
    */
    private String userAgreement;
    /**
    * 招募标题
    */
    private String recruitTitle;
    /**
    * 招募信息
    */
    private String recruitInfo;
    /**
    * 入驻协议
    */
    private String entryAgreement;


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

    public String getLogoIco() {
        return logoIco;
    }

    public void setLogoIco(String logoIco) {
        this.logoIco = logoIco;
    }

    public String getLogoImg() {
        return logoImg;
    }

    public void setLogoImg(String logoImg) {
        this.logoImg = logoImg;
    }

    public String getWebsiteTitle() {
        return websiteTitle;
    }

    public void setWebsiteTitle(String websiteTitle) {
        this.websiteTitle = websiteTitle;
    }

    public String getWebsiteKeyword() {
        return websiteKeyword;
    }

    public void setWebsiteKeyword(String websiteKeyword) {
        this.websiteKeyword = websiteKeyword;
    }

    public String getWebsiteDesc() {
        return websiteDesc;
    }

    public void setWebsiteDesc(String websiteDesc) {
        this.websiteDesc = websiteDesc;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public String getIcp() {
        return icp;
    }

    public void setIcp(String icp) {
        this.icp = icp;
    }

    public String getPrn() {
        return prn;
    }

    public void setPrn(String prn) {
        this.prn = prn;
    }

    public String getWeixin() {
        return weixin;
    }

    public void setWeixin(String weixin) {
        this.weixin = weixin;
    }

    public String getWeixinXcx() {
        return weixinXcx;
    }

    public void setWeixinXcx(String weixinXcx) {
        this.weixinXcx = weixinXcx;
    }

    public String getWeibo() {
        return weibo;
    }

    public void setWeibo(String weibo) {
        this.weibo = weibo;
    }

    public Boolean getIsEnableStatistics() {
        return isEnableStatistics;
    }

    public void setIsEnableStatistics(Boolean isEnableStatistics) {
        this.isEnableStatistics = isEnableStatistics;
    }

    public String getStatisticsCode() {
        return statisticsCode;
    }

    public void setStatisticsCode(String statisticsCode) {
        this.statisticsCode = statisticsCode;
    }

    public Boolean getIsShowService() {
        return isShowService;
    }

    public void setIsShowService(Boolean isShowService) {
        this.isShowService = isShowService;
    }

    public String getService1() {
        return service1;
    }

    public void setService1(String service1) {
        this.service1 = service1;
    }

    public String getService2() {
        return service2;
    }

    public void setService2(String service2) {
        this.service2 = service2;
    }

    public String getUserAgreement() {
        return userAgreement;
    }

    public void setUserAgreement(String userAgreement) {
        this.userAgreement = userAgreement;
    }

    public String getRecruitTitle() {
        return recruitTitle;
    }

    public void setRecruitTitle(String recruitTitle) {
        this.recruitTitle = recruitTitle;
    }

    public String getRecruitInfo() {
        return recruitInfo;
    }

    public void setRecruitInfo(String recruitInfo) {
        this.recruitInfo = recruitInfo;
    }

    public String getEntryAgreement() {
        return entryAgreement;
    }

    public void setEntryAgreement(String entryAgreement) {
        this.entryAgreement = entryAgreement;
    }

}