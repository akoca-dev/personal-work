package com.akoca.containerservice.controller;

import com.akoca.containerservice.dto.ContainerDto;
import com.akoca.containerservice.model.Container;
import com.akoca.containerservice.service.ContainerService;
import com.akoca.containerservice.utilities.ModelMappingUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;

@Slf4j
@RequiredArgsConstructor
@RequestMapping(value = "/containers")
@Validated
@RestController
public class ContainerController {

    private final ContainerService containerService;

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ContainerDto> getOneContainerById(@PathVariable(value = "id") Long id) {

        return containerService.findById(id)
                .map(container -> ModelMappingUtils.mapRegular(ContainerDto.class, container))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.ok().build());
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ContainerDto> addNewContainer(@Valid @RequestBody ContainerDto newContainerDto) {
        Container newContainerToBeSaved = ModelMappingUtils.mapRegular(Container.class, newContainerDto);

        Container savedContainer = containerService.save(newContainerToBeSaved);

        ContainerDto savedContainerDto = ModelMappingUtils.mapRegular(ContainerDto.class, savedContainer);

        return ResponseEntity.ok(savedContainerDto);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ContainerDto> updateContainer(@Valid @RequestBody ContainerDto containerDtoToUpdate) {
        Container newContainerToBeUpdated = ModelMappingUtils.mapRegular(Container.class, containerDtoToUpdate);

        Container updatedContainer = containerService.update(newContainerToBeUpdated);

        ContainerDto updatedContainerDto = ModelMappingUtils.mapRegular(ContainerDto.class, updatedContainer);

        return ResponseEntity.ok(updatedContainerDto);
    }

    @DeleteMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ContainerDto> deleteContainer(@Positive @PathVariable(value = "id") Long containerId) {
        Container containerToBeDeleted = containerService.findById(containerId).orElseThrow();

        containerService.delete(containerId);

        ContainerDto deletedContainerDto = ModelMappingUtils.mapRegular(ContainerDto.class, containerToBeDeleted);

        return ResponseEntity.ok(deletedContainerDto);
    }
}