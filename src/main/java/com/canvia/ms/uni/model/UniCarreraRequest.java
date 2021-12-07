package com.canvia.ms.uni.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Clase UniCarreraRequest.
 * @author Ronald Baron.
 * @version 1.0
 */
@Getter
@Setter
@NoArgsConstructor
public class UniCarreraRequest {
    
    private int idCarrera;
    private String nombreCarrera;
    private int tiempoCarrera;
    
}