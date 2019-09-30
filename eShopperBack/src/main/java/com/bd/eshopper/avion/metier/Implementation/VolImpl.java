package com.bd.eshopper.avion.metier.Implementation;

import com.bd.eshopper.avion.dao.VolRepository;
import com.bd.eshopper.avion.entity.Vol;
import com.bd.eshopper.avion.metier.VolMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VolImpl implements VolMetier {

    @Autowired
    private VolRepository volRepository;

    @Override
    public Vol findOne(Long id) {
        return volRepository.findOne(id);
    }

    @Override
    public List<Vol> getAll() {
        return volRepository.findAll();
    }

    @Override
    public Vol save(Vol o) {
              return volRepository.save(o);
    }

    @Override
    public Vol update(Vol o) {
        return volRepository.save(o);
    }

    @Override
    public String delete(Long id) {
        if (volRepository.findOne(id) != null) {
            volRepository.delete(id);
            return "Vol suprimée de la base";
        } else {
            return "Erreur de suppression du vol";
        }
    }
}
