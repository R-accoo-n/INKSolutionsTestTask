package com.example.inksolutionstesttask.entity;

public enum Category {
    DRINKS,
    FOOD;

    private int totalQuantityPerCategory = 0;

    public void setTotalQuantityPerCategory(int totalQuantityPerCategory) {
        this.totalQuantityPerCategory = totalQuantityPerCategory;
    }

    public int getTotalQuantityPerCategory() {
        return totalQuantityPerCategory;
    }
}
