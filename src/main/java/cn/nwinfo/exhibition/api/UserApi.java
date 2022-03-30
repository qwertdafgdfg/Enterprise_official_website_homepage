package cn.nwinfo.exhibition.api;

import cn.nwinfo.exhibition.annotation.*;
import cn.nwinfo.exhibition.entity.Article;
import cn.nwinfo.exhibition.entity.ArticleCategory;
import cn.nwinfo.exhibition.entity.User;
import cn.nwinfo.exhibition.service.TokenService;
import cn.nwinfo.exhibition.service.UserService;
import cn.nwinfo.exhibition.translate.demo.TransApi;
import cn.nwinfo.exhibition.util.AddressResult;
import cn.nwinfo.exhibition.util.AddressUtils;
import cn.nwinfo.exhibition.util.IpUtil;
import cn.nwinfo.exhibition.util.PageRequest;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.auth0.jwt.JWT;
import com.auth0.jwt.exceptions.JWTDecodeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("api/user")
public class UserApi {
    @Value("${role.user}")
    String user;
    @Value("${role.CSD}")
    String CSD;
    @Autowired
    UserService userService;
    @Autowired
    TokenService tokenService;

    //登录
    @PassToken
    @PostMapping("/adminLogin")
    public Object adminLogin(@RequestBody User user, HttpServletRequest request) {

        JSONObject jsonObject = new JSONObject();
        User userForBase = userService.findByUsername(user);
        if (userForBase == null) {
            jsonObject.put("message", "登录失败,用户不存在");
            return jsonObject;
        } else {
            if (!userForBase.getPassword().equals(user.getPassword()) || userForBase.getRole().equals(this.user)) {
                jsonObject.put("message", "登录失败,密码错误");
                return jsonObject;
            } else {
                String token = tokenService.getToken(userForBase);
                jsonObject.put("token", token);
                return jsonObject;
            }
        }
    }

    @PassToken
    @PostMapping("/login")
    public Object login(@RequestBody User user) {
        System.out.println("用户=" + user);
        JSONObject jsonObject = new JSONObject();
        User userForBase = userService.findByUsername(user);
        if (userForBase == null) {
            jsonObject.put("message", "登录失败,用户不存在");
            return jsonObject;
        } else {
            if (!userForBase.getRole().equals(this.user)) {
                jsonObject.put("message", "登录失败,密码错误");
                return jsonObject;
            } else {
                String token = tokenService.getToken(userForBase);
                jsonObject.put("token", token);
                return jsonObject;
            }
        }
    }

    @CSDToken
    @PostMapping("/changePassword")
    public Object changePassword(@RequestBody User user, HttpServletRequest httpServletRequest) {
        System.out.println("用户=" + user);
        String token = httpServletRequest.getHeader("token");// 从 http 请求头中取出 token
        String userId;
        try {
            userId = JWT.decode(token).getAudience().get(0);
        } catch (JWTDecodeException j) {
            throw new RuntimeException("401");
        }

        JSONObject jsonObject = new JSONObject();
        boolean ok = false;

        if (userService.findById(userId).getPassword().equals(user.getPassword())) {
            user.setPassword(user.getConfirmPassword());
            user.setId(userId);
            System.out.println("修改用户=" + user);
            ok = userService.updateById(user);
        } else {
            jsonObject.put("ok", ok);
            jsonObject.put("message", "密码错误！");
            return jsonObject;
        }
        jsonObject.put("ok", ok);
        if (ok) {
            jsonObject.put("message", "修改成功！");

        } else {
            jsonObject.put("message", "修改失败！");
        }
        return jsonObject;
    }

    //登录
    @CSDToken
    @GetMapping("/getUser")
    public Object getUser(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object object) {
//
        String token = httpServletRequest.getHeader("token");// 从 http 请求头中取出 token
        String userId;
        try {
            userId = JWT.decode(token).getAudience().get(0);
        } catch (JWTDecodeException j) {
            throw new RuntimeException("401");
        }
        User user = userService.findById(userId);
        boolean ok = false;
        if (user != null) {
            ok = true;
        }
        JSONObject jsonObject = new JSONObject();

        jsonObject.put("ok", ok);
        if (ok) {
            user.setPassword("No return");
            jsonObject.put("user", user);

        } else {
            jsonObject.put("message", "获取失败！");
        }
        return jsonObject;
//        return user;
    }

    @SuperAdminToken
    @GetMapping(value = "/findPage")
    public Object findPage(PageRequest pageQuery) {
        System.out.println("分页" + pageQuery);
        return userService.findPage(pageQuery);
    }

    @SuperAdminToken
    @DeleteMapping("/delete")
    public Object delete(@RequestBody User user) {
        System.out.println("删除" + user);
        JSONObject jsonObject = new JSONObject();
        boolean ok = userService.deleteById(user);
        jsonObject.put("ok", ok);
        if (ok) {
            jsonObject.put("message", "删除成功！");

        } else {
            jsonObject.put("message", "删除失败！");
        }
        return jsonObject;
    }

    @SuperAdminToken
    @PutMapping("/updateById")
    public Object updateById(@RequestBody User user) {
        boolean ok = false;

        System.out.println("修改" + user);
        JSONObject jsonObject = new JSONObject();

        if (user.getPassword()==null||user.getUsername()==null){
            jsonObject.put("ok", ok);
            jsonObject.put("message", "账号或密码不能为空！");
            return jsonObject;
        }

        User userForBase = userService.findByUsername(user);
        if (userForBase != null) {
            jsonObject.put("ok", false);
            jsonObject.put("message", "账号已存在，换一个试试！");
            return jsonObject;
        }
        ok = userService.updateById(user);
        jsonObject.put("ok", ok);
        if (ok) {
            jsonObject.put("message", "修改成功！");

        } else {
            jsonObject.put("message", "修改失败！");
        }
        return jsonObject;
    }

    @SuperAdminToken
    @PostMapping("/add")
    public Object add(@RequestBody User user) {
        boolean ok = false;

        System.out.println("添加" + user);
        JSONObject jsonObject = new JSONObject();

        if (user.getPassword()==null||user.getUsername()==null){
            jsonObject.put("ok", ok);
            jsonObject.put("message", "账号或密码不能为空！");
            return jsonObject;
        }
        User userForBase = userService.findByUsername(user);
        if (userForBase != null) {
            jsonObject.put("ok", ok);
            jsonObject.put("message", "账号已存在，换一个试试！");
            return jsonObject;
        }
        if (user.getRole()==null){
            user.setRole(CSD);
        }
        ok = userService.add(user);
        jsonObject.put("ok", ok);
        if (ok) {
            jsonObject.put("message", "添加成功！");

        } else {
            jsonObject.put("message", "添加失败！");
        }

        return jsonObject;
    }

    @SuperAdminToken
    @GetMapping("/findBySearchStr")
    public Object findBySearchStr(String searchStr) {
        System.out.println("搜索" + searchStr);
        return userService.findBySearchStr(searchStr);
    }


}
