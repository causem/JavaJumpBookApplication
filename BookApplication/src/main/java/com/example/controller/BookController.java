package com.example.controller;

import com.example.dto.BookDto;
import com.example.entity.BookEntity;
import com.example.exception.BookNotFoundException;
import com.example.mapper.BookMapper;
import com.example.repository.BookRepository;
import com.example.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;


    // GET all books
    @GetMapping
    public List<BookDto> getAll() {
        return bookService.getAll();
    }


    // GET book by ID
    @GetMapping("/{id}")
    public BookDto getById(@PathVariable Long id) {
        return bookService.getById(id); // <- DTO
    }


    // POST new book
    @PostMapping
    public ResponseEntity<BookDto> create(@RequestBody BookDto dto) {
        BookDto created = bookService.create(dto); // <- DTO in/out
        return ResponseEntity
                .created(URI.create("/api/books/" + created.getId()))
                .body(created);
    }


    // PUT update book
    @PutMapping("/{id}")
    public BookDto update(@PathVariable Long id, @RequestBody BookDto dto) {
        return bookService.update(id, dto);
    }

    // DELETE book
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        bookService.delete(id);
    }
}