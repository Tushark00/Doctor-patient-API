package com.clinic.drpatient.service;

import com.clinic.drpatient.entity.Doctor;
import com.clinic.drpatient.entity.Patient;
import com.clinic.drpatient.repo.DoctorDao;
import com.clinic.drpatient.repo.PatientDoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class ClinicService {

    private final DoctorDao doctorDao;


    private final PatientDoa patientDoa;

    @Autowired
    public ClinicService(DoctorDao doctorDao, PatientDoa patientDoa) {
        this.doctorDao = doctorDao;
        this.patientDoa = patientDoa;
    }
    //      doctor services#########

    public void deleteDoctor(Integer doctorId) {
        doctorDao.deleteById(doctorId);
    }

    public Doctor saveDoctor(Doctor doctor) {
        return doctorDao.save(doctor);
    }

    public Doctor getDoctor(Integer doctorId) {
        return doctorDao.findById(doctorId).orElseThrow();
    }

//    patients services #############

    public Patient savePatient(Patient patient) {
        return patientDoa.save(patient);
    }

    public void deletePatient(Integer patientId) {
        patientDoa.deleteById(patientId);
    }

    public Patient getPatient(Integer patientId) {
        return patientDoa.findById(patientId).orElseThrow();
    }

    public List<Doctor> suggestDoc(Integer patientId) throws Exception {
        Optional<Patient> patient = patientDoa.findById(patientId);
        List<Doctor> reqDocList = new ArrayList<>();
        if (patient.isPresent()){
            var currSymptom = patient.get().getSymptom();
            var currLoc = patient.get().getCity();
            if ( null!= currLoc ){
                List<Doctor> doctorList = doctorDao.findAllByCity(currLoc);
                doctorList.forEach(doctor -> {
                     List<String> specialtyOfDoc = Arrays.stream(doctor.getSpeciality().getSymptoms()).toList();
                     if(specialtyOfDoc.contains(currSymptom)){
                         reqDocList.add(doctor);
                     }
                });
            }
            else{
                throw  new Exception("We are still waiting to expand to your location");
            }
        } else {
            throw new Exception("There isn’t any doctor present at your location for your symptom");
        }
        if(!reqDocList.isEmpty()){
          return reqDocList;
        } else {
            throw new Exception("There isn’t any doctor present at your location for your symptom");
        }
    }
}
