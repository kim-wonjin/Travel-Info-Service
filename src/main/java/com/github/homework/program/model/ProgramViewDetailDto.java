package com.github.homework.program.model;

import lombok.Getter;

@Getter
public class ProgramViewDetailDto {
    private final Long id;
    private final String name;
    private final String introduction;
    private final String introductionDetail;
    private final String region;

    public ProgramViewDetailDto(Long id, String name, String introduction, String introductionDetail, String region) {
        this.id = id;
        this.name = name;
        this.introduction = introduction;
        this.introductionDetail = introductionDetail;
        this.region = region;
    }
}
