package com.akoca.userservice.dto.update;

import com.akoca.userservice.dto.IDto;
import com.akoca.userservice.entity.EntUser;
import com.akoca.userservice.entity.IEnt;
import com.akoca.userservice.enums.OperationResultCode;
import com.akoca.userservice.exceptions.unchecked.UserServiceRuntimeException;
import com.akoca.userservice.util.ErrorNoAndDescriptionConstants;
import com.akoca.userservice.util.JsonUtils;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.Instant;

import static com.akoca.userservice.util.ErrorNoAndDescriptionConstants.UNKNOWN_ERROR_DESCRIPTION;
import static com.akoca.userservice.util.ErrorNoAndDescriptionConstants.UNKNOWN_ERROR_NO;

@Builder
@RequiredArgsConstructor
@Getter
@Setter
public class DtoUpdUser implements IDto {

    private String username;
    private String password;

    @Override
    public String serializeToJson() {
        return JsonUtils.objectToJson(this)
                .orElse(UNKNOWN_ERROR_DESCRIPTION + ": " + UNKNOWN_ERROR_NO);
    }
}