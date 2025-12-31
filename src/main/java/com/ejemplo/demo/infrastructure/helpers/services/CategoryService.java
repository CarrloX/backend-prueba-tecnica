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
    public CategoryResponse create(CategoryRequest request, Long userId) {
        CategoryEntity categoryEntity = this.categoryMapper.toCategoryEntity(request);
        categoryEntity.setUserId(userId);
        return this.categoryMapper.toCategoryResponse(this.categoryRepository.save(categoryEntity));
    }

    @Override
    public CategoryResponse getById(Long id, Long userId) {
        CategoryEntity categoryEntity = this.genericEntityService.find(categoryRepository, id, "CategoryEntity");
        if (!categoryEntity.getUserId().equals(userId)) {
            throw new RuntimeException("Categoría no pertenece al usuario");
        }
        return this.categoryMapper.toCategoryResponse(categoryEntity);
    }

    @Override
    public CategoryResponse update(CategoryRequest request, Long id, Long userId) {
        CategoryEntity categoryEntity = this.genericEntityService.find(categoryRepository, id, "CategoryEntity");
        if (!categoryEntity.getUserId().equals(userId)) {
            throw new RuntimeException("Categoría no pertenece al usuario");
        }
        categoryEntity = this.categoryMapper.toCategoryUpdateEntity(request, categoryEntity);
        return this.categoryMapper.toCategoryResponse(this.categoryRepository.save(categoryEntity));
    }

    @Override
    public void delete(Long id, Long userId) {
        CategoryEntity categoryEntity = this.genericEntityService.find(categoryRepository, id, "CategoryEntity");
        if (!categoryEntity.getUserId().equals(userId)) {
            throw new RuntimeException("Categoría no pertenece al usuario");
        }
        this.categoryRepository.delete(categoryEntity);
    }

    @Override
    public List<CategoryResponse> getAll(Long userId) {
        List<CategoryEntity> categoryEntities = this.categoryRepository.findByUserId(userId);
        return this.categoryMapper.toCategoryResponseList(categoryEntities);
    }
}
