package com.sena.test.IRepository.IInventoryRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sena.test.Entity.Inventory.Product;

public interface IProductRepository extends JpaRepository<Product, Long> {

}