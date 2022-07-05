package com.github.homework.program.repository;

import com.github.homework.program.domain.Program;
import com.github.homework.program.model.ProgramViewDetailDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProgramRepository extends JpaRepository<Program, Long>, ProgramCustomRepository {
}