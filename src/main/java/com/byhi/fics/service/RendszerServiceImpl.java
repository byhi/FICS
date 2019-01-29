package com.byhi.fics.service;

import com.byhi.fics.domain.Rendszer;
import com.byhi.fics.repository.RendszerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RendszerServiceImpl implements RendszerService{

    private RendszerRepository rendszerRepository;

    @Autowired
    public  void  setRendszerRepository( RendszerRepository  rendszerRepository ) {
        this.rendszerRepository = rendszerRepository;
    }

    public  List<Rendszer>  getAllRendszer() {
        return (List<Rendszer>) this.rendszerRepository.findAll();
    }
}
