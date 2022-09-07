package net.biancheng.c.di.collection;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class JavaCollection2 {
    //1 对象数组
    private Course[] courses;
    //2 list 集合类型属性
    private List<String> list;
    //3 map 集合类型属性
    private Map<String, String> maps;
    //4 set 集合类型属性
    private Set<String> sets;

    public JavaCollection2(){

    }

    //全构造函数
    public JavaCollection2(Course[] courses, List<String> list, Map<String, String> maps, Set<String> sets){
        this.courses = courses;
        this.list = list;
        this.sets = sets;
        this.maps = maps;
    }

    @Override
    public String toString() {
        return "JavaCollection2{" +
                "courses=" + Arrays.toString(courses) +
                ", list=" + list +
                ", maps=" + maps +
                ", sets=" + sets +
                '}';
    }
}
