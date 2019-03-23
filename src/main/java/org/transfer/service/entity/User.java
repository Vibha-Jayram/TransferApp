package org.transfer.service.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * Entity class to represent the User table
 * @author Vibha
 *
 */

@Entity
@Table(name = "TS_USER")
public class User implements Serializable {

    @Id
    @Column(name="USER_ID",nullable=false)
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int Id;

    @Column(name="USER_NAME",nullable=false)
    @NotNull
    @Size(min=1, message="User Name should have atleast 1 characters")
    private String userName;

    @Column(name="PASSWORD",nullable=false)
    @NotNull
    @Size(min=6, message="Password should have atleast 6 characters")
    private String password;

    @OneToMany(fetch=FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name= "USER_NAME",referencedColumnName = "USER_NAME")
    private List<Account> account = new ArrayList<Account>();


    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<Account> getAccount() {
        return account;
    }

    public void setAccount(List<Account> account) {
        this.account = account;
    }
}
