package com.example.demo.service.impl;

import com.example.demo.model.dto.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.service.ProductService;
import com.example.demo.dao.ProductDao;

@Service
@Transactional
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductDao productDao;

    @Override
    public Product findByNo(Integer no){
        return productDao.findByNo(no);
    }
}
