package com.example.BookManagementSys.controller;

import com.example.BookManagementSys.model.Book;
import com.example. BookManagementSys.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/Books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable int id) {
        return bookService.getBookById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public String updateBook(@PathVariable int id, @RequestBody Book book) {
        if (bookService.updateBook(id, book)) {
            return "Book updated successfully.";
        }
        return "Book not found.";
    }

    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable int id) {
        if (bookService.deleteBook(id)) {
            return "Book deleted successfully.";
        }
        return "Book not found.";
    }

    @GetMapping("/Search")
    public List<Book> getBooksByAuthor(@RequestParam String author) {
        return bookService.getBooksByAuthor(author);
    }

    @GetMapping("/Filter")
    public List<Book> getBooksCheaperThan(@RequestParam double price) {
        return bookService.getBooksCheaperThan(price);
    }


    @GetMapping("/Count")
    public int getTotalBooks() {
        return bookService.getTotalBooks();
    }

    @GetMapping("/Max-Price")
    public Book getMostExpensiveBook() {
        return bookService.getMostExpensiveBook();
    }
}
