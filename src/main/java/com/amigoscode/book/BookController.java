package com.amigoscode.book;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookController {
    private final BookRepository bookRepository;

    // Inject your BookRepository here via constructor injection
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    // TODO: 03 - Create a GET endpoint mapped to "/api/v1/books"
    //  that returns all books from the database
    //  Hint: use the repository's findAll() method
    @GetMapping("/api/v1/books")
    public ResponseEntity<?> getAllBooks() {
        return ResponseEntity.ok(bookRepository.findAll());
    }

    // TODO: 04 - Create a GET endpoint mapped to "/api/v1/books/{id}"
    //  that returns a single book by its ID
    //  Hint: use the repository's findById() method
    //  Return 404 if the book is not found
    @GetMapping("/api/v1/books/{id}")
    public ResponseEntity<?> getBookById(@PathVariable Long id) {
        if (bookRepository.findById(id).isEmpty()) {
            return ResponseEntity.status(404).build();
        }
        Book book = bookRepository.findById(id).get();
        return ResponseEntity.ok(book);
    }

    // TODO: 05 - Create a POST endpoint mapped to "/api/v1/books"
    //  that accepts a Book in the request body and saves it to the database
    //  Hint: use the repository's save() method
    @PostMapping("/api/v1/books")
    public ResponseEntity<?> saveBook(@RequestBody Book book) {
        bookRepository.save(book);
        return ResponseEntity.ok(book);
    }

    // TODO: 06 - Create a DELETE endpoint mapped to "/api/v1/books/{id}"
    //  that deletes a book by its ID
    //  Hint: use the repository's deleteById() method
    @DeleteMapping("/api/v1/books/{id}")
    public ResponseEntity<?> deleteBookById(@PathVariable Long id) {
        if (bookRepository.findById(id).isEmpty()) {
            return ResponseEntity.status(404).build();
        }
        bookRepository.deleteById(id);
        return ResponseEntity.status(200).build();
    }
}
