package com.klu.controller;

import org.springframework.web.bind.annotation.*;
import java.util.*;

import com.klu.model.Book;

@RestController
@RequestMapping("/api")
public class LibraryController {

    private List<Book> bookList = new ArrayList<>();

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to Online Library System!";
    }

    @GetMapping("/count")
    public int getCount() {
        return 100;
    }

    @GetMapping("/price")
    public double getPrice() {
        return 499.99;
    }

    @GetMapping("/books")
    public List<String> getBooks() {
        return Arrays.asList("Java", "Spring Boot", "Hibernate");
    }

    @GetMapping("/books/{id}")
    public String getBookById(@PathVariable int id) {
        return "Book details for ID: " + id;
    }

    @GetMapping("/search")
    public String searchBook(@RequestParam String title) {
        return "Searching for book: " + title;
    }

    @GetMapping("/author/{name}")
    public String getAuthor(@PathVariable String name) {
        return "Books written by: " + name;
    }

    @PostMapping("/addbook")
    public String addBook(@RequestBody Book book) {
        bookList.add(book);
        return "Book added successfully!";
    }

    @GetMapping("/viewbooks")
    public List<Book> viewBooks() {
        return bookList;
    }
}