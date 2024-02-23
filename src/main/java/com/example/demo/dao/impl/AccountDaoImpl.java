package com.example.demo.dao.impl;

import com.example.demo.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class AccountDaoImpl implements AccountDao {

    @Autowired
    @Qualifier("myjdbcJdbcTemplate")
    private NamedParameterJdbcTemplate myjdbcJdbcTemplate;

    @Override
    public void decreaseMoney(Integer id, Integer money) {
        String sql = "UPDATE account SET balance = balance - :money WHERE id = :id";

        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("money", money);

        myjdbcJdbcTemplate.update(sql, map);
    }

    @Override
    public void addMoney(Integer id, Integer money) {
        String sql = "UPDATE account SET balance = balance + :money WHERE id = :id";

        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("money", money);

        myjdbcJdbcTemplate.update(sql, map);
    }
}
