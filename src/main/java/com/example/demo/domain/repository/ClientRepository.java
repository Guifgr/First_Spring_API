package com.example.demo.domain.repository;

import com.example.demo.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>  {
    List<Client> findByName(String name);
    List<Client> findByNameContaining(String name);
    Client findByEmail(String email);
}
