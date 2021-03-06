/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.silva.lacoscomfitaApp.ExceptionHandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 *
 * @author bergson.silva
 */
@ControllerAdvice
public class LacosComFitaAppExceptionHandler extends ResponseEntityExceptionHandler{

    @Autowired
    private MessageSource messageSource;
    
    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) { 
        String mensagemUsuario = messageSource.getMessage("mensagem.invalida",null, LocaleContextHolder.getLocale());
        String mensagemDesenvolvedor = ex.getCause()!= null?ex.getCause().toString():ex.toString();
        
        List<Erro> erros = Arrays.asList(new Erro(mensagemUsuario, mensagemDesenvolvedor));
        return handleExceptionInternal(ex,erros, headers, HttpStatus.BAD_REQUEST, request);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<Erro> erros = criaraListaDeErros(ex.getBindingResult());
        return  handleExceptionInternal(ex,erros, headers, HttpStatus.BAD_REQUEST, request);
    }
    
    @ExceptionHandler({EmptyResultDataAccessException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> EmptyResultDataAccessException(EmptyResultDataAccessException ex,WebRequest request){
        
        String mensagemUsuario = messageSource.getMessage("recurso.nao-encontrado",null, LocaleContextHolder.getLocale());
        String mensagemDesenvolvedor = ex.toString();
        
         List<Erro> erros = Arrays.asList(new Erro(mensagemUsuario, mensagemDesenvolvedor));
        
        return handleExceptionInternal(ex, erros, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }
    


    private List<Erro> criaraListaDeErros(BindingResult bindingResult){
        List<Erro> erros = new ArrayList<>();
        
        for (FieldError fieldError: bindingResult.getFieldErrors()){
            String messagemUsuario=messageSource.getMessage(fieldError, LocaleContextHolder.getLocale());
            String messagemProgramador= fieldError.toString();
            
            erros.add(new Erro(messagemUsuario,messagemProgramador));
        }
    
        return erros;
    }
    

    public static class Erro{
        private String mensagemUsuario;
        private String messagemDesenvolvedor;

        public Erro(String mensagemUsuario, String messagemDesenvolvedor) {
            this.mensagemUsuario = mensagemUsuario;
            this.messagemDesenvolvedor = messagemDesenvolvedor;
        }

        public String getMensagemUsuario() {
            return mensagemUsuario;
        }

        public String getMessagemDesenvolvedor() {
            return messagemDesenvolvedor;
        }   
    }
    
}
