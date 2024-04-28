package com.mudit.zeepham.entity;


import java.util.List;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private double price;
    private double discountedPrice;
    @ManyToOne
    private Brand brand;
    private boolean inStock;
    private boolean isFeatured;
    private String description;
    private String color;
    private int countInStock;
    private double rating;
    @ManyToOne
    private ProductCategory category;
    @OneToMany(cascade = CascadeType.REMOVE,fetch = FetchType.EAGER)
    private List<Review> reviews;

    
    public Product() {
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public double getDiscountedPrice() {
        return discountedPrice;
    }
    public void setDiscountedPrice(double discountedPrice) {
        this.discountedPrice = discountedPrice;
    }
    public Brand getBrand() {
        return brand;
    }
    public void setBrand(Brand brand) {
        this.brand = brand;
    }
    public boolean isInStock() {
        return inStock;
    }
    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }
    public boolean isFeatured() {
        return isFeatured;
    }
    public void setFeatured(boolean isFeatured) {
        this.isFeatured = isFeatured;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public int getCountInStock() {
        return countInStock;
    }
    public void setCountInStock(int countInStock) {
        this.countInStock = countInStock;
    }
    public double getRating() {
        return rating;
    }
    public void setRating(double rating) {
        this.rating = rating;
    }
    public List<Review> getReviews() {
        return reviews;
    }
    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }
    public ProductCategory getCategory() {
        return category;
    }
    public void setCategory(ProductCategory category) {
        this.category = category;
    }
    @Override
    public String toString() {
        return "Product [id=" + id + ", name=" + name + ", price=" + price + ", discountedPrice=" + discountedPrice
                + ", brand=" + brand + ", inStock=" + inStock + ", isFeatured=" + isFeatured + ", description="
                + description + ", color=" + color + ", countInStock=" + countInStock + ", rating=" + rating
                + ", category=" + category + ", reviews=" + reviews + "]";
    }
    
    
}
// product entity:
// name,price,discounted price,brand,instock,featured,description,color,countInStock,rating,reviews array
