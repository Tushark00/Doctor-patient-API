package com.clinic.drpatient.controller;

import com.clinic.drpatient.entity.Patient;
import com.clinic.drpatient.repo.PatientDoa;
import com.clinic.drpatient.service.ClinicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patient")
public class PatientController {
    @Autowired
    private ClinicService clinicService;

    @PostMapping("/save")
    public Patient savePatient(@RequestBody Patient patient){
        return clinicService.savePatient(patient);
    }

    @DeleteMapping("/{patientId}")
    public void deletePatient(@PathVariable Integer patientId){
        clinicService.deletePatient(patientId);
    }

    @GetMapping("/{patientId}")
    public Patient getPatient(@PathVariable Integer patientId){
    return clinicService.getPatient(patientId);
    }
}