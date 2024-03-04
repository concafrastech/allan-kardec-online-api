package com.allankardeconline.globalkardec.services;

import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.logging.Logger;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.allankardeconline.gestaoacesso.model.Usuario;
import com.allankardeconline.globalkardec.dto.PessoaCadastroDTO;
import com.allankardeconline.globalkardec.dto.PessoaDTO;
import com.allankardeconline.globalkardec.excecoes.DuplicidadeException;
import com.allankardeconline.globalkardec.excecoes.InformacaoObrigatoriaException;
import com.allankardeconline.globalkardec.excecoes.RecursoNaoEncontradoException;
import com.allankardeconline.globalkardec.mapper.DozerMapper;
import com.allankardeconline.globalkardec.model.Cidade;
import com.allankardeconline.globalkardec.model.Idioma;
import com.allankardeconline.globalkardec.model.Pessoa;
import com.allankardeconline.globalkardec.repository.CentroEspiritaRepository;
import com.allankardeconline.globalkardec.repository.CidadeRepository;
import com.allankardeconline.globalkardec.repository.IdiomaRepository;
import com.allankardeconline.globalkardec.repository.PessoaRepository;
import com.allankardeconline.site.model.CentroEspirita;

@Service
public class PessoaService {

	private Logger log = Logger.getLogger(PessoaService.class.getName());

	@Autowired
	PessoaRepository repository;

	@Autowired
	IdiomaRepository idiomaRepository;

	@Autowired
	CidadeRepository cidadeRepository;

	@Autowired
	CentroEspiritaRepository centroEspiritaRepository;

	public Page<PessoaDTO> obterTodos(// UUID uuidCentro,
			Pageable paginacao) {
		var page = repository.findAll(paginacao);

		var pagesDTO = page.map(
				objeto -> DozerMapper.parseObject(objeto, PessoaDTO.class));
		return pagesDTO;

	}

	public Page<PessoaDTO> obterPorNome(String nome, Pageable paginacao) {

		var page = repository.findByNomeLikeIgnoreCase(nome, paginacao);

		var pagesDTO = page.map(
				objeto -> DozerMapper.parseObject(objeto, PessoaDTO.class));
		return pagesDTO;

	}
	
	
	public Page<PessoaDTO> obterPorCentro(UUID centro, Pageable paginacao) {

		var page = repository.obterTodosPorCentro(centro, paginacao);

		var pagesDTO = page.map(
				objeto -> DozerMapper.parseObject(objeto, PessoaDTO.class));
		return pagesDTO;

	}

	public List<PessoaDTO> obterPorEmailOUTelefone(String email,
			String telefone) {

		return DozerMapper.parseListObjects(
				repository.findByEmailOrTelefone(email, telefone),
				PessoaDTO.class);

	}

	public PessoaDTO obterPorUuid(UUID id) {

		var entity = repository.findByUuid(id)
				.orElseThrow(() -> new RecursoNaoEncontradoException(
						"Objeto não encontrado para o id "));

		return DozerMapper.parseObject(entity, PessoaDTO.class);

	}

	public PessoaDTO inserir(PessoaCadastroDTO dto) {

		if (!Objects.isNull(dto.getContato().getEmail()))
			dto.getContato()
					.setEmail(dto.getContato().getEmail().toLowerCase());

		var entity = DozerMapper.parseObject(dto, Pessoa.class);

		if (Objects.isNull(dto.getContato().getEmail())
				&& Objects.isNull(dto.getContato().getTelefone()))
			throw new InformacaoObrigatoriaException(
					"É necessário informar ao menos um dos campos: e-mail ou telefone ");

		var pessoa = repository.findByEmailOrTelefone(
				dto.getContato().getEmail(), dto.getContato().getTelefone());

		if (pessoa != null && !pessoa.isEmpty())
			throw new DuplicidadeException(
					"Pessoa já cadastrada com e-mail ou telefone "
							+ dto.getContato().getEmail() + " - "
							+ dto.getContato().getTelefone());

		Idioma idioma = idiomaRepository.findByUuid(dto.getIdioma())
				.orElseThrow(() -> new RecursoNaoEncontradoException(
						"Idioma não encontrado para o uuid "
								+ dto.getIdioma()));

		Cidade cidade = cidadeRepository
				.findById(dto.getEndereco().getIdCidade())
				.orElseThrow(() -> new RecursoNaoEncontradoException(
						"Cidade não encontrada para o id "
								+ dto.getEndereco().getIdCidade()));

		CentroEspirita centro = centroEspiritaRepository
				.findByUuid(dto.getUuidCentro())
				.orElseThrow(() -> new RecursoNaoEncontradoException(
						"CentroEspirita não encontrada para o uuid "
								+ dto.getUuidCentro()));

		Usuario usuario = new Usuario();
		usuario.setUuid(UUID.randomUUID());
		usuario.setLoginEmail(dto.getContato().getEmail());
		usuario.setLoginTelefone(dto.getContato().getTelefone());
		usuario.setCentroEspirita(centro);
		usuario.setSenha(RandomStringUtils.random(6, true, true));

		entity.setUuid(UUID.randomUUID());
		entity.setIdioma(idioma);
		entity.setUsuario(usuario);
		entity.getEndereco().setCidade(cidade);

		var dtoRetorno = DozerMapper.parseObject(repository.save(entity),
				PessoaDTO.class);

		return dtoRetorno;

	}

	public PessoaDTO alterar(PessoaCadastroDTO dto) {

		if (!Objects.isNull(dto.getContato().getEmail()))
			dto.getContato()
					.setEmail(dto.getContato().getEmail().toLowerCase());

		if (Objects.isNull(dto.getContato().getEmail())
				&& Objects.isNull(dto.getContato().getTelefone()))
			throw new InformacaoObrigatoriaException(
					"É necessário informar ao menos um dos campos: e-mail ou telefone ");

		Pessoa entidade = repository.findByUuid(dto.getUuid())
				.orElseThrow(() -> new RecursoNaoEncontradoException(
						"Objeto não encontrado para o uuid " + dto.getUuid()));

		Idioma idioma = idiomaRepository.findByUuid(dto.getIdioma())
				.orElseThrow(() -> new RecursoNaoEncontradoException(
						"Idioma não encontrado para o uuid "
								+ dto.getIdioma()));

		Cidade cidade = cidadeRepository
				.findById(dto.getEndereco().getIdCidade())
				.orElseThrow(() -> new RecursoNaoEncontradoException(
						"Cidade não encontrado para o uuid "
								+ dto.getEndereco().getIdCidade()));

		entidade.setNome(dto.getNome());
		entidade.setDataNascimento(dto.getDataNascimento());
		entidade.setIdioma(idioma);

		// Contato
		entidade.getContato().setEmail(dto.getContato().getEmail());
		entidade.getContato().setFacebook(dto.getContato().getFacebook());
		entidade.getContato().setInstagram(dto.getContato().getInstagram());
		entidade.getContato().setTelefone(dto.getContato().getTelefone());

		// Endereço

		entidade.getEndereco().setBairro(dto.getEndereco().getBairro());
		entidade.getEndereco().setLogradouro(dto.getEndereco().getLogradouro());
		entidade.getEndereco().setNumero(dto.getEndereco().getNumero());
		entidade.getEndereco().setCidade(cidade);

		var dtoRetorno = DozerMapper.parseObject(repository.save(entidade),
				PessoaDTO.class);

		return dtoRetorno;

	}

	public void excluir(UUID id) {
		Pessoa entidade = repository.findByUuid(id)
				.orElseThrow(() -> new RecursoNaoEncontradoException(
						"Objeto não encontrado para o id " + id));

		repository.delete(entidade);
	}

}
