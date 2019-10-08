package com.practice.motivationporn.service;

import com.practice.motivationporn.entity.SecurityUserDetail;

public interface MoUserCacheService {

    /**
     * 从缓存从查询用户
     * @param userName
     * @return
     */
    SecurityUserDetail selectFromCache(String userName);

    /**
     * 清空缓存中的用户，并设置token到黑名单中
     * @param userName
     */
    void deleteUserCache(String userName, String token);

    /**
     * 检查token是不是在黑名单中
     * @param userName
     */
    String hasBlack(String userName);

}
