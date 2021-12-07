package com.canvia.ms.uni.dao;

import com.canvia.ms.uni.entity.UniProfesorEntity;
import com.canvia.ms.uni.repository.UniProfesoRepository;
import com.canvia.ms.uni.util.UniConstantes;

import java.util.List;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

/**
 * Implementacion UniProfesorDao.
 * @author Ronald Baron.
 * @version 1.0
 */
@Slf4j
@Component
public class UniProfesorDaoImpl implements UniProfesorDao {
    
    @Autowired
    private UniProfesoRepository uniProfesorRepository;
    
    @Override
    public void registrarUniProfesor(UniProfesorEntity entity) {
        log.info("UniProfesorDaoImpl.registrarUniProfesor");
        try {
        	uniProfesorRepository.save(entity);
        } catch (Exception e) {
            throw new RuntimeException(UniConstantes.MENSAJE_ERROR_CONEXION_BD);
        }
    }
    
    @Override
    public UniProfesorEntity buscarUniProfesor(int idProfesor) {
        log.info("UniProfesorDaoImpl.buscarUniProfesorId");
        return uniProfesorRepository.findByIdProfesor(idProfesor);
    }
    
    @Override
    public void actualizarUniProfesor(int idProfesor, UniProfesorEntity entity) {
        log.info("UniProfesorDaoImpl.actualizarUniProfesor");
        try {
            if(uniProfesorRepository.existsById(idProfesor)) {
            	uniProfesorRepository.save(entity);
            }
        } catch (Exception e) {
            throw new RuntimeException(UniConstantes.MENSAJE_NO_CONTENT);
        }
    }
    
    @Override
    public void eliminarUniProfesor(int id) {
        log.info("UniProfesorDaoImpl.eliminarUniProfesor");
        uniProfesorRepository.deleteById(id);
    }
    
    @Override
    public List<UniProfesorEntity> listarUniProfesor() {
        log.info("UniProfesorDaoImpl.listarUniProfesor");
        return (List<UniProfesorEntity>) uniProfesorRepository.findAll();
    }
    
    @Override
    public Page<UniProfesorEntity> paginadoUniProfesor(Pageable pegeable) {
        log.info("UniProfesorDaoImpl.paginadoUniProfesor");
        return uniProfesorRepository.findAll(pegeable);
    }
    
    @Override
    public void eliminarTodoUniProfesor() {
        log.info("UniProfesorDaoImpl.paginadoUniProfesor");
        uniProfesorRepository.deleteAll();
    }
    
}