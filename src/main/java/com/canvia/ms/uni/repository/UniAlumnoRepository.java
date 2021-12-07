package com.canvia.ms.uni.repository;

import com.canvia.ms.uni.entity.UniAlumnoEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Interface UniAlumnoRepository.
 * @author Ronald Baron.
 * @version 1.0
 */
public interface UniAlumnoRepository extends JpaRepository<UniAlumnoEntity, Integer>{
    
    @Query("SELECT c from UniAlumnoEntity c WHERE c.idAlumno=?1")
    public UniAlumnoEntity findByIdAlumno(int idCarrera);
    
    @Query("SELECT c from UniAlumnoEntity c WHERE c.codigoAlumno=?1")
    public UniAlumnoEntity findByCodAlumno(String codigoAlumno);
    
}
