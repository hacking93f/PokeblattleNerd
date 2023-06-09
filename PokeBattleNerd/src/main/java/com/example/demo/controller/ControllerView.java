package com.example.demo.controller;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.repository.UtentiRepository;

@Controller
public class ControllerView {
	
	static final String pokemon = "pikachu";
	@Autowired
	UtentiRepository ur;

	@RequestMapping(value="/" , method = RequestMethod.GET)
	public ModelAndView home() throws IOException, InterruptedException {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("home");
		
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create("https://pokeapi.co/api/v2/pokemon/pikachu/"))
				.method("GET", HttpRequest.BodyPublishers.noBody())
				.build();
		HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
		
		
		JSONObject jo = new JSONObject(response.body());
	
		System.out.println(jo.getJSONObject("sprites"));
		
		JSONObject js = jo.getJSONObject("sprites");
		
		System.out.println(js.get("front_default"));
	
		mav.addObject("immagine", js.get("front_default"));
	
		return mav;
	}
}
