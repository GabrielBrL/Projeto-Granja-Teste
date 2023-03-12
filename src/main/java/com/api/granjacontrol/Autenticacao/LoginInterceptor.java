package com.api.granjacontrol.Autenticacao;

import com.api.granjacontrol.service.CookieService;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
        var result = CookieService.getCookie(request,"user");
        if(CookieService.getCookie(request,"user") != null){
            return true;
        }
        response.sendRedirect("/usuario/login");
        return false;
    }
}
