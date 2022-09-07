#为什么要自动装配：
    简化XML配置。当然，可以使用多个XML以简化每个XML的配置，但由此产生的问题就是要创建多个容器（ApplicationContext）对象
#什么是Spring自动装配：
    自动装配功能即让 Spring 容器依据某种规则（自动装配的规则，有五种），为指定的 Bean 从应用的上下文（AppplicationContext 容器）
    中查找它所依赖的 Bean，并自动建立 Bean 之间的依赖关系。这一过程是在完全不使用任何 <constructor-arg>和 <property> 元素 ref 
    属性的情况下进行的。
#如何进行自动装配：
    spring 框架默认不支持自动装配，若要自动装配，需设置 bean 的 autowire 属性。
    autowire 的五个属性值：
        byName：按名称自动装配。若某个 Bean 的 id 或 name 属性值与某个Java类（另外一个Bean）的 对象属性 的名称相同，则获取这个 Bean，并与当前的 Java 类 Bean 建立关联关系。
        byType：按类型自动装配。若某个 Bean 的 class 属性值与某个Java类（另外一个Bean）的 对象属性 的类型相匹配，则获取这个 Bean，并与当前的 Java 类的 Bean 建立关联关系。
        constructor：与 byType 模式相似，不同之处在与它应用于构造器参数（依赖项），如果在容器中没有找到与构造器参数类型一致的 Bean，那么将抛出异常。
                     其实就是根据构造器参数的数据类型，进行 byType 模式的自动装配。
        default：表示默认采用上一级元素 <beans> 设置的自动装配规则（default-autowire）进行装配。
        no：默认值，表示不使用自动装配，Bean 的依赖关系必须通过 <constructor-arg>和 <property> 元素的 ref 属性来定义。
   
#使用注解注入 Bean 
    spring 默认不使用注解装配 Bean，为使用注解装配 Bean，需执行以下操作：
    1. 通过 <context:component-scan> 元素开启 Spring Beans的自动扫描功能。
       开启此功能后，Spring 会自动从扫描指定的包（base-package 属性设置）及其子包下的所有类，
       如果类上使用了 @Component 注解，就将该类装配到容器中。
    2. 在 XML 配置的一级标签 <beans> 中添加 context 相关的约束以使 <context:component-scan>可用。
    
    ##用于定义 spring Bean 的注解：
    1. @Component
    该注解用于描述 Spring 中的 Bean，它是一个泛化的概念，仅仅表示容器中的一个组件（Bean），并且可以作用在应用的任何层次，例如 Service 层、Dao 层等。
    使用时只需将该注解标注在相应类上即可。
    2. @Repository
    该注解用于将数据访问层（Dao 层）的类标识为 Spring 中的 Bean，其功能与 @Component 相同。
    3. @Service
    该注解通常作用在业务层（Service 层），用于将业务层的类标识为 Spring 中的 Bean，其功能与 @Component 相同。
    4. @Controller
    该注解通常作用在控制层（如 Struts2 的 Action、SpringMVC 的 Controller），用于将控制层的类标识为 Spring 中的 Bean，其功能与 @Component 相同。
    
    ##基于注解方式实现依赖注入：
    1. @Autowired
    可以应用到 Bean 的属性变量、setter 方法、非 setter 方法及构造函数等。
    @Autowired 注解默认按照 Bean 的类型进行装配。
    默认情况下，@Autowired要求依赖对象必须存在，如果允许 null 值，可以设置它的 required 属性为 false。
    如果想按照名称（byName）来装配，可以结合 @Qualifier 注解一起使用。
    
    2. @Resource
    作用与 Autowired 相同，但 @Resource 默认按照 Bean 的名称进行装配。
    @Resource 中有两个重要属性：name 和 type。
    · Spring 将 name 属性解析为 Bean 的实例名称，type 属性解析为 Bean 的实例类型。
    · 如果指定 name 属性，则按实例名称进行装配；
    · 如果指定 type 属性，则按 Bean 类型进行装配；
    · 如果都不指定，则先按 Bean 实例名称装配，如果不能匹配，则再按照 Bean 类型进行装配；如果都无法匹配，则抛出 NoSuchBeanDefinitionException 异常。
    
    3. @Qualifier
    与 @Autowired 注解配合使用，会将默认的按 Bean 类型装配修改为按 Bean 的实例名称装配，Bean 的实例名称由 @Qualifier 注解的参数指定。
    