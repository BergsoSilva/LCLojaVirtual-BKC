package com.silva.lacoscomfitaApp.service;

import java.util.List;
import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

/**
 *
 * @author Bergson Silva 
 */
public interface GenericService<T, ID> {

    void saveOrUpdate(T entity);

    List<T> findAll();

    Page<T> findAllPaginated(int page, int count, Sort.Direction direction, String sortProperty);

    T findById(ID id);

    T save(T entity);

    T add(T entity);

    T update(T entity);

    T addOrUpdate(T entity);

    void updateEntities(Set<T> entitys);

    void delete(T entity);

    void deleteById(ID id);

    void deleteAll(Set<T> entitys);

    void deleteEntitiesById(List<ID> entityIds);
}
