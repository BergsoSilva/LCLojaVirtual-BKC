CREATE  TABLE produto (
  proid INT(11) NOT NULL AUTO_INCREMENT,
  prodescricao VARCHAR(50)  NOT NULL,
  provalor DOUBLE NOT NULL,
  proqtde INT(11) NOT NULL,
  PRIMARY KEY (proid))
ENGINE = InnoDB;


INSERT INTO produto (prodescricao, provalor, proqtde) VALUES ('Laco Norma',5.0, 5);
INSERT INTO produto (prodescricao, provalor, proqtde) VALUES ('Laco Botique',6.0, 4);
INSERT INTO produto (prodescricao, provalor, proqtde) VALUES ('Laco com fita',7.0, 3);
INSERT INTO produto (prodescricao, provalor, proqtde) VALUES ('Laco Laco',8.0, 2);