package com.bd.eshopper.avion.metier.Implementation;

import com.bd.eshopper.avion.dao.CompagnieAerienneRepository;
import com.bd.eshopper.avion.entity.CompagnieAerienne;
import com.bd.eshopper.avion.metier.CompagnieAerienneMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CompagnieAerienneImpl implements CompagnieAerienneMetier {

    @Autowired
    private CompagnieAerienneRepository compagnieAerienneRepository;

    @Override
    public CompagnieAerienne findOne(Long id) {
        return compagnieAerienneRepository.findOne(id);
    }

    @Override
    public List<CompagnieAerienne> getAll() {
        return compagnieAerienneRepository.findAll();
    }

    @Override
    public CompagnieAerienne save(CompagnieAerienne o) {
        CompagnieAerienne a = new CompagnieAerienne();
        if (o.getId() == null) {
            if (o.getAirlineName() != null) {
                if (compagnieAerienneRepository.findByNom(o.getAirlineName()) == null) {
                    a = compagnieAerienneRepository.save(o);
                } else {
                    a.setAirlineName("exite deja");
                }
            }
        }
        return a;
    }

    @Override
    public CompagnieAerienne update(CompagnieAerienne o) {
        return compagnieAerienneRepository.save(o);
    }

    @Override
    public String delete(Long id) {
        if (compagnieAerienneRepository.findOne(id) != null) {
            compagnieAerienneRepository.delete(id);
            return "Compagnie suprimée de la base";
        } else {
            return "Erreur de suppression de la compagnie aérienne";
        }
    }
}
