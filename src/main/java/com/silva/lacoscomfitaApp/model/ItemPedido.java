/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.silva.lacoscomfitaApp.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
@Table(name = "ITEMPEDIDO")
public class ItemPedido implements Serializable{
     @Id
     @ManyToOne
     @JoinColumn(name="PEDCLIID")
     private Pedido pedido;
     @Id
     @Column(name = "IPPROID")
     private Produto produto;
     
     @Column(name = "IPQTDE")
     private int qtde;
    
    /**
     *mappers  
     */
     @OneToMany( mappedBy = "pedido")
     private Set<Produto> itens;
     
    
    
   
}
