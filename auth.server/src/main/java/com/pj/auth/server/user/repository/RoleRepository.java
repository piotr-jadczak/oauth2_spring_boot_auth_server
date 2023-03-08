package com.pj.auth.server.user.repository;

import com.pj.auth.server.user.entity.Role;
import com.pj.auth.server.user.entity.RoleName;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface RoleRepository extends CrudRepository<Role, Long> {

    @Query(value = "SELECT r FROM Role r WHERE r.name = :roleName")
    Role findByRoleName(@Param("roleName") RoleName roleName);
}
