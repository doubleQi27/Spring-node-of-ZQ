package net.biancheng.c.aop.aspectJ.annotation;

//AspectJ 相关注解
//@Aspect	用于定义一个切面。
//@Pointcut	用于定义一个切入点。
//通知注解
//@Before	        用于定义前置通知，相当于 BeforeAdvice。
//@AfterReturning	用于定义后置通知，相当于 AfterReturningAdvice。
//@Around	        用于定义环绕通知，相当于 MethodInterceptor。
//@AfterThrowing	用于定义抛出通知，相当于 ThrowAdvice。
//@After	        用于定义最终通知，不管是否异常，该通知都会执行。
//@DeclareParents	用于定义引介通知，相当于 IntroductionInterceptor（不要求掌握）

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component // 定义为 Spring 容器中的 Bean（配合配置类一起使用）
@Aspect //定义为切面（配合配置类 或 XML 切面 Bean 定义使用）
public class MyAspect {

    //（前置）通知，其 value 属性为一个 expression，表明通知作用的切点
    //也可以使用切入点引用的方式，即使用定义好的切入点
    @Before("execution(* net.biancheng.c.aop.aspectJ.annotation.dao.IUserDao.add(..))")
    public void before(JoinPoint joinPoint) {
        System.out.println("前置增强……" + joinPoint);
    }

    @After("execution(* net.biancheng.c.aop.aspectJ.annotation.dao.IUserDao.get(..))")
    public void after(JoinPoint joinPoint) {
        System.out.println("最终增强……" + joinPoint);
    }

    /**
     * 将 net.biancheng.c.dao包下的 UserDao 类中的 get() 方法 定义为一个切点
     */
    @Pointcut(value = "execution(* net.biancheng.c.aop.aspectJ.annotation.dao.IUserDao.get(..))")
    //注意：定义为切点的方法，它的返回值类型必须为 void
    public void pointCut1() {
    }

    /**
     * 将 net.biancheng.c.dao包下的 UserDao 类中的 delete() 方法 定义为一个切点
     */
    @Pointcut(value = "execution(* net.biancheng.c.aop.aspectJ.annotation.dao.IUserDao.delete(..))")
    //注意：定义为切点的方法，它的返回值类型必须为 void
    public void pointCut2() {
    }

    //使用切入点引用
    @Around("MyAspect.pointCut2()")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("环绕增强……1");
        proceedingJoinPoint.proceed();
        System.out.println("环绕增强……2");
    }

    //使用切入点表达式（AfterReturn 注解有两个属性，所以必须注明属性名称）
    @AfterReturning(value = "execution(* net.biancheng.c.aop.aspectJ.annotation.dao.IUserDao.modify(..))", returning = "returnValue")
    public void afterReturning(Object returnValue) {
        System.out.println("后置返回增强……,方法返回值为：" + returnValue);
    }
}