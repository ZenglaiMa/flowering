package com.happier.flowering.entity;

import javax.validation.constraints.Max;
import java.util.List;

/**
 * @ClassName Attention
 * @Description 关注关系
 * @Author Seven
 * @Date 2020-04-15 09:06
 */
public class Attention {

    private Integer id; // id
    private Integer userInitiative; // 主动关注者id
    private Integer userPassive; // 被关注者id

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserInitiative() {
        return userInitiative;
    }

    public void setUserInitiative(Integer userInitiative) {
        this.userInitiative = userInitiative;
    }

    public Integer getUserPassive() {
        return userPassive;
    }

    public void setUserPassive(Integer userPassive) {
        this.userPassive = userPassive;
    }
}
