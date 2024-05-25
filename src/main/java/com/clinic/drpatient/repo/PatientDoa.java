package com.clinic.drpatient.repo;

import com.clinic.drpatient.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientDoa extends JpaRepository<Patient,Integer> {
}
