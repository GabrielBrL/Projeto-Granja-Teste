package com.api.granjacontrol.service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Optional;

public class CookieService {
    public static void setCookie(HttpServletResponse response, String key, String valor){
        Cookie cookie = new Cookie(key, valor);
        response.addCookie(cookie);
    }
    public static  String getCookie(HttpServletRequest request, String key){
        return Optional.ofNullable(request.getCookies())
                .flatMap(cookies -> Arrays.stream(cookies)
                        .filter(cookie -> key.equals(cookie.getName()))
                        .findAny()
                ).map(e -> e.getValue())
                .orElse(null);
    }
}
