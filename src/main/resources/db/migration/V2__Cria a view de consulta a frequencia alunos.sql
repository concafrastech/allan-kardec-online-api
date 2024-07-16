create or replace view globalkardec.frequencia_aluno_consulta as
select m.uuid, p.nome as aluno,
	t.uuid as uuid_turma,
	dac.uuid as uuid_dia_calendario,
	dac.data_aula, 
	fq.situacao_frequencia_id, 
	sf.nome as situacao_frequencia, 
	dac.aula_especial 
from globalkardec.matricula m 
join globalkardec.turma t on m.turma_id = t.id
join geral.pessoa p on m.pessoa_id  = p.id
left join globalkardec.frequencia_aluno fq on fq.matricula_id = m.id 
left join auxiliar.situacao_frequencia sf on fq.situacao_frequencia_id  = sf.id
left join globalkardec.dia_aula_calendario dac on fq.dia_aula_calendario_id = dac.id