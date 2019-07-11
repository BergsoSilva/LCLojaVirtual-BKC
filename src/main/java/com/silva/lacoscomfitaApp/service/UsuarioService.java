package com.silva.lacoscomfitaApp.service;

import com.silva.lacoscomfitaApp.model.Usuario;

import java.util.Optional;

public interface UsuarioService extends GenericService<Usuario,Long> {

    Usuario findByEmail(String email);
}
