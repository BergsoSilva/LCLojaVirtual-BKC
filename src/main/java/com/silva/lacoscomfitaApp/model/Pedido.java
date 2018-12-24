/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.silva.lacoscomfitaApp.model;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Entity
@Table(name="pedido")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pedid")
    private Long id;
    @NotNull
    
    @Column(name = "peddata")
    private LocalDate datapedido;
    
    @NotNull
    @Column(name = "pedvalortotal")
    private double valor;
   
    @ManyToOne
    @JoinColumn(name = "pedcliid")
    private Cliente cliente;
   
}
