package com.ruoyi.business.config;

import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.SimpleDateFormatSerializer;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;

import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * fastjson转换器
 * @author: Husp
 * @date: 2023/9/24 13:11
 */
@Configuration
public class FastjsonConvertConfig {

    @Bean
    public HttpMessageConverters httpMessageConverters(){
        FastJsonHttpMessageConverter fastJsonConverter = new FastJsonHttpMessageConverter();
        // 可支持的类型
        List<MediaType> typeList = new ArrayList<>();
        typeList.add(MediaType.APPLICATION_JSON);
        fastJsonConverter.setSupportedMediaTypes(typeList);
        // 全局配置
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setCharset(Charset.forName("UTF-8"));
        fastJsonConverter.setFastJsonConfig(fastJsonConfig);
        fastJsonConfig.setSerializerFeatures(
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteNullListAsEmpty,
                SerializerFeature.WriteMapNullValue
        );
        SerializeConfig serializeConfig = new SerializeConfig();
        serializeConfig.put(LocalDate.class, new SimpleDateFormatSerializer("yyyy-MM-dd HH:mm:ss"));
        serializeConfig.put(BigDecimal.class, new MyBigDecimalSerializer(2));
        fastJsonConfig.setSerializeConfig(serializeConfig);

        fastJsonConverter.setFastJsonConfig(fastJsonConfig);
        return new HttpMessageConverters(fastJsonConverter);
    }

}
