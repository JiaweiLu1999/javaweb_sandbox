package com.javey.bookstore.bean;

import java.math.BigDecimal;
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
        BigDecimal total = new BigDecimal("0");
        for (CartItem item : values) {
            BigDecimal amount = new BigDecimal(item.getAmount().toString());
            total = total.add(amount);
        }
        this.totalAmount = total.doubleValue();
        return this.totalAmount;
    }

    public Collection<CartItem> getAllCartItem() {
        return map.values();
    }

    public void deleteCartItem(Integer id) {
        map.remove(id);
    }

    public void addCount(Integer id) {
        CartItem cartItem = map.get(id);
        cartItem.setCount(cartItem.getCount() + 1);
    }

    public void subtractCount(Integer id) {
        CartItem cartItem = map.get(id);
        cartItem.setCount(cartItem.getCount() - 1);
    }

    public void changeCount(Integer id, Integer count) {
        CartItem cartItem = map.get(id);
        cartItem.setCount(count);
    }
}
