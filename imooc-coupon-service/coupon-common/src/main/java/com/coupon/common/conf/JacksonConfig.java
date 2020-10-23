package com.coupon.common.conf;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.catalina.mapper.Mapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;

/**
 * @author zuorui
 * @creat 2020-10-23-19:30
 */
@Configuration
public class JacksonConfig {

    @Bean
    public ObjectMapper getMapper() {

        ObjectMapper mapper = new ObjectMapper();
        mapper.setDateFormat(new SimpleDateFormat("yyyy-mm-dd HH:mm:ss"));
        return mapper;
    }
}
