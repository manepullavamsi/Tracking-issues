package com.spring.Tracking.issues.springplayground.cricularDependency;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class Account {
    
    private  Customer customer;
//    @Autowired
//    public Account( Customer customer) {
//        this.customer = customer;
//    }

    public void setCustomer(Customer c)
    {
        this.customer=c;
    }

    public String withdrawAmount(double amount)
    {
        if(this.customer.getBalance()>=amount)
        {
            return "Withdrawal Amount SuccessFully Done : "+amount;
        }
        return "Insufficient Funds Current Account Balance : "+this.customer.getBalance();
    }
}
