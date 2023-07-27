package com.ltp.globalsuperstore;

import java.util.UUID;

public class Products {
    private String id;
    private String categoriy;
    private String name;
    private String price;
    private String discount;
    private String orderDate;

    public String getId() {
        return this.id;
    }


    public Products() {
        this.id = UUID.randomUUID().toString();
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getCategoriy() {
        return this.categoriy;
    }

    public void setCategoriy(String categoriy) {
        this.categoriy = categoriy;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return this.price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDiscount() {
        return this.discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getOrderDate() {
        return this.orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    @Override
    public String toString() {
        return "{" +
            " categoriy='" + getCategoriy() + "'" +
            ", name='" + getName() + "'" +
            ", price='" + getPrice() + "'" +
            ", discount='" + getDiscount() + "'" +
            ", orderDate='" + getOrderDate() + "'" +
            "}";
    }
  
}
