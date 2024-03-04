package com.allankardeconline.globalkardec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.allankardeconline.globalkardec.model.ConfiguracaoGlobalKardec;

public interface ConfiguracaoGlobalKardecRepository
		extends JpaRepository<ConfiguracaoGlobalKardec, Long> {

	ConfiguracaoGlobalKardec findFirstByOrderByIdAsc();

}
