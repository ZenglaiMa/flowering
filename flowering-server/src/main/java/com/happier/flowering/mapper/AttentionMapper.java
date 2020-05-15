package com.happier.flowering.mapper;

import com.happier.flowering.entity.Attention;
import org.apache.ibatis.annotations.Param;

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
    public int insertAttention(@Param("userInitiative") int userInitiative, @Param("userPassive") int userPassive);
    public int ifAttention(@Param("userInitiative") int userInitiative, @Param("userPassive") int userPassive);
    public int deleteAttention(@Param("userInitiative") int userInitiative, @Param("userPassive") int userPassive);
}
