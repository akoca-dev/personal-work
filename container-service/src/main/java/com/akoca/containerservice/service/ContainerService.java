package com.akoca.containerservice.service;

import com.akoca.containerservice.model.Container;

import java.util.Optional;

public interface ContainerService {

    Optional<Container> findById(Long id);

    Container save(Container newContainerToBeSaved);

    Container update(Container newContainerToBeUpdated);

    void delete(Long containerId);
}