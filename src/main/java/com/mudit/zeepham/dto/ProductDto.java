package com.mudit.zeepham.dto;


public class ProductDto {
    private String name;
    private double price;
    private double discountedPrice;
    private int brandId;
    private boolean inStock;
    private boolean isFeatured;
    private String description;
    private String color;
    private int countInStock;
    private double rating;
    private int categoryId;
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
    public int getBrandId() {
        return brandId;
    }
    public void setBrandId(int brandId) {
        this.brandId = brandId;
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
    public int getCategoryId() {
        return categoryId;
    }
    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
    @Override
    public String toString() {
        return "ProductDto [name=" + name + ", price=" + price + ", discountedPrice=" + discountedPrice + ", brandId="
                + brandId + ", inStock=" + inStock + ", isFeatured=" + isFeatured + ", description=" + description
                + ", color=" + color + ", countInStock=" + countInStock + ", rating=" + rating + ", categoryId="
                + categoryId + "]";
    }
    
}
