package com.canvia.ms.uni.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Clase UniMateriaResponse.
 * @author Ronald Baron.
 * @version 1.0
 */
@Getter
@Setter
@NoArgsConstructor
public class UniMateriaResponse {
    
    @JsonProperty("id")
    private int idMateria;
    
    @JsonProperty("nombreMateria")
    private String nombreMateria;
    
    @JsonProperty("creditoMateria")
    private int creditoMateria;
    
}
