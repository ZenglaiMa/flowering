package com.happier.flowering.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName NineGridModel
 * @Description 承载九宫格数据
 * @Author seven
 * @date 2020/4/21 9:58
 * @Version 0.1
 */
public class NineGridModel implements Serializable {

    private static final long serialVersionUID = 2189052605715370758L;

    public List<String> urlList = new ArrayList<>();

    public boolean isShowAll = false;

}
