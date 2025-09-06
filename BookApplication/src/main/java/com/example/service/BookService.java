package com.example.service;

import com.example.dto.BookDto;
import com.example.entity.BookEntity;
import com.example.exception.BookNotFoundException;
import com.example.mapper.BookMapper;
import com.example.repository.BookRepository;
import com.example.repository.PublisherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;
    private final BookMapper bookMapper;

    @Transactional(readOnly = true)
    public List<BookDto> getAll() {
        return bookRepository.findAll()
                .stream()
                .map(bookMapper::toDto)
                .toList();
    }

    @Transactional(readOnly = true)
    public BookDto getById(Long id) {
        BookEntity entity = bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));
        return bookMapper.toDto(entity);
    }

    @Transactional
    public BookDto create(BookDto dto) {
        BookEntity entity = bookMapper.toEntity(dto, publisherRepository);
        entity.setId(null);
        return bookMapper.toDto(bookRepository.save(entity));
    }

    @Transactional
    public BookDto update(Long id, BookDto dto) {
        BookEntity entity = bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));
        bookMapper.updateEntityFromDto(dto, entity, publisherRepository);
        return bookMapper.toDto(bookRepository.save(entity));
    }

    @Transactional
    public void delete(Long id) {
        if (!bookRepository.existsById(id)) {
            throw new BookNotFoundException(id);
        }
        bookRepository.deleteById(id);
    }
}