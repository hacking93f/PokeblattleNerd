package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Utente;
import com.example.demo.repository.UtentiRepository;

@Service
public class UtenteServiceImpl implements UtentiService {
	
	@Autowired
	UtentiRepository ur;
	

	@Override
	public Utente getUtente(String nome) {
		// TODO Auto-generated method stub
		
		Utente u = ur.getReferenceById(nome);
		return u;
	}

	@Override
	public void salvaUtente(Utente u) {
		// TODO Auto-generated method stub
		ur.save(u);
		
	}

	@Override
	public String getMail(String name) {
		// TODO Auto-generated method stub
		Utente u = ur.getReferenceById(name);
		String mail = u.getEmail();
		return mail;
	}

}
