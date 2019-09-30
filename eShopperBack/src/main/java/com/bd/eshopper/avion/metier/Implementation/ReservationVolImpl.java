package com.bd.eshopper.avion.metier.Implementation;

import com.bd.eshopper.avion.dao.ReservationVolRepository;
import com.bd.eshopper.avion.entity.ReservationVol;
import com.bd.eshopper.avion.metier.ReservationVolMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ReservationVolImpl implements ReservationVolMetier {

    @Autowired
    private ReservationVolRepository ReservationVolRepository;

    @Override
    public ReservationVol findOne(Long id) {
        return ReservationVolRepository.findOne(id);
    }

    @Override
    public List<ReservationVol> getAll() {
        return ReservationVolRepository.findAll();
    }

    @Override
    public ReservationVol save(ReservationVol o) {
              return ReservationVolRepository.save(o);
    }

    @Override
    public ReservationVol update(ReservationVol o) {
        return ReservationVolRepository.save(o);
    }

    @Override
    public String delete(Long id) {
        if (ReservationVolRepository.findOne(id) != null) {
            ReservationVolRepository.delete(id);
            return "reservation suprimée de la base";
        } else {
            return "Erreur de suppression de la réservation";
        }
    }
}
