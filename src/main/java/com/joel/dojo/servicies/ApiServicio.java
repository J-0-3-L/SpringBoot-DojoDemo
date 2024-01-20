package com.joel.dojo.servicies;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joel.dojo.models.Dojo;
import com.joel.dojo.models.Ninja;
import com.joel.dojo.repositories.DojoRepository;
import com.joel.dojo.repositories.NinjaRepository;

@Service
public class ApiServicio {
    
    @Autowired
    private DojoRepository dojoRepo;

    @Autowired
    private NinjaRepository ninjaRepo;

    public List<Dojo> getAllDojos(){
        return dojoRepo.findAll();
    }

    public Dojo getDojoById(Long Id){
        return dojoRepo.findById(Id).orElse(null);
    }

    public Dojo saveDojo(Dojo dojo){
        return dojoRepo.save(dojo);
    }

    public void saveNinja(Ninja ninja){
        ninjaRepo.save(ninja);
    }

    public List<Dojo> getAllDojoWithNinja(){
        return dojoRepo.findAllWithNinja();
    }

    public List<Ninja> getAllDojoWithNinja(Long dojoId) {
        return ninjaRepo.findByDojoId(dojoId);
    }


}
