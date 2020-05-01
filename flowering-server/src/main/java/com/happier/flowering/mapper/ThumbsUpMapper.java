package com.happier.flowering.mapper;

import java.util.List;

/**
 * @ClassName ThumbsUpMapper
 * @Description
 * @Author Seven
 * @Date 2020-04-15 15:09
 */
public interface ThumbsUpMapper {
    public List<Integer> findThumbsOther(int id);
    public List<Integer> findThumbsMe(int id);
}
