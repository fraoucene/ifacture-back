package com.ifacture.repositories;

import com.ifacture.beans.Unite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface UniteRepo extends JpaRepository<Unite, String> {
    Unite findById(String id);
}
