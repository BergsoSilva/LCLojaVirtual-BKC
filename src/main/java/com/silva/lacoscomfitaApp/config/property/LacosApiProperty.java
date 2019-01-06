/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.silva.lacoscomfitaApp.config.property;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 *
 * @author bergson
 */
@ConfigurationProperties("lacoscomfitas")
public class LacosApiProperty {
    
    private String originPermitida="http://localhost:8000" ;
    
    private Seguranca seguranca= new Seguranca();

    public Seguranca getSeguranca() {
        return seguranca;
    }

    public void setSeguranca(Seguranca seguranca) {
        this.seguranca = seguranca;
    }

    public String getOriginPermitida() {
        return originPermitida;
    }

    public void setOriginPermitida(String originPermitida) {
        this.originPermitida = originPermitida;
    }
    
    
    
    public static class Seguranca{
        private boolean  enableHtps;

        public boolean isEnableHtps() {
            return enableHtps;
        }

        public void setEnableHtps(boolean enableHtps) {
            this.enableHtps = enableHtps;
        }
        
        
    }
    
    
    
}
