package com.mudit.zeepham.repository;

import java.util.List;
import java.util.Locale.Category;

import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mudit.zeepham.Exceptions.ObjectNotFound;
import com.mudit.zeepham.dto.ProductDto;
import com.mudit.zeepham.entity.Brand;
import com.mudit.zeepham.entity.Product;
import com.mudit.zeepham.entity.ProductCategory;

@Repository
public class AdminRepo {

    @Autowired
    private SessionFactory sessionFactory;

    public boolean addBrand(Brand brand) {
        Transaction tx = null;
        try (Session session = sessionFactory.openSession()) {
            tx = session.beginTransaction();
            session.save(brand);
            tx.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            assert tx != null;
            tx.rollback();
            return false;
        }
        return true;
    }

    public boolean editBrand(Brand brand, int id) {
        Transaction tx = null;
        try (Session session = sessionFactory.openSession()) {
            Brand oldBrand = session.get(Brand.class, id);
            if (oldBrand == null) {
                throw new ObjectNotFound();
            } else {
                oldBrand.setName(brand.getName());
                tx = session.beginTransaction();
                session.saveOrUpdate(oldBrand);
                tx.commit();
            }
        }  catch (ObjectNotFound e) {
            throw e;
        }catch (Exception e) {
            System.out.println(e.getMessage());
            if(tx!=null)
                tx.rollback();
            return false;
        }
        return true;
    }

    public Brand findBrandById(int id) {
        try (Session session = sessionFactory.openSession()) {
            Brand brand = session.get(Brand.class, id);
            return brand;

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public boolean addProduct(Product product) {
        Transaction tx = null;
        try (Session session = sessionFactory.openSession()) {
            tx = session.beginTransaction();
            ProductCategory category = session.get(ProductCategory.class, product.getCategory().getId());
            List<Product> products = category.getProducts();
            products.add(product);
            category.setProducts(products);
            session.saveOrUpdate(category);
            session.save(product);
            tx.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            assert tx != null;
            tx.rollback();
            return false;
        }
        return true;
    }

    public boolean editProduct(ProductDto productDto, int productId) {
        Transaction tx = null;
        try (Session session = sessionFactory.openSession()) {
            ProductCategory category = this.findCategoryById(productDto.getCategoryId());
            Brand brand = this.findBrandById(productDto.getBrandId());
            Product product = session.get(Product.class, productId);
            tx = session.beginTransaction();
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
            session.saveOrUpdate(product);
            tx.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            assert tx != null;
            tx.rollback();
            return false;
        }
        return true;
    }

    public boolean addCategory(ProductCategory category) {
        Transaction tx = null;
        try (Session session = sessionFactory.openSession()) {
            tx = session.beginTransaction();
            session.save(category);
            tx.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            assert tx != null;
            tx.rollback();
            return false;
        }
        return true;
    }

    public boolean editCategory(ProductCategory category, int id) {
        Transaction tx = null;
        try (Session session = sessionFactory.openSession()) {
            ProductCategory productCategory = session.get(ProductCategory.class, id);
            productCategory.setName(category.getName());
            tx = session.beginTransaction();
            session.saveOrUpdate(productCategory);
            tx.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            assert tx != null;
            tx.rollback();
            return false;
        }
        return true;
    }

    public ProductCategory findCategoryById(int id) {
        try (Session session = sessionFactory.openSession()) {
            ProductCategory category = session.get(ProductCategory.class, id);
            return category;

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

}
