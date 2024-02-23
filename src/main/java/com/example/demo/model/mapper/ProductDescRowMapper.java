package com.example.demo.model.mapper;

import com.example.demo.model.dto.Product;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductDescRowMapper implements RowMapper<Product> {
    @Override
    public Product mapRow(ResultSet resultSet, int i) throws SQLException {
        //從資料庫中取得數據
        Integer no = resultSet.getInt("no");
        String desctxt = resultSet.getString("desctxt");

        return new Product(no, null, desctxt);
    }
}
