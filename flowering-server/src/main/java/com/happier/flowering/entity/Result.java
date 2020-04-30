package com.happier.flowering.entity;

public class Result {
    private Baike_info baike_info;
    private String name;
    private double score;
    public void setBaike_info(Baike_info baike_info) {
        this.baike_info = baike_info;
    }
    public Baike_info getBaike_info() {
        return baike_info;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setScore(double score) {
        this.score = score;
    }
    public double getScore() {
        return score;
    }
}
