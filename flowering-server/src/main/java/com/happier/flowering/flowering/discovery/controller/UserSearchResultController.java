package com.happier.flowering.flowering.discovery.controller;

import com.happier.flowering.entity.User;
import com.happier.flowering.flowering.discovery.service.UserSearchResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName UserSearchResultController
 * @Description 搜索框中对于相关用户的查询逻辑
 * @Author Seven
 * @Date 2020-05-16 10:16
 */
@RestController
@RequestMapping("/UserSearchResult")
public class UserSearchResultController {

    @Autowired
    private UserSearchResultService userSearchResultService;

    @GetMapping("/users")
    public List<User> listUserByNickName(@RequestParam("keyword") String keyword) {
        return userSearchResultService.listUsersByNameLike(keyword);
    }

}
