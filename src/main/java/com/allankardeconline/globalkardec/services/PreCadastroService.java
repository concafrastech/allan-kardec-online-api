package com.allankardeconline.globalkardec.services;

import java.util.Date;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.allankardeconline.globalkardec.dto.PreCadastroDTO;
import com.allankardeconline.globalkardec.mapper.DozerMapper;
import com.allankardeconline.globalkardec.model.PreCadastro;
import com.allankardeconline.globalkardec.repository.PreCadastroRepository;

@Service
public class PreCadastroService {

	private Logger log = Logger.getLogger(PreCadastroService.class.getName());

	@Autowired
	PreCadastroRepository repository;

	public PreCadastroDTO inserir(PreCadastroDTO dto) {

		var entity = DozerMapper.parseObject(dto, PreCadastro.class);
		entity.setDataInclusao(new Date());

		var vo = DozerMapper.parseObject(repository.save(entity),
				PreCadastroDTO.class);

		return vo;

	}

}
