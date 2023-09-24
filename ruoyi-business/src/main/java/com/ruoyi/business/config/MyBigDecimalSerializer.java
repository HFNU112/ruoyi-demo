package com.ruoyi.business.config;

import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;

import java.io.IOException;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author: Husp
 * @date: 2023/9/24 17:55
 */
public class MyBigDecimalSerializer implements ObjectSerializer {

    private final Integer newScale;

    public MyBigDecimalSerializer(Integer newScale) {
        this.newScale = newScale;
    }

    @Override
    public void write(JSONSerializer serializer, Object object, Object fieldName, Type fieldType, int features) throws IOException {
        if (object == null){
            serializer.out.write("0.00");
            return;
        }
        serializer.out.write(((BigDecimal)object).setScale(newScale, RoundingMode.DOWN).toString());
    }
}
