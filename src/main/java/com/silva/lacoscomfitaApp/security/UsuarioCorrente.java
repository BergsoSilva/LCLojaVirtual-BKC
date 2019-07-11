package com.silva.lacoscomfitaApp.security;

import com.silva.lacoscomfitaApp.model.Usuario;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

@Getter
public class UsuarioCorrente extends User {

    private Usuario usuario;

    public UsuarioCorrente(Usuario usuario, Collection<? extends GrantedAuthority> authorities) {
        super(usuario.getEmail(), usuario.getSenha(), authorities);
    }
}
