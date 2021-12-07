package com.canvia.ms.uni.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Clase UniCarreraResponse.
 * @author Ronald Baron.
 * @version 1.0
 */
@Getter
@Setter
@NoArgsConstructor
public class UniCarreraResponse {
   
    @JsonProperty("id")
    private Integer idCarrera;
    
    @JsonProperty("nombreCarrera")
    private String nombreCarrera;
    
    @JsonProperty("tiempoCarrera")
    private int tiempoCarrera;
    
}