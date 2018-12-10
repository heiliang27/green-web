package com.green.generator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.FileOutConfig;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

public class MybatisGenerator extends AbstractGeneratorConfig {
	
	
	public static void main(String[] args) {
		AbstractGeneratorConfig  abstractGenerator = new MybatisGenerator();
		abstractGenerator.doGeneration();		
	}

	String projectPath = null;

	public static String scanner(String tip) {
		Scanner scanner = new Scanner(System.in);
		StringBuilder help = new StringBuilder();
		help.append("请输入" + tip + "：");
		System.out.println(help.toString());
		if (scanner.hasNext()) {
			String ipt = scanner.next();
			if (StringUtils.isNotEmpty(ipt)) {
				return ipt;
			}
		}
		throw new MybatisPlusException("请输入正确的" + tip + "！");
	}	

	@Override
	protected void config() {
		GlobalConfig();
		DataSourceConfig();
		PackageConfig();
		InjectionConfig();
		templateConfig();
		StrategyConfig();
	}

	/** 全局配置 */
	private void GlobalConfig() {
		projectPath = System.getProperty("user.dir");
		gc.setOutputDir(projectPath + "/src/main/java");
		gc.setAuthor("limingliang");
		gc.setBaseColumnList(true);
		gc.setBaseResultMap(false);
		gc.setOpen(false);
	}

	/** 数据源配置 */
	private void DataSourceConfig() {
		dsc.setUrl("jdbc:mysql://127.0.0.1/green?useUnicode=true&characterEncoding=UTF8&useSSL=false");
		// dsc.setSchemaName("public");
		dsc.setDriverName("com.mysql.jdbc.Driver");
		dsc.setUsername("root");
		dsc.setPassword("12345678");
	}

	/** 包配置 */
	private void PackageConfig() {
		pc.setModuleName(scanner("模块名"));
		pc.setParent("com.green.modular");
	}

	/** 自定义配置 */
	private void InjectionConfig() {
		cfg = new InjectionConfig() {
			@Override
			public void initMap() {
				// to do nothing
			}
		};
		List<FileOutConfig> focList = new ArrayList<>();
		focList.add(new FileOutConfig("/templates/mapper.xml.ftl") {
			@Override
			public String outputFile(TableInfo tableInfo) {
				// 自定义输入文件名称
				return projectPath + "/src/main/resources/mapper/" + pc.getModuleName() + "/"
						+ tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
			}
		});
		cfg.setFileOutConfigList(focList);
	}

	/** 策略配置 */
	private void StrategyConfig() {
		strategy.setNaming(NamingStrategy.underline_to_camel);
		strategy.setColumnNaming(NamingStrategy.underline_to_camel);
//		strategy.setSuperEntityClass("com.green.common.base.BaseEntity");
		strategy.setEntityLombokModel(true);
		strategy.setRestControllerStyle(true);
		strategy.setSuperControllerClass("com.green.common.base.BaseController");
		strategy.setInclude(scanner("表名").split("[,;]"));
//		strategy.setSuperEntityColumns("id");
		strategy.setControllerMappingHyphenStyle(true);
		strategy.setTablePrefix(pc.getModuleName() + "_");
	}

	/** 模板配置 */
	private void templateConfig() {
		mpg.setTemplate(new TemplateConfig().setXml(null));
		mpg.setTemplateEngine(new FreemarkerTemplateEngine());
	}
}
