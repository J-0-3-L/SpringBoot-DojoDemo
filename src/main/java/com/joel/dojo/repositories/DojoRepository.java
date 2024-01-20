package com.joel.dojo.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.joel.dojo.models.Dojo;

public interface DojoRepository extends BaseRepository<Dojo> {
    
    //@Query("SELECT DISTINCT d FROM Dojo d JOIN FETCH d.ninjas")
    @Query("SELECT DISTINCT d FROM Dojo d LEFT JOIN FETCH d.ninjas")
    List<Dojo> findAllWithNinja();
}
