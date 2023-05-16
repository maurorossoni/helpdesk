package com.mauro.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mauro.helpdesk.domain.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {

}
