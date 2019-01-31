package com.lysj.property.datasource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author fupeng
 * @date 2019/1/19
 */
@Configuration
@MapperScan("com.lysj.property.dao.**")
public class MyBatisConfig {
}
