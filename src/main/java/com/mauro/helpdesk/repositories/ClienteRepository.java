package com.mauro.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mauro.helpdesk.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
