package com.unifacisa.rest.atividade1.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Car implements Serializable
{	private static final long serialVersionUID = -4031629150447131583L;
	
	@Id
	private String id;
	private String carModel;
	private String ownerName;
	private String pieceId;
	
	public Car()
	{	
	}
	
	public Car(String id, String model, String owner, String piece)
	{	this.id = id;
		this.carModel = model;
		this.ownerName = owner;
		this.pieceId = piece;
	}
	
	public String getId() 
	{	return id;
	}
	public void setId(String id) 
	{	this.id = id;
	}
	public String getCarModel() 
	{	return carModel;
	}
	public void setCarModel(String carModel) 
	{	this.carModel = carModel;
	}
	public String getOwnerName() 
	{	return ownerName;
	}
	public void setOwnerName(String ownerName) 
	{	this.ownerName = ownerName;
	}
	public String getPieceId()
	{	return pieceId;
	}
	public void setPieceId(String piece)
	{	this.pieceId = piece;
	}
}

