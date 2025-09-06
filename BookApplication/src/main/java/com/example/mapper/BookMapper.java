package com.example.mapper;

import com.example.dto.BookDto;
import com.example.entity.BookEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookMapper {

    BookDto toDto(BookEntity entity);
    BookEntity toEntity(BookDto dto);

    List<BookDto> toDtoList(List<BookEntity> entities);
    List<BookEntity> toEntityList(List<BookDto> dtos);

    void updateEntityFromDto(BookDto dto, @MappingTarget BookEntity entity);


}
