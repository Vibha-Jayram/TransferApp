package org.transfer.service.entity;

import javax.persistence.*;
import javax.validation.constraints.PositiveOrZero;
import java.io.Serializable;
import java.math.BigDecimal;
/**
 * Entity class to represent the Account table
 * @author Vibha
 *
 */

@Entity
@Table(name = "TS_ACCOUNT")
public class Account implements Serializable {



    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="ACCOUNT_ID")
    private int accountId;

    @Column(name="ACCOUNT_NUMBER")
    private String accountNumber = Long.toHexString(Double.doubleToLongBits(Math.random()));

    @Column(name="USER_NAME")
    private String userName;

    @Column(name="BALANCE")
    @PositiveOrZero
    private BigDecimal balance = BigDecimal.valueOf(10000);

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

}
