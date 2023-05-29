package com.mauro.helpdesk.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mauro.helpdesk.domain.Tecnico;
import com.mauro.helpdesk.domain.dtos.TecnicoDTO;
import com.mauro.helpdesk.repositories.TecnicoRepository;
import com.mauro.helpdesk.services.exeptions.ObjectNotFoundExcepetion;

@Service
public class TecnicoService {

	@Autowired
	private TecnicoRepository repository;

	public Tecnico findById(Integer id) {
		Optional<Tecnico> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundExcepetion("Objeto Não Encontrado! ID:" + id));
	}

	public List<Tecnico> findAll() {
		return repository.findAll();
	}

	public Tecnico create(TecnicoDTO objDto) {
		objDto.setId(null);
		Tecnico newObj = new Tecnico(objDto);
		return repository.save(newObj);

	}

}
