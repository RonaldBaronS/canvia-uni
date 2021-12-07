package com.canvia.ms.uni.dao;

import com.canvia.ms.uni.entity.UniProfesorEntity;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Interface UniProfesorDao.
 * @author Ronald Baron.
 * @version 1.0
 */
public interface UniProfesorDao {
    
    void registrarUniProfesor(UniProfesorEntity entity);
    UniProfesorEntity buscarUniProfesor(int idProfesor);
    void actualizarUniProfesor(int idProfesor,UniProfesorEntity entity);
    void eliminarUniProfesor(int id);
    List<UniProfesorEntity> listarUniProfesor();
    Page<UniProfesorEntity> paginadoUniProfesor(Pageable pegeable);
    void eliminarTodoUniProfesor();
    
}