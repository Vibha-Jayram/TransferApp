/**
 *
 */
package org.transfer.service.dao;

import org.hibernate.HibernateException;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.transfer.service.entity.User;

/**
 *
 * This class provide default implementation of the basic CURD operations provided by CrudRepository.
 * Also it contains all the blue print of business methods for Account entity
 *
 * @author Vibha
 *
 */

@Repository
public interface UserDao extends CrudRepository<User, Long> {

    /**
     * This dao method is used find an user by user name
     * @param userName input account number which needs to be searched
     * @return the user object if exist else will return null
     * @throws HibernateException data access layer exception
     */
    public User findByUserName(String userName) throws HibernateException;

}
