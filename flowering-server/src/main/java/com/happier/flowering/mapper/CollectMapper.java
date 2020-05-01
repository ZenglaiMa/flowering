package com.happier.flowering.mapper;

import com.happier.flowering.entity.Collect;

import java.util.List;

/**
 * @ClassName CollectMapper
 * @Description
 * @Author Seven 赵语涵
 * @Date 2020-04-15 15:07
 */
public interface CollectMapper{
    public void setStar(Collect collect);
    public int isStar(Collect collect);
    public void unStar(Collect collect);
    public List<Integer> findCollect(int id);
}
