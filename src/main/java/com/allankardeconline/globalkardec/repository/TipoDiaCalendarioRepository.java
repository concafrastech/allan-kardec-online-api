package com.allankardeconline.globalkardec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.allankardeconline.globalkardec.model.categoricos.TipoDiaCalendario;

public interface TipoDiaCalendarioRepository
		extends JpaRepository<TipoDiaCalendario, Long> {

}
