package com.byhi.fics.service;

import com.byhi.fics.dao.SystemUnit;
import com.byhi.fics.domain.Modul;
import com.byhi.fics.domain.Rendszer;
import com.byhi.fics.repository.RendszerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RendszerServiceImpl implements RendszerService {

    private RendszerRepository rendszerRepository;

    @Autowired
    public void setRendszerRepository(RendszerRepository rendszerRepository) {
        this.rendszerRepository = rendszerRepository;
    }

    private ModulService modulService;

    @Autowired
    public void setModulService(ModulServiceImpl modulServiceImpl) {
        this.modulService = modulServiceImpl;
    }

    public List<Rendszer> getAllRendszer() {
        return (List<Rendszer>) this.rendszerRepository.findAll();
    }

    public List<SystemUnit> getAllSystemUnit() {
        List<SystemUnit> list = new ArrayList<SystemUnit>();
        for (Rendszer rendszer : (List<Rendszer>) this.rendszerRepository.findAll()) {
            for (Modul modul : rendszer.getModuls()) {
                list.add(new SystemUnit(modul.getId(), rendszer.getName(), rendszer.getDesc(), modul.getName(), modul.getDesc()));
            }
        }
        return list;
    }

    public void save(Modul modul) {
        Rendszer rendszer = null;
        System.out.println(modul.getR_id().getName());
        if (modul.getId() == null) {

            List<Rendszer> lst = (ArrayList<Rendszer>) this.rendszerRepository.findAll();
            Iterator<Rendszer> iterator = lst.iterator();
            while (iterator.hasNext()) {
                Rendszer setElement = iterator.next();

                if (setElement.getName().equals(modul.getR_id().getName())) {
                    rendszer = setElement;
                    modul.setR_id(rendszer);
                    break;
                }
            }

        } else {
            rendszer = this.modulService.getModulByID(modul.getId()).getR_id();//modul.getR_id();
        }
        if (modul.getR_id().getName().equals(rendszer.getName())) {
            rendszer.setDesc(modul.getR_id().getDesc());
            modul.setR_id(rendszer);
            Iterator<Modul> iterator = rendszer.getModuls().iterator();
            while (iterator.hasNext()) {
                Modul setElement = iterator.next();
                if (setElement.getId().equals(modul.getId())) {
                    setElement = modul;
                    break;

                } else if (!iterator.hasNext()) {
                    rendszer.getModuls().add(modul);
                }
            }
            this.modulService.save(modul);
            this.rendszerRepository.save(rendszer);
        } else {
            Rendszer ujrendszer = null;
            List<Rendszer> lst = (ArrayList<Rendszer>) this.rendszerRepository.findAll();
            Iterator<Rendszer> iterator = lst.iterator();

            while (iterator.hasNext()) {
                Rendszer setElement = iterator.next();

                if (setElement.getName().equals(modul.getR_id().getName())) {
                    ujrendszer = setElement;


                    break;
                }
            }
            if (ujrendszer == null) {
                ujrendszer = this.rendszerRepository.save(new Rendszer(modul.getR_id().getName(), modul.getDesc()));
                modul.setR_id(ujrendszer);
                this.modulService.save(modul);
                this.rendszerRepository.save(rendszer);
            } else {
                modul.setR_id(ujrendszer);
                this.modulService.save(modul);
                this.rendszerRepository.save(rendszer);
            }
        }
    }

    public void deleteModul(Long id) {
        Rendszer rendszer = this.modulService.getModulByID(id).getR_id();
        this.modulService.deleteModul(id);
        this.rendszerRepository.save(rendszer);
    }


    public void saveRendszer(Rendszer rendszer) {
        rendszer = this.rendszerRepository.save(rendszer);
    }

    @Override
    public List<String> getAllRendszerNev() {
        List<String> listsys = new ArrayList<String>();
        for (Rendszer rendszer : getAllRendszer()
        ) {
            listsys.add(rendszer.getName());
        }
        return listsys;
    }

}
