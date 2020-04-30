package com.happier.flowering.flowering.discovery.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.happier.flowering.entity.JasonBean;
import com.happier.flowering.entity.Plant;
import com.happier.flowering.flowering.discovery.HttpUtils;
import com.happier.flowering.mapper.PlantMapper;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.codec.binary.Base64;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

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

    public long imgSize(String path){
        File file = new File(path);
        return file.length();
    }

    public void compressImg(File file){

    }

    public String findPlantByImg(String base64){
        String host = "https://zhiwu.market.alicloudapi.com";
        String path = "/do";
        String method = "POST";
        String appcode = "cad8e6777ca74550882f39fd4a93eb36";
        Map<String, String> headers = new HashMap<String, String>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + appcode);
        //根据API的要求，定义相对应的Content-Type
        headers.put("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        Map<String, String> querys = new HashMap<String, String>();
        Map<String, String> bodys = new HashMap<String, String>();
        bodys.put("baike", "1");
        bodys.put("image", base64);

        String plantInfo = null;
        try {
            HttpResponse response = HttpUtils.doPost(host, path, method, headers, querys, bodys);
            System.out.println(response.toString());
            //获取response的body
            plantInfo = EntityUtils.toString(response.getEntity());
          //  Gson gson = new Gson();
           // JasonBean bean = gson.fromJson(info,new TypeToken<JasonBean>(){}.getType());
          //  System.out.println(bean.getResult().get(0).getName()+" "+bean.getResult().get(0).getBaike_info().getDescription());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(plantInfo);
        if (plantInfo == null){
            return "plant not found";
        }
        return  plantInfo;
    }

    public static String getImgUrlToBase64(String imgPath){
        byte[] data = null;
        // 读取图片字节数组
        try {
            InputStream in = new FileInputStream(imgPath);
            data = new byte[in.available()];
            in.read(data);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 返回Base64编码过的字节数组字符串
        return  Base64.encodeBase64String(Objects.requireNonNull(data));
    }
}
