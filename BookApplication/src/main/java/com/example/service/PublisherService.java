package com.example.service;

import com.example.dto.PublisherDto;
import com.example.entity.PublisherEntity;
import com.example.exception.PublisherNotFoundException;
import com.example.mapper.PublisherMapper;
import com.example.repository.PublisherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PublisherService {

    private final PublisherRepository publisherRepository;
    private final PublisherMapper publisherMapper;

    @Transactional(readOnly = true)
    public List<PublisherDto> getAll() {
        return publisherMapper.toDtoList(publisherRepository.findAll());
    }

    @Transactional(readOnly = true)
    public PublisherDto getById(Long id) {
        PublisherEntity entity = publisherRepository.findById(id)
                .orElseThrow(() -> new PublisherNotFoundException(id));
        return publisherMapper.toDto(entity);
    }

    @Transactional
    public PublisherDto create(PublisherDto dto) {
        PublisherEntity entity = publisherMapper.toEntity(dto);
        entity.setId(null);
        return publisherMapper.toDto(publisherRepository.save(entity));
    }

    @Transactional
    public PublisherDto update(Long id, PublisherDto dto) {
        PublisherEntity entity = publisherRepository.findById(id)
                .orElseThrow(() -> new PublisherNotFoundException(id));
        publisherMapper.updateEntityFromDto(dto, entity);
        return publisherMapper.toDto(publisherRepository.save(entity));
    }

    @Transactional
    public void delete(Long id) {
        if (!publisherRepository.existsById(id)) {
            throw new PublisherNotFoundException(id);
        }
        publisherRepository.deleteById(id);
    }
}
