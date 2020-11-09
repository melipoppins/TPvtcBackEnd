package com.vtc.amelie.controller;

import com.vtc.amelie.exception.ResourceNotFoundException;
import com.vtc.amelie.model.Emprunt;
import com.vtc.amelie.model.EmpruntDTO;
import com.vtc.amelie.repository.EmpruntRepository;
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
public class EmpruntController {
    @Autowired
    private EmpruntRepository empruntRepository;

    @GetMapping("/emprunts")
    public List<Emprunt> getAllEmprunts() {

        return empruntRepository.findAll();
    }

    @GetMapping("/emprunts/{id}")
    public ResponseEntity<Emprunt> getEmpruntById(@PathVariable(value = "id") Long idEmprunt) throws ResourceNotFoundException {
        Emprunt emprunt = empruntRepository.findById(idEmprunt)
                .orElseThrow(() -> new ResourceNotFoundException("Location inconnue sous l'id :: " + idEmprunt));

        return ResponseEntity.ok().body(emprunt);
    }

    @PostMapping("/emprunts")
    public Emprunt createEmprunt(@Valid @RequestBody Emprunt emprunt) {

        return empruntRepository.save(emprunt);
    }

    @PutMapping("/emprunts/{id}")
    public ResponseEntity<Emprunt> updateEmprunt(@PathVariable(value = "id") Long idEmprunt, @Valid @RequestBody Emprunt empruntDetails) throws ResourceNotFoundException {
        Emprunt emprunt = empruntRepository.findById(idEmprunt)
                .orElseThrow(() -> new ResourceNotFoundException("Location inconnue sous l'id :: " + idEmprunt));

        emprunt.setConducteur(empruntDetails.getConducteur());
        emprunt.setVehicule(empruntDetails.getVehicule());

        final Emprunt updateEmprunt = empruntRepository.save(emprunt);

        return ResponseEntity.ok(updateEmprunt);
    }

    @DeleteMapping("/emprunts/{id}")
    public Map<String, Boolean> deleteEmprunt(@PathVariable(value = "id") Long idEmprunt) throws ResourceNotFoundException {
        Emprunt emprunt = empruntRepository.findById(idEmprunt)
                .orElseThrow(() -> new ResourceNotFoundException("Emprunt inconnu sous l'id :: " + idEmprunt));

        empruntRepository.delete(emprunt);

        Map<String, Boolean> response = new HashMap<>();
        response.put("supprimé", Boolean.TRUE);

        return response;
    }
}
