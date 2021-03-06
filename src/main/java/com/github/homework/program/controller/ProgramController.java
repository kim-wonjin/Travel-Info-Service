package com.github.homework.program.controller;

import com.github.homework.program.domain.Program;
import com.github.homework.program.exception.ProgramNotFoundException;
import com.github.homework.program.model.ProgramSaveDto;
import com.github.homework.program.model.ProgramViewDetailDto;
import com.github.homework.program.model.ProgramViewDto;
import com.github.homework.program.model.SimpleResponse;
import com.github.homework.program.service.ProgramSaveService;
import com.github.homework.program.service.ProgramViewService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/programs")
@RequiredArgsConstructor
public class ProgramController {

    private final ProgramViewService programViewService;
    private final ProgramSaveService programSaveService;

    @GetMapping
    public ResponseEntity<Page<ProgramViewDto>> pageBy(
            @PageableDefault(sort = "id", direction = Sort.Direction.DESC)
                    Pageable pageable) {
        return ResponseEntity.ok(this.programViewService.pageBy(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProgramViewDetailDto> getBy(@PathVariable Long id) throws ProgramNotFoundException {
        Optional<ProgramViewDetailDto> programViewDto = this.programViewService.getBy(id);
        return programViewDto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/name")
    public ResponseEntity<ProgramViewDetailDto> getByName(@RequestParam String name) throws ProgramNotFoundException {
        Optional<ProgramViewDetailDto> programViewDto = this.programViewService.getByName(name);
        return programViewDto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<SimpleResponse> saveProgram(@RequestBody @Valid ProgramSaveDto
                                                              programSaveDto) {
        this.programSaveService.saveProgram(programSaveDto);
        return ResponseEntity.ok(new SimpleResponse(true, "?????? ??????"));
    }

    @PutMapping
    public ResponseEntity<SimpleResponse> updateProgram(@RequestBody @Valid ProgramSaveDto
                                                                programSaveDto) {
        try {
            this.programSaveService.updateProgram(programSaveDto);
        } catch (ProgramNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(new SimpleResponse(true, "?????? ??????"));
    }

    @GetMapping("/top10")
    public ResponseEntity<List<ProgramViewDetailDto>> getTop10() throws ProgramNotFoundException {
        Optional<List<ProgramViewDetailDto>> result =  this.programViewService.getTop10();
        return result.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
