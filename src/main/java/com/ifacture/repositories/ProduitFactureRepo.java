package com.ifacture.repositories;

import com.ifacture.beans.ProduitFacture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ProduitFactureRepo extends JpaRepository<ProduitFacture, Long> {
    ProduitFacture findById(Long id);
}
