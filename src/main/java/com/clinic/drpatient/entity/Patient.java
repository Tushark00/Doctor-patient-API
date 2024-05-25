package com.clinic.drpatient.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "Patients")
public class Patient {

    //    In our database we will have the
//    patient's name, city, email, phone number, and symptom
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer patientId;

    @Size(min = 3, message = "name should be min 3 size")
    private String name;
    @Size(max = 20, message = "name should be max 20 size")
    private String city;

    @Email
    private String email;

    @Size(min = 10, max = 10, message = "enter a valid phone number")
    private String phoneNumber;

    private String symptom;

    //    constructor param
    public Patient(Integer patientId, String name, String city, String email, String phoneNumber, String symptom) {
        this.patientId = patientId;
        this.name = name;
        this.city = city;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.symptom = symptom;
    }

    //    constructor noparam
    public Patient() {
    }

    // getter setter
    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getSymptom() {
        return symptom;
    }

    public void setSymptom(String symptom) {
        this.symptom = symptom;
    }
}
