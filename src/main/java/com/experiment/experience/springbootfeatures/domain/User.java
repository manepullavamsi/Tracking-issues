package com.experiment.experience.springbootfeatures.domain;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class User {
    @NotNull
    String name;
    @NotNull
    String emailId;
    Double totalBalance;
    @Max(value = 10)
    String mobileNumber;
}
