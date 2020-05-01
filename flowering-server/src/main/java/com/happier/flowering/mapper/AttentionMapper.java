package com.happier.flowering.mapper;

import com.happier.flowering.entity.Attention;

import java.util.List;

/**
 * @ClassName AttentionMapper
 * @Description
 * @Author Seven
 * @Date 2020-04-15 15:07
 */
public interface AttentionMapper {

    public List<Integer> findUserInitiativeId(int id);
    public List<Integer> findUserpassiveId(int id);
}
