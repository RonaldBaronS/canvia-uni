package com.canvia.ms.uni.dao;

import com.canvia.ms.uni.entity.UniCarreraEntity;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


/**
 * Interface UniCarreraDao.
 * @author Ronald Baron.
 * @version 1.0
 */
public interface UniCarreraDao {
    
    void registrarUniCarrera(UniCarreraEntity entity);
    UniCarreraEntity buscarUniCarrera(int idCarrera);
    void actualizarUniCarrera(int idCarrera,UniCarreraEntity entity);
    void eliminarUniCarrera(int id);
    List<UniCarreraEntity> listarUniCarrera();
    Page<UniCarreraEntity> paginadoUniCarrera(Pageable pegeable);
    void eliminarTodoUniCarrera();
    
}