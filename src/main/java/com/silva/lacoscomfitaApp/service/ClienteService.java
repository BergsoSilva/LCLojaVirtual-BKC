/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.silva.lacoscomfitaApp.service;

import com.silva.lacoscomfitaApp.model.Cliente;
import com.silva.lacoscomfitaApp.repository.ClienteRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

/**
 *
 * @author bergson.silva
 */
@Service
public class ClienteService {
   @Autowired
   private ClienteRepository clienteRepository;
   
   
   public Cliente atualizar(Long id, Cliente cliente){
       Cliente clienteSavar = clienteRepository.findById(id).get();
       if(clienteSavar==null){
           throw new EmptyResultDataAccessException(1);
       }
       BeanUtils.copyProperties(cliente, clienteSavar,"id");
       return  clienteRepository.save(clienteSavar);
       
   }
}
