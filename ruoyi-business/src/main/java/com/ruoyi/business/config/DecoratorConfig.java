package com.ruoyi.business.config;

import com.ruoyi.business.domain.Beauty;
import com.ruoyi.business.domain.Filters;
import com.ruoyi.business.domain.VedioDecorator;
import com.ruoyi.business.service.IVideoService;
import com.ruoyi.business.service.impl.VideoServiceImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 装饰者配置bean
 * @Author Husp
 * @Date 2023/10/19 15:00
 */
@Configuration
public class DecoratorConfig {

    @Bean("videoService")
    IVideoService videoService(){
        return new VideoServiceImpl();
    }

    @Bean("beauty")
    Beauty beauty(@Qualifier("videoService") IVideoService videoService){
        return new Beauty(videoService);
    }

    @Bean("filters")
    Filters filters(@Qualifier("videoService") IVideoService videoService){
        return new Filters(videoService);
    }
}
