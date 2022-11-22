package com.javey.bookstore.bean;

import java.math.BigDecimal;

public class CartItem {
    private Book book;
    private Integer count;
    private Double amount;

    public CartItem() {
    }

    public CartItem(Book book, Integer count) {
        this.book = book;
        this.count = count;
        computeAmount();
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
        computeAmount();
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
        computeAmount();
    }

    public Double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "book=" + book +
                ", count=" + count +
                ", amount=" + amount +
                '}';
    }

    public void computeAmount() {
        BigDecimal price = new BigDecimal(this.book.getPrice().toString());
        BigDecimal count = new BigDecimal(this.count.toString());
        this.amount = price.multiply(count).doubleValue();
    }
}
