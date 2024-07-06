package com.allankardeconline.globalkardec.services;

import java.util.UUID;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.allankardeconline.globalkardec.dto.CursoConsultaDTO;
import com.allankardeconline.globalkardec.dto.CursoDTO;
import com.allankardeconline.globalkardec.excecoes.RecursoNaoEncontradoException;
import com.allankardeconline.globalkardec.mapper.DozerMapper;
import com.allankardeconline.globalkardec.model.Curso;
import com.allankardeconline.globalkardec.repository.CursoRepository;
import com.allankardeconline.globalkardec.repository.CursoRepositoryCustomizado;
import com.allankardeconline.globalkardec.repository.IdiomaRepository;
import com.allankardeconline.globalkardec.repository.InstitutoRepository;
import com.allankardeconline.globalkardec.repository.TipoCursoRepository;

@Service
public class CursoService {

    private Logger log = Logger.getLogger(CursoService.class.getName());

    @Autowired
    CursoRepository repository;

    @Autowired
    CursoRepositoryCustomizado repositoryCustomizado;

    @Autowired
    IdiomaRepository idiomaRepository;

    @Autowired
    InstitutoRepository institutoRepository;

    @Autowired
    TipoCursoRepository tipoCursoRepository;

    public Page<CursoDTO> pesquisar(String curso, String idioma, String instituto, Pageable paginacao) {
        var page = repositoryCustomizado.pesquisar(curso, idioma, instituto, paginacao);

        return page.map(objeto -> DozerMapper.parseObject(objeto, CursoDTO.class));
    }

    public Page<CursoConsultaDTO> obterTodos(Pageable paginacao) {
        var page = repository.findAll(paginacao);

        return page.map(objeto -> DozerMapper.parseObject(objeto, CursoConsultaDTO.class));
    }

    public Page<CursoConsultaDTO> obterPorNome(Pageable paginacao, String nome) {
        var page = repository.findByNomeLikeIgnoreCase(nome, paginacao);

        return page.map(objeto -> DozerMapper.parseObject(objeto, CursoConsultaDTO.class));
    }

    public CursoDTO obterPorUuid(UUID id) {
        Curso entity = repository.findByUuid(id).orElseThrow(() -> new RecursoNaoEncontradoException("Curso não encontrado para o id " + id));

        return DozerMapper.parseObject(entity, CursoDTO.class);
    }

    public CursoDTO inserir(CursoDTO curso) {
        curso.setUuid(UUID.randomUUID());
        var idioma = idiomaRepository.findByUuid(curso.getIdioma()).orElseThrow(() -> new RecursoNaoEncontradoException("Idioma não encontrado para o uuid " + curso.getIdioma()));
        var instituto = institutoRepository.findByUuid(curso.getInstituto()).orElseThrow(() -> new RecursoNaoEncontradoException("Instituto não encontrado para o uuid " + curso.getInstituto()));
        var tipoCurso = tipoCursoRepository.findById(curso.getTipoCurso()).orElseThrow(() -> new RecursoNaoEncontradoException("TipoCurso não encontrado para o id " + curso.getTipoCurso()));
        var entity = DozerMapper.parseObject(curso, Curso.class);

        entity.setIdioma(idioma);
        entity.setInstituto(instituto);
        entity.setTipoCurso(tipoCurso);

        return DozerMapper.parseObject(repository.save(entity), CursoDTO.class);
    }

    public CursoDTO alterar(CursoDTO curso) {
        Curso entity = repository.findByUuid(curso.getUuid()).orElseThrow(() -> new RecursoNaoEncontradoException("Curso não encontrado para o id " + curso.getUuid()));
        var idioma = idiomaRepository.findByUuid(curso.getIdioma()).orElseThrow(() -> new RecursoNaoEncontradoException("Idioma não encontrado para o uuid " + curso.getIdioma()));
        var instituto = institutoRepository.findByUuid(curso.getInstituto()).orElseThrow(() -> new RecursoNaoEncontradoException("Instituto não encontrado para o uuid " + curso.getInstituto()));
        var tipoCurso = tipoCursoRepository.findById(curso.getTipoCurso()).orElseThrow(() -> new RecursoNaoEncontradoException("TipoCurso não encontrado para o id " + curso.getTipoCurso()));

        entity.setCapaCurso(curso.getCapaCurso());
        entity.setIdioma(idioma);
        entity.setInstituto(instituto);
        entity.setNome(curso.getNome());
        entity.setTipoCurso(tipoCurso);
        entity.setDescricao(curso.getDescricao());
        entity.setModalidadeEnsino(curso.getModalidadeEnsino());

        return DozerMapper.parseObject(repository.save(entity), CursoDTO.class);
    }

    public void excluir(UUID id) {
        Curso entity = repository.findByUuid(id).orElseThrow(() -> new RecursoNaoEncontradoException("Objeto não encontrado para o id " + id));

        repository.delete(entity);
    }

}
