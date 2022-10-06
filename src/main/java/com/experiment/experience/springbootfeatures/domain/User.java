package com.experiment.experience.springbootfeatures.domain;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Table(name = "User_Info")
public class User implements Serializable {

    private final long serialVersionUID = 19L;

    @Id
    //    @SequenceGenerator(name="id_gen",sequenceName = "gen",allocationSize = 50)
    //    @GeneratedValue(generator = "id_gen")
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "userName")
    private String userName;

    @Column(name = "total_balance")
    private Double totalBalance;

    @Min(value = 10)
    @Max(value = 10)
    @NotNull
    @Column(name = "mobileNumber")
    private String mobileNumber;

    @Column(name = "created_time")
    private LocalDate createdTime;

    @Column(name = "updated_time")
    private LocalDate updatedTime;
}
