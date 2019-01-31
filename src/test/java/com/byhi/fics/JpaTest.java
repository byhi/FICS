package com.byhi.fics;

import com.byhi.fics.domain.Modul;
import com.byhi.fics.domain.Rendszer;
import com.byhi.fics.repository.ModulRepository;
import com.byhi.fics.repository.RendszerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {FicsApplication.class})
@DataJpaTest
public class JpaTest {
    @Autowired
    private RendszerRepository rendszerRepository;

    @Autowired
    private ModulRepository modulRepository;

    @Test
    public void modulRepository_whenSaveAndRetreiveEntity_thenOK() {
        Modul genericEntity = modulRepository
                .save(new Modul("test", "aspectj_"));
        Optional<Modul> foundEntity = modulRepository
                .findById(genericEntity.getId());
        assertNotNull(genericEntity);
        assertEquals(genericEntity.getName(), foundEntity.get().getName());
    }

    @Test
    public void rendszerRepository_whenSaveAndRetreiveEntity_thenOK() {
        Rendszer genericEntity = rendszerRepository
                .save(new Rendszer("test", "aspectj_"));
        genericEntity.getModuls().add(
                modulRepository.save(
                        new Modul("test1", "aspectj_")));
        genericEntity.getModuls().add(
                modulRepository.save(
                        new Modul("test2", "aspectj_")));
        genericEntity.getModuls().add(
                modulRepository.save(
                        new Modul("test3", "aspectj_")));

        genericEntity = rendszerRepository.save(genericEntity);

        Optional<Rendszer> foundEntity = rendszerRepository
                .findById(genericEntity.getId());
        assertNotNull(genericEntity);
        assertEquals(genericEntity.getName(), foundEntity.get().getName());
        assertEquals(genericEntity.getModuls().size(), foundEntity.get().getModuls().size());
    }
}
