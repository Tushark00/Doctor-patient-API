package com.clinic.drpatient.entity;

import com.clinic.drpatient.enums.Speciality;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="doctors")
public class Doctor {
//    In our database we will have the
//    doctor's name, city, email, phone number, and speciality.
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Integer doctorId;
    @Size(min = 3, message = "name should be min 3 size")
    private String name;

    @Size(max = 20, message = "name should be max 20 size")
    private  String city;

    @Email
    private  String email;

    @Size(min = 10, max = 10, message = "enter a valid phone number")
    private String phoneNumber;
    private Speciality speciality;

    public Doctor(Integer doctorId, String name, String city, String email, String phoneNumber, Speciality speciality) {
        this.doctorId = doctorId;
        this.name = name;
        this.city = city;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.speciality = speciality;
    }

    //    constructor param

//    constructor  non param
    public Doctor() {
    }

//getter setter
    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Speciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
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
}
