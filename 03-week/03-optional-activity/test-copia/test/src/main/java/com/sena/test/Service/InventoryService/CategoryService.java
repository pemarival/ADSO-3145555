package com.sena.test.Service.InventoryService;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.test.Dto.InventoryDto.CategoryDto;
import com.sena.test.Entity.Inventory.Category;
import com.sena.test.IRepository.IInventoryRepository.ICategoryRepository;
import com.sena.test.IService.IInventoryService.ICategoryService;

@Service
public class CategoryService implements ICategoryService {

    @Autowired
    private ICategoryRepository categoryRepository;

    private CategoryDto convertToDto(Category category) {
        return new CategoryDto(
                category.getIdCategory(),
                category.getCategoryName()
        );
    }

    private Category convertToEntity(CategoryDto dto) {
        Category category = new Category();
        category.setIdCategory(dto.getIdCategory());
        category.setCategoryName(dto.getCategoryName());
        return category;
    }

    @Override
    public List<CategoryDto> findAll() {
        return categoryRepository.findAll()
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDto findById(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada"));
        return convertToDto(category);
    }

    @Override
    public CategoryDto save(CategoryDto dto) {
        Category category = convertToEntity(dto);
        return convertToDto(categoryRepository.save(category));
    }

    @Override
    public CategoryDto update(Long id, CategoryDto dto) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada"));

        category.setCategoryName(dto.getCategoryName());

        return convertToDto(categoryRepository.save(category));
    }

    @Override
    public void delete(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada"));
        categoryRepository.delete(category);
    }

}