package com.spring.Tracking.issues.springplayground.cricularDependency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Customer {

/*@Autowired
    public Customer( Account account) {
        this.account = account;
    }*/
    @Autowired
    private  Account account;
    @PostConstruct
    public void init(){
        account.setCustomer(this);
    }
    public double getBalance() {
        return 10.34;
    }
}
