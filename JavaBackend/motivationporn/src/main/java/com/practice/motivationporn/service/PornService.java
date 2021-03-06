package com.practice.motivationporn.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.practice.motivationporn.entity.MotivationPorn;

import java.util.List;

/**
 * @author haoyue
 */
public interface PornService extends IService<MotivationPorn> {

    /**
     * 随机获取一个
     * @return
     */
    MotivationPorn getRandomOne();

    /**
     * 获取所有的毒鸡汤
     * @return
     */
    List<MotivationPorn> getAll();
}
