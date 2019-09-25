package com.practice.motivationporn.service.impl;

import com.practice.motivationporn.entity.MotivationPorn;
import com.practice.motivationporn.mapper.MotivationPronMapper;
import com.practice.motivationporn.service.PornService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PornServiceImplTest {

    @Autowired
    private PornService service;

    @Test
    public void getRandomOne() {

        MotivationPorn porn = service.getRandomOne();
        System.out.println(porn.toString());
    }
}