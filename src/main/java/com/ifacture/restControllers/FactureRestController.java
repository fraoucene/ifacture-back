package com.ifacture.restControllers;

import com.ifacture.beans.Facture;
import com.ifacture.outils.Other;
import com.ifacture.repositories.FactureRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.Collection;

@RestController
@RequestMapping("/api/factures")
public class FactureRestController {

    private FactureRepo repository;

    @Inject
    public void setRepository(FactureRepo repository) {
        this.repository = repository;
    }

    @RequestMapping(
            method = RequestMethod.POST)
    public ResponseEntity<?> addFacture(/*@RequestBody Facture facture*/) {
        return new ResponseEntity<>(repository.save(Other.mockFrature()), HttpStatus.CREATED);
    }

    @RequestMapping(
            method = RequestMethod.GET)
    public ResponseEntity<Collection<Facture>> getAllFactures() {
        return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.GET)
    public ResponseEntity<Facture> getFactureWithId(@PathVariable Long id) {
        return new ResponseEntity<>(repository.findOne(id), HttpStatus.OK);
    }

    @RequestMapping(
            params = {"id"},
            method = RequestMethod.GET)
    public ResponseEntity<Facture> findFactureWithId(@RequestParam(value = "id") Long id) {
        return new ResponseEntity<>(repository.findById(id), HttpStatus.OK);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.PUT)
    public ResponseEntity<Facture> updateFactureFromDB(@PathVariable("id") Long id, @RequestBody Facture facture) {

        Facture currentFacture = repository.findOne(id);
        currentFacture.setDateFacturation(facture.getDateFacturation());
        currentFacture.setDelaiPaiement(facture.getDelaiPaiement());
        currentFacture.setTypeFacture(facture.getTypeFacture());
        currentFacture.setDevis(facture.getDevis());
        currentFacture.setLangue(facture.getLangue());
        currentFacture.setAvecRemise(facture.isAvecRemise());
        currentFacture.setRemise(facture.getRemise());
        currentFacture.setEnTete(facture.getEnTete());
        currentFacture.setNote(facture.getNote());
        currentFacture.setStatus(facture.getStatus());
        currentFacture.setDevis(facture.isDevis());

        return new ResponseEntity<>(repository.save(currentFacture), HttpStatus.OK);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.DELETE)
    public void deleteFactureWithId(@PathVariable Long id) {
        repository.delete(id);
    }

    @RequestMapping(
            method = RequestMethod.DELETE)
    public void deleteAllFacture() {
        repository.deleteAll();
    }
}
