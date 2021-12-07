package com.canvia.ms.uni.service;

import com.canvia.ms.uni.model.UniCarreraRequest;
import com.canvia.ms.uni.model.UniCarreraResponse;

import java.util.List;

import org.springframework.data.domain.Pageable;

/**
 * Interface UniCarreraService.
 * @author Ronald Baron.
 * @version 1.0
 */
public interface UniCarreraService {
    
    void registrarUniCarrera(UniCarreraRequest request);
    UniCarreraResponse buscarUniCarrera(int idCarrera);
    UniCarreraResponse actualizarUniCarrera(UniCarreraRequest request);
    void eliminarUniCarrera(int idCarrera);
    List<UniCarreraResponse> listarUniCarrera();
    List<UniCarreraResponse> paginadoUniCarrera(Pageable pegeable);
    void eliminarTodoUniCarrera();
    
}