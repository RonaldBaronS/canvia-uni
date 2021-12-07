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
 * Clase UniMateriaEntity.
 * @author Ronald Baron.
 * @version 1.0
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "UNI_MATERIA")
public class UniMateriaEntity implements Serializable {
    
    private static final long serialVersionUID = -8985405575923831968L;
     
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID_MATERIA")
    private Integer idMateria;
    
    @Column(name="NOMBRE_MATERIA",length = 250)
    private String nombreMateria;
    
    @Column(name="CREDITO_MATERIA",length = 250)
    private int creditoMateria;
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "UNI_MATERIA_PROFESOR", 
        joinColumns = @JoinColumn(name = "ID_MATERIA"), 
        inverseJoinColumns = @JoinColumn(name = "ID_PROFESOR"))
    private List<UniProfesorEntity> profesorEntities;
    
}