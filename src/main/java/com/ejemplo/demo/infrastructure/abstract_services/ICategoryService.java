package com.ejemplo.demo.infrastructure.abstract_services;

import com.ejemplo.demo.api.dto.request.CategoryRequest;
import com.ejemplo.demo.api.dto.response.CategoryResponse;

import java.util.List;

public interface ICategoryService {
    CategoryResponse create(CategoryRequest request);
    CategoryResponse getById(Long id);
    CategoryResponse update(CategoryRequest request, Long id);
    void delete(Long id);
    List<CategoryResponse> getAll();
}
