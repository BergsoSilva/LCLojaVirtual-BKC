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
@ConfigurationProperties("lacoscomfita")
public class LacosApiProperty {

    private String originPermitida = "http://localhost:8000";

    private final Seguranca seguranca = new Seguranca();

    public Seguranca getSeguranca() {
        return seguranca;
    }

    public String getOriginPermitida() {
        return originPermitida;
    }

    public void setOriginPermitida(String originPermitida) {
        this.originPermitida = originPermitida;
    }

    public static class Seguranca {

        private boolean enableHttps;
        private String  swaggerClientId;
        private String  swaggerclientSecret;
        private String  grantTypePassword;
        private String  grantTypeRefreshToken;
        private String  scopeRead;
        private String  scopeWrite;

        public boolean isEnableHttps() {
            return enableHttps;
        }

        public void setEnableHttps(boolean enableHttps) {
            this.enableHttps = enableHttps;
        }

        public String getSwaggerClientId() {
            return swaggerClientId;
        }

        public void setSwaggerClientId(String swaggerClientId) {
            this.swaggerClientId = swaggerClientId;
        }

        public String getSwaggerclientSecret() {
            return swaggerclientSecret;
        }

        public void setSwaggerclientSecret(String swaggerclientSecret) {
            this.swaggerclientSecret = swaggerclientSecret;
        }

        public String getGrantTypePassword() {
            return grantTypePassword;
        }

        public void setGrantTypePassword(String grantTypePassword) {
            this.grantTypePassword = grantTypePassword;
        }

        public String getGrantTypeRefreshToken() {
            return grantTypeRefreshToken;
        }

        public void setGrantTypeRefreshToken(String grantTypeRefreshToken) {
            this.grantTypeRefreshToken = grantTypeRefreshToken;
        }

        public String getScopeRead() {
            return scopeRead;
        }

        public void setScopeRead(String scopeRead) {
            this.scopeRead = scopeRead;
        }

        public String getScopeWrite() {
            return scopeWrite;
        }

        public void setScopeWrite(String scopeWrite) {
            this.scopeWrite = scopeWrite;
        }
    }



}
