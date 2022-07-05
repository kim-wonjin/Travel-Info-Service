package com.github.homework.program.model;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;

@Getter
public class ProgramViewDto {
    private final Long id;
    private final String name;
    public ProgramViewDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
