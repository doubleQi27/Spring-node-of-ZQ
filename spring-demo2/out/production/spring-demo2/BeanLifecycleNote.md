# Spring Bean 生命周期
## Spring 中 Bean 的生命周期较复杂，大致可以分为以下 5 个阶段：
    Bean 的实例化
    Bean 属性赋值
    Bean 的初始化
    Bean 的使用
    Bean 的销毁
## Spring 根据 Bean 的作用域来选择 Bean 的管理方式:
    对于 singleton 作用域的 Bean 来说，Spring IoC 容器能够精确地控制 Bean 何时被创建、何时初始化完成以及何时被销毁；
    对于 prototype 作用域的 Bean 来说，Spring IoC 容器只负责创建，然后就将 Bean 的实例交给客户端代码管理，Spring IoC 容器将不再跟踪其生命周期
 
## Spring Bean 的完整生命周期从创建 Spring IoC 容器开始，直到最终 Spring IoC 容器销毁 Bean 为止，其具体流程如下：
    Bean 实例化 ——> Bean属性注入 ——> 调用 BeanNameAware 的 setBeanName() 方法 ——> 调用 BeanFactoryAware 中的 setBeanFactory() 方法
    ——> 调用 ApplicationContextAware 的 setApplicationContext() 方法 ——> 调用 BeanPostProcessor 的预初始化方法
    ——> 调用 InitializingBean 的 afterPropertiesSet() 方法 ——> 调用自定义的初始化方法 ——> 调用 BeanPostProcessor 的后初始化方法
    ——> Bean 可以用了 ——> 调用 DisposableBean 的 destory() 方法 ——> 调用 destory-method 属性指定的销毁方法

    链接：http://c.biancheng.net/uploads/allimg/220119/1F32KG1-0.png
    
    Bean 生命周期的整个执行过程描述如下。
    Spring 启动，查找并加载需要被 Spring 管理的 Bean，对 Bean 进行实例化。
    对 Bean 进行属性注入。
    如果 Bean 实现了 BeanNameAware 接口，则 Spring 调用 Bean 的 setBeanName() 方法传入当前 Bean 的 id 值。
    如果 Bean 实现了 BeanFactoryAware 接口，则 Spring 调用 setBeanFactory() 方法传入当前工厂实例的引用。
    如果 Bean 实现了 ApplicationContextAware 接口，则 Spring 调用 setApplicationContext() 方法传入当前 ApplicationContext 实例的引用。
    如果 Bean 实现了 BeanPostProcessor 接口，则 Spring 调用该接口的预初始化方法 postProcessBeforeInitialzation() 对 Bean 进行加工操作，此处非常重要，Spring 的 AOP 就是利用它实现的。
    如果 Bean 实现了 InitializingBean 接口，则 Spring 将调用 afterPropertiesSet() 方法。
    如果在配置文件中通过 init-method 属性指定了初始化方法，则调用该初始化方法。
    如果 BeanPostProcessor 和 Bean 关联，则 Spring 将调用该接口的初始化方法 postProcessAfterInitialization()。此时，Bean 已经可以被应用系统使用了。
    如果在 <bean> 中指定了该 Bean 的作用域为 singleton，则将该 Bean 放入 Spring IoC 的缓存池中，触发 Spring 对该 Bean 的生命周期管理；如果在 <bean> 中指定了该 Bean 的作用域为 prototype，则将该 Bean 交给调用者，调用者管理该 Bean 的生命周期，Spring 不再管理该 Bean。
    如果 Bean 实现了 DisposableBean 接口，则 Spring 会调用 destory() 方法销毁 Bean；如果在配置文件中通过 destory-method 属性指定了 Bean 的销毁方法，则 Spring 将调用该方法对 Bean 进行销毁。

# 自定义 Bean 生命周期
    我们可以在 Spring Bean 生命周期的某个特定时刻，指定一些生命周期回调方法完成一些自定义的操作，对 Bean 的生命周期进行管理。
    
    Bean 的生命周期回调方法主要有两种：
    初始化回调方法：在 Spring Bean 被初始化后调用，执行一些自定义的回调操作。
    销毁回调方法：在 Spring Bean 被销毁前调用，执行一些自定义的回调操作。
    
    我们可以通过以下 3 种方式自定义 Bean 的生命周期回调方法：
    通过接口实现
    通过 XML 配置实现
    使用注解实现
    
    如果一个 Bean 中有多种生命周期回调方法时，优先级顺序为：注解 > 接口 > XML 配置。
## 使用注解实现
    @PostConstruct：指定初始化回调方法，这个方法会在 Spring Bean 被初始化后被调用，执行一些自定义的回调操作。
    @PreDestroy：指定销毁回调方法，这个方法会在 Spring Bean 被销毁前被调用，执行一些自定义的回调操作。
## 实现接口实现
    初始化回调	InitializingBean 	afterPropertiesSet() 	指定初始化回调方法，这个方法会在 Spring Bean 被初始化后被调用，执行一些自定义的回调操作。
    销毁回调	     DisposableBean	           destroy() 	    指定销毁回调方法，这个方法会在 Spring Bean 被销毁前被调用，执行一些自定义的回调操作。
## 通过XML配置实现
    init-method	    指定初始化回调方法，这个方法会在 Spring Bean 被初始化后被调用，执行一些自定义的回调操作。
    destory-method	指定销毁回调方法，这个方法会在 Spring Bean 被销毁前被调用，执行一些自定义的回调操作。
# BeanPostProcessor 接口——后置处理器
    该接口中包含了两个方法：
    postProcessBeforeInitialization() 方法：在 Bean 实例化、属性注入后，初始化前调用。
    postProcessAfterInitialization() 方法：在 Bean 实例化、属性注入、初始化都完成后调用。
    注意：两个方法返回值不能为 null，否则报空指针异常 或 getBean 无法获取对象
    
    当需要添加多个后置处理器实现类时，默认情况下 Spring 容器会根据后置处理器的定义顺序来依次调用;
    也可以通过实现 Ordered 接口的 getOrder 方法指定后置处理器的执行顺序。该方法返回值为整数，默认值为 0，取值越大优先级越低。