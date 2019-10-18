package com.jessila.repositories.impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collection;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jessila.model.Atividade;
import com.jessila.repositories.AtividadeRepository;

@Repository
public class AtividadeRepositoryImpl implements AtividadeRepository {

	@Override
	public List<Atividade> listarAtividadesCompletadas() {

		try {
			URL url = new URL("https://jsonplaceholder.typicode.com/todos");

			HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			if(conn.getResponseCode() != 200) {
				throw new RuntimeException("Falha : HTTP error code : " + conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

			String output;
			String json = "";

			while ((output = br.readLine()) != null) {
				json += output;
			}
			Collection<Atividade> atividades = new ObjectMapper().readValue(json, new TypeReference<Collection<Atividade>>() { });

			conn.disconnect();

			return (List<Atividade>)atividades;

		}  catch (MalformedURLException e) {
			e.printStackTrace();
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
