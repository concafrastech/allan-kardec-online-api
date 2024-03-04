package com.allankardeconline.globalkardec.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.allankardeconline.globalkardec.model.DiaAulaCalendario;

public interface DiaAulaCalendarioRepository
		extends JpaRepository<DiaAulaCalendario, Long> {

	Optional<DiaAulaCalendario> findByUuid(UUID uuid);

	@Query("SELECT o from DiaAulaCalendario o WHERE o.calendario.uuid = :uuidCalendario order by o.dataAula ASC")
	List<DiaAulaCalendario> obterDiasAulaPorCalendario(UUID uuidCalendario);

	@Query("SELECT CASE WHEN (count(o)>0) THEN true ELSE false END from DiaAulaCalendario o "
			+ " WHERE o.calendario.uuid = :uuidCalendario "
			+ "AND o.dataAula = :dataAula ")
	boolean existePorCalendarioAndDataAula(UUID uuidCalendario, LocalDate dataAula);
}
