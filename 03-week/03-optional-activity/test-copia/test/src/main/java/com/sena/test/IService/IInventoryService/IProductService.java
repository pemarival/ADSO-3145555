package com.sena.test.IService.IInventoryService;

import java.util.List;
import com.sena.test.Dto.InventoryDto.ProductDto;

public interface IProductService {

    List<ProductDto> findAll();
    ProductDto findById(Long id);
    ProductDto save(ProductDto dto);
    ProductDto update(Long id, ProductDto dto);
    void delete(Long id);

}