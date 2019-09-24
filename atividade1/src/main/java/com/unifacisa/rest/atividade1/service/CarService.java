package com.unifacisa.rest.atividade1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.unifacisa.rest.atividade1.domain.Car;
import com.unifacisa.rest.atividade1.domain.Piece;
import com.unifacisa.rest.atividade1.repository.CarRepository;
import com.unifacisa.rest.atividade1.service.PieceService;


@Service
@Validated
public class CarService 
{	@Autowired
	private CarRepository repository;
	
	@Autowired
	private PieceService pieceService;

	public Car searchCarById(String id)
	{	return repository.findOne(id);
	}
	
	public List<Car> getAllCars() 
	{	return repository.findAll();	
	}
	
	@Transactional
	public Car registerCar(Car car) throws Exception 
	{	Piece piece = pieceService.searchPieceById(car.getPieceId());
		
		if(piece != null && piece.getAmount() > 0)
		{	return repository.save(car);
		}
		else 
		{	throw new Exception("Erro");
		}
	}

	public CarRepository getRepository() 
	{	return repository;
	}

	public void setRepository(CarRepository repository)
	{	this.repository = repository;
	}	
}
