package com.entrevista.repository;

import com.entrevista.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Long> {

    Client findByName(String name);
}
