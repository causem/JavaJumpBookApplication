package com.example.controller;

import com.example.dto.PublisherDto;
import com.example.service.PublisherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/publishers")
@RequiredArgsConstructor
public class PublisherController {

    private final PublisherService publisherService;

    @GetMapping
    public List<PublisherDto> getAll() {
        return publisherService.getAll();
    }

    @GetMapping("/{id}")
    public PublisherDto getById(@PathVariable Long id) {
        return publisherService.getById(id);
    }

    @PostMapping
    public ResponseEntity<PublisherDto> create(@RequestBody PublisherDto dto) {
        PublisherDto created = publisherService.create(dto);
        return ResponseEntity.created(URI.create("/api/publishers/" + created.getId()))
                .body(created);
    }

    @PutMapping("/{id}")
    public PublisherDto update(@PathVariable Long id, @RequestBody PublisherDto dto) {
        return publisherService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        publisherService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
