package org.transfer.service.dao;


import org.hibernate.HibernateException;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.transfer.service.entity.Account;

/**
 *
 * This class provide default implementation of the basic CURD operations provided by CrudRepository.
 * Also it contains all the blue print of business methods for Account entity
 *
 * @author Vibha
 *
 */

@Repository
public interface AccountDao extends CrudRepository<Account, Long> {

    /**
     * This dao method is used find an account by account number
     * @param accountNumber input account number which needs to be searched
     * @return the account object if exist else will return null
     * @throws HibernateException data access layer exception
     */
    public Account findByAccountNumber(String accountNumber) throws HibernateException;

}
