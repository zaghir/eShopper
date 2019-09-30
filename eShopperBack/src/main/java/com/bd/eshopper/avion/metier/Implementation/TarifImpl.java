package com.bd.eshopper.avion.metier.Implementation;

import com.bd.eshopper.avion.dao.TarifRepository;
import com.bd.eshopper.avion.entity.Tarif;
import com.bd.eshopper.avion.metier.TarifMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TarifImpl implements TarifMetier {

    @Autowired
    private TarifRepository tarifRepository;

    @Override
    public Tarif findOne(Long id) {
        return tarifRepository.findOne(id);
    }

    @Override
    public List<Tarif> getAll() {
        return tarifRepository.findAll();
    }

    @Override
    public Tarif save(Tarif o) {
              return tarifRepository.save(o);
    }

    @Override
    public Tarif update(Tarif o) {
        return tarifRepository.save(o);
    }

    @Override
    public String delete(Long id) {
        if (tarifRepository.findOne(id) != null) {
            tarifRepository.delete(id);
            return "Tarif suprimée de la base";
        } else {
            return "Erreur de suppression du tarif";
        }
    }
}
