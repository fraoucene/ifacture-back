package com.ifacture.restControllers;

import com.ifacture.beans.Client;
import com.ifacture.repositories.ClientRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.Collection;

@RestController
@RequestMapping("/api/clients")
public class ClientRestController {

    private ClientRepo repository;

    @Inject
    public void setRepository(ClientRepo repository) {
        this.repository = repository;
    }

    @RequestMapping(
            method = RequestMethod.POST)
    public ResponseEntity<?> addClient(@RequestBody Client client) {
        return new ResponseEntity<>(repository.save(client), HttpStatus.CREATED);
    }

    @RequestMapping(
            method = RequestMethod.GET)
    public ResponseEntity<Collection<Client>> getAllClients() {
        return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.GET)
    public ResponseEntity<Client> getClientWithId(@PathVariable Long id) {
        return new ResponseEntity<>(repository.findOne(id), HttpStatus.OK);
    }

    @RequestMapping(
            params = {"id"},
            method = RequestMethod.GET)
    public ResponseEntity<Client> findClientWithId(@RequestParam(value = "id") Long id) {
        return new ResponseEntity<>(repository.findById(id), HttpStatus.OK);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.PUT)
    public ResponseEntity<Client> updateClientFromDB(@PathVariable("id") Long id, @RequestBody Client client) {

        Client currentClient = repository.findOne(id);
        currentClient.setTitre(client.getTitre());
        currentClient.setNomEntreprise(client.getNomEntreprise());
        currentClient.setSiret(client.getSiret());
        currentClient.setParticulier(client.isParticulier());
        currentClient.setEmail(client.getEmail());
        currentClient.setLangueFacture(client.getLangueFacture());
        currentClient.setDelaiPaiement(client.getDelaiPaiement());
        currentClient.setNumTva(client.getNumTva());
        currentClient.setTva(client.getTva());
        currentClient.setNomF(client.getNomF());
        currentClient.setPrenom(client.getPrenom());
        currentClient.setAdresse(client.getAdresse());
        currentClient.setComplementAdresse(client.getComplementAdresse());
        currentClient.setCodePostale(client.getCodePostale());
        currentClient.setVille(client.getVille());
        currentClient.setPays(client.getPays());
        currentClient.setTeleFixe(client.getTeleFixe());
        currentClient.setTelePort(client.getTelePort());

        return new ResponseEntity<>(repository.save(currentClient), HttpStatus.OK);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.DELETE)
    public void deleteClientWithId(@PathVariable Long id) {
        repository.delete(id);
    }

    @RequestMapping(
            method = RequestMethod.DELETE)
    public void deleteAllClient() {
        repository.deleteAll();
    }
}
