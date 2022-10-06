package com.experiment.experience.springbootfeatures.service;

import com.experiment.experience.springbootfeatures.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    public User getUserById(Long id) {
        //        System.out.println("user Count:"+userRepo.count());
        //         Optional<User> u=userRepo.findById(id);

        //   return u.get();
        return User.builder().userName("VenkatId").build();
    }

    public User getUserByName(String userName) {
        return User.builder().userName("VenkatName").build();
        //        System.out.println("user Count:"+userRepo.count());
        //    return userRepo.findByUserNameIgnoreCase(userName);
    }
}
