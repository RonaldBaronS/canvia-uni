package com.canvia.ms.uni.repository;

import com.canvia.ms.uni.entity.UniMateriaEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Interface UniMateriaRepository.
 * @author Ronald Baron.
 * @version 1.0
 */
public interface UniMateriaRepository extends JpaRepository<UniMateriaEntity, Integer> {
    
    @Query("SELECT c from UniMateriaEntity c WHERE c.idMateria=?1")
    public UniMateriaEntity findByIdMateria(int idMateria);
    
}
