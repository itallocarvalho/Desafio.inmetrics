package com.jessila.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jessila.services.AtividadeServices;

@RestController
@RequestMapping("atividades")
public class AtividadeController {

	@Autowired
	private AtividadeServices atividadeService;

	@GetMapping("/listarConcluidas")
	public ResponseEntity<?> listarAtividadesCompletadas(){
		try {
			return ResponseEntity.ok(this.atividadeService.listarAtividadesCompletadas());
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Erro ao listar as atividades: " + e.getMessage());
		}
	}
}
