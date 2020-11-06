package com.vtc.amelie.controller;

import com.vtc.amelie.exception.ResourceNotFoundException;
import com.vtc.amelie.model.Vehicule;
import com.vtc.amelie.model.VehiculeDTO;
import com.vtc.amelie.repository.VehiculeRepository;
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
public class VehiculeController {

    @Autowired
    private VehiculeRepository vehiculeRepository;

    @GetMapping("/vehicules")
    public List<Vehicule> getAllVehicules() {

        return vehiculeRepository.findAll();
    }

    @GetMapping("/vehicules/min")
    public List<VehiculeDTO> getAllMinVehicules() {

        return vehiculeRepository.findAllVehicules();
    }

    @GetMapping("/vehicules/{id}")
    public ResponseEntity<Vehicule> getVehiculeById(@PathVariable(value = "id") Long vehicule_id) throws ResourceNotFoundException {
        Vehicule vehicule = vehiculeRepository.findById(vehicule_id)
                .orElseThrow(() -> new ResourceNotFoundException("Vehicule inconnu sour l'id :: " + vehicule_id));

        return ResponseEntity.ok().body(vehicule);
    }

    @PostMapping("/vehicules")
    public Vehicule createVehicule(@Valid @RequestBody Vehicule vehicule) {

        return vehiculeRepository.save(vehicule);
    }

    @PutMapping("/vehicules/{id}")
    public ResponseEntity<Vehicule> updateVehicule(@PathVariable(value = "id") Long vehicule_id, @Valid @RequestBody Vehicule vehiculeDetails) throws ResourceNotFoundException {
        Vehicule vehicule = vehiculeRepository.findById(vehicule_id)
                .orElseThrow(() -> new  ResourceNotFoundException("Vehicule inconnu sous l'id :: " + vehicule_id));

        vehicule.setCouleur(vehiculeDetails.getCouleur());
        vehicule.setImmatriculation(vehiculeDetails.getImmatriculation());
        vehicule.setMarque(vehiculeDetails.getMarque());
        vehicule.setModele(vehiculeDetails.getModele());

        final Vehicule updateVehicule = vehiculeRepository.save(vehicule);
        return ResponseEntity.ok(updateVehicule);
    }

    @DeleteMapping("/vehicules/{id}")
    public Map<String, Boolean> deleteVehicule(@PathVariable(value = "id") Long vehicule_id) throws ResourceNotFoundException {
        Vehicule vehicule = vehiculeRepository.findById(vehicule_id)
                .orElseThrow(()-> new ResourceNotFoundException("Vehicules inconnu sous l'id :: " + vehicule_id));

        vehiculeRepository.delete(vehicule);

        Map<String, Boolean> response = new HashMap<>();
        response.put("supprimé", Boolean.TRUE);

        return response;
    }
}
