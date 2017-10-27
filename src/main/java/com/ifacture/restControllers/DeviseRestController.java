package com.ifacture.restControllers;

import com.ifacture.beans.Devise;
import com.ifacture.repositories.DeviseRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.Collection;

@RestController
@RequestMapping("/api/devises")
public class DeviseRestController {

    private DeviseRepo repository;

    @Inject
    public void setRepository(DeviseRepo repository) {
        this.repository = repository;
    }

    @RequestMapping(
            method = RequestMethod.POST)
    public ResponseEntity<?> addDevise(@RequestBody Devise devise) {
        return new ResponseEntity<>(repository.save(devise), HttpStatus.CREATED);
    }

    @RequestMapping(
            method = RequestMethod.GET)
    public ResponseEntity<Collection<Devise>> getAllDevises() {
        return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.GET)
    public ResponseEntity<Devise> getDeviseWithId(@PathVariable String id) {
        return new ResponseEntity<>(repository.findOne(id), HttpStatus.OK);
    }

    @RequestMapping(
            params = {"id"},
            method = RequestMethod.GET)
    public ResponseEntity<Devise> findDeviseWithId(@RequestParam(value = "id") String id) {
        return new ResponseEntity<>(repository.findById(id), HttpStatus.OK);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.PUT)
    public ResponseEntity<Devise> updateDeviseFromDB(@PathVariable("id") String id, @RequestBody Devise devise) {

        Devise currentDevise = repository.findOne(id);
        currentDevise.setId(devise.getId());
        currentDevise.setLabel(devise.getLabel());

        return new ResponseEntity<>(repository.save(currentDevise), HttpStatus.OK);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.DELETE)
    public void deleteDeviseWithId(@PathVariable String id) {
        repository.delete(id);
    }

    @RequestMapping(
            method = RequestMethod.DELETE)
    public void deleteAllDevise() {
        repository.deleteAll();
    }
}
