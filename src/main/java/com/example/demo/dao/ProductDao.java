package com.example.demo.dao;

import com.example.demo.model.dto.Product;

public interface ProductDao {

    Product findByNo(Integer no);
}
