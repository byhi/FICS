package com.byhi.fics.service;

import com.byhi.fics.dao.SystemUnit;
import com.byhi.fics.domain.Modul;
import com.byhi.fics.domain.Rendszer;

import java.util.List;

public interface RendszerService {
    public List<Rendszer> getAllRendszer();
    public List<SystemUnit> getAllSystemUnit();
    void save(Modul modul);

    void deleteModul(Long id);

    void saveRendszer(Rendszer rendszer);

    List<String> getAllRendszerNev();

    void update(Modul modul);
}
