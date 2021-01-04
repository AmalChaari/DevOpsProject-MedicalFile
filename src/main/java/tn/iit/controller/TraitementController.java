package tn.iit.controller;

import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import tn.iit.dto.TraitementDto;
import tn.iit.service.TraitementService;
import javax.validation.Valid;
import java.util.Collection;

@CrossOrigin("*")
@RequestMapping(value = "/traitements")
@RestController()
public class TraitementController {

    private final TraitementService traitementService;

    public TraitementController(TraitementService traitementService) {
        this.traitementService = traitementService;
    }

    @GetMapping("{id}")
    public TraitementDto findOne(@PathVariable("id") long id) {
        return this.traitementService.findOne (id);

    }

    @GetMapping
    public Collection<TraitementDto> findAll(
            @RequestParam(defaultValue = "0") int pageNo,
            @RequestParam(defaultValue = "2") int pageSize
    ) {
        return this.traitementService.findAll (PageRequest.of (pageNo,pageSize));
    }

    @PostMapping
    public TraitementDto add(@Valid @RequestBody TraitementDto traitementDto) {
        return this.traitementService.save (traitementDto);
    }

    @PutMapping
    public TraitementDto update(@Valid @RequestBody TraitementDto traitementDto) {
        return this.traitementService.save (traitementDto);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") long id) {
        this.traitementService.deleteById (id);
    }
}
