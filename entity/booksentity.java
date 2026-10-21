package com.books.booksrp.entity;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jdk.jfr.DataAmount;
import lombok.Data;
import jakarta.persistence.Id;

@Entity
@Table(name="Books")
@Data
public class booksentity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    private String BookName;
    private String BookAuthor;
}
