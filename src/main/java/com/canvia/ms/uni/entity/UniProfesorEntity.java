package com.canvia.ms.uni.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Clase UniProfesorEntity.
 * @author Ronald Baron.
 * @version 1.0
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "UNI_PROFESOR")
public class UniProfesorEntity implements Serializable {
    
    private static final long serialVersionUID = -8985405575923831968L;
     
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID_PROFESOR")
    private Integer idProfesor;
    
    @Column(name="NOMBRE_PROFESOR",length = 250)
    private String nombreProfesor;
    
    @Column(name="HORARIO_PROFESOR",length = 250)
    private String horarioProfesor;
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "UNI_PROFESOR_ALUMNO", 
        joinColumns = @JoinColumn(name = "ID_PROFESOR"), 
        inverseJoinColumns = @JoinColumn(name = "ID_ALUMNO"))
    private List<UniAlumnoEntity> alumnoEntities;
    
}