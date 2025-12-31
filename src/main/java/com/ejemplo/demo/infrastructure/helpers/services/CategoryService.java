package com.ejemplo.demo.infrastructure.helpers.services;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import com.ejemplo.demo.api.dto.request.CategoryRequest;
import com.ejemplo.demo.api.dto.response.CategoryResponse;
import com.ejemplo.demo.domain.entities.CategoryEntity;
import com.ejemplo.demo.domain.entities.repositories.CategoryRepository;
import com.ejemplo.demo.infrastructure.abstract_services.ICategoryService;
import com.ejemplo.demo.infrastructure.helpers.generic_methods.GenericEntityService;
import com.ejemplo.demo.infrastructure.helpers.mappers.CategoryMapper;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService implements ICategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;
    private final GenericEntityService<CategoryEntity, Long> genericEntityService;

    @Override
    public CategoryResponse create(CategoryRequest request) {
        CategoryEntity categoryEntity = this.categoryMapper.toCategoryEntity(request);
        return this.categoryMapper.toCategoryResponse(this.categoryRepository.save(categoryEntity));
    }

    @Override
    public CategoryResponse getById(Long id) {
        CategoryEntity categoryEntity = this.genericEntityService.find(categoryRepository, id, "CategoryEntity");
        return this.categoryMapper.toCategoryResponse(categoryEntity);
    }

    @Override
    public CategoryResponse update(CategoryRequest request, Long id) {
        CategoryEntity categoryEntity = this.genericEntityService.find(categoryRepository, id, "CategoryEntity");
        categoryEntity = this.categoryMapper.toCategoryUpdateEntity(request, categoryEntity);
        return this.categoryMapper.toCategoryResponse(this.categoryRepository.save(categoryEntity));
    }

    @Override
    public void delete(Long id) {
        CategoryEntity categoryEntity = this.genericEntityService.find(categoryRepository, id, "CategoryEntity");
        this.categoryRepository.delete(categoryEntity);
    }

    @Override
    public List<CategoryResponse> getAll() {
        List<CategoryEntity> categoryEntities = this.categoryRepository.findAll();
        return this.categoryMapper.toCategoryResponseList(categoryEntities);
    }
}
