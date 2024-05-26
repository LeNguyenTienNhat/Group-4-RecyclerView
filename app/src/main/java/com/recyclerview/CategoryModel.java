package com.recyclerview;
public class CategoryModel {
    int thumbnail;
    String label;
    String des;

    public CategoryModel(int thumbnail, String label, String des) {
        this.thumbnail = thumbnail;
        this.label = label;
        this.des = des;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public String getLabel() {
        return label;
    }

    public String getDes() {
        return des;
    }
}
