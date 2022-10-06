package com.experiment.experience.springbootfeatures.controller;

import com.experiment.experience.springbootfeatures.api.UserApi;
import com.experiment.experience.springbootfeatures.domain.User;
import com.experiment.experience.springbootfeatures.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class UserController implements UserApi {

    private final UserService userService;

    @Override
    @GetMapping("/getByUserId")
    public ResponseEntity<User> getByUserId(Long id) {
        //            return ResponseEntity.ok(User.builder().userName("Venkat").build());
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @Override
    @GetMapping("/getByUserName")
    public ResponseEntity<User> getByUserName(String userName) {

        return ResponseEntity.ok(userService.getUserByName(userName));
    }
}
