package com.javey.bookstore.bean;

public class CartItem {
    private Book book;
    private Integer count;
    private Double amount;

    public CartItem() {
    }

    public CartItem(Book book, Integer count) {
        this.book = book;
        this.count = count;
        this.amount = this.count * this.book.getPrice();
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
        this.amount = this.count * this.book.getPrice();
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
        this.amount = this.count * this.book.getPrice();
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
}
