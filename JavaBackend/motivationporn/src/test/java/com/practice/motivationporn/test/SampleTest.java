package com.practice.motivationporn.test;

import com.practice.motivationporn.entity.MotivationPorn;
import com.practice.motivationporn.mapper.MotivationPronMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SampleTest {

    @Autowired
    private MotivationPronMapper mapper;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<MotivationPorn> userList = mapper.selectList(null);
        Assert.assertEquals(5, userList.size());
        userList.forEach(System.out::println);
    }

}