CREATE TABLE  pedido(
  pedid INT(11) NOT NULL AUTO_INCREMENT,
  pedclid INT(11) NOT NULL,
  peddata DATE NOT NULL,
  pedvalortotal DOUBLE NOT NULL,
  PRIMARY KEY (pedid),
    FOREIGN KEY (pedclid)
    REFERENCES cliente (cliid))
ENGINE = InnoDB;


INSERT INTO pedido (pedclid, peddata, pedvalortotal) VALUES (1, '2018-12-10', 12.00);
INSERT INTO pedido (pedclid, peddata, pedvalortotal) VALUES (2, '2018-12-11', 13.00);



