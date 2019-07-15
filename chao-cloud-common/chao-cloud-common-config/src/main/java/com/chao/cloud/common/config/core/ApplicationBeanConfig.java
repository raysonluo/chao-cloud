package com.chao.cloud.common.config.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.ConversionService;
import org.springframework.format.support.FormattingConversionServiceFactoryBean;

import com.chao.cloud.common.core.ApplicationRefreshed;
import com.chao.cloud.common.core.SpringContextUtil;

/**
 * 
 * @功能：核心配置
 * @author： 薛超
 * @时间： 2019年7月15日
 * @version 1.0.0
 */
@Configuration
public class ApplicationBeanConfig {

	/**
	 * 全局spring容器
	 * 
	 * @return
	 */
	@Bean
	public SpringContextUtil springContextUtil(ApplicationContext applicationContext) {
		SpringContextUtil util = new SpringContextUtil();
		util.setApplicationContext(applicationContext);
		return util;
	}

	@Bean
	public ApplicationRefreshed application() {
		return new ApplicationRefreshed();
	}

	/**
	 * 类型转换器
	 */
	@Bean
	public ConversionService conversionService() {
		FormattingConversionServiceFactoryBean factoryBean = new FormattingConversionServiceFactoryBean();
		factoryBean.afterPropertiesSet();
		return factoryBean.getObject();
	}

}
