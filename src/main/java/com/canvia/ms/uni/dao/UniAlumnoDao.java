package com.canvia.ms.uni.dao;

import com.canvia.ms.uni.entity.UniAlumnoEntity;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Interface UniAlumnoDao.
 * @author Ronald Baron.
 * @version 1.0
 */
public interface UniAlumnoDao {
    
    void registrarUniAlumno(UniAlumnoEntity entity);
    UniAlumnoEntity buscarUniAlumno(int idAlumno);
    void actualizarUniAlumno(int idAlumno,UniAlumnoEntity entity);
    List<UniAlumnoEntity> listarUniAlumno();
    Page<UniAlumnoEntity> paginadoUniAlumno(Pageable pegeable);
    void eliminarTodoUniAlumno();
    UniAlumnoEntity buscarPorCodigoAlumno(String codigoAlumno);
    
}
