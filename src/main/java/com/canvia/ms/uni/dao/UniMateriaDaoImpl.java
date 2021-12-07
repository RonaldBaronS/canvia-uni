package com.canvia.ms.uni.dao;

import com.canvia.ms.uni.entity.UniMateriaEntity;
import com.canvia.ms.uni.repository.UniMateriaRepository;
import com.canvia.ms.uni.util.UniConstantes;

import java.util.List;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

/**
 * Implementacion UniMateriaDao.
 * @author Ronald Baron.
 * @version 1.0
 */
@Slf4j
@Component
public class UniMateriaDaoImpl implements UniMateriaDao {
    
    @Autowired
    private UniMateriaRepository uniMateriaRepository;
    
    @Override
    public void registrarUniMateria(UniMateriaEntity entity) {
        log.info("UniMateriaDaoImpl.registrarUniMateria");
        try {
        	uniMateriaRepository.save(entity);
        } catch (Exception e) {
            throw new RuntimeException(UniConstantes.MENSAJE_ERROR_CONEXION_BD);
        }
    }
    
    @Override
    public UniMateriaEntity buscarUniMateria(int idMateria) {
        log.info("UniMateriaDaoImpl.buscarUniMateria");
        return uniMateriaRepository.findByIdMateria(idMateria);
    }
    
    @Override
    public void actualizarUniMateria(int idMateria, UniMateriaEntity entity) {
        log.info("UniMateriaDaoImpl.actualizarUniMateria");
        try {
            if(uniMateriaRepository.existsById(idMateria)) {
            	uniMateriaRepository.save(entity);
            }
        } catch (Exception e) {
            throw new RuntimeException(UniConstantes.MENSAJE_NO_CONTENT);
        }
    }
    
    @Override
    public void eliminarUniMateria(int id) {
        log.info("UniMateriaDaoImpl.eliminarUniMateria");
        uniMateriaRepository.deleteById(id);
    }
    
    @Override
    public List<UniMateriaEntity> listarUniMateria() {
        log.info("UniMateriaDaoImpl.listarUniMateria");
        return (List<UniMateriaEntity>) uniMateriaRepository.findAll();
    }
    
    @Override
    public Page<UniMateriaEntity> paginadoUniMateria(Pageable pegeable) {
        log.info("UniMateriaDaoImpl.paginadoUniMateria");
        return uniMateriaRepository.findAll(pegeable);
    }
    
    @Override
    public void eliminarTodoUniMateria() {
        log.info("UniMateriaDaoImpl.paginadoUniCarrera");
        uniMateriaRepository.deleteAll();
	}
    
}