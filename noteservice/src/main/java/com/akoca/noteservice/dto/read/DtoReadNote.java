package com.akoca.noteservice.dto.read;

import com.akoca.noteservice.dto.IDto;
import com.akoca.noteservice.entity.EntNote;
import com.akoca.noteservice.entity.IEnt;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DtoReadNote implements IDto<EntNote> {

    private final Long id;

    @Override
    public EntNote convertToEntity() {
        return null;
    }

    @Override
    public String serializeToJson() {
        return null;
    }

    @Override
    public IDto<EntNote> deserializeFromJson(String json) {
        return this;
    }

    @Override
    public IDto<EntNote> composeFromEntity(EntNote entity) {
        return this;
    }
}
