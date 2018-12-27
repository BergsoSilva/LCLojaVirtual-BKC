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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
@Table(name = "usuario")
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column("useid")
    private Long id;
    
    @Column("usenome")
    private String nome;
    
    @Column("useemail")
    private String email;
    
    @Column("usesenha")
    private String senha;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "usuario_permissao", joinColumns = @JoinColumn(name = "up_useid"),
             inverseJoinColumns = @JoinColumn(name = "up_perid"))
    private List<Permissao> permissoes;

    public Usuario() {
    }

    public Usuario(Long id, String nome, String email, String senha, List<Permissao> permissoes) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.permissoes = permissoes;
    }
    
     

}
