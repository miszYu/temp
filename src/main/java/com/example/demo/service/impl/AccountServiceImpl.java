package com.example.demo.service.impl;

import com.example.demo.dao.AccountDao;
import com.example.demo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;


    @Override
    public void transfer(Integer fromAccountId, Integer toAccountId, Integer money) {

        // User A 扣除轉帳金額
        accountDao.decreaseMoney(fromAccountId, money);

        // User B 收到轉入金額
        accountDao.addMoney(toAccountId, money);
    }
}
