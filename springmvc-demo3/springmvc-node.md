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
    3. required：该 请求参数名 是否必须（对参数名的要求，不是对参数值的要求），默认值为 true，即默认情况下请求中必须包含对应的请求参数名，否则就会抛出异常。
    4. defaultValue：请求参数的默认值。 defaultValue 属性会使 required ="true" 失效，即将 required 属性自动设置为 false。
    
通过实体类对象获取请求参数（推荐）
    在 Controller 控制器方法的形参中设置一个实体类形参，如果请求参数的参数名与实体类中的属性名一致，那么 Spring MVC 会自动将请求参数封装到该实体类对象中。
    之后，通过该实体类对象即可获取所需的请求参数。

# Spring MVC域对象共享数据
域对象是什么：域对象是服务器在内存上创建的一块存储空间，主要用于不同动态资源之间的数据传递和数据共享。

在 Spring MVC 中，控制器在接收到 DispatcherServlet 分发过来的请求后，会继续调用 Model 层对请求进行处理。
Model 层处理完请求后的结果被称为模型数据，会将模型数据返回给 Controller。Controller 在接收到 Model 层返回的模型数据后，
下一步就是将模型数据通过 域对象共享 的方式传递给 View 视图进行渲染，最终返回给客户端展示。

域对象的类型： request 域对象、session 域对象、application 域对象等。

Spring MVC 提供了多种域对象共享数据的方式，其中最常用的方式如下：
使用 Servlet API 向 request 域对象中共享数据
    在控制器方法中设置一个 HttpServletRequest 类型的形参。通过它将模型数据共享到 request 域对象中。
    
使用 ModelAndView 向 request 域对象中共享数据
    ModelAndView 只有在作为控制器方法的返回值返回给前端控制器（DispatcherServlet）时，前端控制器解析才会去解析它。
    
使用 Model 向 request 域对象中共享数据
    在 Controller 控制器方法中设置一个 Model 类型的形参。通过它向 request 域对象中共享数据。
    
使用 Map 向 request 域对象中共享数据
    在 Controller 控制器方法中设置一个 Map 类型的形参。通过它向 request 域对象中共享数据。
    
使用 ModelMap 向 request 域对象中共享数据
    在 Controller 控制器方法中设置一个 ModelMap 类型的形参。通过它向 request 域对象中共享数据。
    
使用 Servlet API 向 session 域中共享数据
    在控制器方法中设置一个 HttpSession 类型的形参。通过它可以将数据共享到 session 域对象中。
    
使用 Servlet API 向 application 域中共享数据
    在控制器方法中设置一个 HttpSession 类型的形参，通过它可获取到 application 域对象，最终可以将数据共享到 application 域对象中。
    
# spring MVC 视图与视图解析器
ModelAndView = Model(模型数据)+View(视图)。
ModelAndView 是 spring MVC 最终封装的控制器方法返回内容(ModelAndView、ModelMap、View、String等类型)的对象。

View 是一个抽象概念，主要功能是用于渲染页面，将 Model(模型数据) 填入到页面中。
View 的分类：
    逻辑视图：控制器方法返回内容封装而成的的 ModelAndView 中的 view 可能不是一个真正的视图对象，而是一个字符串类型的逻辑视图名。
    需要使用 视图解析器（ViewResolver） 进行解析，才能得到真正的物理视图对象。
    eg：ThymeleafView
    逻辑视图的返回方式：
        1. 直接返回逻辑视图名（String 类型），后由视图解析器根据名称找到真正的视图；
        2. 控制器方法直接返回 ModelAndView。通过 ModelAndView 的 .setViewName() 添加逻辑视图名，.addObject()方法添加 Model(模型数据)。
    非逻辑视图：控制方法返回的是真正的视图对象，不是逻辑视图名，不需要视图解析器解析，只需直接将视图模型渲染出来即可。
    eg：MappingJackson2JsonView
    
视图解析器：解析逻辑视图。

视图控制器：控制器方法只返回一个逻辑视图名，而没有返回任何 Model 数据，那么这个控制器方法就可以使用 View-Controller（视图控制器）标签来代替。
eg：
    @RequestMapping("/addPage")
    public String addPage() {
        return "base/add";
    }
可有以下替代形式：
    <mvc:view-controller path="/addPage" view-name="base/add"></mvc:view-controller>
    
# 视图转发与重定向
视图转发：无论是控制器方法以 String 类型返回 逻辑视图名 或是通过 ModelAndView 的 .setViewName() 方法设置逻辑视图名，
只需在 逻辑视图名 前加上 "forward:" 前缀就好。
eg: return "forward:/user"; 
    modelAndView.setViewName("forward:/user").
    
视图重定向：方式同视图转发，但前缀改成 “redirect:”。
eg：return "redirect:/user"; 
    modelAndView.setViewName("redirect:/user").
    
# RESTful(REST风格)
REST：Resource Representational State Transfer，表现层资源表述状态转移。
几个相关概念
    1. Resource（资源）
    服务器上部署的工程所包含的所有内容，例如工程所包含的类文件、HTML文件、css文件、JS文件、数据表、图片等。
    2. Representation（资源的表述）
    资源在某个特定时刻的状态的描述，即资源的具体表现形式，它可以有多种格式，例如 HTML、XML、JSON、纯文本、图片、视频、音频等等。
    注意：通常情况下，客户端与服务端资源的表现形式往往是不同的。
    3. State Transfer（状态转移）
    由于资源在客户端与服务端的表现形式不同，而 HTTP 请求为无状态请求，因此，当客户端请求服务端的资源时，需要用一定的手段使资源在
    服务端发生“状态变化”，而这种状态转化又是建立在应用的表现层（UI）上的，因此叫做“表现层资源状态转移”。
RESTful含义：提倡使用统一的风格来设计 URL。
    1. URL 只用来标识和定位资源，不得包含任何与操作相关的动词。
       eg：http://localhost:8080/biancheng/user
    2. 当请求中需要携带参数时，RESTFul 提倡将参数通过斜杠（/）拼接到 URL 中，将其作为 URL 的一部分发送到服务器中，而不再像以前一样使用问号（?）拼接键值对的方式来携带参数。
       eg：http://localhost:8080/biancheng/user/1 ----（1是请求参数值）
    
spring MVC 实现 RESTful
通过 @RequestMapping + @PathVariable 注解的方式，来实现 RESTful 风格的请求。
    1. 通过 @RequestMapping 注解设置 RESTful 风格路径
       注意：“{}”为参数占位符，注意参数的位置顺序需与 URL 中参数值的位置顺序一致，否则传参错误。
       eg：@RequestMapping("/testRest/{id}/{username}")  
    2. 通过 @PathVariable 注解绑定参数
       注意：在控制器方法的形参位置通过 @PathVariable 注解，将占位符 “{}” 所表示的参数赋值给指定的形参。
       eg：@RequestMapping("/testRest/{id}/{username}")
          public String testRest(@PathVariable("id") String id, @PathVariable("username") String username) {
              System.out.println("id:" + id + ",username:" + username);
              return "success";
          }
    3. 通过 HiddenHttpMethodFilter 对请求进行过滤
       注意：浏览器默认只支持发送 GET 和 POST 方法的请求，为将 POST 请求转换为 PUT 或 DELETE 请求，
            需在 web.xml 中使用 Spring MVC 提供的 HiddenHttpMethodFilter 对请求进行过滤。
       eg：
           <!--处理 PUT 和 DELETE 请求的过滤器-->
           <filter>
               <filter-name>HiddenHttpMethodFilter</filter-name>
               <filter-class>org.springframework.web.filter.HiddenHttpMethodFilter</filter-class>
           </filter>
           <filter-mapping>
               <filter-name>HiddenHttpMethodFilter</filter-name>
               <url-pattern>/*</url-pattern>
           </filter-mapping>
       注意：HiddenHttpMethodFilter 处理 PUT 和 DELETE 请求时，必须满足以下 2 个条件：
       1. 当前请求的请求方式必须为 POST；
       2. 当前请求必须传输请求参数 _method，请求参数 _method 的值才是最终的请求方式，所以必须有。
       
#spring MVC JSON 数据交互
1. JSON 数据格式：
     对象数据结构：JSON 的对象结构以“{”开始，以“}”结束，中间则由 0 个或多个以英文的逗号（即“,”）分隔的 key/value 对构成。
     eg：
     {
         key1:value1,
         key2:value2,
         ...
     }
     其中，key 必须为 String 类型，value 可以是 String、Number、Object、Array 等数据类型。
    
     数组结构：JSON 的数组结构以“[”开始、以“]”结束，中间部分由 0 个或多个以英文的逗号（即“,”）分隔的值列表组成。
     注意：数组元素类型未限制必须为同一数据类型。
     eg：
     [
         "c语言中文网",
         123456789,
         true,
         null
     ]
    
     对象结构与数组结构混用：
     eg：
     {
         "sno":"201802228888",
         "sname":"张三",
         "hobby":[
             "篮球",
             "足球"
         ],
         "college":{
             "cname":"清华大学",
             "city":"北京",
             "code":100000
         }
     }

2. 相关注解：
    @RequestBody，作用在方法的形参上，该注解用于将请求体中的数据（JSON 格式）绑定到控制器方法的形参上。
    @ResponseBody，作用在方法上，该注解用于将控制器方法的返回值（JSON 格式），直接作为响应报文的响应体响应到浏览器上。

# Spring MVC 拦截器
含义：对用户请求进行拦截。在请求进入控制器（Controller）之前、控制器处理完请求后、甚至是渲染视图后，执行一些指定的操作。

拦截器接口： HandlerInterceptor，包含三个接口方法：
    1. boolean preHandle()：在控制器方法执行前执行，若返回 true，则继续向下执行；若返回 fakse，则中断后续所有操作；
    2. void postHandle()：在控制器方法调用之后，解析式图之前执行。通过此方法可以对请求域中的模型（Model）数据和视图做出进一步的修改；
    3. void afterCompletion()：在整个请求完成后（即视图渲染结束之后）执行。通过此方法可以实现资源清理、日志记录等工作。

自定义拦截器有如下步骤：
    1. 须实现 HandlerInterceptor 接口，重写三个方法；
    2. 配置拦截器。
    eg：
    <!--配置拦截器-->
    <mvc:interceptors>                          // 所有拦截器配置的根标签
        <bean/>                                 // 用于定义一个全局拦截器，对所有的请求进行拦截——所有请求
        <ref/>                                  // 用于定义一个全局拦截器的引用，对所有的请求进行拦截——与 
                                                // Bean（<mvc:interceptors> 标签内或 <mvc:interceptors>标签外） 或 @Component 联用，不可单独使用
        <!--拦截器 1-->
        <mvc:interceptor>                       // 用于定义一个指定拦截路径的拦截器——指定拦截路径
            <!--配置拦截器拦截的请求路径-->          
            <mvc:mapping path="/**"/>           // 配置拦截器拦截的路径，拦截路径通过属性 “path” 来定义
            <!--配置拦截器不需要拦截的请求路径-->
            <mvc:exclude-mapping path="/login"/>    // 配置不需要被拦截器拦截的路径
            <mvc:exclude-mapping path="/"/>
            <!--定义在 <mvc:interceptors> 下，表示拦截器只对指定路径的请求进行拦截-->
            <bean class="net.biancheng.c.interceptor.MyInterceptor1"></bean>       // 定义一个指定了拦截路径的拦截器——指定拦截路径
        </mvc:interceptor>
    </mvc:interceptors>
    注意：配置时，子元素必须按照 <mvc:mapping> → <mvc:exclude-mapping> → <bean> 的顺序编写，否则会报错
    3. 拦截器处理流程：
        1. 当请求路径与拦截器拦截的路径相匹配时，程序会先执行拦截器类（MyInterceptor）的 preHandl() 方法。
           若该方法返回值为 true，则继续向下执行 Controller（控制器）中的方法，否则将不再向下执行；
        2. 控制器方法对请求进行处理；
        3. 调用拦截器的 postHandl() 方法，此时可以对请求域中的模型（Model）数据和视图做出进一步的修改；
        4. 通过 DispatcherServlet 的 render() 方法对视图进行渲染；
        5. 调用拦截器的 afterCompletion () 方法，完成资源清理、日志记录等工作。
    4. 多拦截器执行流程：当存在多个拦截器时，拦截器的执行顺序与其在配置文件中的配置顺序有关。
    当存在多个拦截器同时工作时，它们的 preHandle() 方法会按照拦截器在配置文件中的配置顺序执行，
    但它们的 PostHandle() 和 afterCompletion() 方法则会按照配置顺序的反序执行。
    如果其中有拦截器的 preHandle() 方法返回了 false，各拦截器方法执行情况如下。
        1. 第一个返回 preHandle() 方法 false 的拦截器以及它之前的拦截器的 preHandle() 方法都会执行。
        2. 所有拦截器的 postHandle() 都不会执行。
        3. 第一个返回 preHandle() 方法 false 的拦截器之前的拦截器的 afterComplation() 方法都会执行。

# spring MVC 异常处理
spring mvc 提供名为 HandlerExceptionResolver 的异常处理器接口，可以对控制器方法执行过程中出现的各种异常进行处理。其有四个实现类：
    1. DefaultHandlerExceptionResolver（默认异常处理器类）
    2. ResponseStatusExceptionResolver（默认异常处理器类）
    3. ExceptionHandlerExceptionResolver（默认异常处理器类）
    4. SimpleMappingExceptionResolver
    附：如果程序发生异常，Spring MVC 会按照 
       ExceptionHandlerExceptionResolver → ResponseStatusExceptionResolver → DefaultHandlerExceptionResolver 
       的顺序，依次使用这三个异常处理器对异常进行解析，直到完成对异常的解析工作为止。
       
ResponseStatusExceptionResolver：用于解析 @ResponseStatus 注解标注的自定义异常，并把异常的状态信息返回给客户端展示
    @ResponseStatus：作用于自定义异常类，包含三个属性：
    1. code：设置异常的状态码。
    2. value：设置异常的状态码。value 与 code 完全等价。
    3. reason：设置异常的原因或描述。
    
ExceptionHandlerExceptionResolver：在控制器方法出现异常时，调用相应的 @ExceptionHandler 方法（即使用了 @ExceptionHandler 注解的方法）对异常进行处理。
    @ExceptionHandler：作用于方法，当控制器方法出现异常时，通过 @ExceptionHandler 注解定义的异常处理方法来处理异常。
    value属性：声明一个指定的异常，若控制器方法发生这个异常， ExceptionHandlerExceptionResolver 就会调用这个 @ExceptionHandler 方法对异常进行处理。
    注意：
    1. 定义在某个控制器类中的 @ExceptionHandler 方法只在当前的控制器中有效，它只能处理其所在控制器类中发生的异常；
    2. 若使用 @ExceptionHandler 定义多个异常处理方法，则异常处理的优先级为：
       ExceptionHandlerExceptionResolver 根据继承关系，调用继承深度最浅的异常处理方法对异常进行处理（优先调用子类异常处理方法）。
全局异常处理：
    1. 在使用了 @ControllerAdvice 注解的类中定义所有  @ExceptionHandler 方法，这些方法可以作用在应用程序中所有带有  @RequestMapping 注解的控制器方法上，
    实现全局异常处理。
    2. SimpleMappingExceptionResolver，spring 提供的自定义异常处理器，装配到配置文件（{dispatcher-name}-servelet.xml）后，亦可实现全局异常处理（配置方式百度可查）。
    
# spring MVC 注解+配置类实现
使用初始化类替代 web.xml
    Servlet 容器在启动时，会自动查找类项目路径下实现了 javax.servlet.ServletContainerInitializer 接口的初始化类。
    若找到，则使用该初始化类代替 web.xml，对 Servlet 容器的上下文进行配置。Spring 就为 ServletContainerInitializer 
    接口提供了一个名为 SpringServletContainerInitializer 的实现类。