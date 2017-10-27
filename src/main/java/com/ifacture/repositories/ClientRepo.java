package com.ifacture.repositories;

import com.ifacture.beans.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ClientRepo extends JpaRepository<Client, Long> {
    Client findById(Long id);
}
