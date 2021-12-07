package com.canvia.ms.uni.service;

import com.canvia.ms.uni.model.UniProfesorRequest;
import com.canvia.ms.uni.model.UniProfesorResponse;

import java.util.List;

import org.springframework.data.domain.Pageable;

/**
 * Interface UniProfesorService.
 * @author Ronald Baron.
 * @version 1.0
 */
public interface UniProfesorService {
    
    void registrarUniProfesor(UniProfesorRequest request);
    UniProfesorResponse buscarUniProfesor(int idProfesor);
    UniProfesorResponse actualizarUniProfesor(UniProfesorRequest request);
    void eliminarUniProfesor(int idProfesor);
    List<UniProfesorResponse> listarUniProfesor();
    List<UniProfesorResponse> paginadoUniProfesor(Pageable pegeable);
    void eliminarTodoUniProfesor();
    
}