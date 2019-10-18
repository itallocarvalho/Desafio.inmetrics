package com.italo.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.italo.model.Livro;
import com.italo.repositories.LivroRepository;
import com.italo.services.LivroService;

@Service
public class LivroServiceImpl implements LivroService {

	@Autowired
	private LivroRepository livroRepository;

	@Override
	public boolean inserir(Livro livro) {
		return this.livroRepository.inserir(livro);
	}

}
