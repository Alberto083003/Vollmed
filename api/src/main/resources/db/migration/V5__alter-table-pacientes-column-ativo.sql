ALTER TABLE pacientes ADD ativos tinyint;
UPDATE pacientes SET ativos = 1;