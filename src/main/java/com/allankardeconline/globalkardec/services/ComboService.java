package com.allankardeconline.globalkardec.services;

import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.allankardeconline.globalkardec.dto.CidadeDTO;
import com.allankardeconline.globalkardec.dto.ConteudoDTO;
import com.allankardeconline.globalkardec.dto.EstadoProvinciaDTO;
import com.allankardeconline.globalkardec.dto.IdiomaDTO;
import com.allankardeconline.globalkardec.dto.InstitutoDTO;
import com.allankardeconline.globalkardec.dto.PaisDTO;
import com.allankardeconline.globalkardec.dto.SituacaoFrequenciaDTO;
import com.allankardeconline.globalkardec.dto.SituacaoMatriculaDTO;
import com.allankardeconline.globalkardec.dto.TipoCursoDTO;
import com.allankardeconline.globalkardec.dto.TipoDiaCalendarioDTO;
import com.allankardeconline.globalkardec.dto.TipoRecursoAulaDTO;
import com.allankardeconline.globalkardec.dto.VinculoMatriculaDTO;
import com.allankardeconline.globalkardec.mapper.DozerMapper;
import com.allankardeconline.globalkardec.repository.CidadeRepository;
import com.allankardeconline.globalkardec.repository.ConteudoRepository;
import com.allankardeconline.globalkardec.repository.EstadoProvinciaRepository;
import com.allankardeconline.globalkardec.repository.IdiomaRepository;
import com.allankardeconline.globalkardec.repository.InstitutoRepository;
import com.allankardeconline.globalkardec.repository.PaisRepository;
import com.allankardeconline.globalkardec.repository.SituacaoFrequenciaRepository;
import com.allankardeconline.globalkardec.repository.SituacaoMatriculaRepository;
import com.allankardeconline.globalkardec.repository.TipoCursoRepository;
import com.allankardeconline.globalkardec.repository.TipoDiaCalendarioRepository;
import com.allankardeconline.globalkardec.repository.TipoRecursoAulaRepository;
import com.allankardeconline.globalkardec.repository.VinculoMatriculaRepository;

@Service
public class ComboService {

	private Logger log = Logger.getLogger(ComboService.class.getName());

	@Autowired
	SituacaoFrequenciaRepository situacaoFrequenciaRepository;

	@Autowired
	InstitutoRepository institutoRepository;

	@Autowired
	ConteudoRepository categoriaMaterialRepository;

	@Autowired
	SituacaoMatriculaRepository situacaoMatriculaRepository;

	@Autowired
	TipoCursoRepository tipoCursoRepository;

	@Autowired
	TipoDiaCalendarioRepository tipoDiaCalendarioRepository;

	@Autowired
	TipoRecursoAulaRepository tipoRecursoAulaRepository;

	@Autowired
	VinculoMatriculaRepository vinculoMatriculaRepository;

	@Autowired
	PaisRepository paisRepository;

	@Autowired
	EstadoProvinciaRepository estadoProvinciaRepository;

	@Autowired
	CidadeRepository cidadeRepository;

	@Autowired
	IdiomaRepository idiomaRepository;

	public List<InstitutoDTO> obterInstitutos() {
		return DozerMapper.parseListObjects(institutoRepository.findAll(),
				InstitutoDTO.class);
	}

	public List<ConteudoDTO> obterCategoriaMateria() {
		return DozerMapper.parseListObjects(
				categoriaMaterialRepository.findAll(), ConteudoDTO.class);
	}

	public List<SituacaoFrequenciaDTO> obterSituacaoFrequencia() {
		return DozerMapper.parseListObjects(
				situacaoFrequenciaRepository.findAll(),
				SituacaoFrequenciaDTO.class);
	}

	public List<SituacaoMatriculaDTO> obterSituacaoMatricula() {
		return DozerMapper.parseListObjects(
				situacaoMatriculaRepository.findAll(),
				SituacaoMatriculaDTO.class);
	}

	public List<TipoCursoDTO> obterTipoCurso() {
		return DozerMapper.parseListObjects(tipoCursoRepository.findAll(),
				TipoCursoDTO.class);
	}

	public List<TipoDiaCalendarioDTO> obterTipoDiaCalendario() {
		return DozerMapper.parseListObjects(
				tipoDiaCalendarioRepository.findAll(),
				TipoDiaCalendarioDTO.class);
	}

	public List<TipoRecursoAulaDTO> obterTipoRecursoAula() {
		return DozerMapper.parseListObjects(tipoRecursoAulaRepository.findAll(),
				TipoRecursoAulaDTO.class);
	}

	public List<VinculoMatriculaDTO> obterVinculoMatricula() {
		return DozerMapper.parseListObjects(
				vinculoMatriculaRepository.findAll(),
				VinculoMatriculaDTO.class);
	}

	public List<IdiomaDTO> obterIdiomas() {
		return DozerMapper.parseListObjects(idiomaRepository.findAll(),
				IdiomaDTO.class);
	}

	public List<PaisDTO> obterPaises() {
		return DozerMapper.parseListObjects(paisRepository.findAll(),
				PaisDTO.class);
	}

	public List<PaisDTO> obterPaisPorNome(String nome) {
		return DozerMapper.parseListObjects(paisRepository.obterPorNome(nome),
				PaisDTO.class);
	}

	public List<EstadoProvinciaDTO> obterEstadoProvinciaPorPaisENome(Long pais,
			String nome) {
		return DozerMapper.parseListObjects(
				estadoProvinciaRepository.obterPorPaisENome(pais, nome),
				EstadoProvinciaDTO.class);
	}

	public List<EstadoProvinciaDTO> obterEstadoProvinciaPorPais(Long pais) {
		return DozerMapper.parseListObjects(
				estadoProvinciaRepository.obterPorPais(pais),
				EstadoProvinciaDTO.class);
	}

	public List<CidadeDTO> obterCidadePorNome(String nome) {
		return DozerMapper.parseListObjects(cidadeRepository.obterPorNome(nome),
				CidadeDTO.class);
	}

	public List<CidadeDTO> obterCidadePorEstadoProvincia(Long estado) {
		return DozerMapper.parseListObjects(
				cidadeRepository.obterPorEstadoProvincia(estado),
				CidadeDTO.class);
	}
}
