package com.canvia.ms.uni.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Clase UniAlumnoRequest.
 * @author Ronald Baron.
 * @version 1.0
 */
@Getter
@Setter
@NoArgsConstructor
public class UniAlumnoRequest {
    
    private int idAlumno;
    private String codigoAlumno;
    private String nombreAlumno;
    private String apellidoAlumno;
    private String semestreAlumno;
    private int idCarrera;
    
}
