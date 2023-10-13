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

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


@Configuration
@EnableTransactionManagement
@ComponentScan("web")
@PropertySource("classpath:db.properties")
public class DBConfig {
    private Environment env;

   /* private static final String URL = "jdbc:mysql://localhost:3306/mvc-users";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static Connection connection;

    static {
        try {
            //registering the jdbc driver here, your string to use
            //here depends on what driver you are using.
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("CLASS NOT FOUND");
        }
    }

    static {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connected successfully");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Disconnected");
        }
    }
*/


    @Autowired
    public DBConfig(Environment env){
        this.env = env;
    }


    @Bean
    public LocalContainerEntityManagerFactoryBean getEntityManagerFactory(){
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setPackagesToScan("web");
        em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        em.setJpaProperties(getHibernateProperties());
        em.setDataSource(getDataSource());
        return em;
    }

    @Bean
    public PlatformTransactionManager getTransactionManager(){
        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
        jpaTransactionManager.setEntityManagerFactory(getEntityManagerFactory().getObject());
        return jpaTransactionManager;
    }

    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSources = new DriverManagerDataSource();
        dataSources.setDriverClassName(env.getRequiredProperty("db.driver"));
        dataSources.setUrl(env.getRequiredProperty("db.url"));
        dataSources.setUsername(env.getRequiredProperty("db.username"));
        dataSources.setPassword(env.getRequiredProperty("db.password"));

        return dataSources;
    }
    private Properties getHibernateProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", env.getRequiredProperty("hibernate.dialect"));
        properties.put("hibernate.show_sql", env.getRequiredProperty("hibernate.show_sql"));
        properties.put("hibernate.hbm2ddl.auto", env.getRequiredProperty("hibernate.hbm2ddl.auto"));
        return properties;

    }


}
