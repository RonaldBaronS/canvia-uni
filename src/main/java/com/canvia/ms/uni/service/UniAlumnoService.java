package com.canvia.ms.uni.service;

import com.canvia.ms.uni.model.UniAlumnoRequest;
import com.canvia.ms.uni.model.UniAlumnoResponse;

import java.util.List;

import org.springframework.data.domain.Pageable;

/**
 * Interface UniAlumnoService.
 * @author Ronald Baron.
 * @version 1.0
 */
public interface UniAlumnoService {
    
    void registrarUniAlumno(UniAlumnoRequest request);
    UniAlumnoResponse buscarUniAlumno(int idAlumno);
    UniAlumnoResponse actualizarUniAlumno(UniAlumnoRequest request);
    List<UniAlumnoResponse> listarUniAlumno();
    List<UniAlumnoResponse> paginadoUniAlumno(Pageable pegeable);
    void eliminarTodoUniAlumno();
    UniAlumnoResponse buscarPorCodigoAlumno(String codigoAlumno);
    
}
