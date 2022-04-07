package com.akoca.noteservice.dto.add;

import com.akoca.noteservice.dto.IDto;
import com.akoca.noteservice.entity.EntNote;
import com.akoca.noteservice.entity.IEnt;
import com.akoca.noteservice.util.NoteServiceUtils;
import com.google.common.collect.ImmutableSet;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Builder
@RequiredArgsConstructor
@Getter
public class DtoCrtNote implements IDto<EntNote> {
    private final String ownerId;
    private final ImmutableSet<String> partnerIds;
    private final String title;
    private final String bodyText;
    private final ImmutableSet<String> triggerIds;

    @Override
    public EntNote convertToEntity() {
        EntNote newNote = EntNote.getInstance();

        newNote.setUniqueId(NoteServiceUtils.generateUniqueId());
        newNote.setOwnerId(getOwnerId());
        //newNote.addPartnerIds(getPartnerIds());
        newNote.setTitle(getTitle());
        newNote.setBodyText(getBodyText());
        //newNote.addTriggerIds(getTriggerIds());

        return newNote;
    }

    @Override
    public IDto<EntNote> composeFromEntity(IEnt entity) {
        return null;
    }

    @Override
    public String serializeToJson() {
        return null;
    }

    @Override
    public IDto<EntNote> deserializeFromJson(String json) {
        return null;
    }
}
