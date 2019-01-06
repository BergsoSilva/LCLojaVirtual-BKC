/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.silva.lacoscomfitaApp.Resource;

import com.silva.lacoscomfitaApp.config.property.LacosApiProperty;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author bergson
 */
@RestController
@RequestMapping("/tokens")
public class TokenResource {
    
    @Autowired
    private LacosApiProperty lacosApiProperty;
    
    @DeleteMapping("/revoke")
    public void revoke( HttpServletRequest req, HttpServletResponse resp){
       Cookie cookie = new Cookie("refreshToken", null);
		cookie.setHttpOnly(true);
		cookie.setSecure(lacosApiProperty.getSeguranca().isEnableHtps()); // TODO: Em producao sera true
		cookie.setPath(req.getContextPath() + "/oauth/token");
		cookie.setMaxAge(0);
		
		resp.addCookie(cookie);
		resp.setStatus(HttpStatus.NO_CONTENT.value());
        
    }
}
