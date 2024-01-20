package com.joel.dojo.repositories;

import java.util.List;

import com.joel.dojo.models.Ninja;

public interface NinjaRepository extends BaseRepository<Ninja> {

    List<Ninja> findByDojoId(Long dojoId);
    
}
