CREATE TABLE pacientes(

	id bigint NOT NULL auto_increment,
	nome varchar(100) NOT NULL,
	email varchar(100) NOT NULL UNIQUE,
	cpf varchar(11) NOT NULL UNIQUE,
	telefone varchar(20) NOT NULL,
	logradouro varchar(100) not null,
    bairro varchar(100) not null,
    cep varchar(9) not null,
    complemento varchar(100),
    numero varchar(20),
    uf char(2) not null,
    cidade varchar(100) not null,

    primary key(id)
	
);