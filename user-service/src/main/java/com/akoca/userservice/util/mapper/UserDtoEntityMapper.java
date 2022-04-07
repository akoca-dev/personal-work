package com.akoca.userservice.util.mapper;

import com.akoca.userservice.dto.add.DtoAddUser;
import com.akoca.userservice.dto.delete.DtoDelUser;
import com.akoca.userservice.dto.read.DtoReadUser;
import com.akoca.userservice.dto.update.DtoUpdUser;
import com.akoca.userservice.entity.EntUser;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserDtoEntityMapper {
    EntUser dtoAddUserToEntity (DtoAddUser dtoAddUser);

    EntUser dtoUpdUserToEntity (DtoUpdUser dtoUpdUser);

    DtoAddUser dtoAddUserFromEntity(EntUser entUser);

    DtoDelUser dtoDelUserFromEntity(EntUser entUser);

    DtoUpdUser dtoUpdUserFromEntity(EntUser entUser);

    DtoReadUser dtoReadUserFromEntity(EntUser entUser);
}
