package com.ejemplo.demo.infrastructure.abstract_services;

import com.ejemplo.demo.api.dto.request.CategoryRequest;
import com.ejemplo.demo.api.dto.response.CategoryResponse;

import java.util.List;

public interface ICategoryService {
    CategoryResponse create(CategoryRequest request, Long userId);
    CategoryResponse getById(Long id, Long userId);
    CategoryResponse update(CategoryRequest request, Long id, Long userId);
    void delete(Long id, Long userId);
    List<CategoryResponse> getAll(Long userId);
}
