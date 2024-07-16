ALTER TABLE geral.pessoa ADD centro_espirita_id int8 NULL;
ALTER TABLE geral.pessoa ADD CONSTRAINT pessoa_fk FOREIGN KEY (centro_espirita_id) REFERENCES public.member_spiritist_center(id);