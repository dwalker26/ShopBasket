package com.ynap.shop;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Basket {
        protected List<Product> basket = new LinkedList<>();

        public void AddItem( Product newProduct ) {
            basket.add(newProduct);
        }

        public void removeItem(String productId) {
            Iterator<Product> iterator = basket.iterator();
             while (iterator.hasNext()) {
                Product data = iterator.next();
                 if (data.getProductId().equals(productId)) {
                iterator.remove();
            }
        }
    }
        public BigDecimal getTotal() {
            double total = 0;

            for(Product product: basket) {
                total += product.getPrice();
            }
            return new BigDecimal(total).setScale(2, RoundingMode.HALF_UP);
        }



}
