package cn.lqs.model;

import java.io.Serializable;

/**
 * Created by LiQingsong on 2018/9/30.
 */
public class Book implements Serializable {
    private Integer id;
    private String title;
    private String author;
    private String date;
    private double price;
    private int amount;

    // Alt + Insert

    public Book() {
    }

    public Book(Integer id, String title, String author, String date, double price, int amount) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.date = date;
        this.price = price;
        this.amount = amount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
