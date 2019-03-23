package org.transfer.service.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.transfer.service.entity.Transfer;

/**
 *
 * This class provide default implementation of the basic CURD operations provided by CrudRepository.
 * Also it contains all the blue print of business methods for Transfer entity
 *
 * @author Vibha
 *
 */

@Repository
public interface TransferDao extends CrudRepository<Transfer, Long> {


}