package com.mudit.zeepham.entity;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.hibernate.validator.constraints.Length;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;





@Entity
@Table(name = "users")
public class User {
    @Id
    private String username;

    @Length(min = 5,max = 40,message = "name validation failed")
    private String name;

    @Length(min = 8,message = "password validation failed")
    private String password;

    private boolean enabled;

    @Length(min = 10,max = 10,message = "Phone Number validation failed")
    private String mobileNumber;

    @OneToOne(cascade = CascadeType.ALL)
    private Authority authority;

    @ManyToMany
    private List<Product> favProducts;

    @OneToMany
    private List<Order> orders;

    @OneToMany
    private List<CartItem> cartItems;

    public List<Product> getFavProducts() {
        return favProducts;
    }

    public void setFavProducts(List<Product> favProducts) {
        this.favProducts = favProducts;
    }

    // public List<Order> getOrders() {
    //     return orders;
    // }

    // public void setOrders(List<Order> orders) {
    //     this.orders = orders;
    // }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public Authority getAuthority() {
        return authority;
    }

    public void setAuthority(Authority authority) {
        this.authority = authority;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
   
    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", enabled=" + enabled +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", authority=" + authority +
                '}';
    }

}