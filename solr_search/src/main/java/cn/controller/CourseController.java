package cn.controller;

import cn.util.Dto;
import cn.util.DtoUtil;
import cn.vo.SolrCourse;
import io.swagger.annotations.Api;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.params.ModifiableSolrParams;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@Api("课程管理")
public class CourseController {


    @Resource
    private SolrClient client;

    /**
     * 综合查询: 在综合查询中, 有按条件查询, 条件过滤, 排序, 分页, 高亮显示, 获取部分域信息
     * @return
     */
    @RequestMapping(value = "/student/selectCourseBySolr" ,method = RequestMethod.GET)
    public Dto search(String courseName,String status,String is_free,String category_name1,String category_name2,String category_name3){
        List<SolrCourse> courses=new ArrayList<>();
        try {
            //存储条件的对象，单条件用SolrQuery也可以进行存储，如果是多条件用SolrQuery，fq条件会进行覆盖，达不到多条件的效果
            ModifiableSolrParams params = new ModifiableSolrParams();

            SolrQuery filterQuery = new SolrQuery();
            //查询条件, 这里的 q 对应 下面图片标红的地方
            params.set("q", "*:*");
            //课程名称模糊查询
            if(courseName!=null&&courseName!=""){
                filterQuery.addFilterQuery("course_name:*"+courseName+"*");
            }else{
                filterQuery.addFilterQuery("course_name:**");
            }
            if(status!=null&&status!=""){
                filterQuery.addFilterQuery("status:"+status);
            }
            if(is_free!=null&&is_free!=""){
                filterQuery.addFilterQuery("is_free:"+is_free);
            }
            if(category_name1!=null&&category_name1!=""){
                filterQuery.addFilterQuery("category_name1:"+category_name1);
            }
            if(category_name2!=null&&category_name2!=""){
                filterQuery.addFilterQuery("category_name2:"+category_name2);
            }
            if(category_name3!=null&&category_name3!=""){
                filterQuery.addFilterQuery("category_name3:"+category_name3);
            }
            //排序
            //params.addSort("product_price", SolrQuery.ORDER.asc);
            //分页
            filterQuery.setStart(0);
            filterQuery.setRows(20);
            params.add(filterQuery);
           // params.set("fq", stringBuffer.toString());
            QueryResponse queryResponse = client.query(params);
            //获取数据
            SolrDocumentList results = queryResponse.getResults();
            long numFound = results.getNumFound();
            System.out.println(numFound);
            for (SolrDocument result : results) {
                SolrCourse solrCourse=new SolrCourse();
                solrCourse.setId(String.valueOf(result.get("id")));
                solrCourse.setCourse_name(String.valueOf(result.get("course_name")));
                solrCourse.setCategory_name1(String.valueOf(result.get("category_name1")));
                solrCourse.setCategory_name2(String.valueOf(result.get("category_name2")));
                solrCourse.setCategory_name3(String.valueOf(result.get("category_name3")));
                solrCourse.setIs_free(String.valueOf(result.get("is_free")));
                solrCourse.setCourse_original(String.valueOf(result.get("course_original")));
                solrCourse.setIs_putaway(String.valueOf(result.get("is_putaway")));
                solrCourse.setStatus(String.valueOf(result.get("status")));
                //System.out.println("SOLR:"+String.valueOf(result.get("course_name")));
                courses.add(solrCourse);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return DtoUtil.returnDataSuccess(courses);
    }

}
