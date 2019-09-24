package com.unifacisa.rest.atividade1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unifacisa.rest.atividade1.domain.Car;

public interface CarRepository extends JpaRepository<Car, String>
{
}
