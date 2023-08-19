package com.github.mimiknight.panda.common.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * MyBatis配置类
 *
 * @author MiMiKnight victor2015yhm@gmail.com
 * @since 2023-08-18 22:39:13
 */
@MapperScan(basePackages = {"com.github.mimiknight.panda.mapper"})
@Configuration
public class MyBatisConfig {

}
