package com.mauro.helpdesk;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mauro.helpdesk.domain.Chamado;
import com.mauro.helpdesk.domain.Cliente;
import com.mauro.helpdesk.domain.Tecnico;
import com.mauro.helpdesk.domain.enums.Perfil;
import com.mauro.helpdesk.domain.enums.Prioridade;
import com.mauro.helpdesk.domain.enums.Status;
import com.mauro.helpdesk.repositories.ChamadoRepository;
import com.mauro.helpdesk.repositories.ClienteRepository;
import com.mauro.helpdesk.repositories.TecnicoRepository;

@SpringBootApplication
public class HelpdeskApplication implements CommandLineRunner{

	@Autowired
	private TecnicoRepository tecnicoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private ChamadoRepository chamadoRepository;
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(HelpdeskApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Tecnico tec1 = new Tecnico(null, "Valdir cezar", "10115130993", "valadir@gmail.com", "123");
		tec1.addPerfils(Perfil.ADMIN);
		
		Cliente clie1 = new Cliente(null, "Videira" , "10115130992", "Videira@gmail.com", "123");
		
		Chamado c1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 01", "Primeiro Chamado", tec1, clie1);
		
		
		tecnicoRepository.saveAll(Arrays.asList(tec1));
		clienteRepository.saveAll(Arrays.asList(clie1));
		chamadoRepository.saveAll(Arrays.asList(c1));
		
	}

}
