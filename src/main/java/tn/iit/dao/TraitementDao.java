package tn.iit.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.iit.entity.Traitement;

import java.util.List;

@Repository
public interface TraitementDao extends JpaRepository<Traitement,Long> {
    List<Traitement> findAllByDossier_Id(long dossier_id);
}
