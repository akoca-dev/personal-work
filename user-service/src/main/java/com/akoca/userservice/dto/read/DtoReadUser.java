package com.akoca.userservice.dto.read;

import com.akoca.userservice.dto.IDto;
import com.akoca.userservice.entity.EntUser;
import com.akoca.userservice.entity.IEnt;
import com.akoca.userservice.util.JsonUtils;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static com.akoca.userservice.util.ErrorNoAndDescriptionConstants.UNKNOWN_ERROR_DESCRIPTION;
import static com.akoca.userservice.util.ErrorNoAndDescriptionConstants.UNKNOWN_ERROR_NO;

@Getter
@Setter
@AllArgsConstructor
public class DtoReadUser implements IDto {

    private final Long id;

    @Override
    public String serializeToJson() {
        return JsonUtils.objectToJson(this)
                .orElse(UNKNOWN_ERROR_DESCRIPTION + ": " + UNKNOWN_ERROR_NO);
    }
}
