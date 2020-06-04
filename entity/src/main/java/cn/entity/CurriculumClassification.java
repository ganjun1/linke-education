package cn.entity;

import java.io.Serializable;

/**
 * (CurriculumClassification)实体类
 *
 * @author makejava
 * @since 2020-05-21 03:43:14
 */
public class CurriculumClassification implements Serializable {
    private static final long serialVersionUID = -84027933718569005L;
    /**
    * 课程分类关系表
    */
    private Integer id;
    /**
    * 课程id
    */
    private Integer curriculumId;
    /**
    * 分类关系表ID
    */
    private Integer relationshipid;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCurriculumId() {
        return curriculumId;
    }

    public void setCurriculumId(Integer curriculumId) {
        this.curriculumId = curriculumId;
    }

    public Integer getRelationshipid() {
        return relationshipid;
    }

    public void setRelationshipid(Integer relationshipid) {
        this.relationshipid = relationshipid;
    }

}