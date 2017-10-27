package com.ifacture.repositories;

import com.ifacture.beans.Devise;
import com.ifacture.beans.Facture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface FactureRepo extends JpaRepository<Facture, Long> {
    Facture findById(Long id);
}
