package com.canvia.ms.uni.service;

import com.canvia.ms.uni.dao.UniProfesorDao;
import com.canvia.ms.uni.entity.UniProfesorEntity;
import com.canvia.ms.uni.model.UniProfesorRequest;
import com.canvia.ms.uni.model.UniProfesorResponse;

import java.util.ArrayList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * Implementacion UniProfesorService.
 * @author Ronald Baron.
 * @version 1.0
 */
@Slf4j
@Service
public class UniProfesorServiceImpl implements UniProfesorService {
    
    @Autowired
    private UniProfesorDao uniProfesorDao;
    
    @Override
    public void registrarUniProfesor(UniProfesorRequest request) {
        log.info("UniProfesorServiceImpl.registrarUniProfesor");
        UniProfesorEntity entity = new UniProfesorEntity();
        entity.setIdProfesor(request.getIdProfesor());
        entity.setNombreProfesor(request.getNombreProfesor());
        entity.setHorarioProfesor(request.getHorarioProfesor());
        uniProfesorDao.registrarUniProfesor(entity);
    }
    
    @Override
    public UniProfesorResponse buscarUniProfesor(int idProfesor) {
        log.info("UniProfesorServiceImpl.buscarUniProfesor");
        UniProfesorEntity uniProfesorEntity = uniProfesorDao.buscarUniProfesor(idProfesor);
        UniProfesorResponse response = new UniProfesorResponse();
        response.setIdProfesor(uniProfesorEntity.getIdProfesor());
        response.setNombreProfesor(uniProfesorEntity.getNombreProfesor());
        response.setHorarioProfesor(uniProfesorEntity.getHorarioProfesor());
        return response;
    }
    
    @Override
    public UniProfesorResponse actualizarUniProfesor(UniProfesorRequest request) {
        log.info("UniProfesorServiceImpl.actualizarUniProfesor");
        UniProfesorEntity entity = new UniProfesorEntity();
        entity.setIdProfesor(request.getIdProfesor());
        entity.setNombreProfesor(request.getNombreProfesor());
        entity.setHorarioProfesor(request.getHorarioProfesor());
        UniProfesorResponse response = new UniProfesorResponse();
        response.setIdProfesor(entity.getIdProfesor());
        response.setNombreProfesor(entity.getNombreProfesor());
        response.setHorarioProfesor(entity.getHorarioProfesor());
        uniProfesorDao.actualizarUniProfesor(entity.getIdProfesor(), entity);
        return response;
    }
    
    @Override
    public void eliminarUniProfesor(int idProfesor) {
        log.info("UniProfesorServiceImpl.eliminarUniProfesor");
        UniProfesorEntity entity = new UniProfesorEntity();
        entity.setIdProfesor(idProfesor);
        uniProfesorDao.eliminarUniProfesor(idProfesor);
    }
    
    @Override
    public List<UniProfesorResponse> listarUniProfesor() {
        log.info("UniProfesorServiceImpl.listarUniProfesor");
        List<UniProfesorResponse> uniProfesorResponseList = new ArrayList<>();
        List<UniProfesorEntity> uniProfesorEntityList = uniProfesorDao.listarUniProfesor();
        uniProfesorEntityList.forEach(p-> {
            UniProfesorResponse response = new UniProfesorResponse();
            response.setIdProfesor(p.getIdProfesor());
            response.setNombreProfesor(p.getNombreProfesor());
            response.setHorarioProfesor(p.getHorarioProfesor());
            uniProfesorResponseList.add(response);
        });
        return uniProfesorResponseList;
     }
    
    @Override
    public List<UniProfesorResponse> paginadoUniProfesor(Pageable pegeable) {
        log.info("UniProfesorServiceImpl.listarUniProfesor");
        List<UniProfesorResponse> uniProfesorResponseList = new ArrayList<>();
        Page<UniProfesorEntity> pageEntity = uniProfesorDao.paginadoUniProfesor(pegeable);
        pageEntity.forEach(p->{
             UniProfesorResponse response = new UniProfesorResponse();
             response.setIdProfesor(p.getIdProfesor());
             response.setNombreProfesor(p.getNombreProfesor());
             response.setHorarioProfesor(p.getHorarioProfesor());
             uniProfesorResponseList.add(response);
        });
        return uniProfesorResponseList;
    }
    
    @Override
    public void eliminarTodoUniProfesor() {
        log.info("UniProfesorServiceImpl.eliminarTodoUniProfesor");
        uniProfesorDao.eliminarTodoUniProfesor();
    }
    
}