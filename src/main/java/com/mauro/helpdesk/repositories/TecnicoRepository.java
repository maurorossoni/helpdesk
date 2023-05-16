package com.mauro.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mauro.helpdesk.domain.Tecnico;

public interface TecnicoRepository extends JpaRepository<Tecnico, Integer> {

}
