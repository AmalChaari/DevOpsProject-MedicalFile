package tn.iit.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.iit.entity.Patient;
@Repository
public interface PatientDao extends JpaRepository<Patient,Long> {
}
