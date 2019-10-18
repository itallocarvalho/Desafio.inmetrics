package com.jessila.repositories;

import java.util.List;

import com.jessila.model.Atividade;

public interface AtividadeRepository {

	public List<Atividade> listarAtividadesCompletadas();
}
