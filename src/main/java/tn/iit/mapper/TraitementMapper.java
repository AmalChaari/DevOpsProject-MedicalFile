package tn.iit.mapper;

import tn.iit.entity.Traitement;
import tn.iit.dto.DossierDto;
import tn.iit.dto.TraitementDto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TraitementMapper {


    public static TraitementDto traitementToTraitementDto(Traitement traitement)
    {
        TraitementDto traitementDto = new TraitementDto ();
        traitementDto.setId (traitement.getId ());
        traitementDto.setDossierId (traitement.getDossier ().getId ());
        traitementDto.setMedicamentId (traitement.getMedicamentId ());
        return traitementDto;
    }

    public static Traitement traitementDtoToTraitement(TraitementDto traitementDto)
    {
        Traitement traitement = new Traitement ();
        traitement.setId (traitementDto.getId ());
        traitement.setDossier (DossierMapper.dossierDtoToDossier (new DossierDto (traitementDto.getDossierId ())));
        traitement.setMedicamentId (traitementDto.getMedicamentId ());
        return traitement;
    }

    public static Collection<TraitementDto> traitementsToTraitementDtos(Collection<Traitement> traitements)
    {
        List<TraitementDto> traitementDtoList = new ArrayList<> ();
        traitements.forEach(traitement -> {
            traitementDtoList.add (traitementToTraitementDto (traitement));
        });
        return traitementDtoList;
    }
}
