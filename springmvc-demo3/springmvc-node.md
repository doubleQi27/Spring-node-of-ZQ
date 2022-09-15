# spring MVC 之 web.xml 文件
用于配置 spring MVC 项目的各 servlet 及 servlet-mappimg 等内容。

# 前端控制器 DispatcherServlet
spring MVC 基于 Servlet，DispatcherServlet 是整个 Spring MVC 框架的核心，主要负责截获请求并将其分派给相应的处理器（Handler，即 controller）处理。
DispatcherServlet 既然是一个 servlet，自然需要在 web.xml 中进行配置。
## servlet 标签
用于配置一个 servlet。
子标签：
    servlet-name：servlet 的名称；
    servlet-class：servlet 对应类路径
## servlet-mapping 标签
定义 servlet 映射。
子标签：
    servlet-name：servlet 的名称（与对应的 servlet 配置的 servlet-name 相同）；
    url-pattern：设置springMVC的核心控制器所能处理的请求的请求路径。
        eg：<url-pattern>/</url-pattern>
        注意：“/”所匹配的请求可以是/login或.html或.js或.css方式的请求路径，但是“/”不能匹配.jsp请求路径的请求

# {servlet-name}-servlet.xml 文件
Spring MVC 初始化时，会自动从应用程序的 WEB-INF 目录下查找 Spring MVC 的配置文件。该配置文件的默认命名规则为 {servlet-name}-servlet.xml。
    eg：springMVC-servlet.xml，表示在 web.xml中设置的 DispatcherServlet 名称为 springMVC。

# @controller 注解
将一个普通的 Java 类标识成控制器（Controller）类，Controller 类中的每一个处理请求的方法被称为“控制器方法”。

# spring MVC 工作流程
0. 图片链接：http://c.biancheng.net/uploads/allimg/220729/0314131950-0.png
1. 用户通过浏览器发起一个 HTTP 请求，该请求会被 DispatcherServlet（前端控制器）拦截；
2. DispatcherServlet 调用 HandlerMapping（处理器映射器）找到具体的处理器（Handler）及拦截器，最后以 HandlerExecutionChain 执行链的形式返回给 DispatcherServlet。
3. DispatcherServlet 将执行链返回的 Handler 信息发送给 HandlerAdapter（处理器适配器）；
4. HandlerAdapter 根据 Handler 信息找到并执行相应的 Handler（即 Controller 控制器）对请求进行处理；
5. Handler 执行完毕后会返回给 HandlerAdapter 一个 ModelAndView 对象（Spring MVC 的底层对象，包括 Model 数据模型和 View 视图信息）；
6. HandlerAdapter 接收到 ModelAndView 对象后，将其返回给 DispatcherServlet ；
7. DispatcherServlet 接收到 ModelAndView 对象后，会请求 ViewResolver（视图解析器）对视图进行解析；
8. ViewResolver 解析完成后，会将 View 视图并返回给 DispatcherServlet；
9. DispatcherServlet 接收到具体的 View 视图后，进行视图渲染，将 Model 中的模型数据填充到 View 视图中的 request 域，生成最终的 View（视图）；
10. 视图负责将结果显示到浏览器（客户端）。

# @RequestMapping 注解
通常被标注在控制器方法上，负责将请求与处理请求的控制器方法关联起来，建立映射关系。
使用方式：
    1. 修饰方法
    当 @RequestMapping  注解被标注在方法上时，value 属性值就表示访问该方法的 URL 地址。当用户发送过来的请求想要访问该 Controller 下的控制器方法时，请求路径就必须与这个 value 值相同。
    2. 修饰类
    当 @RequestMapping 注解标注在控制器类上时，value 属性的取值就是这个控制器类中的所有控制器方法 URL 地址的父路径。也就是说，访问这个 Controller 下的任意控制器方法都需要带上这个父路径。
    此外，为访问到具体的处理器方法，还需在 Controller 类的方法上也加上 @RequestMapping 注解。
属性：
    1. value 属性
    value 属性是 @RequestMapping 注解的默认属性（当只设置一个属性值时，属性名 value 可省略），
    用来设置控制器方法的请求映射地址。所有能够匹配到该请求映射地址的请求，都可以被该控制器方法处理。
    2. name 属性
    处理器方法的说明，即描述这个方法是干什么用的
    3. method 属性
    用来设置控制器方法支持的请求方式：GET、POST、DELETE、PUT等。若未设置 method 属性则支持所有方法。
    此外，method 属性的取值是一个 RequestMethod 类型的数组，表示一个控制器方法支持多种方式的请求。
    eg：
    @RequestMapping(value = "/toUser",method = {RequestMethod.GET,RequestMethod.POST})
    4. params 属性
    用于指定请求参数，只有请求中携带了符合条件的参数时，控制器方法才会对该请求进行处理。
    5. headers 属性
    用于设置请求中请求头信息，只有当请求中携带指定的请求头信息时，控制器方法才会处理该请求。

# spring mvc 获取请求参数的方式
通过 HttpServletRequest 获取请求参数
    在控制器方法中设置一个 HttpServletRequest 类型的形参，Spring MVC 会自动将请求中携带的参数封装到 HttpServletRequest 形参中，
    然后通过 HttpServletRequest 提供的 getParameter() 方法获取所需的请求参数。
    
通过控制器方法的形参获取请求参数
    在 Controller 的控制器方法中设置与请求参数同名的形参，以获取请求中携带的参数。
    当浏览器发送的请求匹配到这个控制器方法时，Spring MVC 会自动将请求参数赋值给相应的方法形参。
    注意：
    1. 必须保证参数名一致：必须保证控制器方法的形参名称与请求中携带参数的名称完全一致（区分大小写），否则控制器方法接收到的请求参数值会是 null。
    2. 无视数据类型：一般用 String 接收参数然后自行转换，在知道参数类型的情况下也可以用已知的参数类型。
    3. 不适用于请求参数过多的请求：拒绝代码臃肿。
    4. 同名请求参数的处理方式：“,”隔开或者构造 String 数组。
    
使用 @RequestParam 注解获取请求参数
    在控制器方法中通过 @RequestParam 注解在请求参数与控制器方法的形参之间建立起映射关系，这样即使请求参数与控制器方法中的形参名称不一致，也能获取到对应的请求参数值。
    @RequestParam 的四个属性：
    1. name；请求中的参数名，为 @RequestParam 注解 value 属性的别名，它与 value 属性完全等价。
    2. value：请求中的参数名，与 name 完全等价。
    3. required：该请求参数名是否必须（对参数名的要求，不是对参数值的要求），默认值为 true，即默认情况下请求中必须包含对应的请求参数名，否则就会抛出异常。
    4. defaultValue：请求参数的默认值。 defaultValue 属性会使 required ="true" 失效，即将 required 属性自动设置为 false。
    
通过实体类对象获取请求参数（推荐）
    在 Controller 控制器方法的形参中设置一个实体类形参，如果请求参数的参数名与实体类中的属性名一致，那么 Spring MVC 会自动将请求参数封装到该实体类对象中。
    之后，通过该实体类对象即可获取所需的请求参数。

    
    