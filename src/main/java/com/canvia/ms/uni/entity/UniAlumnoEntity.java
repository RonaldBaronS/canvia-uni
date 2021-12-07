package com.canvia.ms.uni.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Clase UniAlumnoEntity.
 * @author Ronald Baron.
 * @version 1.0
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "UNI_ALUMNO")
public class UniAlumnoEntity implements Serializable {
    
    private static final long serialVersionUID = 6979196965649401041L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID_ALUMNO")
    private Integer idAlumno;
    
    @Column(name="CODIGO_ALUMNO",length = 250)
    private String codigoAlumno;
    
    @Column(name="NOMBRE_ALUMNO",length = 250)
    private String nombreAlumno;
    
    @Column(name="APELLIDO_ALUMNO",length = 250)
    private String apellidoAlumno;
    
    @Column(name="SEMESTRE_ALUMNO",length = 250)
    private String semestreAlumno;
    
    
    @OneToOne
    @JoinColumn( name = "ID_CARRERA")
    private UniCarreraEntity carreraEntity;
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "UNI_ALUMNO_MATERIA", 
        joinColumns = @JoinColumn(name = "ID_ALUMNO"), 
        inverseJoinColumns = @JoinColumn(name = "ID_MATERIA"))
    private List<UniMateriaEntity> materiaEntities;
    
}