package com.bd.eshopper.avion.metier.Implementation;

import com.bd.eshopper.avion.dao.VoyageurRepository;
import com.bd.eshopper.avion.entity.Voyageur;
import com.bd.eshopper.avion.metier.VoyageurMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VoyageurImpl implements VoyageurMetier {

    @Autowired
    private VoyageurRepository voyageurRepository;

    @Override
    public Voyageur findOne(Long id) {
        return voyageurRepository.findOne(id);
    }

    @Override
    public List<Voyageur> getAll() {
        return voyageurRepository.findAll();
    }

    @Override
    public Voyageur save(Voyageur o) {
              return voyageurRepository.save(o);
    }

    @Override
    public Voyageur update(Voyageur o) {
        return voyageurRepository.save(o);
    }

    @Override
    public String delete(Long id) {
        if (voyageurRepository.findOne(id) != null) {
            voyageurRepository.delete(id);
            return "Voyageur suprimée de la base";
        } else {
            return "Erreur de suppression du voyageur";
        }
    }
}
