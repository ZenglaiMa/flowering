package com.happier.flowering.entity;

/**
 * @ClassName Plant
 * @Description 植物实体类
 * @Author Seven
 * @Date 2020-04-15 09:27
 */
public class Plant {

    private Integer plantId; // 植物id
    private String nameCn; // 中文名
    private String nameEn; // 英文名
    private String area; // 分布地区
    private String family; // 科属
    private String description; // 简介描述
    private String conservation; // 养护方法
    private String skill; // 种植技巧
    private String img; // 图片集, 用 "," 分隔
    private String initial; // 拼音首字母(大写), 如牵牛花 -> Q

    public Integer getPlantId() {
        return plantId;
    }

    public void setPlantId(Integer plantId) {
        this.plantId = plantId;
    }

    public String getNameCn() {
        return nameCn;
    }

    public void setNameCn(String nameCn) {
        this.nameCn = nameCn;
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getConservation() {
        return conservation;
    }

    public void setConservation(String conservation) {
        this.conservation = conservation;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getInitial() {
        return initial;
    }

    public void setInitial(String initial) {
        this.initial = initial;
    }
}
