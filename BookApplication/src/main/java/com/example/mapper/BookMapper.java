package com.example.mapper;

import com.example.dto.BookDto;
import com.example.entity.BookEntity;
import com.example.entity.PublisherEntity;
import com.example.repository.PublisherRepository;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookMapper {

    @Mapping(source = "publisher.id",   target = "publisherId")
    @Mapping(source = "publisher.name", target = "publisherName")
    BookDto toDto(BookEntity entity);

    List<BookDto> toDtoList(List<BookEntity> entities);

    @Mapping(target = "publisher", ignore = true)
    BookEntity toEntity(BookDto dto, @Context PublisherRepository publisherRepository);

    @Mapping(target = "publisher", ignore = true)
    void updateEntityFromDto(BookDto dto,
                             @MappingTarget BookEntity entity,
                             @Context PublisherRepository publisherRepository);

    @AfterMapping
    default void setPublisher(BookDto dto,
                              @MappingTarget BookEntity entity,
                              @Context PublisherRepository publisherRepository) {
        if (dto == null) return;

        PublisherEntity publisher = null;

        if (dto.getPublisherId() != null) {
            publisher = publisherRepository.findById(dto.getPublisherId()).orElse(null);
        } else {
            String name = dto.getPublisherName();
            if (name != null) {
                String trimmed = name.trim();
                if (!trimmed.isEmpty()) {
                    publisher = publisherRepository.findByNameIgnoreCase(trimmed)
                            .orElseGet(() -> publisherRepository.save(new PublisherEntity(null, trimmed)));
                }
            }
        }

        entity.setPublisher(publisher);
    }
}