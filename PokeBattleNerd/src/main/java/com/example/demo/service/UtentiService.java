package com.example.demo.service;

import com.example.demo.model.Utente;

public interface UtentiService {
	
	public Utente getUtente(String nome);
	public void salvaUtente(Utente u);
	public String getMail(String name);

}
