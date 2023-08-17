package com.yugen.todomgmtbe.repository;

import com.yugen.todomgmtbe.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for managing Todo items.
 */
@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
}
