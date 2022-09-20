package net.biancheng.c.annotationconfig.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 自定义日期转换器
 */
public class MyDateConverter implements Converter<String, Date> {
    private String datePatten = "yyyy-MM-dd";
    @Override
    public Date convert(String source) {
        System.out.println("自定义的类型转换器生效；前端页面传递过来的时间为：" + source);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(datePatten);
        try {
            return simpleDateFormat.parse(source);
        } catch (ParseException e) {
            throw new IllegalArgumentException("无效的日期格式，请使用正确的日期格式" + datePatten);
        }
    }
}
