package com.happier.flowering.mapper;

import com.happier.flowering.entity.Plant;

import java.util.List;

/**
 * @ClassName PlantMapper
 * @Description
 * @Author Seven
 * @Date 2020-04-15 15:08
 */
public interface PlantMapper {
    public List<Plant> findAllPlantInfos();
}
