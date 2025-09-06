package com.example.mapper;

import com.example.dto.PublisherDto;
import com.example.entity.PublisherEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PublisherMapper {

    PublisherDto toDto(PublisherEntity entity);
    PublisherEntity toEntity(PublisherDto dto);

    List<PublisherDto> toDtoList(List<PublisherEntity> entities);

    void updateEntityFromDto(PublisherDto dto, @MappingTarget PublisherEntity entity);
}
