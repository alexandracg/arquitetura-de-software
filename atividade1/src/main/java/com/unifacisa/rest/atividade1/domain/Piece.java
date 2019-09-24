package com.unifacisa.rest.atividade1.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Piece implements Serializable 
{	private static final long serialVersionUID = -3190198559865287025L;
	
	@Id
	private String id;
	private String name;
	private int amount;
	
	public Piece()
	{	
	}
	
	public Piece(String id, String name, int amount) 
	{	this.id = id;
		this.name = name;
		this.amount = amount;
	}
	
	public String getId() 
	{	return id;
	}
	public void setId(String id) 
	{	this.id = id;
	}
	public String getName() 
	{	return name;
	}
	public void setName(String name) 
	{	this.name = name;
	}
	public int getAmount() 
	{	return amount;
	}
	public void setAmount(int amount)
	{	this.amount = amount;
	}
}
