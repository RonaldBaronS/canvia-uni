package com.canvia.ms.uni.dao;

import com.canvia.ms.uni.entity.UniAlumnoEntity;
import com.canvia.ms.uni.repository.UniAlumnoRepository;
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
public class UniAlumnoDaoImpl implements UniAlumnoDao {
    
    @Autowired
    private UniAlumnoRepository uniAlumnoRepository;
    
    @Override
    public void registrarUniAlumno(UniAlumnoEntity entity) {
        log.info("UniAlumnoDaoImpl.UniAlumno");
        try {
            uniAlumnoRepository.save(entity);
        } catch (Exception e) {
            throw new RuntimeException(UniConstantes.MENSAJE_ERROR_CONEXION_BD);
        }
    }
    
    @Override
    public UniAlumnoEntity buscarUniAlumno(int idAlumno) {
        log.info("UniAlumnoDaoImpl.buscarUniAlumno");
        return uniAlumnoRepository.findByIdAlumno(idAlumno);
    }
    
    @Override
    public void actualizarUniAlumno(int idAlumno, UniAlumnoEntity entity) {
        log.info("UniAlumnoDaoImpl.actualizarUniAlumno");
        try {
            if(uniAlumnoRepository.existsById(idAlumno)) {
                uniAlumnoRepository.save(entity);
            }
        } catch (Exception e) {
            throw new RuntimeException(UniConstantes.MENSAJE_NO_CONTENT);
        }
    }
    
    @Override
    public List<UniAlumnoEntity> listarUniAlumno() {
        log.info("UniAlumnoDaoImpl.listarUniAlumno");
        return (List<UniAlumnoEntity>) uniAlumnoRepository.findAll();
    }
    
    @Override
    public Page<UniAlumnoEntity> paginadoUniAlumno(Pageable pegeable) {
        log.info("UniAlumnoDaoImpl.paginadoUniAlumno");
        return uniAlumnoRepository.findAll(pegeable);
    }
    
    @Override
    public void eliminarTodoUniAlumno() {
        log.info("UniAlumnoDaoImpl.paginadoUniAlumno");
        uniAlumnoRepository.deleteAll();
    }
    
    @Override
    public UniAlumnoEntity buscarPorCodigoAlumno(String codigoAlumno) {
        log.info("UniAlumnoDaoImpl.buscarUniAlumno");
        return uniAlumnoRepository.findByCodAlumno(codigoAlumno);
     }
    
}