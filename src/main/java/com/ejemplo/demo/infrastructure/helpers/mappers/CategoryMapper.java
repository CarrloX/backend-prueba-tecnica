package com.ejemplo.demo.infrastructure.helpers.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.ejemplo.demo.api.dto.request.CategoryRequest;
import com.ejemplo.demo.api.dto.response.CategoryResponse;
import com.ejemplo.demo.domain.entities.CategoryEntity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "fecha", ignore = true)
    @Mapping(target = "userId", ignore = true)
    CategoryEntity toCategoryEntity(CategoryRequest request);

    @Mapping(target = "fecha", expression = "java(formatFecha(entity.getFecha()))")
    CategoryResponse toCategoryResponse(CategoryEntity entity);

    List<CategoryResponse> toCategoryResponseList(List<CategoryEntity> entities);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "fecha", ignore = true)
    @Mapping(target = "userId", ignore = true)
    CategoryEntity toCategoryUpdateEntity(CategoryRequest request, @MappingTarget CategoryEntity category);

    default String formatFecha(LocalDateTime fecha) {
        if (fecha == null) return null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM d, yyyy", new Locale("es", "ES"));
        return fecha.format(formatter);
    }
}
