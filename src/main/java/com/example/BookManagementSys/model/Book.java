package com.example.BookManagementSys.model;
import lombok.Data;


@Data
public class Book {
    private Integer id;
    private String title;
    private String author;
    private Double price;

}
