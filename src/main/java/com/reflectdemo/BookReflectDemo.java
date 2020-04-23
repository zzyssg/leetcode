package com.reflectdemo;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class BookReflectDemo {
    public static void bookPrivateField() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        Class bookClass = Class.forName("com.reflectdemo.Book");
        Object bookObj = bookClass.newInstance();
        Book book = (Book) bookObj;
        book.setName("ting");
        book.setPage(123);
        book.setPrice(134.0);

        Field field = bookClass.getField("name");
        Method method = bookClass.getMethod("");
    }

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, InstantiationException, IllegalAccessException {
        BookReflectDemo.bookPrivateField();
    }
}
