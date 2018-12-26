package com.green.config;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.pool.DruidDataSource;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.green.common.enums.DatasourceEnum;
import com.green.config.properties.DruidProperties;
import com.green.core.datasource.DynamicDataSource;

@Configuration
@EnableConfigurationProperties(DruidProperties.class)
@MapperScan(basePackages = { "com.green.modular.**.mapper" })
public class MybatisConfig {

	private final DruidProperties druidProperties;

	public MybatisConfig(DruidProperties druidProperties) {
		this.druidProperties = druidProperties;
	}

	@Bean
	public DataSource dataSource() {
		DynamicDataSource dynamicDataSource = new DynamicDataSource();
		DataSource greenDataSource = greenDataSource();
		DataSource hadesDataSource = hadesDataSource();
		Map<Object, Object> targetDataSources = new HashMap<>();
		targetDataSources.put(DatasourceEnum.DATA_SOURCE_GREEN, greenDataSource);
		targetDataSources.put(DatasourceEnum.DATA_SOURCE_HADES, hadesDataSource);
		dynamicDataSource.setTargetDataSources(targetDataSources);
		dynamicDataSource.setDefaultTargetDataSource(greenDataSource);
		System.out.println("*****dynamicDataSource************************************");
		return dynamicDataSource;
	}

	@Bean
	public PaginationInterceptor paginationInterceptor() {
		return new PaginationInterceptor();
	}

	private DataSource greenDataSource() {
		DruidDataSource dataSource = new DruidDataSource();
		druidProperties.greenConfig(dataSource);
		System.out.println("*****green数据源加载************************************");
		return dataSource;
	}

	private DataSource hadesDataSource() {
		DruidDataSource dataSource = new DruidDataSource();
		druidProperties.hadesConfig(dataSource);
		System.out.println("*****hades数据源加载************************************");
		return dataSource;
	}
}
