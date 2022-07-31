package com.github.homework.program.domain;


import com.github.homework.theme.domain.Theme;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;


@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SequenceGenerator(
        name = "program_seq_generator",
        sequenceName = "program_seq", allocationSize = 10)
@EqualsAndHashCode(of = "id")
@DynamicInsert
@ToString
public class Program {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "program_seq_generator")
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "introduction", nullable = false)
    private String introduction;
    @Column(name = "region", nullable = false)
    private String region;
    @Column(name = "introduction_detail", nullable = false)
    private String introductionDetail;
    @Column(name = "viewCount", nullable = false)
    @ColumnDefault("0")
    private Long viewCount;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "theme_id", foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
    private Theme theme;


    @Builder
    public Program(String name, String introduction, String introductionDetail, String region, Long viewCount, Theme theme) {
        this.name = name;
        this.introduction = introduction;
        this.introductionDetail = introductionDetail;
        this.region = region;
        this.viewCount = viewCount;
        this.theme = theme;
    }

    public void updateProgram(String name, String introduction, String introductionDetail, String region,
                              Theme theme) {
        this.name = name;
        this.introduction = introduction;
        this.introductionDetail = introductionDetail;
        this.region = region;
        this.theme = theme;
    }

}
