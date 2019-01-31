package com.byhi.fics.service;

import com.byhi.fics.dao.SystemUnit;
import com.byhi.fics.domain.Modul;
import com.byhi.fics.repository.ModulRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModulServiceImpl implements ModulService {

    private ModulRepository modulRepository;

    @Autowired
    public void setModulRepository(ModulRepository modulRepository) {
        this.modulRepository = modulRepository;
    }

    public List<Modul> getAllModul() {
        return (List<Modul>) this.modulRepository.findAll();
    }

    public SystemUnit getSystemUnitByID(Long id) {
        Modul modul = this.modulRepository.findById(id).get();

        return new SystemUnit(  modul.getId(),
                                modul.getR_id().getName(),
                                modul.getR_id().getDesc(),
                                modul.getName(),
                                modul.getDesc());
    }

    public Modul getModulByID(Long id) {
        return  this.modulRepository.findById(id).get();
    }

    public Modul save(Modul modul) {
        System.out.println(modul.getName() +" "+ modul.getDesc()  +" "+modul.getR_id().getName() +" "+ modul.getR_id().getDesc());
        return this.modulRepository.save(modul);
    }

    @Override
    public void deleteModul(Long id) {
        this.modulRepository.delete(this.modulRepository.findById(id).get());
    }

}
