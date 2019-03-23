package org.transfer.service.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;


/**
 * Entity class to represent the Transfer table
 * @author Vibha
 *
 */


@Entity
@Table(name = "TS_TRANSFER")

public class Transfer implements Serializable {


    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="ID")
    private Long id;

    @Column(name="USER_NAME")
    private String userName;

    @Column(name="SOURCE_ACCOUNT",insertable = false, updatable = false)
    private String sourceAccount;

    @Column(name="DESTINATION_ACCOUNT",insertable = false, updatable = false)
    private String destinationAccount;

    @Column(name="TRANSFER_AMOUNT")
    private BigDecimal transferAmount;

    @Column(name="TRANSFER_DESCRIPTION")
    @NotNull (message=" Transfer from one account to the other")
    private String transferDescription;

 //   @ManyToOne (fetch=FetchType.EAGER,cascade = CascadeType.ALL)
 //   @JoinColumn(name= "USER_NAME",referencedColumnName = "USER_NAME")
 //   private User user;

    @ManyToOne (fetch=FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name= "SOURCE_ACCOUNT",referencedColumnName = "ACCOUNT_NUMBER")
    private Account senderAccount;

    @ManyToOne (fetch=FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name= "DESTINATION_ACCOUNT",referencedColumnName = "ACCOUNT_NUMBER")
    private Account receiverAccount;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSourceAccount() {
        return sourceAccount;
    }

    public void setSourceAccount(String sourceAccount) {
        this.sourceAccount = sourceAccount;
    }

    public String getDestinationAccount() {
        return destinationAccount;
    }

    public void setDestinationAccount(String destinationAccount) {
        this.destinationAccount = destinationAccount;
    }

    public BigDecimal getTransferAmount() {
        return transferAmount;
    }

    public void setTransferAmount(BigDecimal transferAmount) {
        this.transferAmount = transferAmount;
    }

    public String getTransferDescription() {
        return transferDescription;
    }

    public void setTransferDescription(String transferDescription) {
        this.transferDescription = transferDescription;
    }

 //   public User getUser() {
 //       return user;
 //   }

 //   public void setUser(User user) {
//        this.user = user;
//    }

    public Account getSenderAccount() {
        return senderAccount;
    }

    public void setSenderAccount(Account senderAccount) {
        this.senderAccount = senderAccount;
    }

    public Account getReceiverAccount() {
        return receiverAccount;
    }

    public void setReceiverAccount(Account receiverAccount) {
        this.receiverAccount = receiverAccount;
    }
}
