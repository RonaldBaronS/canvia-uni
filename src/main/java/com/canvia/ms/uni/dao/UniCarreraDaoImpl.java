package com.canvia.ms.uni.dao;

import com.canvia.ms.uni.entity.UniCarreraEntity;
import com.canvia.ms.uni.repository.UniCarreraRepository;
import com.canvia.ms.uni.util.UniConstantes;

import java.util.List;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

/**
 * Implementacion UniCarreraDao.
 * @author Ronald Baron.
 * @version 1.0
 */
@Slf4j
@Component
public class UniCarreraDaoImpl implements UniCarreraDao {
    
	@Autowired
    private UniCarreraRepository uniCarreraRepository;
    
    @Override
    public void registrarUniCarrera(UniCarreraEntity entity) {
       log.info("UniCarreraDaoImpl.registrarUniCarrera");
       try {
           uniCarreraRepository.save(entity);
       } catch (Exception e) {
           throw new RuntimeException(UniConstantes.MENSAJE_ERROR_CONEXION_BD);
       }
    }
    
    @Override
    public UniCarreraEntity buscarUniCarrera(int idCarrera) {
        log.info("UniCarreraDaoImpl.buscarUniCarreraId");
        return uniCarreraRepository.findByIdCarrera(idCarrera);
    }
    
    @Override
    public void actualizarUniCarrera(int idCarrera, UniCarreraEntity entity) {
        log.info("UniCarreraDaoImpl.actualizarUniCarrera");
        try {
            if(uniCarreraRepository.existsById(idCarrera)) {
            	uniCarreraRepository.save(entity);
            }
        } catch (Exception e) {
            throw new RuntimeException(UniConstantes.MENSAJE_NO_CONTENT);
        }
    }
    
    @Override
    public void eliminarUniCarrera(int id) {
        log.info("UniCarreraDaoImpl.eliminarUniCarrera");
        uniCarreraRepository.deleteById(id);
    }
    
    @Override
    public List<UniCarreraEntity> listarUniCarrera() {
        log.info("UniCarreraDaoImpl.listarUniCarrera");
        return (List<UniCarreraEntity>) uniCarreraRepository.findAll();
    }
    
    @Override
    public Page<UniCarreraEntity> paginadoUniCarrera(Pageable pegeable) {
        log.info("UniCarreraDaoImpl.paginadoUniCarrera");
        return uniCarreraRepository.findAll(pegeable);
    }
    
    @Override
    public void eliminarTodoUniCarrera() {
        log.info("UniCarreraDaoImpl.paginadoUniCarrera");
        uniCarreraRepository.deleteAll();
    }
    
}