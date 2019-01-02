
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
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
@Table(name =  "usuario")
public class Usuario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "useid")
    private Long id;
    
    @Column(name =  "usenome")
    private String nome;
    
    @Column( name = "useemail")
    private String email;
    
    @Column(name = "usesenha")
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
