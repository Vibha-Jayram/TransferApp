package org.transfer.service.services.impl;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.transfer.service.dao.AccountDao;
import org.transfer.service.dao.UserDao;
import org.transfer.service.entity.Account;
import org.transfer.service.entity.User;
import org.transfer.service.services.UserService;
import org.transfer.service.services.exception.ErrorDetails;
import org.transfer.service.services.exception.UserServiceException;

import java.util.Arrays;
import java.util.Date;
import java.util.Optional;

/**
 * Implementation class of CustomerService which provides all the business layer implementation
 *
 * @author Vibha
 * @see org.transfer.service.services.UserService
 *
 */

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    @Autowired
    private AccountDao accountDao;

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = UserServiceException.class)
    public User createUser(User user) throws UserServiceException{
        try {
            Optional<User> getusers = Optional.ofNullable(userDao.findByUserName(user.getUserName()));
            if(getusers.isPresent()) {
                Account account = new Account();
                account.setUserName(user.getUserName());
                account.setAccountNumber(account.getAccountNumber());
                account.setBalance(account.getBalance());
                accountDao.save(account);
            }else {
                Account account = new Account();
                user.setAccount(Arrays.asList(account));
                userDao.save(user);
            }
            return user;
        }catch(HibernateException e) {
            ErrorDetails errorDetails = new ErrorDetails(new Date(), "Error while saving customer details","Error while saving customer details");
            throw new UserServiceException(errorDetails);
        }
    }

}
