package tn.iit.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import tn.iit.dto.PatientDto;
import tn.iit.service.PatientService;

import javax.validation.Valid;
import java.util.Collection;

@CrossOrigin("*")
@RequestMapping(value = "/patients")
@RestController()
public class PatientController {

    private final PatientService patientService;
    private final Logger logger= LoggerFactory.getLogger (PatientController.class);

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("{id}")
    public PatientDto findOne(@PathVariable("id") long id) {
        this.logger.debug ("Get Patient {}",id);
        return this.patientService.findOne (id);
    }

    @GetMapping
    public Collection<PatientDto> findAll(){
        this.logger.debug ("Get all patients");
        return this.patientService.findAll ();
    }

    @PostMapping
    public PatientDto add(@Valid @RequestBody PatientDto patientDto){
        this.logger.debug ("Add new Patient {}",patientDto);
        return this.patientService.save (patientDto);
    }

    @PutMapping
    public PatientDto update(@Valid @RequestBody PatientDto patientDto){
        this.logger.debug ("Updating Patient {}",patientDto.getId ());
        return this.patientService.save (patientDto);

    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") long id){
        this.logger.debug ("Delete Patient {}",id);
        this.patientService.deleteById (id);
    }
}
