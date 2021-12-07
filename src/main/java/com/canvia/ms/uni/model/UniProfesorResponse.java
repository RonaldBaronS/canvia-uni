package com.canvia.ms.uni.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Clase UniProfesorResponse.
 * @author Ronald Baron.
 * @version 1.0
 */
@Getter
@Setter
@NoArgsConstructor
public class UniProfesorResponse {
    
    @JsonProperty("id")
    private int idProfesor;
    
    @JsonProperty("nombreProfesor")
    private String nombreProfesor;
    
    @JsonProperty("horarioProfesor")
    private String horarioProfesor;
    
}
