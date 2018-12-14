CREATE TABLE  PEDIDO(
  pedid INT(11) NOT NULL AUTO_INCREMENT,
  pedclid INT(11) NOT NULL,
  peddata DATE NOT NULL,
  pedvalortotal DOUBLE NOT NULL,
  PRIMARY KEY (pedid),
  CONSTRAINT fk_PEDIDO_CLIENTE
    FOREIGN KEY (pedclid)
    REFERENCES CLIENTE (CLIID))
ENGINE = InnoDB;


INSERT INTO PEDIDO (pedclid, peddata, pedvalortotal) VALUES (1, '2018-12-10', 12.00);
INSERT INTO PEDIDO (pedclid, peddata, pedvalortotal) VALUES (2, '2018-12-11', 13.00);
INSERT INTO PEDIDO (pedclid, peddata, pedvalortotal) VALUES (3, '2018-12-11', 14.00);
INSERT INTO PEDIDO (pedclid, peddata, pedvalortotal) VALUES (4, '2018-12-11', 15.00);



