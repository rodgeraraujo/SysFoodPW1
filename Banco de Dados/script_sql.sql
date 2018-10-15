--CREATE DATABASE sysfood;

CREATE TABLE usuario(
    id serial,
    nome VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL,
    profissao VARCHAR(50),
    aniversario VARCHAR(11),
    sexo CHARACTER(1),
    fotoperfil bytea NOT NULL,
    descricao VARCHAR(200),
    rua VARCHAR(50),
    numero VARCHAR(10),
    cidade VARCHAR(50),
    estado CHARACTER(2),
    cep VARCHAR(15),
    telefone VARCHAR(20),
    senha VARCHAR(50) NOT NULL,
    CONSTRAINT usuario_pkey PRIMARY KEY (id),
    CONSTRAINT usuario_email_key UNIQUE (email)
);

CREATE TABLE estabelecimento(
    id serial,
    nome VARCHAR(50) NOT NULL,
    rua VARCHAR(50), 
    numero VARCHAR(10),
    cidade VARCHAR(50), 
    estado CHARACTER(2), 
    cep VARCHAR(15),
    tipo VARCHAR(50),
    funcionamento VARCHAR(10) NOT NULL,
    fotoperfil VARCHAR NOT NULL,
    descricao VARCHAR(200),
    email_usuario VARCHAR(50) NOT NULL,
    status int NOT NULL,
    CONSTRAINT estabelecimento_pkey PRIMARY KEY (id),
    CONSTRAINT usuario_email_key FOREIGN KEY (email_usuario) REFERENCES  usuario(email)
);


CREATE TABLE solicitacao(
    id serial,
    idRemetente int, 
    idDestinatario int, 
    status int, 
    dataHora TIMESTAMP, 
    CONSTRAINT solicitacao_pkey PRIMARY KEY (id),
    CONSTRAINT remetente_id_key FOREIGN KEY (idRemetente) REFERENCES usuario(id),
    CONSTRAINT destintario_id_key FOREIGN KEY (idDestinatario) REFERENCES  usuario(id)
);

CREATE TABLE comida(
    id serial, 
    nome VARCHAR(50) NOT NULL, 
    desscricao VARCHAR(150) NOT NULL,
    idEstabelecimento int, 
    foto VARCHAR,
    dataPublicacao TIMESTAMP,
    CONSTRAINT comida_pkey PRIMARY KEY (id),
    CONSTRAINT estabelecimento_id_key FOREIGN KEY (idEstabelecimento) REFERENCES estabelecimento(id)
);

CREATE TABLE publicacao(
    id serial, 
    nomeUsuario VARCHAR(50), 
    conteudo VARCHAR(300) NOT NULL,
    idUsuario int, 
    foto VARCHAR,
    dataPublicacao VARCHAR(20),
    usuarioFoto VARCHAR,
    CONSTRAINT publicacao_pkey PRIMARY KEY (id),
    CONSTRAINT usuario_id_key FOREIGN KEY (idUsuario) REFERENCES  usuario(id)
);


CREATE TABLE recomendacao(
    id serial, 
    idUsuario int, 
    idEstabelecimento int,
    CONSTRAINT recomendacao_pkey PRIMARY KEY (id),
    CONSTRAINT usuario_id_key FOREIGN KEY (idUsuario) REFERENCES usuario(id),
    CONSTRAINT estabelecimento_id_key FOREIGN KEY (idEstabelecimento) REFERENCES  estabelecimento(id)
);

CREATE TABLE avaliarEstabelecimento(
    id serial, 
    idUsuario int, 
    idEstabelecimento int,
    avaliacao real,
    comentario VARCHAR(250),
    dataAvaliacao TIMESTAMP,
    CONSTRAINT avaliarEstabelecimento_pkey PRIMARY KEY (id),
    CONSTRAINT usuario_id_key FOREIGN KEY (idUsuario) REFERENCES usuario(id),
    CONSTRAINT estabelecimento_id_key FOREIGN KEY (idEstabelecimento) REFERENCES  estabelecimento(id)
);

CREATE TABLE avaliarComida(
    id serial, 
    idUsuario int, 
    idEstabelecimento int,
    idComida int, 
    avaliacao real,
    comentario VARCHAR(250),
    dataAvaliacao TIMESTAMP,
    CONSTRAINT avaliarComida_pkey PRIMARY KEY (id),
    CONSTRAINT usuario_id_key FOREIGN KEY (idUsuario) REFERENCES usuario(id),
    CONSTRAINT estabelecimento_id_key FOREIGN KEY (idEstabelecimento) REFERENCES  estabelecimento(id),
    CONSTRAINT comida_id_key FOREIGN KEY (idComida) REFERENCES  comida(id)
);

-- CREATE TABLE amizadeStatus(
--     id serial, 
--     status boolean, 
--     CONSTRAINT amizade_status_pkey PRIMARY KEY (id),
-- )

CREATE TABLE Amizade(
    id serial, 
    idUsuario int, 
    idAmigo int,
    amizadeStatus boolean, 
    dataAmizade TIMESTAMP,
    CONSTRAINT Amizade_pkey PRIMARY KEY (id),
    CONSTRAINT usuario_id_key FOREIGN KEY (idUsuario) REFERENCES usuario(id),
    CONSTRAINT amigo_id_key FOREIGN KEY (idAmigo) REFERENCES  usuario(id)
)