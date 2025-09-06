package com.example.controller;

import com.example.dto.BookDto;
import com.example.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/books")
@Tag(name = "Books", description = "CRUD operations for books (with publisher linkage)")
public class BookController {

    private final BookService bookService;


    // GET all books
    @GetMapping
    @Operation(summary = "List all books", description = "Returns all books")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Book added."),
            @ApiResponse(responseCode = "400", description = "Wrong data.")
    })
    public List<BookDto> getAll() {
        return bookService.getAll();
    }


    // GET book by ID
    @GetMapping("/{id}")
    @Operation(summary = "Get book by id", description = "Returns a single book")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Book not found")})
    public BookDto getById(@PathVariable Long id) {
        return bookService.getById(id); // <- DTO
    }


    // POST new book
    @PostMapping
    @Operation(summary = "Create a book", description = "Creates a new book")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Created")})
    public ResponseEntity<BookDto> create(@RequestBody BookDto dto) {
        BookDto created = bookService.create(dto); // <- DTO in/out
        return ResponseEntity
                .created(URI.create("/api/books/" + created.getId()))
                .body(created);
    }


    // PUT update book
    @PutMapping("/{id}")
    @Operation(summary = "Update a book", description = "Updates an existing book")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Updated"),
            @ApiResponse(responseCode = "404", description = "Book not found")})
    public BookDto update(@PathVariable Long id, @RequestBody BookDto dto) {
        return bookService.update(id, dto);
    }

    // DELETE book
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete a book", description = "Deletes a book by id")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "No Content"),
            @ApiResponse(responseCode = "404", description = "Book not found")
    })
    public void delete(@PathVariable Long id) {
        bookService.delete(id);
    }
}