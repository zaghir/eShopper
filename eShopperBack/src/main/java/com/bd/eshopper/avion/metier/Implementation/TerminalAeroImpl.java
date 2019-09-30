package com.bd.eshopper.avion.metier.Implementation;

import com.bd.eshopper.avion.dao.TerminalAeroRepository;
import com.bd.eshopper.avion.entity.TerminalAero;
import com.bd.eshopper.avion.metier.TerminalAeroMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TerminalAeroImpl implements TerminalAeroMetier {

    @Autowired
    private TerminalAeroRepository terminalAeroRepository;

    @Override
    public TerminalAero findOne(Long id) {
        return terminalAeroRepository.findOne(id);
    }

    @Override
    public List<TerminalAero> getAll() {
        return terminalAeroRepository.findAll();
    }

    @Override
    public TerminalAero save(TerminalAero o) {
              return terminalAeroRepository.save(o);
    }

    @Override
    public TerminalAero update(TerminalAero o) {
        return terminalAeroRepository.save(o);
    }

    @Override
    public String delete(Long id) {
        if (terminalAeroRepository.findOne(id) != null) {
            terminalAeroRepository.delete(id);
            return "TerminalAero suprimée de la base";
        } else {
            return "Erreur de suppression du terminalAero";
        }
    }
}
