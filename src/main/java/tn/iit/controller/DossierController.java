package tn.iit.controller;

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

    public DossierController(DossierService dossierService, PatientService patientService) {
        this.dossierService = dossierService;
        this.patientService = patientService;
    }

    @GetMapping("{id}")
    public DossierDto findOne(@PathVariable("id") long id) {
        return this.dossierService.findOne (id);
    }

    @GetMapping
    public Collection<DossierDto> findAll(){
        return this.dossierService.findAll ();
    }

    @PostMapping
    public DossierDto add(@Valid @RequestBody DossierDto dossierDto){
        Dossier dossier = new Dossier (PatientMapper.patientDtoToPatient (this.patientService.findOne (dossierDto.getPatientId ())));
        return this.dossierService.save (dossierDto);
    }

    @PutMapping
    public DossierDto update(@RequestBody DossierDto dossierDto){
        return this.dossierService.save (dossierDto);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") long id){
        this.dossierService.deleteById (id);
    }
}
