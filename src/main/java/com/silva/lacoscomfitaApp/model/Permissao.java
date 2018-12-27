/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.silva.lacoscomfitaApp.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author bergson
 */
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "permissao")
public class Permissao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "perid")
    private Long id;

    @Column(name = "perdescricao")
    private String descricao;

    public Permissao() {
    }

    public Permissao(Long id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }
    
    
    
}
