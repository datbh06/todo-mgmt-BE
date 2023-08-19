package com.yugen.todomgmtbe.repository;

import com.yugen.todomgmtbe.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    /**
     * Finds a role by its name.
     *
     * @param name the name of the role to find
     * @return the role with the given name
     */
    Role findByName(String name);
}
