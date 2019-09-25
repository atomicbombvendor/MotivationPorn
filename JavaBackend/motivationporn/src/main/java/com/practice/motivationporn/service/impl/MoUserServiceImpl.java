package com.practice.motivationporn.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.practice.motivationporn.entity.MotivationUser;
import com.practice.motivationporn.entity.SecurityUserDetail;
import com.practice.motivationporn.mapper.MotivationUserMapper;
import com.practice.motivationporn.service.MoUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author haoyue
 */
@Service
@CacheConfig(cacheNames = {"moUser"})
public class MoUserServiceImpl extends ServiceImpl<MotivationUserMapper, MotivationUser> implements MoUserService {

    private static final Logger logger = LoggerFactory.getLogger(MoUserServiceImpl.class);

    @Override
    @CachePut(key = "#userName", condition = "#result != null ")
    public SecurityUserDetail login(String userName, String password) {

        QueryWrapper<MotivationUser> queryWrapper =
                new QueryWrapper<MotivationUser>().eq("user_name", userName)
                .eq("password", password);
        logger.info("put cache #" + userName);
        MotivationUser moUser = this.getBaseMapper().selectOne(queryWrapper);

        return SecurityUserDetail.getUserDetail(moUser);
    }

    @Override
    @Cacheable(key = "#userName")
    public SecurityUserDetail selectFromCache(String userName) {
        logger.info("select cache #" + userName);
        return null;
    }

    @Override
    @Cacheable(key = "#userName")
    public SecurityUserDetail selectByName(String userName) {
        logger.info("select cache #" + userName);
        QueryWrapper<MotivationUser> queryWrapper =
                new QueryWrapper<MotivationUser>().eq("user_name", userName);
        logger.info("put cache #" + userName);
        MotivationUser moUser = this.getBaseMapper().selectOne(queryWrapper);
        return SecurityUserDetail.getUserDetail(moUser);
    }

    @Override
    @CacheEvict(key = "#userName", value = "moUser")
    @CachePut(key = "#token", value = "blackList")
    public void deleteUserCache(String userName, String token) {
        logger.info("delete cache #" + userName);
    }

    @Override
    @Cacheable(key = "#userName", value = "blackList")
    public String hasBlack(String userName) {
        logger.info("check in black #" + userName);
        return null;
    }
}
