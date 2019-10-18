package com.italo.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.italo.model.Atividade;
import com.italo.repositories.AtividadeRepository;
import com.italo.services.AtividadeServices;

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
