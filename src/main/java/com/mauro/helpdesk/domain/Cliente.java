package com.mauro.helpdesk.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mauro.helpdesk.domain.enums.Perfil;

@Entity
public class Cliente extends Pessoa implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "cliente")
		private List<Chamado> chamados = new ArrayList<>();

		public Cliente() {
			super();
			addPerfils(Perfil.CLIENTE);
		}

		public Cliente(Integer id, String nome, String cpf, String email, String senha) {
			super(id, nome, cpf, email, senha);
			addPerfils(Perfil.CLIENTE);
		}

		public List<Chamado> getChamados() {
			return chamados;
		}

		public void setChamados(List<Chamado> chamados) {
			this.chamados = chamados;
		}
		
		
}
