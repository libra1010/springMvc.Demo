package cn.libra.config;

/**
 * Created by libra on 2017/1/10.
 */
import javax.servlet.*;
import javax.servlet.ServletRegistration.Dynamic;
import javax.swing.*;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * 服务器启动入口类 用作web.xml
 *
 * servlet3.0+规范后，允许servlet，filter，listener不必声明在web.xml中，而是以硬编码的方式存在，实现容器的零配置。
 * ServletContainerInitializer：启动容器时负责加载相关配置
 *
 * 容器启动时会自动扫描当前服务中ServletContainerInitializer的实现类，并调用其onStartup方法，其参数Set<Class<?>> c，可通过在实现类上声明注解javax.servlet.annotation.HandlesTypes(xxx.class)注解自动注入，@HandlesTypes会自动扫描项目中所有的xxx.class的实现类，并将其全部注入Set。
 *
 * Spring为其提供了一个实现类：
 * SpringServletContainerInitializer
 *
 * 从中可以看出，WebApplicationInitializer才是我们需要关心的接口，我们只需要将相应的servlet，filter，listener等硬编码到该接口的实现类中即可。
 *
 * Spring为我们提供了一些WebApplicationInitializer的抽象类，我们只需要继承并按需修改即可
 *
 * @author Administrator
 *
 *
 */

//public class CommonInitializer implements WebApplicationInitializer{
//
//    @Override
//    public void onStartup(ServletContext servletContext)
//            throws ServletException {
//
//        //Log4jConfigListener
//        servletContext.setInitParameter("log4jConfigLocation", "classpath:config/properties/log4j.properties");
//        servletContext.addListener(Log4jConfigListener.class);
//
//
//        //OpenSessionInViewFilter
//        OpenSessionInViewFilter hibernateSessionInViewFilter = new OpenSessionInViewFilter();
//        FilterRegistration.Dynamic filterRegistration = servletContext.addFilter(
//                "hibernateFilter", hibernateSessionInViewFilter);
//        filterRegistration.addMappingForUrlPatterns(
//                EnumSet.of(DispatcherType.REQUEST, DispatcherType.FORWARD, DispatcherType.INCLUDE), false, "/");
//
//
//        //DemoServlet
//        DemoServlet demoServlet = new DemoServlet();
//        ServletRegistration.Dynamic dynamic = servletContext.addServlet(
//                "demoServlet", demoServlet);
//        dynamic.setLoadOnStartup(2);
//        dynamic.addMapping("/demo_servlet");
//
//
//    }
//
//}


public class  WebApplicationStartup extends AbstractAnnotationConfigDispatcherServletInitializer{

    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{ViewConfiguration.class};
    }

    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{SpringMvcConifg.class};
    }

    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    protected  Filter[] getServletFilters(){
        CharacterEncodingFilter encodingfilter = new CharacterEncodingFilter();
        encodingfilter.setEncoding("UTF-8");
        return new Filter[]{encodingfilter};
    }
}


//public class WebApplicationStartup implements WebApplicationInitializer {
//
//    private static final String SERVLET_NAME = "Spring-mvc";
//
//    private static final long MAX_FILE_UPLOAD_SIZE = 1024 * 1024 * 5; // 5 Mb
//
//    private static final int FILE_SIZE_THRESHOLD = 1024 * 1024; // After 1Mb
//
//    private static final long MAX_REQUEST_SIZE = -1L; // No request size limit
//
//    /**
//     * 服务器启动调用此方法，在这里可以做配置 作用与web.xml相同
//     */
//    public void onStartup(ServletContext servletContext) throws ServletException {
//        // 注册springMvc的servlet
//        this.addServlet(servletContext);
//        this.addFilter(servletContext);
//        // 注册过滤器
//        // servletContext.addFilter(arg0, arg1)
//        // 注册监听器
//        // servletContext.addListener(arg0);
//    }
//
//    private void addFilter(ServletContext servletContext){
//        CharacterEncodingFilter encodingfilter = new CharacterEncodingFilter();
//        encodingfilter.setEncoding("UTF-8");
//        encodingfilter.setForceEncoding(true);
//        FilterRegistration.Dynamic  encodingfilterDynamic = servletContext.addFilter("encodingfilter", encodingfilter);
////        encodingfilterDynamic.addMappingForServletNames(EnumSet.of(DispatcherType.REQUEST), true, "dispatcher");
//    }
//
//    /**
//     * 注册Spring servlet
//     *
//     * @param servletContext
//     */
//    private void addServlet(ServletContext servletContext) {
//        // 构建一个application context
//        AnnotationConfigWebApplicationContext webContext = createWebContext(SpringMvcConifg.class, ViewConfiguration.class);
//        // 注册spring mvc 的 servlet
//        Dynamic dynamic = servletContext.addServlet(SERVLET_NAME, new DispatcherServlet(webContext));
//        // 添加springMVC 允许访问的Controller后缀
//       // dynamic.addMapping("*.html", "*.ajax", "*.css", "*.js", "*.gif", "*.jpg", "*.png");
//        // 全部通过请用 “/”
//         dynamic.addMapping("/");
//        dynamic.setLoadOnStartup(1);
//
//        dynamic.setMultipartConfig(new MultipartConfigElement(null, MAX_FILE_UPLOAD_SIZE, MAX_REQUEST_SIZE, FILE_SIZE_THRESHOLD));
//    }
//
//    /**
//     * 通过自定义的配置类来实例化一个Web Application Context
//     *
//     * @param annotatedClasses
//     * @return
//     */
//    private AnnotationConfigWebApplicationContext createWebContext(Class<?>... annotatedClasses) {
//        AnnotationConfigWebApplicationContext webContext = new AnnotationConfigWebApplicationContext();
//        webContext.register(annotatedClasses);
//
//        return webContext;
//    }
//
//}