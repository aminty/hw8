package entity;

import base.entity.BaseEntity;

public class Product extends BaseEntity<Integer> {
    private String name;
    private String category;
    private int price;
    private  int count;
    private int currentCount;

    public Product(){

    }
    public Product( String name, String category, int price,int count) {

        this.name = name;
        this.category = category;
        this.price = price;
        this.count=count;
    }

    public int getCurrentCount() {
        return currentCount;
    }

    public void setCurrentCount(int currentCount) {
        this.currentCount = currentCount;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
