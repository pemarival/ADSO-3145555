package com.sena.test.Service.InventoryService;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.test.Dto.InventoryDto.ProductDto;
import com.sena.test.Entity.Inventory.Product;
import com.sena.test.Entity.Inventory.Category;
import com.sena.test.IRepository.IInventoryRepository.IProductRepository;
import com.sena.test.IRepository.IInventoryRepository.ICategoryRepository;
import com.sena.test.IService.IInventoryService.IProductService;

@Service
public class ProductService implements IProductService {

    @Autowired
    private IProductRepository productRepository;

    @Autowired
    private ICategoryRepository categoryRepository;

    private ProductDto convertToDto(Product product) {
        return new ProductDto(
                product.getIdProduct(),
                product.getProductName(),
                product.getPrice(),
                product.getCategory().getIdCategory()
        );
    }

    private Product convertToEntity(ProductDto dto) {
        Product product = new Product();
        product.setIdProduct(dto.getIdProduct());
        product.setProductName(dto.getName());
        product.setPrice(dto.getPrice());

        Category category = categoryRepository.findById(dto.getIdCategory())
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada"));

        product.setCategory(category);

        return product;
    }

    @Override
    public List<ProductDto> findAll() {
        return productRepository.findAll()
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProductDto findById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        return convertToDto(product);
    }

    @Override
    public ProductDto save(ProductDto dto) {
        Product product = convertToEntity(dto);
        Product saved = productRepository.save(product);
        return convertToDto(saved);
    }

    @Override
    public ProductDto update(Long id, ProductDto dto) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        product.setProductName(dto.getName());
        product.setPrice(dto.getPrice());

        Category category = categoryRepository.findById(dto.getIdCategory())
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada"));

        product.setCategory(category);

        Product updated = productRepository.save(product);
        return convertToDto(updated);
    }

    @Override
    public void delete(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        productRepository.delete(product);
    }
}