package com.github.homework.program.model;

import com.github.homework.program.domain.Program;
import com.github.homework.theme.domain.Theme;
import com.github.homework.theme.repository.ThemeRepository;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProgramViewDetailDto {
    private final Long id;
    private final String name;
    private final String introduction;
    private final String introductionDetail;
    private final String region;
    private Long viewCount;
    private final String themeName;

    public ProgramViewDetailDto(Long id, String name, String introduction, String introductionDetail, String region, Long viewCount, String themeName) {
        this.id = id;
        this.name = name;
        this.introduction = introduction;
        this.introductionDetail = introductionDetail;
        this.region = region;
        this.viewCount = viewCount;
        this.themeName = themeName;
    }
}
