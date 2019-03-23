package org.transfer.service.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.transfer.service.dao.TransferDao;
import org.transfer.service.entity.Transfer;
import org.transfer.service.services.TransferService;
import org.transfer.service.services.exception.ResourceNotFoundException;
import org.transfer.service.services.exception.TransferServiceException;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * Rest controller for handling all the operations related to Transaction between two accounts
 * @author Vibha
 *
  * @version : 1.0.0
 *
 *	REST URLS:
 *
 *  1. POST : /transactions -> to crate a customer IDtransfer between two customers
 */

@RestController
public class TransferController {

    @Autowired
    private TransferService transactionService;

    @Autowired
    private TransferDao transferdao;

    /**
     * This Rest controller is used to do transaction between two accounts
     * @param transaction details of the transaction
     * @throws ResourceNotFoundException account not found exception
     */
    @RequestMapping(value = "transactions",
            method = RequestMethod.POST,
            headers = "Accept=application/json",
            produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseStatus(HttpStatus.OK)
    public void createTransaction(@Valid @RequestBody Transfer transaction) throws ResourceNotFoundException{
        try {
            transactionService.createTransfer(transaction);
        } catch (TransferServiceException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "displaytransfer",
            method = RequestMethod.GET,
            headers = "Accept=application/json",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseStatus(HttpStatus.OK)
    public Iterable<Transfer> createUser() {
        List<Transfer> accounts = new ArrayList<>();
        return transferdao.findAll();
    }
}



