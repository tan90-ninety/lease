package com.atguigu.lease.web.admin.custom.interceptor;

import com.atguigu.lease.common.login.LoginUser;
import com.atguigu.lease.common.login.LoginUserHolder;
import com.atguigu.lease.common.utils.JWTUtil;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class AuthenticationInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull Object handler) throws Exception {
        String token = request.getHeader("access-token");

        Claims claims = JWTUtil.parseToken(token);
        Long userId = claims.get("userId", Long.class);
        String userName = claims.get("userName", String.class);
        LoginUserHolder.setLoginUser(new LoginUser(userId, userName));

        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        LoginUserHolder.clear();
    }
}
