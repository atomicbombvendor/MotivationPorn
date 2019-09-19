package com.practice.motivationporn.util;

import com.practice.motivationporn.common.TokenEnum;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author haoyue
 */
public class JwtTokenUtil {

    private static final Logger logger = LoggerFactory.getLogger(JwtTokenUtil.class);

    /**
     * 生成token(请根据自身业务扩展)
     * @param subject （主体信息） 置入claim中。
     * @param claims 自定义其他的信息，可选
     * @return
     */
    public static String generateToken(String subject, Map<String,Object> claims) {
        if (claims == null){
            claims = new HashMap<>(0);
        }
        return TokenEnum.TITLE.getValue() + Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuer(TokenEnum.ISSUER.getValue())
                .setExpiration(new Date(System.currentTimeMillis() + Integer.parseInt(TokenEnum.EXPIRE_SECONDS.getValue()) * 1000))
                .signWith(SignatureAlgorithm.HS512, TokenEnum.SALT.getValue())
                .compact();
    }

    /**
     * 解析token, 获得subject中的信息
     * @param token
     * @return token未过期时，返回不为空
     */
    public static String parseSubject(String token) {

        return parseClaims(token).getSubject();
    }

    public static Claims parseClaims(String token) {

        Claims claims = null;
        if (token.startsWith(TokenEnum.TITLE.getValue())) {
            String authToken = token.substring(TokenEnum.TITLE.getValue().length());
            try {
                claims = getTokenBody(authToken);
            } catch (Exception e) {
                logger.error("token invalid");
            }
        }
        return claims;
    }

    /**
     * 解析token
     * @param token
     * @return
     */
    private static Claims getTokenBody(String token){
        return Jwts.parser()
                .setSigningKey(TokenEnum.SALT.getValue())
                .parseClaimsJws(token)
                .getBody();
    }
}
