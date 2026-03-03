package com.sena.test.Entity.Inventory;

import java.util.List;

import com.sena.test.Entity.Bill.BillDetail;

import jakarta.persistence.*;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idproduct")
    private Long idProduct;

    @Column(name = "productname", nullable = false, length = 100)
    private String productName;

    @Column(name = "price", nullable = false)
    private Double price;

    @ManyToOne
    @JoinColumn(name = "idcategory", nullable = false)
    private Category category;

    @OneToMany(mappedBy = "product")
    private List<BillDetail> billDetails;

    public Product() {
    }

    public Product(Long idProduct, String productName, Double price, Category category, List<BillDetail> billDetails) {
        this.idProduct = idProduct;
        this.productName = productName;
        this.price = price;
        this.category = category;
        this.billDetails = billDetails;
    }

    public Long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Long idProduct) {
        this.idProduct = idProduct;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<BillDetail> getBillDetails() {
        return billDetails;
    }

    public void setBillDetails(List<BillDetail> billDetails) {
        this.billDetails = billDetails;
    }

    

   

}