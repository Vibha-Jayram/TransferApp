package org.transfer.service.services.exception;


/**
 * This class represents the exception class which needs to be thrown from UserService implementation
 *
 * @author Vibha
 *
 */
public class UserServiceException extends Exception{


    /**
     * default constructor
     */
    public UserServiceException() {
        super();
    }

    /**
     * parametrized constructor with string error as input
     * @param messages the error message
     */
    public UserServiceException(final String messages) {
        super(messages);
    }


    /**
     * parametrized constructor with ErrorDetails as input
     * @param errors the details of error messageerror message
     */
    public UserServiceException(final ErrorDetails errors) {
        super(errors);
    }

}
