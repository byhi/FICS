package com.byhi.fics.service;

import com.byhi.fics.dao.SystemUnit;
import com.byhi.fics.domain.Modul;

import java.util.List;

public interface ModulService {
    public List<Modul> getAllModul();

    SystemUnit getSystemUnitByID(Long i);

    Modul getModulByID(Long id);

    Modul save(Modul modul);

    void deleteModul(Long id);
}
