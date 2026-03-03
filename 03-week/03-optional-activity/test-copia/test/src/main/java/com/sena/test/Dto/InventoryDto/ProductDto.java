package com.sena.test.Dto.InventoryDto;

public class ProductDto {

    private Long idProduct;
    private String name;
    private Double price;
    private Long idCategory;

    public ProductDto() {
    }

    public ProductDto(Long idProduct, String name, Double price, Long idCategory) {
        this.idProduct = idProduct;
        this.name = name;
        this.price = price;
        this.idCategory = idCategory;
    }

    public Long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Long idProduct) {
        this.idProduct = idProduct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Long idCategory) {
        this.idCategory = idCategory;
    }
}