package com.yugen.todomgmtbe.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Data transfer object for a Todo item.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TodoDTO {
    /**
     * The id of the Todo item.
     */
    private Long id;

    /**
     * The title of the Todo item.
     */
    private String title;

    /**
     * The description of the Todo item.
     */
    private String description;

    /**
     * Whether the Todo item is completed or not.
     */
    private Boolean completed;
}
