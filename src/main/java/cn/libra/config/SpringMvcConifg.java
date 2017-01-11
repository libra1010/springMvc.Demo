package cn.libra.config;

/**
 * Created by libra on 2017/1/10.
 */
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
//指明controller所在的包名
@ComponentScan(basePackages = {"cn.libra.controller"})
// 加载.xml如果没有使用到额外的.xml配置文件，则无需加载
@ImportResource({ "classpath:spring-mybatis.xml" })
public class SpringMvcConifg extends WebMvcConfigurerAdapter {

    /**
     * 非必须
     */
    @Override
    public void configureDefaultServletHandling(final DefaultServletHandlerConfigurer configurer) {
        configurer.enable();//将静态资源的请求转发到servlet容器中默认的servlet上
    }

    /**
     * 如果项目的一些资源文件放在/WEB-INF/resources/下面
     * 在浏览器访问的地址就是类似：http://host:port/projectName/WEB-INF/resources/xxx.css
     * 但是加了如下定义之后就可以这样访问：
     * http://host:port/projectName/resources/xxx.css
     * 非必须
     */
    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/resources/**/*").addResourceLocations("/WEB-INF/resources/");
    }
}