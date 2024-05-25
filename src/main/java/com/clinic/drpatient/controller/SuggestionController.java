package com.clinic.drpatient.controller;

import com.clinic.drpatient.entity.Doctor;
import com.clinic.drpatient.service.ClinicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/suggestion")
public class SuggestionController {

    private final ClinicService clinicService;

    @Autowired
    public SuggestionController(ClinicService clinicService) {
        this.clinicService = clinicService;
    }

    @GetMapping("/{patientId}")
    public List<Doctor> getDocList(@PathVariable Integer patientId) throws Exception {
        return clinicService.suggestDoc(patientId);
    }
}
