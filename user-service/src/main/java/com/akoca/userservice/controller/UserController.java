package com.akoca.userservice.controller;

import com.akoca.userservice.dto.add.DtoAddUser;
import com.akoca.userservice.dto.delete.DtoDelUser;
import com.akoca.userservice.dto.read.DtoReadUser;
import com.akoca.userservice.dto.update.DtoUpdUser;
import com.akoca.userservice.entity.EntUser;
import com.akoca.userservice.service.IUserService;
import com.akoca.userservice.util.ExecutionTimer;
import com.akoca.userservice.util.OperationResult;
import com.akoca.userservice.util.mapper.UserDtoEntityMapper;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor(access = AccessLevel.PUBLIC)
public class UserController {

    private final IUserService userService;
    private final UserDtoEntityMapper userDtoEntityMapper;

    public OperationResult<EntUser> addUser(DtoAddUser dtoAddUser) {
        ExecutionTimer executionTimer = ExecutionTimer.getStartedInstance();
        EntUser newUser = userDtoEntityMapper.dtoAddUserToEntity(dtoAddUser);

        OperationResult<EntUser> addUserOpResult = userService.addNewUser(newUser);

        addUserOpResult.setExecutionTimer(executionTimer.stopTimer());
        return addUserOpResult;
    }

    public OperationResult<EntUser> deleteUser(DtoDelUser dtoDelUser) {
        ExecutionTimer executionTimer = ExecutionTimer.getStartedInstance();

        OperationResult<EntUser> deleteUserOpResult = userService.deleteById(dtoDelUser.getId());

        deleteUserOpResult.setExecutionTimer(executionTimer.stopTimer());

        return deleteUserOpResult;
    }

    public OperationResult<EntUser> updateUser(DtoUpdUser dtoUpdUser) {
        ExecutionTimer executionTimer = ExecutionTimer.getStartedInstance();
        EntUser updUser = userDtoEntityMapper.dtoUpdUserToEntity(dtoUpdUser);

        OperationResult<EntUser> updateUserOpResult = userService.updateUser(updUser);

        updateUserOpResult.setExecutionTimer(executionTimer.stopTimer());

        return updateUserOpResult;
    }

    public OperationResult<EntUser> readUser(DtoReadUser dtoReadUser) {
        ExecutionTimer executionTimer = ExecutionTimer.getStartedInstance();

        OperationResult<EntUser> getUserOpResult = userService.getUserById(dtoReadUser.getId());

        getUserOpResult.setExecutionTimer(executionTimer.stopTimer());
        return getUserOpResult;
    }
}
