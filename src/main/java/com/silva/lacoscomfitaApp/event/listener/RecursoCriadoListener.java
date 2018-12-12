/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.silva.lacoscomfitaApp.event.listener;

import com.silva.lacoscomfitaApp.event.RecursoCriadoEvent;
import java.net.URI;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 *
 * @author bergson.silva
 */
@Component
public class RecursoCriadoListener implements ApplicationListener<RecursoCriadoEvent>{

    @Override
    public void onApplicationEvent(RecursoCriadoEvent recursoCriadoEvent) {
        HttpServletResponse response= recursoCriadoEvent.getResponse();
        Long codigo = recursoCriadoEvent.getCodigo();
        
        adicionarHeaderLocation(response, codigo);
    }
    
    private void adicionarHeaderLocation(HttpServletResponse response, Long codigo){
        URI uri =  ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                .buildAndExpand(codigo).toUri();

        response.setHeader("Location", uri.toASCIIString());
    }
    
}
