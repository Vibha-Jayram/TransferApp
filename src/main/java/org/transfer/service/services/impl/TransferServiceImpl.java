package org.transfer.service.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.transfer.service.dao.AccountDao;
import org.transfer.service.dao.TransferDao;
import org.transfer.service.dao.UserDao;
import org.transfer.service.entity.Account;
import org.transfer.service.entity.Transfer;
import org.transfer.service.entity.User;
import org.transfer.service.services.TransferService;
import org.transfer.service.services.exception.ErrorDetails;
import org.transfer.service.services.exception.ResourceNotFoundException;
import org.transfer.service.services.exception.TransferServiceException;
import org.transfer.service.services.validator.TransferValidator;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Implementation class of TransferService which provides all the business layer implementation
 *
 * @author Vibha
 * @see org.transfer.service.services.TransferService
 *
 */


@Service
public class TransferServiceImpl implements TransferService{

    @Autowired
    private TransferValidator transferValidator;

    @Autowired
    private TransferDao transferDao;

    @Autowired
    private AccountDao accountDao;

    @Autowired
    private UserDao userDao;

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = TransferServiceException.class)
    public void createTransfer(Transfer transfer) throws TransferServiceException, ResourceNotFoundException{
        User user = transferValidator.validateUser(transfer.getUserName());
        Account senderAccount = transferValidator.validateAccount(transfer.getSourceAccount());
        Account receiverAccount = transferValidator.validateAccount(transfer.getDestinationAccount());

        if(user == null) {
            ErrorDetails errorDetails = new ErrorDetails(new Date(), "Validation Failed","User does not exist");
            throw new ResourceNotFoundException(errorDetails.getDetails());
        }

        if(senderAccount == null) {
            ErrorDetails errorDetails = new ErrorDetails(new Date(), "Validation Failed","Sender Account does not exist");
            throw new ResourceNotFoundException(errorDetails.getDetails());
        }

        if(receiverAccount == null) {
            ErrorDetails errorDetails = new ErrorDetails(new Date(), "Validation Failed","Receiver Account does not exist");
            throw new ResourceNotFoundException(errorDetails.getDetails());
        }

        //validate the transfer amount
        boolean isValidTransferAmount = transferValidator.validateTransferAmount(senderAccount.getBalance(),transfer.getTransferAmount());
        if(isValidTransferAmount) {
            //determine the new balance for sender
            BigDecimal newSenderBalance = senderAccount.getBalance().subtract(transfer.getTransferAmount());
            senderAccount.setBalance(newSenderBalance);

            //determine the new balance for receiver
            BigDecimal newReceiverBalance = receiverAccount.getBalance().add(transfer.getTransferAmount());
            receiverAccount.setBalance(newReceiverBalance);

            //update sender and receiver
            createTransaction(transfer,senderAccount,receiverAccount);

            //update account to reflect new account balances
            accountDao.save(senderAccount);
            accountDao.save(receiverAccount);

        }else {
            //throw validation that overdrawing of account is not allowed
            ErrorDetails errorDetails = new ErrorDetails(new Date(), "Validation Failed","Account balance is insufficient to complete the transaction");
            throw new TransferServiceException(errorDetails);
        }
    }

    public void createTransaction(Transfer transfer, Account sender, Account Receiver) {
        Transfer transactionObj = new Transfer();

        transactionObj.setUserName(transfer.getUserName());
        System.out.println(transfer.getUserName());
        transactionObj.setSourceAccount(transfer.getSourceAccount());
        transactionObj.setDestinationAccount(transfer.getDestinationAccount());
        transactionObj.setTransferAmount(transfer.getTransferAmount());
        transactionObj.setTransferDescription(transfer.getTransferDescription());
        transactionObj.setSenderAccount(sender);
        transactionObj.setReceiverAccount(Receiver);

        transferDao.save(transactionObj);
    }

}


