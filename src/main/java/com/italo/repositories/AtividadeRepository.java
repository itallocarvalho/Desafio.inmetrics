package com.italo.repositories;

import java.util.List;

import com.italo.model.Atividade;

public interface AtividadeRepository {

	public List<Atividade> listarAtividadesCompletadas();
}
