package com.happier.flowering.flowering.center.controller;

import com.happier.flowering.flowering.center.service.CenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName CenterController
 * @Description 个人中心 controller
 * @Author Seven
 * @Date 2020-04-15 15:11
 */
@RestController
@RequestMapping("/center")
public class CenterController {

    @Autowired
    private CenterService centerService;

}
