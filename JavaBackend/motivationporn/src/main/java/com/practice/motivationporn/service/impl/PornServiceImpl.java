package com.practice.motivationporn.service.impl;

import cn.hutool.core.util.RandomUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.practice.motivationporn.entity.MotivationPorn;
import com.practice.motivationporn.exception.PornException;
import com.practice.motivationporn.mapper.MotivationPronMapper;
import com.practice.motivationporn.service.PornService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author haoyue
 */
@Service
public class PornServiceImpl extends ServiceImpl<MotivationPronMapper, MotivationPorn> implements PornService {

    private static final Logger logger = LoggerFactory.getLogger(PornServiceImpl.class);

    @Override
    public MotivationPorn getRandomOne() {

        QueryWrapper<MotivationPorn> queryWrapper =
                new QueryWrapper<MotivationPorn>().eq("status", "1");
        int total = this.getBaseMapper().selectCount(queryWrapper);

        MotivationPorn porn = null;
        for (int i=0; i< 10; i++){
            logger.debug("random " + i + " times to get porn");
            porn = this.getBaseMapper().selectById(RandomUtil.randomInt(1, total));
            if (porn != null){
                break;
            }
        }

        if (porn == null){
            throw new PornException("random 10 times, still is empty");
        }
        return porn;
    }

    @Override
    public List<MotivationPorn> getAll() {

        QueryWrapper<MotivationPorn> queryWrapper =
                new QueryWrapper<MotivationPorn>();
        return this.getBaseMapper().selectList(queryWrapper);
    }

}
