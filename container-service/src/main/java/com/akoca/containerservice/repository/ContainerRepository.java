package com.akoca.containerservice.repository;

import com.akoca.containerservice.model.Container;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContainerRepository extends JpaRepository<Container, Long> {
}