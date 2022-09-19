package com.experiment.experience.springbootfeatures.controller;

import com.experiment.experience.springbootfeatures.api.UserApi;
import com.experiment.experience.springbootfeatures.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class UserController implements UserApi {

    @Override
    @GetMapping("/getUserById")
    public ResponseEntity<User> getUserById() {
        return null;
    }
}
