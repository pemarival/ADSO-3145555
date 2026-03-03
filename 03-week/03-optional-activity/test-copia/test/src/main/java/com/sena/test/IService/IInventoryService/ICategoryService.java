package com.sena.test.IService.IInventoryService;

import java.util.List;
import com.sena.test.Dto.InventoryDto.CategoryDto;

public interface ICategoryService {

    List<CategoryDto> findAll();
    CategoryDto findById(Long id);
    CategoryDto save(CategoryDto dto);
    CategoryDto update(Long id, CategoryDto dto);
    void delete(Long id);
    
}