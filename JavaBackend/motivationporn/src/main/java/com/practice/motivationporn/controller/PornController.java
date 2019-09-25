package com.practice.motivationporn.controller;

import com.practice.motivationporn.common.ResponseStatusEnum;
import com.practice.motivationporn.entity.MotivationPorn;
import com.practice.motivationporn.exception.PornException;
import com.practice.motivationporn.service.PornService;
import com.practice.motivationporn.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/porn")
public class PornController {

    private static final Logger logger = LoggerFactory.getLogger(PornController.class);

    @Autowired
    private PornService pornService;

    @GetMapping("/random")
    public Object getRandomPorn(){

        MotivationPorn data;
        try {
            data = pornService.getRandomOne();
        }catch (PornException pe){
            logger.error(pe.getMsg());
            return ResponseUtil.fail(ResponseStatusEnum.QUERY_FAIL.getCode(), pe.getMsg());
        }
        return ResponseUtil.ok(data);
    }

    @PostMapping("/postNew")
    public Object submitNewPorn(@RequestParam(value = "token") String token,
                                @RequestParam(value = "content") String content,
                                @RequestParam(value = "title", required = false) String title){

        return ResponseUtil.ok();
    }
}
