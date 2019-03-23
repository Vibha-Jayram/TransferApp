package org.transfer.service.services.validator;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.transfer.service.dao.AccountDao;
import org.transfer.service.dao.UserDao;
import org.transfer.service.entity.Account;
import org.transfer.service.entity.User;

import java.math.BigDecimal;

/**
 * Validator class which is used to validate the input parameters of transfer
 * @author Vibha
 * @version : 1.0.0
 */

@Component
public class TransferValidator {

    @Autowired
    private UserDao userDao;

    @Autowired
    private AccountDao accountDao;


    /**
     * This method is used to validate the user and return user to the calling  method
     * @param userName input user which needs to be found
     * @return user if exist or else will return NULL
     */
    public User validateUser(String userName) {
        User user = null;
        try {
            user = userDao.findByUserName(userName);
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return user;
    }

    /**
     * This method is used to validate the account and return account to the calling  method
     * @param accountNumber input account which needs to be found
     * @return account if exist or else will return NULL
     */
    public Account validateAccount(String accountNumber) {
        Account account = null;
        try {
            account = accountDao.findByAccountNumber(accountNumber);
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return account;
    }

    /**
     * This method is used to validate the transfer amount
     * @param balance account balance of user
     * @param amount transfer amount of transaction
     * @return true if amount is less than or equal to  balance else will return false
     */
    public boolean validateTransferAmount(BigDecimal balance, BigDecimal amount) {
        boolean isValidTransferAmount = false;
        if(balance.compareTo(amount) > 0) {
            isValidTransferAmount = true;
        }
        return isValidTransferAmount;
    }

}
