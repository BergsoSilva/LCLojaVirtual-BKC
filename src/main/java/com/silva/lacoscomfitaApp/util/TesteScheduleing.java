/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.silva.lacoscomfitaApp.util;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 *
 * @author bergson.silva
 */
@Component
public class TesteScheduleing {

    private final long SEGUNDO = 1000;
    private final long MINUTO = SEGUNDO * 60;
    private final long HORA = MINUTO * 60;

    @Scheduled(fixedDelay = SEGUNDO)
    private void RodarRotina() {
        System.out.println("Testet TesteScheduleing");
    }

}
