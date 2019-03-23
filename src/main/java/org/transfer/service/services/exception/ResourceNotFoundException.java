package org.transfer.service.services.exception;


/**
 * This class represents the resource not found exception
 *
 * @author Vibha
 *
 */
public class ResourceNotFoundException extends Exception {


    /**
     * default constructor
     */
    public ResourceNotFoundException() {
        super();
    }

    /**
     * parametrized constructor with string error as input
     * @param messages the error message
     */
    public ResourceNotFoundException(final String messages) {
        super(messages);
    }


    /**
     * parametrized constructor with ErrorDetails as input
     * @param errors the details of error messageerror message
     */
    public ResourceNotFoundException(final ErrorDetails errors) {
        super(errors);
    }
}
