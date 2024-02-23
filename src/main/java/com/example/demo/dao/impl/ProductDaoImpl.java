package com.example.demo.dao.impl;

import com.example.demo.dao.ProductDao;
import com.example.demo.model.dto.Product;
import com.example.demo.model.mapper.ProductDescRowMapper;
import com.example.demo.model.mapper.ProductRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class ProductDaoImpl implements ProductDao {

    @Autowired
    @Qualifier("test1")
    private NamedParameterJdbcTemplate test1;

    @Autowired
    @Qualifier("test2")
    private NamedParameterJdbcTemplate test2;

    @Override
    public Product findByNo(Integer no){
        Product product = new Product();

        String sql1 = "SELECT no, name FROM PRODUCT WHERE NO = :no";
        String sql2 = "SELECT no, desctxt FROM PRODUCT_desc WHERE NO = :no";

        Map<String, Object> map = new HashMap<>();
        map.put("no", no);

        Product product1 = test1.queryForObject(sql1, map, new ProductRowMapper());
        Product product2 = test2.queryForObject(sql2, map, new ProductDescRowMapper());

        product.setNo(no);

        if(product1 != null){
            product.setName(product1.getName());
        }
        if(product2 != null){
            product.setDesctxt(product2.getDesctxt());
        }

        return product;
    }
}
