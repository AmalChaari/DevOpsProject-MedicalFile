package tn.iit.mapper;

import tn.iit.entity.Patient;
import tn.iit.dto.PatientDto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PatientMapper {
    public static PatientDto patientToPatientDto(Patient patient)
    {
        PatientDto patientDto = new PatientDto ();
        patientDto.setId (patient.getId ());
        patientDto.setBirthday (patient.getBirthday ());
        patientDto.setCin (patient.getCin ());
        patientDto.setName (patient.getName ());
        return patientDto;
    }

    public static Patient patientDtoToPatient(PatientDto patientDto)
    {
        Patient patient = new Patient ();
        patient.setId (patientDto.getId ());
        patient.setBirthday (patientDto.getBirthday ());
        patient.setCin (patientDto.getCin ());
        patient.setName (patientDto.getName ());
        patient.setName (patientDto.getName ());
        return patient;
    }

    public static Collection<PatientDto> patientsToPatientDtos(Collection<Patient> patients)
    {
        List<PatientDto> patientDtoList = new ArrayList<> ();
        patients.forEach(patient -> {
            patientDtoList.add (patientToPatientDto (patient));
        });
        return patientDtoList;
    }
}
