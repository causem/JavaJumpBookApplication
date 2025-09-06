package com.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class BookDto {
    private Long id;
    private String title;
    private String author;
    private Long publisherId;
    private String publisherName;

}