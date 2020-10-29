package cn.jiyun.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@Configuration
public class Exception implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, java.lang.Exception ex) {

        ModelAndView mv = new ModelAndView();
        //判断不同异常类型，做不同视图跳转
        if(ex instanceof ArithmeticException){
            mv.setViewName("error1");
        }

        if(ex instanceof NullPointerException){
            mv.setViewName("error2");
        }
        mv.addObject("error", ex.toString());

        return mv;

    }
}
