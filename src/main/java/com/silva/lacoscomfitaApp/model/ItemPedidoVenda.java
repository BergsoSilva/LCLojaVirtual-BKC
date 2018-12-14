/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.silva.lacoscomfitaApp.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


/**
 *
 * @author bergson.silva
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Table(name="item_pedido")
@Entity
public class ItemPedidoVenda implements Serializable {
    @Id
    @Column(name = "ipid")
    private Long id;
    @OneToOne
    @JoinColumn(name = "ipproid")
    private Produto produto;
    
    @Column(name = "ipqtde")
    private Integer quantidade;
    
    @Column(name = "ipvaloruni")
    private BigDecimal valorUnitario;
   
    @ManyToOne
    @JoinColumn(name = "ippedid")
    private Pedido pedido;
   
}
