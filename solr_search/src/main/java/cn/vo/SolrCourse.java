package cn.vo;

public class SolrCourse {
    private String id;
     private String course_name;
     private String category_name1;
     private String category_name2;
     private String category_name3;
     private String is_free;
     private String course_original;
     private String is_putaway;
     private String status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getCategory_name1() {
        return category_name1;
    }

    public void setCategory_name1(String category_name1) {
        this.category_name1 = category_name1;
    }

    public String getCategory_name2() {
        return category_name2;
    }

    public void setCategory_name2(String category_name2) {
        this.category_name2 = category_name2;
    }

    public String getCategory_name3() {
        return category_name3;
    }

    public void setCategory_name3(String category_name3) {
        this.category_name3 = category_name3;
    }

    public String getIs_free() {
        return is_free;
    }

    public void setIs_free(String is_free) {
        this.is_free = is_free;
    }

    public String getCourse_original() {
        return course_original;
    }

    public void setCourse_original(String course_original) {
        this.course_original = course_original;
    }

    public String getIs_putaway() {
        return is_putaway;
    }

    public void setIs_putaway(String is_putaway) {
        this.is_putaway = is_putaway;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
