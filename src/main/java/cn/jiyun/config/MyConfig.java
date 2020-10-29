package cn.jiyun.config;

import cn.jiyun.Interceptor.LoginInterceptor;
import cn.jiyun.dates.DateConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyConfig implements WebMvcConfigurer {


    @Override
    public void addFormatters(FormatterRegistry registry) {

        registry.addConverter(new DateConverter());
    }

    //<mvc:interceptors>
    @Override
   public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/show").excludePathPatterns("login","/zhuce","/js/**");
  }


}
