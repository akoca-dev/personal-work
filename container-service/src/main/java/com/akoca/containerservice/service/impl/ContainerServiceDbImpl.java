package com.akoca.containerservice.service.impl;

import com.akoca.containerservice.model.Container;
import com.akoca.containerservice.repository.ContainerRepository;
import com.akoca.containerservice.service.ContainerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class ContainerServiceDbImpl implements ContainerService {

    private final ContainerRepository containerRepository;

    @Override
    public Optional<Container> findById(Long id) {
        return containerRepository.findById(id);
    }

    @Override
    public Container save(Container newContainerToBeSaved) {
        return containerRepository.save(newContainerToBeSaved);
    }

    @Override
    public Container update(Container newContainerToBeUpdated) {
        return containerRepository.save(newContainerToBeUpdated);
    }

    @Override
    public void delete(Long containerId) {
        containerRepository.deleteById(containerId);
    }
}