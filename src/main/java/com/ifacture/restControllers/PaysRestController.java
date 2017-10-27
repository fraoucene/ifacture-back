package com.ifacture.restControllers;

import com.ifacture.beans.Pays;
import com.ifacture.repositories.PaysRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.Collection;

@RestController
@RequestMapping("/api/pays")
public class PaysRestController {

    private PaysRepo repository;

    @Inject
    public void setRepository(PaysRepo repository) {
        this.repository = repository;
    }

    @RequestMapping(
            method = RequestMethod.POST)
    public ResponseEntity<?> addPays(@RequestBody Pays pays) {
        return new ResponseEntity<>(repository.save(pays), HttpStatus.CREATED);
    }

    @RequestMapping(
            method = RequestMethod.GET)
    public ResponseEntity<Collection<Pays>> getAllPays() {
        return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.GET)
    public ResponseEntity<Pays> getPaysWithId(@PathVariable String id) {
        return new ResponseEntity<>(repository.findOne(id), HttpStatus.OK);
    }

    @RequestMapping(
            params = {"id"},
            method = RequestMethod.GET)
    public ResponseEntity<Pays> findPaysWithId(@RequestParam(value = "id") String id) {
        return new ResponseEntity<>(repository.findById(id), HttpStatus.OK);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.PUT)
    public ResponseEntity<Pays> updatePaysFromDB(@PathVariable("id") String id, @RequestBody Pays pays) {

        Pays currentPays = repository.findOne(id);
        currentPays.setId(pays.getId());
        currentPays.setLabel(pays.getLabel());

        return new ResponseEntity<>(repository.save(currentPays), HttpStatus.OK);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.DELETE)
    public void deletePaysWithId(@PathVariable String id) {
        repository.delete(id);
    }

    @RequestMapping(
            method = RequestMethod.DELETE)
    public void deleteAllPays() {
        repository.deleteAll();
    }
}
