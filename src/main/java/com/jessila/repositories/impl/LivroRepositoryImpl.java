package com.jessila.repositories.impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONObject;
import org.springframework.stereotype.Repository;

import com.jessila.model.Livro;
import com.jessila.repositories.LivroRepository;

@Repository
public class LivroRepositoryImpl implements LivroRepository {

	@Override
	public boolean inserir(Livro livro) {


		try {

			URL url = new URL("http://fakerestapi.azurewebsites.net/api/Books");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");

			JSONObject json = new JSONObject();
			json.put("ID", livro.getId());
			json.put("Title", livro.getTitle());
			json.put("Description", livro.getDescription());
			json.put("PageCount", livro.getPageCount());
			json.put("Excerpt", livro.getExcerpt());
			json.put("PublishDate", livro.getPublishDate());

			String input = json.toString();

			OutputStream os = conn.getOutputStream();
			os.write(input.getBytes());
			os.flush();

			if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
				throw new RuntimeException("Falha : HTTP error code : " + conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(
					conn.getInputStream()));

			String output;
			while ((output = br.readLine()) != null) {
				System.out.println("Log: Livro inserido com sucesso!");
				System.out.println(output);
			}

			conn.disconnect();

			return true;
		}catch (MalformedURLException e) {
			e.printStackTrace();
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

}
