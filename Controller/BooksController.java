package com.books.booksrp.Controller;


import com.books.booksrp.Service.BooksService;
import com.books.booksrp.entity.booksentity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BooksController {
    private final BooksService booksService;
    @Autowired
    public BooksController(BooksService booksService) {
        this.booksService = booksService;
    }
    @PostMapping
    public booksentity addBook(@RequestBody booksentity booksentity) {
        return booksService.addBook(booksentity);

    }
    @GetMapping
    public List<booksentity> getAllBooks() {
        return booksService.getAllBooks();
    }

    @GetMapping("/{Id}")
    public booksentity getBookById(@PathVariable Integer id) {
        return booksService.getBookById(id);
    }
    @PutMapping("/{Id}")
    public booksentity updateBook(@PathVariable Integer id, @RequestBody booksentity books) {
        return booksService.updateBook(id, books);
    }
    @DeleteMapping("/{Id}")
    public String  deleteBookById(@PathVariable Integer id) {
        booksService.deleteBook(id);
        return "Book deleted";
    }
}
