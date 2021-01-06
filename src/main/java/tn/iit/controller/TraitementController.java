package tn.iit.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private final Logger logger = LoggerFactory.getLogger (TraitementController.class);

    public TraitementController(TraitementService traitementService) {
        this.traitementService = traitementService;
    }

    @GetMapping("{id}")
    public TraitementDto findOne(@PathVariable("id") long id) {
        this.logger.debug ("Get Traitement {}", id);
        return this.traitementService.findOne (id);

    }

    @GetMapping
    public Collection<TraitementDto> findAll(
            @RequestParam(defaultValue = "0") int pageNo,
            @RequestParam(defaultValue = "2") int pageSize
    ) {
        this.logger.debug ("Gett all traitements");
        return this.traitementService.findAll (PageRequest.of (pageNo,pageSize));
    }

    @PostMapping
    public TraitementDto add(@Valid @RequestBody TraitementDto traitementDto) {
        this.logger.debug ("Add new Traitement {}", traitementDto);
        return this.traitementService.save (traitementDto);
    }

    @PutMapping
    public TraitementDto update(@Valid @RequestBody TraitementDto traitementDto) {
        this.logger.debug ("Update Traitement {}", traitementDto.getId ());
        return this.traitementService.save (traitementDto);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") long id) {
        this.logger.debug ("Delete Traitement {}", id);
        this.traitementService.deleteById (id);
    }
}
