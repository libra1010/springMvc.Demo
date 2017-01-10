package cn.libra.config;

/**
 * Created by libra on 2017/1/10.
 */
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles2.TilesConfigurer;
import org.springframework.web.servlet.view.tiles2.TilesView;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
public class ViewConfiguration {

//    @Bean
//    public ViewResolver viewResolver() {
//        UrlBasedViewResolver viewResolver;
//        viewResolver = new UrlBasedViewResolver();
//        viewResolver.setOrder(2);
//        viewResolver.setPrefix("/WEB-INF/views/");
//        viewResolver.setSuffix(".jsp");
//       // viewResolver.setViewClass(JstlView.class);
//        // for debug envirment
//        viewResolver.setCache(false);
//        return viewResolver;
//    }

    @Bean
    // 设置 InternalResourceViewResolver. 为跳转页面自动加上前缀及后缀
    public InternalResourceViewResolver jspViewResolver() {
        InternalResourceViewResolver jspViewResolver = new InternalResourceViewResolver();
        // 前缀
        jspViewResolver.setPrefix("/WEB-INF/views/");
        // 后缀
        jspViewResolver.setSuffix(".jsp");
        return jspViewResolver;
    }



//    @Bean
//    public ViewResolver tilesViewResolver() {
//        UrlBasedViewResolver urlBasedViewResolver = new UrlBasedViewResolver();
//        urlBasedViewResolver.setOrder(1);
//        urlBasedViewResolver.setViewClass(TilesView.class);
//        //urlBasedViewResolver.
//        return urlBasedViewResolver;
//    }
//    @Bean
//    public TilesConfigurer tilesConfigurer() {
//        TilesConfigurer tilesConfigurer = new TilesConfigurer();
//        tilesConfigurer.setDefinitions(new String[] { "classpath:tiles.xml" });
//        return tilesConfigurer;
//    }
}