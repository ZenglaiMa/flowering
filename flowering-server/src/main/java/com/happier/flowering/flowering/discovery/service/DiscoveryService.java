package com.happier.flowering.flowering.discovery.service;

import com.happier.flowering.entity.Plant;
import com.happier.flowering.mapper.PlantMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName DiscoveryService
 * @Description 花觅(找花) service
 * @Author Seven
 * @Date 2020-04-15 15:13
 */
@Service
public class DiscoveryService {
    @Autowired
    PlantMapper plantMapper;

    public List<Plant> findAllPlantInfos(){
        List<Plant> plantList = plantMapper.findAllPlantInfos();
        return plantList;
    }
}
