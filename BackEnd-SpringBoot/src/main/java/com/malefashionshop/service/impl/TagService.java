package com.malefashionshop.service.impl;

import com.malefashionshop.dto.request.CategoryUpdateDto;
import com.malefashionshop.dto.request.TagUpdateDto;
import com.malefashionshop.dto.response.CategoryResponseDto;
import com.malefashionshop.dto.response.TagResponseDto;
import com.malefashionshop.entities.CategoryEntity;
import com.malefashionshop.entities.TagEntity;
import com.malefashionshop.exceptions.DataConstrainConflictException;
import com.malefashionshop.exceptions.ResourceNotFoundException;
import com.malefashionshop.repository.CategoryRepository;
import com.malefashionshop.repository.TagRepository;
import com.malefashionshop.service.ICategoryService;
import com.malefashionshop.service.ITagService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TagService implements ITagService {

    @Autowired
    private TagRepository tagRepository;


    @Autowired
    private ModelMapper modelMapper;


    @Override
    public List<TagResponseDto> getAllTags() {
        List<TagResponseDto> listTagResponseDto = new ArrayList<>();
        List<TagEntity> listTagEntity = this.tagRepository.findAll();
        listTagEntity.forEach(tagEntity ->{
            TagResponseDto tagResponseDto = new TagResponseDto();
            this.modelMapper.map(tagEntity,tagResponseDto);
            listTagResponseDto.add(tagResponseDto);
        });
        return listTagResponseDto;
    }

    @Override
    public TagResponseDto createTag(TagUpdateDto dto) {
        if(this.tagRepository.findByCode(dto.getCode()) != null){
            throw new DataConstrainConflictException("Tag code: "+dto.getCode() +" is already exist");
        }

        TagEntity tagEntity = modelMapper.map(dto, TagEntity.class);
        this.tagRepository.save(tagEntity);

//        TagResponseDto tagResponseDto = new TagResponseDto();
        return modelMapper.map(tagEntity,TagResponseDto.class);
    }
}
