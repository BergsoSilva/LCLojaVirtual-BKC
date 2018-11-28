CREATE TABLE IF NOT EXISTS cliente(
  id INT(11)  PRIMARY KEY NOT NULL AUTO_INCREMENT,
  nome VARCHAR(50),
  cpf VARCHAR(15),
  datanasc DATE 
 );


INSERT INTO cliente ( nome, cpf,datanasc) VALUES ('Bergson','111.111.111-11', '1989-06-20');
INSERT INTO cliente ( nome, cpf,datanasc) VALUES ('Keren','222.222.222-22', '1992-04-23');



