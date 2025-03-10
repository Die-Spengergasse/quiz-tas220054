package at.spengergasse.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // for MySQL
//    @GeneratedValue // for SQLite
    private int id;
    private String author;
    private String title;
    private LocalDate published;
}
