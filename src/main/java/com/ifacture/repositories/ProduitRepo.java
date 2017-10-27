package com.ifacture.repositories;

import com.ifacture.beans.Devise;
import com.ifacture.beans.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ProduitRepo extends JpaRepository<Produit, Long> {
    Produit findById(Long id);
}
