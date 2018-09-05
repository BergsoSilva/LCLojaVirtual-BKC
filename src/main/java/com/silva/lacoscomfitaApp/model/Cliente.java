/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.silva.lacoscomfitaApp.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "CLIENTE")
public class Cliente implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CLIID")
    private Integer id;
    @Column(name = "CLINOME")
    private String nome;
    @Column(name = "CLICPF")
    private Double cpf;
    @Column(name = "CLIDATANASC")
    private Calendar data;
    
    /**
     * mappers
     */
    
    @OneToMany(cascade=CascadeType.MERGE, mappedBy="cliente")
    private List<Pedido> pedidos = new ArrayList<>(); 

    
    
   
}
