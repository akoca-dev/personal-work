package com.akoca.noteservice.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "NOTE")
@Getter
@Setter
@Builder
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor
public class EntNote extends BaseEntUpdatable {

    @Id
    @GeneratedValue(generator = "SEQ_GEN_NOTE")
    @SequenceGenerator(name = "SEQ_GEN_NOTE", sequenceName = "SEQ_NOTE", initialValue = 100)
    private Long id;

    @Builder.Default
    private boolean isDone = false;
    private String uniqueId;
    private String ownerId;

    @ElementCollection
    private final Set<String> partnerIds = new HashSet<>();
    private String title;
    private String bodyText;

    @ElementCollection
    private final Set<String> triggerIds = new HashSet<>();

    @Override
    public String getId() {
        return String.valueOf(id);
    }

    public boolean isDone() {
        return isDone;
    }

    public String getUniqueId() {
        return uniqueId;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public Set<String> getPartnerIds() {
        return partnerIds;
    }

    public String getTitle() {
        return title;
    }

    public String getBodyText() {
        return bodyText;
    }

    public Set<String> getTriggerIds() {
        return triggerIds;
    }

    public boolean addPartnerId(String partnerId) {
        return partnerIds.add(partnerId);
    }

    public boolean addPartnerIds(Set<String> newPartnerIds) {
        return partnerIds.addAll(newPartnerIds);
    }

    public boolean removePartnerId(String partnerId) {
        return partnerIds.remove(partnerId);
    }

    public boolean addTriggerId(String triggerId) {
        return triggerIds.add(triggerId);
    }

    public boolean addTriggerIds(Set<String> newTriggerIds) {
        return triggerIds.addAll(newTriggerIds);
    }

    public boolean removeTriggerId(String triggerId) {
        return triggerIds.remove(triggerId);
    }

    public static EntNote getInstance() {
        return EntNote
                .builder()
                .build();
    }
}