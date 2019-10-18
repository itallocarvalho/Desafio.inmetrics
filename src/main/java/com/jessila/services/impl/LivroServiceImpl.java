package com.jessila.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jessila.model.Livro;
import com.jessila.repositories.LivroRepository;
import com.jessila.services.LivroService;

@Service
public class LivroServiceImpl implements LivroService {

	@Autowired
	private LivroRepository livroRepository;

	@Override
	public boolean inserir(Livro livro) {
		return this.livroRepository.inserir(livro);
	}

}
