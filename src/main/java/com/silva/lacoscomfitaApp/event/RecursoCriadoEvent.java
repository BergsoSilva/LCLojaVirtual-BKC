/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.silva.lacoscomfitaApp.event;

import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationEvent;

/**
 *
 * @author bergson.silva
 */
public class RecursoCriadoEvent  extends  ApplicationEvent{
    private HttpServletResponse response;
    private Long codigo;
        
    public RecursoCriadoEvent(Object source, HttpServletResponse response, Long codigo) {
        super(source);
    }

    public HttpServletResponse getResponse() {
        return response;
    }

    public Long getCodigo() {
        return codigo;
    }

    
}
