update geral.pessoa set centro_espirita_id = (select msc.id from member_spiritist_center msc 
where msc."name" like '%Centro%'
order by id asc
limit 1)