package com.itheima.dao;

import com.itheima.domain.Product;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ProductDao {

    List<Product>findAll();

    public Product findById(String id);

    void save(Product product);
}
