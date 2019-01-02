CREATE TABLE usuario (
	useid BIGINT(11) PRIMARY KEY auto_increment,
	usenome VARCHAR(50) NOT NULL,
	useemail VARCHAR(50) NOT NULL,
	usesenha VARCHAR(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE permissao (
	perid BIGINT(11) PRIMARY KEY,
	perdescricao VARCHAR(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE usuario_permissao (
	up_useid BIGINT(11) NOT NULL,
	up_perid BIGINT(11) NOT NULL,
	PRIMARY KEY (up_useid, up_perid),
	FOREIGN KEY (up_useid) REFERENCES usuario(useid),
	FOREIGN KEY (up_perid) REFERENCES permissao(perid)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO usuario (useid, usenome, useemail, usesenha) values (1, 'Administrador', 'admin@algamoney.com', '$2a$10$2FOY3q0QYryOulwTYPAMQOo4PUK1FibI.gh.YWqJtgRTTGY/BVDS2');
                                                                                                                
INSERT INTO usuario (useid, usenome, useemail, usesenha) values (2, 'Berg Silva', 'berg@algamoney.com', '$2a$10$XCYS/vKLLyScSVHxhiQ25.z4IVJF/ZXBm3CRnXqmY959jD0/d7wXu');

INSERT INTO permissao (perid, perdescricao) values (1, 'ROLE_CADASTRAR_CLIENTE');
INSERT INTO permissao (perid, perdescricao) values (2, 'ROLE_PESQUISAR_CLIENTE');

INSERT INTO permissao (perid, perdescricao) values (3, 'ROLE_CADASTRAR_PRODUTO');
INSERT INTO permissao (perid, perdescricao) values (4, 'ROLE_REMOVER_PRODUTO');
INSERT INTO permissao (perid, perdescricao) values (5, 'ROLE_PESQUISAR_PRODUTO');

-- admin
INSERT INTO usuario_permissao (up_useid, up_perid) values (1, 1);
INSERT INTO usuario_permissao (up_useid, up_perid) values (1, 2);
INSERT INTO usuario_permissao (up_useid, up_perid) values (1, 3);


-- maria
INSERT INTO usuario_permissao (up_useid, up_perid) values (2, 3);
INSERT INTO usuario_permissao (up_useid, up_perid) values (2, 4);
INSERT INTO usuario_permissao (up_useid, up_perid) values (2, 5);