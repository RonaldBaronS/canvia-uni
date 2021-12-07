package com.canvia.ms.uni.service;

import com.canvia.ms.uni.dao.UniCarreraDao;
import com.canvia.ms.uni.entity.UniCarreraEntity;
import com.canvia.ms.uni.model.UniCarreraRequest;
import com.canvia.ms.uni.model.UniCarreraResponse;

import java.util.ArrayList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * Implementacion UniCarreraService.
 * @author Ronald Baron.
 * @version 1.0
 */
@Slf4j
@Service
public class UniCarreraServiceImpl implements UniCarreraService {
    
    @Autowired
    private UniCarreraDao uniCarreraDao;
    
    @Override
    public void registrarUniCarrera(UniCarreraRequest request) {
        log.info("UniCarreraServiceImpl.registrarUniCarrera");
        UniCarreraEntity entity = new UniCarreraEntity();
        entity.setIdCarrera(request.getIdCarrera());
        entity.setNombreCarrera(request.getNombreCarrera());
        entity.setTiempoCarrera(request.getTiempoCarrera());
        uniCarreraDao.registrarUniCarrera(entity);
    }
    
    @Override
    public UniCarreraResponse buscarUniCarrera(int idCarrera) {
        log.info("UniCarreraServiceImpl.buscarUniCarrera");
        UniCarreraEntity uniCarreraEntity =uniCarreraDao.buscarUniCarrera(idCarrera);
        UniCarreraResponse uniCarreraResponse = new UniCarreraResponse();
        uniCarreraResponse.setIdCarrera(uniCarreraEntity.getIdCarrera());
        uniCarreraResponse.setNombreCarrera(uniCarreraEntity.getNombreCarrera());
        uniCarreraResponse.setTiempoCarrera(uniCarreraEntity.getTiempoCarrera());
        return uniCarreraResponse;
    }
    
    @Override
    public UniCarreraResponse actualizarUniCarrera(UniCarreraRequest request) {
        log.info("UniCarreraServiceImpl.actualizarUniCarrera");
        UniCarreraEntity entity = new UniCarreraEntity();
        entity.setIdCarrera(request.getIdCarrera());
        entity.setNombreCarrera(request.getNombreCarrera());
        entity.setTiempoCarrera(request.getTiempoCarrera());
        UniCarreraResponse response = new UniCarreraResponse();
        response.setIdCarrera(entity.getIdCarrera());
        response.setNombreCarrera(entity.getNombreCarrera());
        response.setTiempoCarrera(entity.getTiempoCarrera());
        uniCarreraDao.actualizarUniCarrera(entity.getIdCarrera(), entity);
        return response;
    }
    
    @Override
    public void eliminarUniCarrera(int idCarrera) {
        log.info("UniCarreraServiceImpl.eliminarUniCarrera");
        UniCarreraEntity entity = new UniCarreraEntity();
        entity.setIdCarrera(idCarrera);
        uniCarreraDao.eliminarUniCarrera(entity.getIdCarrera());
    }
    
    @Override
    public List<UniCarreraResponse> listarUniCarrera() {
        log.info("UniCarreraServiceImpl.listarUniCarrera");
        List<UniCarreraResponse> uniCarreraResponseList= new ArrayList<>();
        List<UniCarreraEntity> uniCarreraEntityList = uniCarreraDao.listarUniCarrera();
        for (UniCarreraEntity uniCarreraEntity : uniCarreraEntityList) {
           UniCarreraResponse response = new UniCarreraResponse();
           response.setIdCarrera(uniCarreraEntity.getIdCarrera());
           response.setNombreCarrera(uniCarreraEntity.getNombreCarrera());
           response.setTiempoCarrera(uniCarreraEntity.getTiempoCarrera());
           uniCarreraResponseList.add(response);
        }
        return uniCarreraResponseList;
    }
    
    @Override
    public List<UniCarreraResponse> paginadoUniCarrera(Pageable pegeable) {
        log.info("UniCarreraServiceImpl.paginadoUniCarrera");
        List<UniCarreraResponse> uniCarreraResponseList = new ArrayList<>();
        Page<UniCarreraEntity>  pageEntity = uniCarreraDao.paginadoUniCarrera(pegeable);
        pageEntity.forEach(p-> {
            UniCarreraResponse response = new UniCarreraResponse();
            response.setIdCarrera(p.getIdCarrera());
            response.setNombreCarrera(p.getNombreCarrera());
            response.setTiempoCarrera(p.getTiempoCarrera());
            uniCarreraResponseList.add(response);
        });
        return uniCarreraResponseList;
    }
    
    @Override
    public void eliminarTodoUniCarrera() {
        log.info("UniCarreraServiceImpl.eliminarTodoUniCarrera");
        uniCarreraDao.eliminarTodoUniCarrera();
    }
    
}