package com.unifacisa.rest.atividade1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unifacisa.rest.atividade1.domain.Piece;

public interface PieceRepository extends JpaRepository <Piece, String>
{
}
