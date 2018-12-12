/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.silva.lacoscomfitaApp.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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
@Table(name="produto")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "proid")
    private Long id;
    @NotNull
    @Size(min = 3 , max = 50)
    @Column(name = "prodescricao")
    private String descricao;
    
    @NotNull
    @Column(name = "provalor")
    private double valor;
    @NotNull
    @Column(name = "proqtde")
    private Integer quantidade;
   
}
