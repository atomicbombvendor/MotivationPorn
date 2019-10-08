package com.practice.motivationporn.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.practice.motivationporn.entity.MotivationUser;
import com.practice.motivationporn.entity.SecurityUserDetail;

/**
 * @author haoyue
 */
public interface MoUserService extends IService<MotivationUser> {

    /**
     * 用户登录，并将结果置入缓存；
     * key为用户名，value为Motivation User
     * @param userName
     * @param password
     * @return
     */
    SecurityUserDetail login(String userName, String password);

    /**
     * 根据用户名查询,先从缓存中查询
     * @param userName
     * @return
     */
    SecurityUserDetail selectByName(String userName);


}
