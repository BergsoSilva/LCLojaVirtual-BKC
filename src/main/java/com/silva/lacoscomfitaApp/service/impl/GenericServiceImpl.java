package com.silva.lacoscomfitaApp.service.impl;

import com.silva.lacoscomfitaApp.exception.EntityInvalidException;
import com.silva.lacoscomfitaApp.service.GenericService;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolationException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;


/**
 *
 * @author Bergson Rodrigues da Silva
 */
@Service
public abstract class GenericServiceImpl<T, ID extends Serializable> implements GenericService<T, ID> {

    protected final Log logger = LogFactory.getLog(getClass());

    @Autowired
    private JpaRepository<T, ID> repository;

    @Override
    public void saveOrUpdate(T entity) {
        try {
            repository.save(entity);
        } catch (ConstraintViolationException e) {
            throw new EntityInvalidException(e.getMessage());
        }
    }

    @Override
    public List<T> findAll() {
        return repository.findAll();
    }

    @Override
    public Page<T> findAllPaginated(int page, int count, Sort.Direction direction, String sortProperty) {
        return repository.findAll(PageRequest.of(page, count, new Sort(direction, sortProperty)));
    }

    @Override
    public T findById(ID id) {
        return repository.findById(id).get();
    }

    @Override
    public T save(T entity) {
        return repository.save(entity);
    }

    @Override
    public T add(T entity) {
        return repository.save(entity);
    }

    @Override
    public T update(T entity) {
        return repository.save(entity);
    }

    @Override
    public T addOrUpdate(T entity) {
        return repository.save(entity);
    }

    @Override
    public void updateEntities(Set<T> entities) {
        repository.saveAll(entities);
    }

    @Override
    public void delete(T entity) {
        repository.delete(entity);
    }

    @Override
    public void deleteById(ID id) {
        repository.deleteById(id);
    }

    @Override
    public void deleteAll(Set<T> entities) {
        repository.deleteAll(entities);
    }

    @Override
    public void deleteEntitiesById(List<ID> entityIds) {
        entityIds.forEach((id) -> {
            repository.deleteById(id);
        });
    }
}
