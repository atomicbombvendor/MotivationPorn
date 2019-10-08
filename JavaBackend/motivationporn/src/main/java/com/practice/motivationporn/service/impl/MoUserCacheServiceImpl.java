package com.practice.motivationporn.service.impl;

import com.practice.motivationporn.entity.SecurityUserDetail;
import com.practice.motivationporn.service.MoUserCacheService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author haoyue
 */
@Service
public class MoUserCacheServiceImpl implements MoUserCacheService {

    private static final Logger logger = LoggerFactory.getLogger(MoUserCacheServiceImpl.class);

    @Override
    @Cacheable(key = "#userName")
    public SecurityUserDetail selectFromCache(String userName) {
        logger.info("select cache #" + userName);
        return null;
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
