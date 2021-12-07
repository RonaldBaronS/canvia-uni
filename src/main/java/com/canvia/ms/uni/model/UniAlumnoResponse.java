package com.canvia.ms.uni.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Clase UniAlumnoResponse.
 * @author Ronald Baron.
 * @version 1.0
 */
@Getter
@Setter
@NoArgsConstructor
public class UniAlumnoResponse {
    
    private Integer idAlumno;
    private String codigoAlumno;
    private String nombreAlumno;
    private String apellidoAlumno;
    private String semestreAlumno;
    private String carrera;
}
