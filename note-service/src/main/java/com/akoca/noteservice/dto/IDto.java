package com.akoca.noteservice.dto;

import com.akoca.noteservice.entity.IEnt;

public interface IDto<T extends IEnt> {
    T convertToEntity();

    IDto<T> composeFromEntity(IEnt entity);

    String serializeToJson();

    IDto<T> deserializeFromJson(String json);
}
