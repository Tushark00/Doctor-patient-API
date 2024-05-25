package com.clinic.drpatient.controller;

import com.clinic.drpatient.entity.Doctor;
import com.clinic.drpatient.service.ClinicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    private final ClinicService clinicService;

    @Autowired
    public DoctorController(ClinicService clinicService) {
        this.clinicService = clinicService;
    }


    @PostMapping("/save")
    public Doctor saveDoctor(@RequestBody Doctor doctor) throws Exception {
        if (doctor.getCity().equalsIgnoreCase("NOIDA") || doctor.getCity().equalsIgnoreCase("FARIDABAD") || doctor.getCity().equalsIgnoreCase("DELHI")) {
            return clinicService.saveDoctor(doctor);
        } else {
            throw new Exception("CITY SHOULD BE IN NOIDA, FARIDABAD, DELHI");
        }
    }

    @GetMapping("/{doctorId}")
    public Doctor getDoctor(@PathVariable Integer doctorId) {
        return clinicService.getDoctor(doctorId);
    }

    @DeleteMapping("/{doctorId}")
    public void deleteDoctor(@PathVariable Integer doctorId) {
        clinicService.deleteDoctor(doctorId);
    }

}
