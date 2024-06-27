package com.example.e_bookapp.models;

public class ModelCart {
    String uid, bookId, title, categoryId;

    public ModelCart(){}

    public ModelCart(String uid, String bookId, String title, String categoryId) {
        this.uid = uid;
        this.bookId = bookId;
        this.title = title;
        this.categoryId = categoryId;
    }


    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookIdId(String bookIdid) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }
}
