package com.canvia.ms.uni.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Clase UniProfesorRequest.
 * @author Ronald Baron.
 * @version 1.0
 */
@Getter
@Setter
@NoArgsConstructor
public class UniProfesorRequest {
    
    private int idProfesor;
    private String nombreProfesor;
    private String horarioProfesor;
    
}