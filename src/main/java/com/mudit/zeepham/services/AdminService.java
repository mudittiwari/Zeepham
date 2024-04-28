package com.mudit.zeepham.services;

import java.util.ArrayList;
import java.util.Locale.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mudit.zeepham.dto.ProductDto;
import com.mudit.zeepham.entity.Brand;
import com.mudit.zeepham.entity.Product;
import com.mudit.zeepham.entity.ProductCategory;
import com.mudit.zeepham.repository.AdminRepo;

@Service
public class AdminService {

    @Autowired
    private AdminRepo repo;

    public boolean addBrand(Brand brand) {
        return repo.addBrand(brand);
    }
    public boolean editBrand(Brand brand,int id) {
        return repo.editBrand(brand,id);
    }

    

    public Brand findBrandById(int id) {
        return repo.findBrandById(id);
    }

    public boolean addProduct(ProductDto productDto) {
        ProductCategory category = this.findCategoryById(productDto.getCategoryId());
        Brand brand = this.findBrandById(productDto.getBrandId());
        Product product = new Product();
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setDiscountedPrice(productDto.getDiscountedPrice());
        product.setBrand(brand);
        product.setInStock(productDto.isInStock());
        product.setFeatured(productDto.isFeatured());
        product.setDescription(productDto.getDescription());
        product.setColor(productDto.getColor());
        product.setCountInStock(productDto.getCountInStock());
        product.setRating(productDto.getRating());
        product.setCategory(category);
        System.out.println(product);
        return repo.addProduct(product);
    }

    public boolean editProduct(ProductDto productDto,int productId){
        return repo.editProduct(productDto,productId);
    }


    public boolean addCategory(ProductCategory category) {
        return repo.addCategory(category);
    }

    public ProductCategory findCategoryById(int id) {
        return repo.findCategoryById(id);
    }

    public boolean editCategory(ProductCategory category,int categoryId){
        return repo.editCategory(category,categoryId);
    }
}
