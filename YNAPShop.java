package com.ynap.shop;

import org.apache.commons.lang.StringUtils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class YNAPShop {
    private String row;
    private Basket basket = new Basket();
    private List<Product> productList = new ArrayList<>();
    private StringBuilder builder = new StringBuilder("Product ID, Product Name, Product Price");
    public void loadProducts() throws IOException {
        BufferedReader csvReader = new BufferedReader(new FileReader("src/main/resources/product-data.csv"));
        csvReader.readLine();
        row = null;
        while ((row = csvReader.readLine()) != null) {
            String[] data = row.split(",");
            productList.add(new Product(data[0], data[1], Double.parseDouble(data[2].substring(1))));
        }
        csvReader.close();
    }
    public List getProducts() {return productList; }

    public String displayProducts() {
        for (Product product : productList) {
            builder.append("\n");
            builder.append(product.getProductId());
            builder.append(" , ");
            builder.append(product.getProductName());
            builder.append(" , ");
            builder.append("£");
            builder.append(product.getPrice());
        }
        String productDisplay = builder.toString();

        return productDisplay;
    }
    /**
     * Add a product to the Basket
     */
    public void addProductToBasket(String productId) {
        for(Product product : productList){
            if(product.getProductId().equals(productId)){
                basket.AddItem(product);
            }
        }
    }

    public List getBasketItems(){ return basket.basket; }

    public void removeProductFromBasket(String productId) {
        for(Product product : basket.basket){
            if(product.getProductId().equals(productId)){
                basket.removeItem(productId);
            }
        }
    }
    public BigDecimal getTotal() { return basket.getTotal(); }

    public static void main(String args[]) throws IOException {
      YNAPShop ynapShop = new YNAPShop();
      ynapShop.loadProducts();
        System.out.println(ynapShop.displayProducts());
    }

}
