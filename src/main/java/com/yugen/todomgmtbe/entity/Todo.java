package com.yugen.todomgmtbe.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * JPA entity for a Todo item.
 */
@Entity
@Table(name = "todos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Todo {
    /**
     * The id of the Todo item.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The title of the Todo item.
     */
    @Column(nullable = false)
    private String title;

    /**
     * The description of the Todo item.
     */
    @Column(nullable = false)
    private String description;

    /**
     * Whether the Todo item is completed or not.
     */
    private Boolean completed;
}
