package com.allankardeconline.globalkardec.services;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.allankardeconline.config.UploadArquivoConfig;
import com.allankardeconline.globalkardec.excecoes.ArquivoException;

@Service
public class ArquivoUploadService {

	private final Path localizacaoArquivo;


	public ArquivoUploadService(UploadArquivoConfig uploadArquivoConfig) {
		Path path = Paths.get(uploadArquivoConfig.getUploadDir())
				.toAbsolutePath().normalize();

		this.localizacaoArquivo = path;

		try {
			Files.createDirectories(this.localizacaoArquivo);

		} catch (Exception e) {
			throw new ArquivoException(
					"Falha ao criar diretório para upload dos arquivos ", e);
		}
	}

	public String gravarArquivo(MultipartFile file) {
		String arquivo = StringUtils.cleanPath(file.getOriginalFilename());

		try {

			String arquivoDestino = new Date().getTime() + "_"
					+ arquivo.replaceAll(" ", "_");

			Path targetLocation = this.localizacaoArquivo
					.resolve(arquivoDestino);
			Files.copy(file.getInputStream(), targetLocation,
					StandardCopyOption.REPLACE_EXISTING);
			return arquivoDestino;
		} catch (Exception e) {
			throw new ArquivoException(
					"Falha ao criar diretório para upload dos arquivos ", e);
		}

	}

}
