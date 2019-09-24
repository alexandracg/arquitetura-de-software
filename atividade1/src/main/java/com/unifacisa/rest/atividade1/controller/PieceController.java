package com.unifacisa.rest.atividade1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.unifacisa.rest.atividade1.domain.Piece;
import com.unifacisa.rest.atividade1.service.PieceService;

@RestController
public class PieceController 
{	@Autowired
	private PieceService pieceService;
	
	@RequestMapping(value = "/piece", method = RequestMethod.GET)
	public ResponseEntity< List<Piece> > getAllPiece()
	{	pieceService.registerPiece(new Piece("1", "Motor", 2));
		pieceService.registerPiece(new Piece("2", "Escapamento", 5));
		pieceService.registerPiece(new Piece("3", "Pneus", 10));	
		
		List<Piece> getAllPiece = pieceService.getAllPiece();
		
		return new ResponseEntity< List<Piece> >(getAllPiece, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/piece/{id}", method = RequestMethod.GET)
	public ResponseEntity<Piece> getPiece(@PathVariable String id)
	{	Piece getPiece = pieceService.searchPieceById(id);
	
		if(getPiece == null) 
		{	return new ResponseEntity<Piece>(HttpStatus.NOT_FOUND);
		}
		else 
		{	return new ResponseEntity<Piece>(getPiece, HttpStatus.OK);	
		}
	}
	
	@RequestMapping(value = "/piece", method = RequestMethod.POST)
	public ResponseEntity<Piece> registerPiece(@RequestBody Piece piece)
	{	try
		{	Piece registerPiece = pieceService.registerPiece(piece);
			return new ResponseEntity<Piece>(registerPiece, HttpStatus.CREATED);
		}
		catch(Exception e)
		{	e.printStackTrace();
			return new ResponseEntity<Piece>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public PieceService getPieceService()
	{	return pieceService;
	}

	public void setPieceService(PieceService pieceService) 
	{	this.pieceService = pieceService;
	}
}
