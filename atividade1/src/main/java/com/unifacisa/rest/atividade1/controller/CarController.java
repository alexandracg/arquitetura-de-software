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

import com.unifacisa.rest.atividade1.domain.Car;
import com.unifacisa.rest.atividade1.service.CarService;

@RestController
public class CarController
{	@Autowired
	private CarService carService;
	
	@RequestMapping(value = "/car", method = RequestMethod.GET)
	public ResponseEntity< List<Car> > listCars() throws Exception
	{	
		List<Car> listCar = carService.getAllCars();
		
		return new ResponseEntity< List<Car> >(listCar, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/car/{id}", method = RequestMethod.GET)
	public ResponseEntity< Car > getCar(@PathVariable String id)
	{	Car car = carService.searchCarById(id);
		
		if(car == null)
		{	return new ResponseEntity<Car>(HttpStatus.NOT_FOUND);
		}
		else
		{	return new ResponseEntity<Car>(car, HttpStatus.OK);
		}
	}
	
	@RequestMapping(value = "/car", method = RequestMethod.POST)
	public ResponseEntity<Car> registerCar(@RequestBody Car car)
	{	try 
		{	Car registerCar = carService.registerCar(car);
		
			return new ResponseEntity<Car>(registerCar, HttpStatus.CREATED);
		}
		catch(Exception e)
		{	e.printStackTrace();
			return new ResponseEntity<Car>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public CarService getCarService() 
	{	return carService;
	}

	public void setCarService(CarService carService) 
	{	this.carService = carService;
	}
}
