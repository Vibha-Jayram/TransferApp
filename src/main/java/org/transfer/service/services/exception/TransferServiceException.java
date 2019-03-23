package org.transfer.service.services.exception;

/**
 * This class represents the exception class which needs to be thrown from  TransactionService implementation
 *
 * @author Vibha
 *
 */
public class TransferServiceException extends Exception{


    /**
     * default constructor
     */
    public TransferServiceException() {
        super();
    }

    /**
     * parametrized constructor with string error as input
     * @param messages the error message
     */
    public TransferServiceException(final String messages) {
        super(messages);
    }


    /**
     * parametrized constructor with ErrorDetails as input
     * @param errors the details of error messageerror message
     */
    public TransferServiceException(final ErrorDetails errors) {
        super(errors);
    }

}
