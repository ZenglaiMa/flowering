package com.happier.flowering.flowering.discovery.controller;

import com.happier.flowering.flowering.discovery.service.DiscoveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName DiscoveryController
 * @Description 花觅(找花) controller
 * @Author Seven
 * @Date 2020-04-15 15:14
 */
@RestController
@RequestMapping("/discovery")
public class DiscoveryController {

    @Autowired
    private DiscoveryService discoveryService;

}
