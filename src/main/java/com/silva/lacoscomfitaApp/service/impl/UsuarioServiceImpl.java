package com.silva.lacoscomfitaApp.service.impl;

import com.silva.lacoscomfitaApp.model.Usuario;
import com.silva.lacoscomfitaApp.repository.UsuarioRepository;
import com.silva.lacoscomfitaApp.service.UsuarioService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class UsuarioServiceImpl implements UsuarioService {


    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public void saveOrUpdate(Usuario entity) {

    }

    @Override
    public List<Usuario> findAll() {
        return null;
    }

    @Override
    public Page<Usuario> findAllPaginated(int page, int count, Sort.Direction direction, String sortProperty) {
        return null;
    }

    @Override
    public Usuario findById(Long aLong) {
        return null;
    }

    @Override
    public Usuario save(Usuario entity) {
        return null;
    }

    @Override
    public Usuario add(Usuario entity) {
        return null;
    }

    @Override
    public Usuario update(Usuario entity) {
        return null;
    }

    @Override
    public Usuario addOrUpdate(Usuario entity) {
        return null;
    }

    @Override
    public void updateEntities(Set<Usuario> entitys) {

    }

    @Override
    public void delete(Usuario entity) {

    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void deleteAll(Set<Usuario> entitys) {

    }

    @Override
    public void deleteEntitiesById(List<Long> entityIds) {

    }

    @Override
    public Usuario findByEmail(String email) {

         Optional<Usuario> usuarioOptional= usuarioRepository.findByEmail(email);

        return  usuarioOptional.get();
    }
}
