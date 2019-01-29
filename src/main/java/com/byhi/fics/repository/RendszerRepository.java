package com.byhi.fics.repository;

import com.byhi.fics.domain.Rendszer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface RendszerRepository extends CrudRepository<Rendszer, Long> {
    Optional<Rendszer> findById(Long aLong);
}