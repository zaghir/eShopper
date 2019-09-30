package com.bd.eshopper.avion.dao;

import com.bd.eshopper.avion.entity.CompagnieAerienne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CompagnieAerienneRepository extends JpaRepository<CompagnieAerienne, Long> {

    //methode personalisée pour récupéré l'entité par nom
    @Query("select c from CompagnieAerienne c where c.airlineName like :nom")
    public CompagnieAerienne findByNom(@Param(value = "nom") String nom);
}
