package com.canvia.ms.uni.repository;

import com.canvia.ms.uni.entity.UniProfesorEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Interface UniProfesoRepository.
 * @author Ronald Baron.
 * @version 1.0
 */
public interface UniProfesoRepository extends JpaRepository<UniProfesorEntity, Integer> {
    
    @Query("SELECT c from UniProfesorEntity c WHERE c.idProfesor=?1")
    public UniProfesorEntity findByIdProfesor(int idProfesor);
    
}
