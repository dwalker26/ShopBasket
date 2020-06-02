package com.ynap.shop;

public class Product {
    private String productId;
    private String productName;
    private double price;

    public Product(String productId, String productName, double price) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
    }

    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (productId == null) return false;
        if (obj instanceof String)return productId.equals(obj);
        else if (obj instanceof Product)return ((Product) obj).productId.equals(this.productId);
        else return false;
    }

}
