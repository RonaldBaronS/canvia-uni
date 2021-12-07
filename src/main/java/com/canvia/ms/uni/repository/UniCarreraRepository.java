package com.canvia.ms.uni.repository;

import com.canvia.ms.uni.entity.UniCarreraEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Interface UniCarreraRepository.
 * @author Ronald Baron.
 * @version 1.0
 */
public interface UniCarreraRepository extends JpaRepository<UniCarreraEntity, Integer> {
    
    @Query("SELECT c from UniCarreraEntity c WHERE c.idCarrera=?1")
    public UniCarreraEntity findByIdCarrera(int idCarrera);
    
}