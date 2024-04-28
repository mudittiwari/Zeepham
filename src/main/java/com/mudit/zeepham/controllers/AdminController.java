package com.mudit.zeepham.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mudit.zeepham.Exceptions.ObjectNotFound;
import com.mudit.zeepham.dto.ProductDto;
import com.mudit.zeepham.entity.Brand;
import com.mudit.zeepham.entity.Product;
import com.mudit.zeepham.entity.ProductCategory;
import com.mudit.zeepham.services.AdminService;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/admin")
@PreAuthorize(value = "hasRole('ROLE_ADMIN')")
public class AdminController {

    @Autowired
    private AdminService service;
    /////////////////////////////////product related code starts//////////////////////////////////
    @PostMapping("/addProduct")
    
    public ResponseEntity<String> addProduct(@RequestBody ProductDto product) {
        if(service.addProduct(product)){
            return new ResponseEntity<>("product added successfully",HttpStatus.OK);
        }
        
        return new ResponseEntity<>("error occoured while adding the product",HttpStatus.BAD_REQUEST);
    }



    @PostMapping("/editProduct")
    public ResponseEntity<String> editProduct(@RequestParam("productId") int productId,@RequestBody ProductDto product) {
        if(service.editProduct(product,productId)){
            return new ResponseEntity<>("product updated successfully",HttpStatus.OK);
        }
        
        return new ResponseEntity<>("error occoured while updating the product",HttpStatus.BAD_REQUEST);
    }






    /////////////////////////////////product related code ends//////////////////////////////////

    /////////////////////////////////brand related code starts//////////////////////////////////
    @PostMapping("/addBrand")
    public ResponseEntity<String> addBrand(@RequestBody Brand brand) {
        if(service.addBrand(brand)){
            return new ResponseEntity<>("brand added successfully",HttpStatus.OK);
        }
        
        return new ResponseEntity<>("error occoured while adding the brand",HttpStatus.BAD_REQUEST);
    }
    @PostMapping("/editBrand")
    public ResponseEntity<String> editBrand(@RequestParam("id") int id,@RequestBody Brand brand) {
        if(service.editBrand(brand,id)){
            return new ResponseEntity<>("brand updated successfully",HttpStatus.OK);
        }
        
        return new ResponseEntity<>("error occoured while updating the brand",HttpStatus.BAD_REQUEST);
    }
    /////////////////////////////////brand related code ends//////////////////////////////////


    /////////////////////////////////category related code starts//////////////////////////////////

    @PostMapping("/addCategory")
    public ResponseEntity<String> addCategory(@RequestBody ProductCategory category) {
        
        if(service.addCategory(category)){
            return new ResponseEntity<>("category added successfully",HttpStatus.OK);
        }
        
        return new ResponseEntity<>("error occoured while adding the category",HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/editCategory")
    public ResponseEntity<String> editCategory(@RequestParam("id") int id,@RequestBody ProductCategory category) {
        if(service.editCategory(category,id)){
            return new ResponseEntity<>("category updated successfully",HttpStatus.OK);
        }
        return new ResponseEntity<>("error occoured while updating the category",HttpStatus.BAD_REQUEST);
    }
    
    /////////////////////////////////category related code ends//////////////////////////////////
}
