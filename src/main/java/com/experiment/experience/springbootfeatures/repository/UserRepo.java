package com.experiment.experience.springbootfeatures.repository;

import com.experiment.experience.springbootfeatures.domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo {
    @Query(
            value =
                    "SELECT \"userName\", created_time, updated_time, name, \"mobileNumber\", total_balance, id\n"
                            + "\tFROM \"Dev\".\"User_Info\";",
            nativeQuery = true)
    User findByUserNameIgnoreCase(@Param("userName") @NonNull String userName);
}
