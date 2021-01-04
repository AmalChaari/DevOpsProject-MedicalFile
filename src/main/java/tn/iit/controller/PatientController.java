package tn.iit.controller;

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

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("{id}")
    public PatientDto findOne(@PathVariable("id") long id) {
        return this.patientService.findOne (id);
    }

    @GetMapping
    public Collection<PatientDto> findAll(){
        return this.patientService.findAll ();
    }

    @PostMapping
    public PatientDto add(@Valid @RequestBody PatientDto patientDto){
        return this.patientService.save (patientDto);
    }

    @PutMapping
    public PatientDto update(@Valid @RequestBody PatientDto patientDto){
        return this.patientService.save (patientDto);

    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") long id){
        this.patientService.deleteById (id);
    }
}
