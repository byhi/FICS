package com.byhi.fics.repository;

import com.byhi.fics.domain.Rendszer;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RendszerRepository extends CrudRepository<Rendszer, Long> {
    Optional<Rendszer> findById(Long aLong);
}