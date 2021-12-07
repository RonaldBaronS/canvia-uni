package com.canvia.ms.uni.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Clase UniCarreraEntity.
 * @author Ronald Baron.
 * @version 1.0
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "UNI_CARRERA")
public class UniCarreraEntity implements Serializable {
    
    private static final long serialVersionUID = 6979196965649401041L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CARRERA")
    private Integer idCarrera;
    
    @Column(name = "NOMBRE_CARRERA" , length = 250)
    private String nombreCarrera;
    
    @Column(name = "TIEMPO_CARRERA" , length = 250)
    private int tiempoCarrera;
    
    @OneToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY , mappedBy = "carreraEntity")
    private List<UniAlumnoEntity> alumnoEntities;
    
}