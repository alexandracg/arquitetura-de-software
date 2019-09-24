package com.unifacisa.rest.atividade1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.unifacisa.rest.atividade1.domain.Piece;
import com.unifacisa.rest.atividade1.repository.PieceRepository;

@Service
@Validated
public class PieceService 
{	@Autowired
	private PieceRepository repository;

	public Piece searchPieceById(String id)
	{	return repository.findOne(id);	
	}
	
	public List<Piece> getAllPiece()
	{	return repository.findAll();	
	}
	
	@Transactional
	public Piece registerPiece(Piece piece)
	{	return repository.save(piece);	
	}

	public PieceRepository getRepository() 
	{	return repository;
	}

	public void setRepository(PieceRepository repository)
	{	this.repository = repository;
	}
}
