package org.transfer.service.services;


import org.transfer.service.entity.Transfer;
import org.transfer.service.services.exception.ResourceNotFoundException;
import org.transfer.service.services.exception.TransferServiceException;

/**
 *
 * Interface to have blue print of all the business methods related to transfer operation
 * @author Vibha
 * @version : 1.0.0
 *
 */
public interface TransferService {

    /**
     * This method is used to do transfer between two accounts
     * @param transfer details of the transaction
     * @throws TransferServiceException dao layer exception wrapper
     * @throws ResourceNotFoundException resource not found exception
     */
    public void createTransfer(Transfer transfer) throws TransferServiceException,ResourceNotFoundException;


}
