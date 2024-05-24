package com.recyclerview;

public class CategoryModel {
    int thumbnail;
    String label;

    public CategoryModel(int thumbnail, String label) {
        this.thumbnail = thumbnail;
        this.label = label;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public String getLabel() {
        return label;
    }
}
