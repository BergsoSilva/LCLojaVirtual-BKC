CREATE TABLE cliente(
  cliid INT(11) NOT NULL AUTO_INCREMENT,
  clinome VARCHAR(50) NOT NULL,
  clicpf VARCHAR(14) NOT NULL,
  clidatanasc DATE  NULL,
  PRIMARY KEY (CLIID)
  )
ENGINE = InnoDB;

INSERT INTO cliente (clinome, clicpf,clidatanasc) VALUES ('Bergson','111.111.111-11', '1989-06-20');
INSERT INTO cliente (clinome, clicpf,clidatanasc) VALUES ('Keren','222.222.222-22', '1992-04-23');



