package cn.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@MapperScan(value = "cn.mapper3",sqlSessionFactoryRef = "sqlSessionFactoryBean3")
public class MyBatisConfigThere {
    @Autowired
    @Qualifier("dsThere")
    DataSource dsThere;
    @Bean
    SqlSessionFactory sqlSessionFactoryBean3() throws Exception{
        SqlSessionFactoryBean factoryBean=new SqlSessionFactoryBean();
        factoryBean.setDataSource(dsThere);
        return factoryBean.getObject();
    }
    @Bean
    SqlSessionTemplate sqlSessionTemplate3() throws Exception{
        return new SqlSessionTemplate(sqlSessionFactoryBean3());
    }
}
