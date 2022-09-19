// 包说明：fomatter，格式化器
// Formatter<T> 的作用与 Converter（类型转换器）相似，都是可以将一种数据类型转换成另一种数据类型。
// 但不同的是，Formatter 的源类型和目标类型之一必须是 String 类型，而 Converter 的源类型和目标类型可以是任意数据类型。
package net.biancheng.c.fomatter.entity;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author C语言中文网
 */
public class Supermarket {

    private String name;

    // 日期格式化器：将 对 java.util.Date、java.util.Calendar、java.long.Long 等时间类型的数据进行标注，以实现对日期类型的数据进行格式化处理。
    // 此例中格式化为 "yyyy-MM-dd" 形式。
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

    // 数值格式化器：用来格式化任何数字基本类型（如 int、long 等）或 java.lang.Number 类型的实例（如 BigDecimal、Integer 等)。
    // 此例中格式化为 CURRENCY 类型（即现金类型）
    @NumberFormat(style = NumberFormat.Style.CURRENCY)
    private BigDecimal money;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public BigDecimal getMoney() {
        return money;
    }
    public void setMoney(BigDecimal money) {
        this.money = money;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    @Override
    public String toString() {
        return "Supermarket{" +
                "name='" + name + '\'' +
                ", date=" + date +
                ", money=" + money +
                '}';
    }
}
