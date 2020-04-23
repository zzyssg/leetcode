package com.reflectdemo;

public class Book {
    private String name;
    private Integer page;
    public Double price;

    public String getName() {
        return name;
    }

    public Integer getPage() {
        return page;
    }

    public Double getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    private String caidan(){
        return "caidan";
    }


}
