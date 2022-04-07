package com.akoca.userservice.service.impl;

import com.akoca.userservice.entity.EntUser;
import com.akoca.userservice.enums.OperationResultCode;
import com.akoca.userservice.exceptions.unchecked.UserServiceRuntimeException;
import com.akoca.userservice.repository.UserRepository;
import com.akoca.userservice.service.IUserService;
import com.akoca.userservice.util.ErrorNoAndDescriptionConstants;
import com.akoca.userservice.util.OperationResult;
import com.akoca.userservice.util.UserServiceUtils;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final UserRepository userRepository;

    @Override
    public OperationResult<EntUser> addNewUser(EntUser newUser) {

        Optional<EntUser> userAlreadyExists = userRepository.findById(newUser.getId());

        if (userAlreadyExists.isPresent()) {
            OperationResult<EntUser> addUserOpResult = OperationResult.<EntUser>builder()
                    .operationResultCode(OperationResultCode.USER_ALREADY_EXISTS)
                    .build();

            logger.error("User already exists: {}", newUser.getUsername());
            return addUserOpResult;
        }

        EntUser savedUser = userRepository.save(newUser);
        return OperationResult.<EntUser>builder()
                .resultData(savedUser)
                .build();
    }

    @Override
    public OperationResult<EntUser> getUserById(Long userId) {

        Optional<EntUser> userOptional = userRepository.findById(userId);

        return userOptional
                .map(entUser ->
                        OperationResult.<EntUser>builder()
                                .resultData(entUser)
                                .operationResultCode(OperationResultCode.GENERAL_SUCCESS_CODE)
                                .build())
                .orElseGet(() ->
                        OperationResult.<EntUser>builder()
                                .operationResultCode(OperationResultCode.USER_NOT_FOUND)
                                .build()
                );
    }

    @Override
    public OperationResult<EntUser> deleteById(Long userId) {

        Optional<EntUser> userOptional = userRepository.findById(userId);

        return userOptional
            .map(entUser -> {
                Optional<EntUser> userDelOptional = userRepository.deleteUserById(userId);
                return userDelOptional
                        .map(deletedUser -> OperationResult.<EntUser>builder()
                                .resultData(deletedUser)
                                .operationResultCode(OperationResultCode.GENERAL_SUCCESS_CODE)
                                .build())
                        .orElseGet(() ->
                                OperationResult.<EntUser>builder()
                                        .operationResultCode(OperationResultCode.UNKNOWN_ERROR)
                                        .operationException(new UserServiceRuntimeException(ErrorNoAndDescriptionConstants.UNKNOWN_ERROR_DESCRIPTION, OperationResultCode.USER_NOT_FOUND, Instant.now()))
                                        .build()
                        );
                    }
            )
            .orElseGet(() ->
                OperationResult.<EntUser>builder()
                        .operationResultCode(OperationResultCode.USER_NOT_FOUND)
                        .operationException(new UserServiceRuntimeException(ErrorNoAndDescriptionConstants.USER_NOT_FOUND_ERROR_DESCRIPTION, OperationResultCode.USER_NOT_FOUND, Instant.now()))
                        .build()
            );
    }

    @Override
    public OperationResult<EntUser> updateUser(EntUser updUser) {
        Optional<EntUser> userOptional = userRepository.findById(updUser.getId());

        return userOptional
                .map(entUser -> {
                    BeanUtils.copyProperties(updUser, entUser, UserServiceUtils.getNullPropertyNames(updUser));

                    entUser = userRepository.save(entUser);

                    return OperationResult.<EntUser>builder()
                            .resultData(entUser)
                            .operationResultCode(OperationResultCode.GENERAL_SUCCESS_CODE)
                            .build();
                })
                .orElseGet(() ->
                        OperationResult.<EntUser>builder()
                            .operationResultCode(OperationResultCode.USER_NOT_FOUND)
                            .operationException(new UserServiceRuntimeException(ErrorNoAndDescriptionConstants.USER_NOT_FOUND_ERROR_DESCRIPTION, OperationResultCode.USER_NOT_FOUND, Instant.now()))
                            .build()
                );
    }
}
