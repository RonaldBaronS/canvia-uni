package com.canvia.ms.uni.service;

import com.canvia.ms.uni.model.UniMateriaRequest;
import com.canvia.ms.uni.model.UniMateriaResponse;

import java.util.List;

import org.springframework.data.domain.Pageable;

/**
 * Interface UniMateriaService.
 * @author Ronald Baron.
 * @version 1.0
 */
public interface UniMateriaService {
    
    void registrarUniMateria(UniMateriaRequest request);
    UniMateriaResponse buscarUniMateria(int idMateria);
    UniMateriaResponse actualizarUniMateria(UniMateriaRequest request);
    void eliminarUniMateria(int idMateria);
    List<UniMateriaResponse> listarUniMateria();
    List<UniMateriaResponse> paginadoUniMateria(Pageable pegeable);
    void eliminarTodoUniMateria();
    
}
