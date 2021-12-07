package com.canvia.ms.uni.dao;

import com.canvia.ms.uni.entity.UniMateriaEntity;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Interface UniMateriaDao.
 * @author Ronald Baron.
 * @version 1.0
 */
public interface UniMateriaDao {
    
    void registrarUniMateria(UniMateriaEntity entity);
    UniMateriaEntity buscarUniMateria(int idMateria);
    void actualizarUniMateria(int idMateria,UniMateriaEntity entity);
    void eliminarUniMateria(int id);
    List<UniMateriaEntity> listarUniMateria();
    Page<UniMateriaEntity> paginadoUniMateria(Pageable pegeable);
    void eliminarTodoUniMateria();
    
}