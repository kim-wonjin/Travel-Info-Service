package com.github.homework.program.service;

import com.github.homework.program.domain.Program;
import com.github.homework.program.exception.ProgramNotFoundException;
import com.github.homework.program.model.ProgramViewDetailDto;
import com.github.homework.program.model.ProgramViewDto;
import com.github.homework.program.repository.ProgramRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = false)
public class ProgramViewService {
    private final ProgramRepository programRepository;

    public Optional<ProgramViewDetailDto> getBy(Long id) throws ProgramNotFoundException {
        Program program = this.programRepository.findById(id).orElseThrow(
                ProgramNotFoundException::new);
        program.setViewCount(program.getViewCount() + 1);
        programRepository.save(program);
    return Optional.of(new ProgramViewDetailDto(
            program.getId(),
            program.getName(),
            program.getIntroduction(),
            program.getIntroductionDetail(),
            program.getRegion(),
            program.getViewCount(),
            program.getTheme().getName()
    ));
    }

    public Optional<ProgramViewDetailDto> getByName(String name) throws ProgramNotFoundException {
        Program program = this.programRepository.findByName(name).orElseThrow(
                ProgramNotFoundException::new);
        program.setViewCount(program.getViewCount() + 1);
        programRepository.save(program);
        return Optional.of(new ProgramViewDetailDto(
                program.getId(),
                program.getName(),
                program.getIntroduction(),
                program.getIntroductionDetail(),
                program.getRegion(),
                program.getViewCount(),
                program.getTheme().getName()
        ));
    }

    public Optional<List<ProgramViewDetailDto>> getTop10() throws ProgramNotFoundException {
        return Optional.of((programRepository.findTop10ByOrderByViewCountDesc().orElseThrow(ProgramNotFoundException::new)));
    }

    public Page<ProgramViewDto> pageBy(Pageable pageable) {
        return programRepository.findBy(pageable);
    }

}
