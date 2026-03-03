package com.sena.test.Dto.InventoryDto;

public class CategoryDto {

    private Long idCategory;
    private String categoryName;

    public CategoryDto() {
    }

    public CategoryDto(Long idCategory, String categoryName) {
        this.idCategory = idCategory;
        this.categoryName = categoryName;
     
    }

    public Long getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Long idCategory) {
        this.idCategory = idCategory;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

}