package web.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.PersistenceContext;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableAspectJAutoProxy
@EnableTransactionManagement
//@PropertySource("db.properties")

public class DBConfig {

    @PersistenceContext
    private Environment env;



    @Autowired
    public DBConfig(Environment env){
        this.env = env;
    }


    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSources = new DriverManagerDataSource();
        dataSources.setDriverClassName(env.getRequiredProperty("com.mysql.cj.jdbc.Driver"));
        dataSources.setUrl(env.getRequiredProperty("jdbc:mysql://localhost:3306/mvc-users?verifyServerCertificate=false&useSSL=false&requireSSL=false&useLegacyDatetimeCode=false&amp&serverTimezone=UTC"));
        dataSources.setUsername(env.getRequiredProperty("root"));
        dataSources.setPassword(env.getRequiredProperty("root"));

        return dataSources;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean getEntityManagerFactory(){
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(getDataSource());
        em.setPackagesToScan("web");
        em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        em.setJpaProperties(getHibernateProperties());
        return em;
    }

    @Bean
    public PlatformTransactionManager getTransactionManager(){
        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
        jpaTransactionManager.setEntityManagerFactory(getEntityManagerFactory().getObject());
        return jpaTransactionManager;
    }

    private Properties getHibernateProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", env.getRequiredProperty("org.hibernate.dialect.MySQL8Dialect"));
        properties.put("hibernate.show_sql", env.getRequiredProperty("true"));
        properties.put("hibernate.hbm2ddl.auto", env.getRequiredProperty("create"));
        return properties;

    }
}
