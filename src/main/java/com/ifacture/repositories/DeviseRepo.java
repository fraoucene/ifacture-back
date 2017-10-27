package com.ifacture.repositories;

import com.ifacture.beans.Devise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface DeviseRepo extends JpaRepository<Devise, String> {
    Devise findById(String id);
}
