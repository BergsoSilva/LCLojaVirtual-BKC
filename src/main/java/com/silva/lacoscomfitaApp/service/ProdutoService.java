/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.silva.lacoscomfitaApp.service;

import com.silva.lacoscomfitaApp.model.Cliente;
import com.silva.lacoscomfitaApp.model.Produto;
import com.silva.lacoscomfitaApp.repository.ProdutoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

/**
 *
 * @author bergson.silva
 */
@Service
public class ProdutoService {
   @Autowired
   private ProdutoRepository productRepository;
   
   
   public Produto atualizar(Long id, Produto produto){
       Produto produtoSavar = productRepository.findById(id).get();
       if(produtoSavar==null){
           throw new EmptyResultDataAccessException(1);
       }
       BeanUtils.copyProperties(produto, produtoSavar,"id");
       return  productRepository.save(produtoSavar);
       
   }
}
