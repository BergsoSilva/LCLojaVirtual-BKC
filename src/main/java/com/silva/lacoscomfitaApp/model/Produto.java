/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.silva.lacoscomfitaApp.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
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
@Entity
@Table(name = "PRODUTO")
public class Produto implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PROID")
    private Integer id;
    @Column(name = "PRODESCRICAO")
    private String descricao;
    @Column(name = "PROVALOR")
    private Double valor;
    @Column(name = "PROQTDE")
    private int qtde;

    
    /**
     * mappers
     */
    
     @ManyToOne
     @JoinColumn(name="PEDCLIID")
     private ItemPedido itemPedido;
    
    
   
}
