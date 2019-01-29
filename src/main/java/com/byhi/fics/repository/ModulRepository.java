package com.byhi.fics.repository;

import com.byhi.fics.domain.Modul;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ModulRepository extends CrudRepository<Modul, Long> , JpaRepository<Modul, Long> {
    Optional<Modul> findById(Long aLong);
}
