package com.akoca.userservice.controller.impl;

import com.akoca.userservice.controller.UserController;
import com.akoca.userservice.dto.add.DtoAddUser;
import com.akoca.userservice.dto.delete.DtoDelUser;
import com.akoca.userservice.dto.read.DtoReadUser;
import com.akoca.userservice.dto.update.DtoUpdUser;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "users")
public class UserControllerRest {

    private final UserController userController;

    @PostMapping
    public ResponseEntity<String> addUser(@RequestBody DtoAddUser dtoAddUser) {
        return userController
                .addUser(dtoAddUser)
                .generateResponseEntity();
    }

    @DeleteMapping
    public ResponseEntity<String> deleteUser(DtoDelUser dtoDelUser) {
        return userController
                .deleteUser(dtoDelUser)
                .generateResponseEntity();
    }

    @PutMapping
    public ResponseEntity<String> updateUser(DtoUpdUser dtoUpdUser) {
        return userController
                .updateUser(dtoUpdUser)
                .generateResponseEntity();
    }

    @GetMapping
    public ResponseEntity<String> readUser(DtoReadUser dtoReadUser) {
        return userController
                .readUser(dtoReadUser)
                .generateResponseEntity();
    }
}