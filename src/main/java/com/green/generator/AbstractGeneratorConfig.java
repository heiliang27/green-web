package com.green.generator;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;

public abstract class AbstractGeneratorConfig {
	// 代码生成器
	AutoGenerator mpg = new AutoGenerator();
	// 全局配置
	GlobalConfig gc = new GlobalConfig();
	// 数据源配置
	DataSourceConfig dsc = new DataSourceConfig();
	// 包配置
	PackageConfig pc = new PackageConfig();
	// 策略配置
	StrategyConfig strategy = new StrategyConfig();
	// 自定义配置
	InjectionConfig cfg = null;

	protected abstract void config();

	// 构造方法
	public AbstractGeneratorConfig() {
	}

	// 执行方法
	public void doGeneration() {
		config();		
		mpg.setGlobalConfig(gc);
		mpg.setDataSource(dsc);
		mpg.setPackageInfo(pc);
		mpg.setCfg(cfg);
		mpg.setStrategy(strategy);
		mpg.execute();
	}

}
