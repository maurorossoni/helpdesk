package com.mauro.helpdesk.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mauro.helpdesk.domain.Tecnico;
import com.mauro.helpdesk.domain.dtos.TecnicoDTO;
import com.mauro.helpdesk.services.tecnicoService;

@RestController
@RequestMapping(value ="/tecnicos")
public class TecnicoResource {
	
	@Autowired 
	private tecnicoService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<TecnicoDTO> findById(@PathVariable Integer id){
		Tecnico obj = service.findById(id);
		return ResponseEntity.ok(new TecnicoDTO(obj));
			}

}