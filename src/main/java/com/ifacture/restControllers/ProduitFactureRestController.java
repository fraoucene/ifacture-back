package com.ifacture.restControllers;

import com.ifacture.beans.Produit;
import com.ifacture.beans.ProduitFacture;
import com.ifacture.outils.Other;
import com.ifacture.repositories.ProduitFactureRepo;
import com.ifacture.repositories.ProduitRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.Collection;

@RestController
@RequestMapping("/api/facture/produits")
public class ProduitFactureRestController {

    private ProduitFactureRepo repository;

    @Inject
    public void setRepository(ProduitFactureRepo repository) {
        this.repository = repository;
    }

    @RequestMapping(
            method = RequestMethod.POST)
    public ResponseEntity<?> addProduit(/*@RequestBody ProduitFacture produitFacture*/) {
        return new ResponseEntity<>(repository.save(Other.mockProduitFrature()), HttpStatus.CREATED);
    }

    @RequestMapping(
            method = RequestMethod.GET)
    public ResponseEntity<Collection<ProduitFacture>> getAllProduits() {
        return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.GET)
    public ResponseEntity<ProduitFacture> getProduitWithId(@PathVariable Long id) {
        return new ResponseEntity<>(repository.findOne(id), HttpStatus.OK);
    }

    @RequestMapping(
            params = {"id"},
            method = RequestMethod.GET)
    public ResponseEntity<ProduitFacture> findProduitWithId(@RequestParam(value = "id") Long id) {
        return new ResponseEntity<>(repository.findById(id), HttpStatus.OK);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.PUT)
    public ResponseEntity<ProduitFacture> updateProduitFromDB(@PathVariable("id") Long id, @RequestBody ProduitFacture produitFacture) {

        ProduitFacture currentProduit = repository.findOne(id);
        currentProduit.setNom(produitFacture.getNom());
        currentProduit.setDescription(produitFacture.getDescription());
        currentProduit.setPrix(produitFacture.getPrix());
        currentProduit.setTva(produitFacture.getTva());
        currentProduit.setTarif(produitFacture.getTarif());
        currentProduit.setUnite(produitFacture.getUnite());
        currentProduit.setDate(produitFacture.getDate());
        currentProduit.setQuantite(produitFacture.getQuantite());


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
