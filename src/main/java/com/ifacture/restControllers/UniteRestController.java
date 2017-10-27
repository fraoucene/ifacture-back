package com.ifacture.restControllers;

import com.ifacture.beans.Unite;
import com.ifacture.repositories.UniteRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.Collection;

@RestController
@RequestMapping("/api/unites")
public class UniteRestController {

    private UniteRepo repository;

    @Inject
    public void setRepository(UniteRepo repository) {
        this.repository = repository;
    }

    @RequestMapping(
            method = RequestMethod.POST)
    public ResponseEntity<?> addUnite(@RequestBody Unite unite) {
        return new ResponseEntity<>(repository.save(unite), HttpStatus.CREATED);
    }

    @RequestMapping(
            method = RequestMethod.GET)
    public ResponseEntity<Collection<Unite>> getAllUnites() {
        return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.GET)
    public ResponseEntity<Unite> getUniteWithId(@PathVariable String id) {
        return new ResponseEntity<>(repository.findOne(id), HttpStatus.OK);
    }

    @RequestMapping(
            params = {"id"},
            method = RequestMethod.GET)
    public ResponseEntity<Unite> findUniteWithId(@RequestParam(value = "id") String id) {
        return new ResponseEntity<>(repository.findById(id), HttpStatus.OK);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.PUT)
    public ResponseEntity<Unite> updateUniteFromDB(@PathVariable("id") String id, @RequestBody Unite unite) {

        Unite currentUnite = repository.findOne(id);
        currentUnite.setId((unite.getId()));
        currentUnite.setLabel(unite.getLabel());

        return new ResponseEntity<>(repository.save(currentUnite), HttpStatus.OK);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.DELETE)
    public void deleteUniteWithId(@PathVariable String id) {
        repository.delete(id);
    }

    @RequestMapping(
            method = RequestMethod.DELETE)
    public void deleteAllUnite() {
        repository.deleteAll();
    }
}
