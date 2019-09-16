package com.practice.motivationporn.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.practice.motivationporn.entity.MotivationPorn;

public interface PornService extends IService<MotivationPorn> {

    MotivationPorn getRandomOne();
}
