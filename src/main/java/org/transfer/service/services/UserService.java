package org.transfer.service.services;

import org.transfer.service.entity.User;
import org.transfer.service.services.exception.UserServiceException;


/**
 *
 * Interface to have blue print of all the business methods related to customer operation
 * @author Vibha
 * @version : 1.0.0
 *
 */
public interface UserService extends TSService{

    /**
     * This method is used to create a new user in the database by passing the details of the user
     * @param user : input user details
     * @return the newly created user object and account object
     * @throws UserServiceException wrapper exception for database errors
     */
    public User createUser(User user) throws UserServiceException;

}
