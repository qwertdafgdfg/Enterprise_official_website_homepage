package cn.nwinfo.exhibition.service;

import cn.nwinfo.exhibition.entity.User;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;


/**
 * @author
 * @date 2020-01-23 21:04
 */
@Service("TokenService")
public class TokenService {
    @Value("${jwt.expire_time}")
    long expire_time;
    public String getToken(User user) {
        expire_time= 15*60*expire_time;
        Date expiresAt = new Date(System.currentTimeMillis() + expire_time);
        String token="";
        token= JWT.create().withAudience(user.getId())// 将 user id 保存到 token 里面
                .withExpiresAt(expiresAt)
                .sign(Algorithm.HMAC256(user.getPassword()));// 以 password 作为 token 的密钥
        return token;
    }
}
