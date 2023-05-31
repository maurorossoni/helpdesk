package com.mauro.helpdesk.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.mauro.helpdesk.domain.Pessoa;
import com.mauro.helpdesk.domain.Cliente;
import com.mauro.helpdesk.domain.dtos.ClienteDTO;
import com.mauro.helpdesk.repositories.PessoaRepository;
import com.mauro.helpdesk.repositories.ClienteRepository;
import com.mauro.helpdesk.services.exeptions.DataIntegrityViolationException;
import com.mauro.helpdesk.services.exeptions.ObjectNotFoundExcepetion;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repository;
	@Autowired
	private PessoaRepository pessoaRepository;
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	
	public Cliente findById(Integer id) {
		Optional<Cliente> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundExcepetion("Objeto Não Encontrado! ID:" + id));
	}

	public List<Cliente> findAll() {
		return repository.findAll();
	}

	public Cliente create(ClienteDTO objDto) {
		objDto.setId(null);
		objDto.setSenha(encoder.encode(objDto.getSenha()));
		validaPorCpfEEmail(objDto);
		Cliente newObj = new Cliente(objDto);
		return repository.save(newObj);

	}

	public Cliente update(Integer id, @Valid ClienteDTO objDto) {
		objDto.setId(id);
		Cliente oldObj = findById(id);
		validaPorCpfEEmail(objDto);
		oldObj = new Cliente(objDto);
		return repository.save(oldObj);
	}

	public void delete(Integer id) {
		Cliente obj = findById(id);
		if (obj.getChamados().size() > 0) {
			throw new DataIntegrityViolationException(
					"Cliente possui ORDEM DE SERVIÇOS atreladas e NÃO PODE SER DELETADO! ");
		}
		repository.deleteById(id);
	}

	private void validaPorCpfEEmail(ClienteDTO objDto) {
		Optional<Pessoa> obj = pessoaRepository.findByCpf(objDto.getCpf());
		if (obj.isPresent() && obj.get().getId() != objDto.getId()) {
			throw new DataIntegrityViolationException("CPF Já cadastrado no sistema!");
		}

		obj = pessoaRepository.findByEmail(objDto.getEmail());
		if (obj.isPresent() && obj.get().getId() != objDto.getId()) {
			throw new DataIntegrityViolationException("E-mail Já cadastrado no sistema!");
		}
	}

}
