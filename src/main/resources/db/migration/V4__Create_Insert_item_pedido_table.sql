CREATE TABLE ITEM_PEDIDO (
  ippedid INT(11) NOT NULL,
  ipqtde INT(11) NOT NULL,
  ipprodid INT(11) NOT NULL,
  ipvaloruni DECIMAL(10,3) NULL,
  ipid INT(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (ipid),
    FOREIGN KEY (ippedid)
    REFERENCES PEDIDO (pedid),
    FOREIGN KEY (ipprodid)
    REFERENCES PRODUTO (PROID))
ENGINE = InnoDB;

INSERT INTO ITEM_PEDIDO (ippedid, ipqtde, ipprodid, ipvaloruni) VALUES (1,2,1,6.0);


