package com.ifacture.restControllers;

import com.ifacture.beans.Produit;
import com.ifacture.repositories.ProduitRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.Collection;

@RestController
@RequestMapping("/api/produits")
public class ProduitRestController {

    private ProduitRepo repository;

    @Inject
    public void setRepository(ProduitRepo repository) {
        this.repository = repository;
    }

    @RequestMapping(
            method = RequestMethod.POST)
    public ResponseEntity<?> addProduit(@RequestBody Produit produit) {
        return new ResponseEntity<>(repository.save(produit), HttpStatus.CREATED);
    }

    @RequestMapping(
            method = RequestMethod.GET)
    public ResponseEntity<Collection<Produit>> getAllProduits() {
        return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.GET)
    public ResponseEntity<Produit> getProduitWithId(@PathVariable Long id) {
        return new ResponseEntity<>(repository.findOne(id), HttpStatus.OK);
    }

    @RequestMapping(
            params = {"id"},
            method = RequestMethod.GET)
    public ResponseEntity<Produit> findProduitWithId(@RequestParam(value = "id") Long id) {
        return new ResponseEntity<>(repository.findById(id), HttpStatus.OK);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.PUT)
    public ResponseEntity<Produit> updateProduitFromDB(@PathVariable("id") Long id, @RequestBody Produit produit) {

        Produit currentProduit = repository.findOne(id);
        currentProduit.setNom(produit.getNom());
        currentProduit.setDescription(produit.getDescription());
        currentProduit.setPrix(produit.getPrix());
        currentProduit.setTva(produit.getTva());
        currentProduit.setTarif(produit.getTarif());
        currentProduit.setUnite(produit.getUnite());

        return new ResponseEntity<>(repository.save(currentProduit), HttpStatus.OK);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.DELETE)
    public void deleteProduitWithId(@PathVariable Long id) {
        repository.delete(id);
    }

    @RequestMapping(
            method = RequestMethod.DELETE)
    public void deleteAllProduit() {
        repository.deleteAll();
    }
}
