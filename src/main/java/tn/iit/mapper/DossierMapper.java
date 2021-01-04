package tn.iit.mapper;

import tn.iit.entity.Dossier;
import tn.iit.dto.DossierDto;
import tn.iit.dto.PatientDto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DossierMapper {

    public static DossierDto dossierToDossierDto(Dossier dossier)
    {
        DossierDto dossierDto = new DossierDto ();
        dossierDto.setId (dossier.getId ());
        dossierDto.setPatientId (dossier.getPatient ().getId ());
        dossierDto.setPatientName (dossier.getPatient ().getName ());
        return dossierDto;
    }

    public static Dossier dossierDtoToDossier(DossierDto dossierDto)
    {
        Dossier dossier = new Dossier ();
        dossier.setId (dossierDto.getId ());
        dossier.setPatient (PatientMapper.patientDtoToPatient (new PatientDto (dossierDto.getPatientId ())));
        return dossier;
    }

    public static Collection<DossierDto> dossiersToDossierDtos(Collection<Dossier> categories)
    {
        List<DossierDto> dossierDtoList = new ArrayList<> ();
        categories.forEach(dossier -> {
            dossierDtoList.add (dossierToDossierDto (dossier));
        });
        return dossierDtoList;
    }
}
