package com.pj.auth.server.user.repository;

import com.pj.auth.server.user.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    @Query(value = "SELECT u FROM User u WHERE u.uuid = :uuid")
    Optional<User> findByUUID(@Param("uuid") String uuid);
}
