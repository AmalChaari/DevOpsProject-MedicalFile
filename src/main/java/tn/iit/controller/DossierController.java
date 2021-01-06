package tn.iit.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import tn.iit.dto.DossierDto;
import tn.iit.entity.Dossier;
import tn.iit.mapper.PatientMapper;
import tn.iit.service.DossierService;
import tn.iit.service.PatientService;

import javax.validation.Valid;
import java.util.Collection;

@CrossOrigin("*")
@RequestMapping(value = "/dossiers")
@RestController()
public class DossierController {

    private final DossierService dossierService;
    private final PatientService patientService;
    private final Logger logger= LoggerFactory.getLogger (DossierController.class);

    public DossierController(DossierService dossierService, PatientService patientService) {
        this.dossierService = dossierService;
        this.patientService = patientService;
    }

    @GetMapping("{id}")
    public DossierDto findOne(@PathVariable("id") long id) {
        this.logger.debug ("Get Dossier {}",id);
        return this.dossierService.findOne (id);
    }

    @GetMapping
    public Collection<DossierDto> findAll(){
        this.logger.debug ("Get all dossiers");
        return this.dossierService.findAll ();
    }

    @PostMapping
    public DossierDto add(@Valid @RequestBody DossierDto dossierDto){
        this.logger.debug ("Add new Dossier {}",dossierDto);
        Dossier dossier = new Dossier (PatientMapper.patientDtoToPatient (this.patientService.findOne (dossierDto.getPatientId ())));
        return this.dossierService.save (dossierDto);
    }

    @PutMapping
    public DossierDto update(@RequestBody DossierDto dossierDto){
        this.logger.debug ("Update Dossier {} ",dossierDto.getId () );
        return this.dossierService.save (dossierDto);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") long id){
        this.logger.debug ("Delete Dossier {}",id);
        this.dossierService.deleteById (id);
    }
}
