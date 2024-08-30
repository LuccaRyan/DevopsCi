package com.example.dbpicpay.repository;

import com.example.dbpicpay.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, String> {

}
