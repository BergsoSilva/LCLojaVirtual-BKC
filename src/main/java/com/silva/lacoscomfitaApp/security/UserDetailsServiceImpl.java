package com.silva.lacoscomfitaApp.security;

import com.silva.lacoscomfitaApp.model.Usuario;
import com.silva.lacoscomfitaApp.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioService usuarioService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

            Usuario usuario = usuarioService.findByEmail(s);



        return new UsuarioCorrente(usuario, getAuthorities(usuario));
    }

    public Collection<? extends GrantedAuthority> getAuthorities(Usuario usuario) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();


        usuario.getPermissoes().forEach(permissao -> {
            authorities.add(new SimpleGrantedAuthority(permissao.getDescricao()));
        });

        return authorities;
    }
}

