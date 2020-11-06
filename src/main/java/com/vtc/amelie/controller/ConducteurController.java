package com.vtc.amelie.controller;

import com.vtc.amelie.exception.ResourceNotFoundException;
import com.vtc.amelie.model.Conducteur;
import com.vtc.amelie.model.ConducteurDTO;
import com.vtc.amelie.repository.ConducteurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class ConducteurController {
    @Autowired
    private ConducteurRepository conducteurRepository;

    @GetMapping("/conducteurs")
    public List<Conducteur> getAllConducteurs() {

        return conducteurRepository.findAll();
    }

    @GetMapping("/conducteurs/min")
    public List<ConducteurDTO> getAllMinConducteurs() {

        return conducteurRepository.findAllConducteurs();
    }

    @GetMapping("/conducteurs/{id}")
    public ResponseEntity<Conducteur> getConducteurById(@PathVariable(value = "id") Long conducteur_id) throws ResourceNotFoundException {
        Conducteur conducteur = conducteurRepository.findById(conducteur_id)
                .orElseThrow(() -> new ResourceNotFoundException("Conducteur inconnu sous l'id :: " + conducteur_id));

        return ResponseEntity.ok().body(conducteur);
    }

    @PostMapping("/conducteurs")
    public Conducteur createConducteur(@Valid @RequestBody Conducteur conducteur) {

        return conducteurRepository.save(conducteur);
    }

    @PutMapping("/conducteurs/{id}")
    public ResponseEntity<Conducteur> updateConducteur(@PathVariable(value = "id") Long conducteur_id, @Valid @RequestBody Conducteur conducteurDetails) throws ResourceNotFoundException {
        Conducteur conducteur = conducteurRepository.findById(conducteur_id)
                .orElseThrow(() -> new ResourceNotFoundException("Conducteur inconnu sous l'id :: " + conducteur_id));

        conducteur.setNom(conducteurDetails.getNom());
        conducteur.setPrenom(conducteurDetails.getPrenom());

        final Conducteur updateConducteur = conducteurRepository.save(conducteur);

        return ResponseEntity.ok(updateConducteur);
    }

    @DeleteMapping("/conducteurs/{id}")
    public Map<String, Boolean> deleteConducteur(@PathVariable(value = "id") Long conducteur_id) throws ResourceNotFoundException {
        Conducteur conducteur = conducteurRepository.findById(conducteur_id)
                .orElseThrow(() -> new ResourceNotFoundException("Conducteur inconnu sous l'id :: " + conducteur_id));

        conducteurRepository.delete(conducteur);

        Map<String, Boolean> response = new HashMap<>();
        response.put("supprimé", Boolean.TRUE);

        return response;
    }
}
