package com.jessila.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jessila.model.Livro;
import com.jessila.services.LivroService;

@RestController
@RequestMapping("livro")
public class LivroController {

	@Autowired
	private LivroService livroService;

	@PostMapping("/cadastrar")
	public ResponseEntity<?> Inserir(@RequestBody Livro livro){
		try {

			if(null == livro) {
				return ResponseEntity.badRequest().body("Por favor, informe os dados do livro");
			}

			if(this.livroService.inserir(livro)) {
				return ResponseEntity.ok("Livro cadastrado com sucesso.");
			}else {
				return ResponseEntity.badRequest().body("Ocorreu um erro ao cadastrar novo livro.");
			}

		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Erro ao cadastrar novo livro: " + e.getMessage());
		}
	}
}
