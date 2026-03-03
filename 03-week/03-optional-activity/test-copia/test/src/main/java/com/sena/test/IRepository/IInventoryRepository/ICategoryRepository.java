package com.sena.test.IRepository.IInventoryRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sena.test.Entity.Inventory.Category;

public interface ICategoryRepository extends JpaRepository<Category, Long> {

}