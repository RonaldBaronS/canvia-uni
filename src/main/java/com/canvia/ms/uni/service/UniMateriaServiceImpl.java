package com.canvia.ms.uni.service;

import com.canvia.ms.uni.dao.UniMateriaDao;
import com.canvia.ms.uni.entity.UniMateriaEntity;
import com.canvia.ms.uni.model.UniMateriaRequest;
import com.canvia.ms.uni.model.UniMateriaResponse;

import java.util.ArrayList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * Implementacion UniMateriaService.
 * @author Ronald Baron.
 * @version 1.0
 */
@Slf4j
@Service
public class UniMateriaServiceImpl implements UniMateriaService {
    
    @Autowired
    private UniMateriaDao uniMateriaDao;
    
    @Override
    public void registrarUniMateria(UniMateriaRequest request) {
        log.info("UniMateriaServiceImpl.registrarUniMateria");
        UniMateriaEntity entity = new UniMateriaEntity();
        entity.setIdMateria(request.getIdMateria());
        entity.setNombreMateria(request.getNombreMateria());
        entity.setCreditoMateria(request.getCreditoMateria());
        uniMateriaDao.registrarUniMateria(entity);
    }
    
    @Override
    public UniMateriaResponse buscarUniMateria(int idMateria) {
        log.info("UniMateriaServiceImpl.buscarUniMateria");
        UniMateriaEntity uniMateriaEntity = uniMateriaDao.buscarUniMateria(idMateria);
        UniMateriaResponse uniMateriaResponse = new UniMateriaResponse();
        uniMateriaResponse.setIdMateria(uniMateriaEntity.getIdMateria());
        uniMateriaResponse.setNombreMateria(uniMateriaEntity.getNombreMateria());
        uniMateriaResponse.setCreditoMateria(uniMateriaEntity.getCreditoMateria());
        return uniMateriaResponse;
    }
    
    @Override
    public UniMateriaResponse actualizarUniMateria(UniMateriaRequest request) {
        log.info("UniMateriaServiceImpl.actualizarUniMateria");
        UniMateriaEntity entity = new UniMateriaEntity();
        entity.setIdMateria(request.getIdMateria());
        entity.setNombreMateria(request.getNombreMateria());
        entity.setCreditoMateria(request.getCreditoMateria());
        UniMateriaResponse response = new UniMateriaResponse();
        response.setIdMateria(entity.getIdMateria());
        response.setNombreMateria(entity.getNombreMateria());
        response.setCreditoMateria(entity.getCreditoMateria());
        uniMateriaDao.actualizarUniMateria(entity.getIdMateria(), entity);
        return response;
    }
    
    @Override
    public void eliminarUniMateria(int idMateria) {
        log.info("UniMateriaServiceImpl.eliminarUniMateria");
        UniMateriaEntity entity = new UniMateriaEntity();
        entity.setIdMateria(idMateria);
        uniMateriaDao.eliminarUniMateria(idMateria);
    }
    
    @Override
    public List<UniMateriaResponse> listarUniMateria() {
        log.info("UniMateriaServiceImpl.listarUniMateria");
        List<UniMateriaResponse> uniMateriaResponseList = new ArrayList<>();
        List<UniMateriaEntity> uniMateriaEntityList = uniMateriaDao.listarUniMateria();
        for (UniMateriaEntity uniMateriaEntity : uniMateriaEntityList) {
            UniMateriaResponse response = new UniMateriaResponse();
            response.setIdMateria(uniMateriaEntity.getIdMateria());
            response.setNombreMateria(uniMateriaEntity.getNombreMateria());
            response.setCreditoMateria(uniMateriaEntity.getCreditoMateria());
            uniMateriaResponseList.add(response);
        }
        return uniMateriaResponseList;
    }
    
    @Override
    public List<UniMateriaResponse> paginadoUniMateria(Pageable pegeable) {
        log.info("UniMateriaServiceImpl.paginadoUniMateria");
        List<UniMateriaResponse> uniMateriaResponseList = new ArrayList<>();
        Page<UniMateriaEntity> pageEntity = uniMateriaDao.paginadoUniMateria(pegeable);
        pageEntity.forEach(p -> {
           UniMateriaResponse response = new UniMateriaResponse();
           response.setIdMateria(p.getIdMateria());
           response.setNombreMateria(p.getNombreMateria());
           response.setCreditoMateria(p.getCreditoMateria());
           uniMateriaResponseList.add(response);
        });
        return uniMateriaResponseList;
     }
    
    @Override
    public void eliminarTodoUniMateria() {
        log.info("UniMateriaServiceImpl.eliminarTodoUniMateria");
        uniMateriaDao.eliminarTodoUniMateria();
    }
    
}