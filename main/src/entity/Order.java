package entity;

import base.entity.BaseEntity;

public class Order extends BaseEntity<Integer> {

    private String username;
    private int productId;
    private  int count;
    private  int price;

    public Order() {
    }

    public Order(String username, int productId, int count, int price) {
        this.username = username;
        this.productId = productId;
        this.count = count;
        this.price = price;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
