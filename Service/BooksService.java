package com.books.booksrp.Service;

import com.books.booksrp.entity.booksentity;
import com.books.booksrp.Repository.BooksRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BooksService {

    private final BooksRepository booksRepository;

    public BooksService(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    // Add book
    public booksentity addBook(booksentity book) {
        return booksRepository.save(book);
    }

    // Get all books
    public List<booksentity> getAllBooks() {
        return booksRepository.findAll();
    }

    // Get book by ID
    public booksentity getBookById(int id) {
        return booksRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Book not found: " + id));
    }

    // Update book
    public booksentity updateBook(int id, booksentity updatedBook) {
        booksentity existingBook = getBookById(id);

        existingBook.setBookName(updatedBook.getBookName());
        existingBook.setBookAuthor(updatedBook.getBookAuthor());

        return booksRepository.save(existingBook);
    }

    // Delete book
    public void deleteBook(int id) {
        if (!booksRepository.existsById(id)) {
            throw new RuntimeException("Book not found: " + id);
        }

        booksRepository.deleteById(id);
    }
}