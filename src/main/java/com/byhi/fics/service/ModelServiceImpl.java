package com.byhi.fics.service;

import com.byhi.fics.domain.Modul;
import com.byhi.fics.repository.ModulRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModelServiceImpl implements ModelService{

    private ModulRepository modulRepository;

    @Autowired
    public  void  setModulRepository ( ModulRepository  modulRepository ) {
        this.modulRepository = modulRepository;
    }
    public  List<Modul>  getAllModul() {
        return (List<Modul>) this.modulRepository.findAll();
    }
}
