package tn.iit.service;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tn.iit.dao.TraitementDao;
import tn.iit.dto.MedicamentDto;
import tn.iit.dto.TraitementDto;
import tn.iit.mapper.TraitementMapper;

import org.springframework.transaction.annotation.Transactional;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Transactional
@Service
public class TraitementService {
    private final TraitementDao traitementDao;
    private final StoreManagementClientService storeManagementClientService;

    public TraitementService(TraitementDao traitementDao, StoreManagementClientService storeManagementClientService) {
        this.traitementDao = traitementDao;
        this.storeManagementClientService = storeManagementClientService;
    }

    public TraitementDto save(TraitementDto traitementDto) {
        this.traitementDao.saveAndFlush (TraitementMapper.traitementDtoToTraitement (traitementDto));
        return traitementDto;
    }

    public void deleteById(Long id) {
        this.traitementDao.deleteById (id);
    }
    @Transactional(readOnly = true)
    public TraitementDto findOne(Long id) {
        TraitementDto traitementDto= TraitementMapper.traitementToTraitementDto (this.traitementDao.getOne (id));
        MedicamentDto medicamentDto = this.storeManagementClientService.getMedicamentById (traitementDto.getMedicamentId ());
        traitementDto.setMedicamentDosage (medicamentDto.getDosage ());
        traitementDto.setMedicamentName (medicamentDto.getName ());
        traitementDto.setMedicamentPrice (medicamentDto.getPrice ());
        return traitementDto;
    }
    @Transactional(readOnly = true)
    public Collection<TraitementDto> findAll(Pageable pageable) {
        Collection<TraitementDto> traitementDtos = TraitementMapper.traitementsToTraitementDtos (this.traitementDao.findAll (pageable).getContent ());
        traitementDtos.forEach (traitementDto -> {
            MedicamentDto medicamentDto = this.storeManagementClientService.getMedicamentById (traitementDto.getMedicamentId ());
            traitementDto.setMedicamentDosage (medicamentDto.getDosage ());
            traitementDto.setMedicamentName (medicamentDto.getName ());
            traitementDto.setMedicamentPrice (medicamentDto.getPrice ());
        });
        return traitementDtos;
    }
    @Transactional(readOnly = true)
    public Collection<TraitementDto> findAllByDossierId(Long dossierId){
        Collection<TraitementDto> traitementDtos = TraitementMapper.traitementsToTraitementDtos (this.traitementDao.findAllByDossier_Id (dossierId));
        List<Long> ids = traitementDtos.stream ().map (TraitementDto::getMedicamentId).collect(Collectors.toList());
        List<MedicamentDto> medicaments=this.storeManagementClientService.getMedicamentsByIds (ids);
        traitementDtos.forEach (traitementDto -> {
            MedicamentDto medicamentDto = medicaments.stream ().filter (medicamentDto1 -> medicamentDto1.getId () == traitementDto.getMedicamentId ()).findFirst().orElseThrow ();
            traitementDto.setMedicamentDosage (medicamentDto.getDosage ());
            traitementDto.setMedicamentName (medicamentDto.getName ());
            traitementDto.setMedicamentPrice (medicamentDto.getPrice ());
        });
        return traitementDtos;
    }
}
