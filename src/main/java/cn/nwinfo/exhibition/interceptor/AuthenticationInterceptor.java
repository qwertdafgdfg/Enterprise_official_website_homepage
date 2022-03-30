package cn.nwinfo.exhibition.interceptor;

import cn.nwinfo.exhibition.annotation.*;
import cn.nwinfo.exhibition.entity.User;
import cn.nwinfo.exhibition.service.UserService;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;


/**
 * @author
 * @date 2020-01-23 20:41
 */
public class AuthenticationInterceptor implements HandlerInterceptor {

    @Value("${role.superAdmin}")
    String superAdmin;
    @Value("${role.admin}")
    String admin;
    @Value("${role.CSD}")
    String CSD;
    @Value("${role.user}")
    String user;
    @Autowired
    UserService userService;
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object object) throws Exception {
        String token = httpServletRequest.getHeader("token");// 从 http 请求头中取出 token
        // 如果不是映射到方法直接通过
        if(!(object instanceof HandlerMethod)){
            return true;
        }
        HandlerMethod handlerMethod=(HandlerMethod)object;
        Method method=handlerMethod.getMethod();
        //检查是否有passtoken注释，有则跳过认证
        if (method.isAnnotationPresent(PassToken.class)) {
            PassToken passToken = method.getAnnotation(PassToken.class);
            if (passToken.required()) {
                return true;
            }
        }
//        // 执行认证
//        if (token == null) {
//            throw new RuntimeException("无token，请重新登录");
//        }
        // 获取 token 中的 user id
        String userId;
        try {
            userId = JWT.decode(token).getAudience().get(0);
        } catch (JWTDecodeException j) {
            throw new RuntimeException("401");
        }
        User user = userService.findById(userId);
        //检查有没有需要用户权限的注解
        if (method.isAnnotationPresent(UserLoginToken.class)) {
            UserLoginToken userLoginToken = method.getAnnotation(UserLoginToken.class);
            if (userLoginToken.required()) {

                if (!user.getRole().equals(this.user)) {

                    throw new RuntimeException("用户不存在，请重新登录");
                }
                // 验证 token
                JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(user.getPassword())).build();
                try {
                    jwtVerifier.verify(token);
                } catch (JWTVerificationException e) {
                    throw new RuntimeException("401");
                }
                return true;
            }
        }
        //检查有没有需要超级管理员权限的注解
        if (method.isAnnotationPresent(SuperAdminToken.class)) {
            SuperAdminToken superAdminToken = method.getAnnotation(SuperAdminToken.class);
            if (superAdminToken.required()) {

                if (!user.getRole().equals(this.superAdmin)) {
                    throw new RuntimeException("请用超级管理员身份执行该操作！");
                }
                // 验证 token
                JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(user.getPassword())).build();
                try {
                    jwtVerifier.verify(token);
                } catch (JWTVerificationException e) {
                    throw new RuntimeException("401");
                }
                return true;
            }
        }
        //检查有没有需要管理员权限的注解
        if (method.isAnnotationPresent(AdminToken.class)) {
            AdminToken adminToken = method.getAnnotation(AdminToken.class);
            if (adminToken.required()) {
                //管理员以下级别权限终止操作（不包含管理员）
                if (!user.getRole().equals(this.admin)&&!user.getRole().equals(this.superAdmin)) {
                    throw new RuntimeException("请用超级管理员或管理员身份执行该操作！");
                }
                // 验证 token
                JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(user.getPassword())).build();
                try {
                    jwtVerifier.verify(token);
                } catch (JWTVerificationException e) {
                    throw new RuntimeException("401");
                }
                return true;
            }
        }
        //检查有没有需要管理员权限的注解
        if (method.isAnnotationPresent(AdminToken.class)) {
            CSDToken csdToken = method.getAnnotation(CSDToken.class);
            if (csdToken.required()) {
                //管理员以下级别权限终止操作（不包含管理员）
                if (!user.getRole().equals(this.CSD)&&!user.getRole().equals(this.admin)&&!user.getRole().equals(this.superAdmin)) {
                    throw new RuntimeException("请登录后执行该操作！");
                }
                // 验证 token
                JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(user.getPassword())).build();
                try {
                    jwtVerifier.verify(token);
                } catch (JWTVerificationException e) {
                    throw new RuntimeException("401");
                }
                return true;
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
