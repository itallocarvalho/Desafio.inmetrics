package com.jessila.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jessila.model.Atividade;
import com.jessila.repositories.AtividadeRepository;
import com.jessila.services.AtividadeServices;

@Service
public class AtividadeServicesImpl implements AtividadeServices{

	@Autowired
	private AtividadeRepository atividadeRepository;

	@Override
	public List<Atividade> listarAtividadesCompletadas() {

		List<Atividade> atividades = this.atividadeRepository.listarAtividadesCompletadas();
		List<Atividade> atividadesCompletadas = new ArrayList<Atividade>();

		for (Atividade atividade : atividades) {
			if(atividade.completed) {
				atividadesCompletadas.add(atividade);
			}
		}

		return atividadesCompletadas;
	}


}
