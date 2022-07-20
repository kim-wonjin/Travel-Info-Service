package com.github.homework.program.model;

import com.github.homework.theme.domain.Theme;
import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;

@Getter
public class ProgramViewDto {
    private final Long id;
    private final String name;
    private final String themeName;
    public ProgramViewDto(Long id, String name, String themeName) {
        this.id = id;
        this.name = name;
        this.themeName = themeName;
    }
}
