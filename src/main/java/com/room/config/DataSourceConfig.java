package com.room.config;
import java.util.Properties;
import javax.sql.DataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.aop.framework.autoproxy.BeanNameAutoProxyCreator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.interceptor.TransactionInterceptor;
import org.springframework.context.annotation.PropertySource;
import com.alibaba.druid.pool.DruidDataSource;
/**
 ************************************************************
 * @类名 : DataSourceConfig.java
 *
 * @DESCRIPTION :数据源相关配置
 ************************************************************
 */
@Configuration
@EnableTransactionManagement
@MapperScan(basePackages = { "com.room.dao" }, sqlSessionFactoryRef = "sqlSessionFactory")

public class DataSourceConfig {
	/**
	 * 配置数据源
	 * 给其中一个数据源加上@Primary。因为在Spring Boot Jdbc的自动配置过程中，会对于开发者透明地使用dataSource进行一些相关配置，所以当有两个Datasource实现类时，Spring Boot将无法确定使用哪一个。
		当我们不为@Bean指定名字时，Spring会默认使用方法名作为Bean的名字，所以下面两个数据源的名字分别为prodDataSource和devDataSource。
	 * @return
	 */
    @Bean(name = "datasource")
  //配置文件里的属性名是不需要写成spring.datasource.xxx的形式的，写成a.b.c.url也没有问题，只要在配置bean时指定前缀为a.b.c
    @ConfigurationProperties(prefix = "spring.datasource.dev")
    @Primary
    public DataSource testDataSource() {
        return new DruidDataSource();
    }
    @Bean(name = "sqlSessionFactory")
    @Primary
    public SqlSessionFactory testSqlSessionFactory(@Qualifier("datasource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        System.out.println("数据库配置："+dataSource);
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:/mapper/*.xml"));
        // 开启驼峰命名转换
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        configuration.setMapUnderscoreToCamelCase(true);
        bean.setConfiguration(configuration);
        return bean.getObject();
    }
    /**
	 * 配置事务管理器
	 * @param prodDataSource
	 * @return
	 */
    @Bean(name = "transactionManager")
    @Primary
    public DataSourceTransactionManager testTransactionManager(@Qualifier("datasource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
    /**
	 * 配置JdbcTemplate
	 * 在此我们返回的不是JdbcTemplate的实现，而是其实现接口JdbcOperations。
		使用@Qualifier注解指定该注入哪个bean，默认名字为定义该bean的方法名。
	 * @param prodDataSource
	 * @return
	 */
    @Bean(name = "sqlSessionTemplate")
    @Primary
    public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("sqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
    @Bean(name = "txAdvice")
    @Primary
    public TransactionInterceptor transactionInterceptor(PlatformTransactionManager transactionManager) {
        final String PROPAGATION_REQUIRED = "PROPAGATION_REQUIRED,-Exception";
        TransactionInterceptor interceptor = new TransactionInterceptor();
        interceptor.setTransactionManager(transactionManager);
        Properties transactionAttributes = new Properties();
        // TransactionDefinition.PROPAGATION_REQUIRED;
        transactionAttributes.setProperty("insert*", PROPAGATION_REQUIRED);
        transactionAttributes.setProperty("update*", PROPAGATION_REQUIRED);
        transactionAttributes.setProperty("delete*", PROPAGATION_REQUIRED);
        transactionAttributes.setProperty("select*", PROPAGATION_REQUIRED + ",readOnly");
        interceptor.setTransactionAttributes(transactionAttributes);
        return interceptor;
    }
    @Bean
    @Primary
    public BeanNameAutoProxyCreator transactionAutoProxy() {
        BeanNameAutoProxyCreator bapc = new BeanNameAutoProxyCreator();
        bapc.setExposeProxy(true);
        bapc.setBeanNames("*ServiceImpl");
        bapc.setInterceptorNames("txAdvice");
        return bapc;
    }
}
