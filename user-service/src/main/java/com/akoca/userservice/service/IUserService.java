package com.akoca.userservice.service;

import com.akoca.userservice.entity.EntUser;
import com.akoca.userservice.util.OperationResult;

public interface IUserService {
    OperationResult<EntUser> addNewUser(EntUser newUser);

    OperationResult<EntUser> getUserById(Long userId);

    OperationResult<EntUser> deleteById(Long userId);

    OperationResult<EntUser> updateUser(EntUser updUser);
}
