package com.bookstore;

import com.bookstore.service.BookstoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MainApplication {

    @Autowired
    private BookstoreService bookstoreService;

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

    @Bean
    public ApplicationRunner init() {
        return args -> {
            System.out.println("\n\npersistAuthorWithBooks():");
            bookstoreService.persistAuthorWithBooks();

            System.out.println("\n\nfetchPaperback():");
            bookstoreService.fetchPaperback();
            System.out.println("\n\nfetchEbook():");
            bookstoreService.fetchEbook();

            System.out.println("\n\nfetchEbookByAuthorId():");
            bookstoreService.fetchEbookByAuthorId();

            System.out.println("\n\nfetchPaperbackByAuthorId():");
            bookstoreService.fetchPaperbackByAuthorId();
        };
    }
}
/*
 * JPA Inheritance - @MappedSuperclass

Description: This application is a sample of using the JPA @MappedSuperclass.

Key points:

the base class is not an entity, it can be abstract, and is annotated with @MappedSuperclass
subclasses of the base class are mapped in tables that contains columns for the inherited attributes and for their own attibutes
when the base class doens't need to be an entity, the @MappedSuperclass is the proper alternative to the JPA table-per-class inheritance strategy
 * 
 * 
 */
