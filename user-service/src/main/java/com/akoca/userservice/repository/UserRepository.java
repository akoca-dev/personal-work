package com.akoca.userservice.repository;

import com.akoca.userservice.entity.EntUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.Nonnull;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<EntUser, Long> {

    @Nonnull
    Optional<EntUser> findById(@Nonnull Long userId);

    Optional<EntUser> findByUsername(String userName);

    Optional<EntUser> deleteUserById(@Nonnull Long userId);
}
