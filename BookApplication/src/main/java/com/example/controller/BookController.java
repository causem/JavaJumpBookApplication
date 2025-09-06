package com.example.controller;

import com.example.dto.BookDto;
import com.example.entity.BookEntity;
import com.example.exception.BookNotFoundException;
import com.example.mapper.BookMapper;
import com.example.repository.BookRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    public BookController(BookRepository bookRepository, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }

    // GET all books
    @GetMapping
    public List<BookDto> getAllBooks() {
        return bookMapper.toDtoList(bookRepository.findAll());
    }

    // GET book by ID
    @GetMapping("/{id}")
    public BookDto getBookById(@PathVariable Long id) {
        BookEntity entity = bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));
        return bookMapper.toDto(entity);
    }

    // POST new book
    @PostMapping
    public BookDto addBook(@RequestBody BookDto dto) {
        BookEntity entity = bookMapper.toEntity(dto);
        return bookMapper.toDto(bookRepository.save(entity));
    }

    // PUT update book
    @PutMapping("/{id}")
    public BookDto updateBook(@PathVariable Long id, @RequestBody BookDto updatedDto) {
        return bookRepository.findById(id)
                .map(entity -> {
                    entity.setTitle(updatedDto.getTitle());
                    entity.setAuthor(updatedDto.getAuthor());
                    return bookMapper.toDto(bookRepository.save(entity));
                })
                .orElseThrow(() -> new BookNotFoundException(id));
    }

    // DELETE book
    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookRepository.deleteById(id);
    }
}