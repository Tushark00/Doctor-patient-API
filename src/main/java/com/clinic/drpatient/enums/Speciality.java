package com.clinic.drpatient.enums;


import com.clinic.drpatient.constants.SymptomsConstant;

public enum Speciality {


    ORTHOPEDIC(SymptomsConstant.ORTHOPEDIC),
    GYNECOLOGY(SymptomsConstant.GYNECOLOGY),
    DERMATOLOGY(SymptomsConstant.DERMATOLOGY),
    ENT(SymptomsConstant.ENT);


    private String[] symptoms;

    Speciality(String... symptoms) {
        this.symptoms = symptoms;
    }

    public String[] getSymptoms() {
        return symptoms;
    }


}

