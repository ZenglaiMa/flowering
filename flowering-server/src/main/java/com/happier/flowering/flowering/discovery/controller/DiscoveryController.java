package com.happier.flowering.flowering.discovery.controller;

import com.google.gson.Gson;
import com.happier.flowering.flowering.discovery.service.DiscoveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

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

    @RequestMapping("/plantinfo")
    public String plantInfo(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Gson gson = new Gson();
        String plantList = gson.toJson(discoveryService.findAllPlantInfos());
        System.out.println(plantList);
        return plantList;
    }


    @RequestMapping("/test")
    public String test(){
        return "planttest";
    }

    @RequestMapping("/findplant")
    public String findPlant(HttpServletRequest request) throws IOException{
         File file = new File(this.getClass().getResource("/").getPath()+"plant-image");
        if(!file.exists()){//如果文件夹不存在
            file.mkdir();//创建文件夹
        }
        String path = "plant-image/" + System.currentTimeMillis() + ".jpg";
        String plantInfo=null;
        try {
            InputStream is = request.getInputStream();

            String realPath = this.getClass().getResource("/").getPath()+path;
            FileOutputStream fos = new FileOutputStream(realPath);
            byte[] buffer = new byte[512];
            int len;
            while ((len = is.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
            }
            fos.flush();
            fos.close();
            is.close();
            String base64 = discoveryService.getImgUrlToBase64(realPath);
            plantInfo = discoveryService.findPlantByImg(base64);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (plantInfo==null){
            return "plant not found";
        }

        return plantInfo;
    }
}
