package com.books.booksrp.Repository;



import com.books.booksrp.entity.booksentity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BooksRepository
        extends JpaRepository<booksentity, Integer> {

}
