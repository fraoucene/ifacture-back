package com.ifacture.repositories;

import com.ifacture.beans.Pays;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface PaysRepo extends JpaRepository<Pays, String> {
    Pays findById(String id);
}
