package com.work.conf;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ConditionalOnClass({
		EnableTransactionManagement.class/* , EntityManager.class */ })
@AutoConfigureAfter({ DataBaseConfiguration.class })
@MapperScan(basePackages = { "springboot_demo.mapper" })
public class MyBatisConfiguration implements EnvironmentAware {
	private static Log logger = LogFactory.getLog(MyBatisConfiguration.class);

	private RelaxedPropertyResolver propertyResolver;

	@Resource(name = "writeDataSource")
	private DataSource writeDataSource;

/*	@Resource(name = "readDataSources")
	private List<Object> readDataSources;*/

	public void setEnvironment(Environment environment) {
		this.propertyResolver = new RelaxedPropertyResolver(environment, "mybatis.");
	}

	@Bean
	@ConditionalOnMissingBean
	public SqlSessionFactory sqlSessionFactory() {
		try {
			SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
			sessionFactory.setDataSource(writeDataSource);
			sessionFactory.setTypeAliasesPackage(propertyResolver.getProperty("typeAliasesPackage"));
			sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
					.getResources(propertyResolver.getProperty("mapperLocations")));
			sessionFactory.setConfigLocation(
					new DefaultResourceLoader().getResource(propertyResolver.getProperty("configLocation")));

			return sessionFactory.getObject();
		} catch (Exception e) {
			logger.warn("Could not confiure mybatis session factory");
			return null;
		}
	}

	/*
	 * @Bean public RoundRobinRWRoutingDataSourceProxy
	 * roundRobinDataSouceProxy(){ RoundRobinRWRoutingDataSourceProxy proxy =
	 * new RoundRobinRWRoutingDataSourceProxy();
	 * proxy.setWriteDataSource(writeDataSource);
	 * proxy.setReadDataSoures(readDataSources); proxy.setReadKey("READ");
	 * proxy.setWriteKey("WRITE");
	 * 
	 * return proxy; }
	 */

	@Bean
	@ConditionalOnMissingBean
	public DataSourceTransactionManager transactionManager() {
		return new DataSourceTransactionManager(writeDataSource);
	}
}
