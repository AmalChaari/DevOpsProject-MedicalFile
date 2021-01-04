package tn.iit.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.iit.entity.Dossier;

@Repository
public interface DossierDao extends JpaRepository<Dossier,Long> {
}
