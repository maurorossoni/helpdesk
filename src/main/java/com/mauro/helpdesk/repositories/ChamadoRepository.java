package com.mauro.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mauro.helpdesk.domain.Chamado;

public interface ChamadoRepository extends JpaRepository<Chamado, Integer> {

}
