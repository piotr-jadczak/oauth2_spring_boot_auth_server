package com.pj.auth.server.user.repository;

import com.pj.auth.server.user.entity.User;
import com.pj.auth.server.utils.hibernate.ReadOnlyRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserReadOnlyRepository extends ReadOnlyRepository<User, Long> {

    @Query(value = "SELECT u FROM User u WHERE u.username = :username")
    Optional<User> findByUsername(@Param("username") String username);

    @Query(value = "SELECT u FROM User u WHERE u.uuid = :uuid")
    Optional<User> findByUUID(@Param("uuid") String uuid);

    @Query(value = "SELECT u FROM User u WHERE u.email = :email")
    Optional<User> findByEmail(@Param("email") String email);
}
