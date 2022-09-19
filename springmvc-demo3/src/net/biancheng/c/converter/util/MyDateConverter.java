// 包说明：converter，数据转换器
package net.biancheng.c.converter.util;

// 定义自定义转换器类型必须实现Converter<S, T>（S 表示原类型，T 表示目标类型），
// 还可以实现 ConverterFactory 或 GenericConverter 接口。
// Spring MVC 内置多种类型转换器，基本满足开发需求。正是有了类型转换器（converter）的存在，控制器方法才能获取各种类型的参数。
import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 自定义日期转换器（String 转为 Data 类型）
 */
public class MyDateConverter implements Converter<String, Date> {
    private String datePatten = "yyyy-MM-dd";
    @Override
    public Date convert(String source) {
        System.out.println("前端页面传递过来的时间为：" + source);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(datePatten);
        try {
            return simpleDateFormat.parse(source);
        } catch (ParseException e) {
            throw new IllegalArgumentException("无效的日期格式，请使用正确的日期格式" + datePatten);
        }
    }
}
