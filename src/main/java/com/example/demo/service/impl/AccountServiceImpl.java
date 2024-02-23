package com.example.demo.service.impl;

import com.example.demo.dao.AccountDao;
import com.example.demo.service.AccountService;
import com.example.demo.service.AccountService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Autowired
    private AccountService2 accountService2;

    @Override
    public void transfer(Integer fromAccountId, Integer toAccountId, Integer money) {

        // User A 扣除轉帳金額
        accountDao.decreaseMoney(fromAccountId, money);

        //@Transactional看進入點，accountService2沒有@Transactional。
        //可是進入點有@Transactional一樣會roll back
        accountService2.decreaseMoney(3,1);
        int i = 1/0;

        // User B 收到轉入金額
        accountDao.addMoney(toAccountId, money);
    }
}
