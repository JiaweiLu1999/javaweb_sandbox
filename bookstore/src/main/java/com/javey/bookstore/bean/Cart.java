package com.javey.bookstore.bean;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Integer, CartItem> map = new HashMap<>();
    private Integer totalCount;
    private Double totalAmount;

    public void addCart(Book book) {
        if (!map.containsKey(book.getBookId())) {
            map.put(book.getBookId(), new CartItem(book, 1));
        } else {
            CartItem cartItem = map.get(book.getBookId());
            cartItem.setCount(cartItem.getCount() + 1);
        }
        System.out.println(map);
    }

    public Integer getTotalCount() {
        Collection<CartItem> values = map.values();
        Integer total = 0;
        for (CartItem item : values) {
            total += item.getCount();
        }
        this.totalCount = total;
        return total;
    }

    public Double getTotalAmount() {
        Collection<CartItem> values = map.values();
        Double total = 0.0;
        for (CartItem item : values) {
            total += item.getAmount();
        }
        this.totalAmount = total;
        return total;
    }

    public Collection<CartItem> getAllCartItem() {
        return map.values();
    }
}
