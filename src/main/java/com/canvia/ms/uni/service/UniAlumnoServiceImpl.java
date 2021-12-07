package com.canvia.ms.uni.service;

import com.canvia.ms.uni.dao.UniAlumnoDao;
import com.canvia.ms.uni.dao.UniCarreraDao;
import com.canvia.ms.uni.entity.UniAlumnoEntity;
import com.canvia.ms.uni.entity.UniCarreraEntity;
import com.canvia.ms.uni.model.UniAlumnoRequest;
import com.canvia.ms.uni.model.UniAlumnoResponse;

import java.util.ArrayList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * Implementacion UniAlumnoService.
 * @author Ronald Baron.
 * @version 1.0
 */
@Slf4j
@Service
public class UniAlumnoServiceImpl implements UniAlumnoService {
    
    @Autowired
    private UniAlumnoDao uniAlumnoDao;
    
    @Autowired
    private UniCarreraDao uniCarreraDao;
    
    @Override
    public void registrarUniAlumno(UniAlumnoRequest request) {
        log.info("UniAlumnoServiceImpl.registrarUniAlumno");
        UniAlumnoEntity entity = new UniAlumnoEntity();
        entity.setIdAlumno(request.getIdAlumno());
        entity.setCodigoAlumno(request.getCodigoAlumno());
        entity.setNombreAlumno(request.getNombreAlumno());
        entity.setApellidoAlumno(request.getApellidoAlumno());
        entity.setSemestreAlumno(request.getSemestreAlumno());
        UniCarreraEntity uniCarreraEntity = new UniCarreraEntity();
        uniCarreraEntity.setIdCarrera(request.getIdCarrera());
        entity.setCarreraEntity(uniCarreraEntity);
        uniAlumnoDao.registrarUniAlumno(entity);
    }
    
    @Override
    public UniAlumnoResponse buscarUniAlumno(int idAlumno) {
        log.info("UniCarreraServiceImpl.buscarUniCarrera");
        UniAlumnoEntity uniAlumnoEntity =uniAlumnoDao.buscarUniAlumno(idAlumno);
        UniAlumnoResponse uniAlumnoResponse = new UniAlumnoResponse();
        uniAlumnoResponse.setIdAlumno(uniAlumnoEntity.getIdAlumno());
        uniAlumnoResponse.setNombreAlumno(uniAlumnoEntity.getNombreAlumno());
        uniAlumnoResponse.setApellidoAlumno(uniAlumnoEntity.getApellidoAlumno());
        uniAlumnoResponse.setSemestreAlumno(uniAlumnoEntity.getSemestreAlumno());
        int idCarrera = uniAlumnoEntity.getCarreraEntity().getIdCarrera();
        UniCarreraEntity uniCarreraEntity = uniCarreraDao.buscarUniCarrera(idCarrera);
        uniAlumnoResponse.setCarrera(uniCarreraEntity.getNombreCarrera());
        return uniAlumnoResponse;
    }
    @Override
    public UniAlumnoResponse actualizarUniAlumno(UniAlumnoRequest request) {
        log.info("UniAlumnoServiceImpl.actualizarUniAlumno");
        UniAlumnoEntity uniAlumnoEntity = new UniAlumnoEntity();
        uniAlumnoEntity.setIdAlumno(request.getIdAlumno());
        uniAlumnoEntity.setCodigoAlumno(request.getCodigoAlumno());
        uniAlumnoEntity.setNombreAlumno(request.getNombreAlumno());
        uniAlumnoEntity.setApellidoAlumno(request.getApellidoAlumno());
        uniAlumnoEntity.setSemestreAlumno(request.getSemestreAlumno());
        UniCarreraEntity uniCarreraEntity = uniCarreraDao.buscarUniCarrera(request.getIdCarrera());
        uniAlumnoEntity.setCarreraEntity(uniCarreraEntity);
        UniAlumnoResponse uniAlumnoResponse = new UniAlumnoResponse();
        uniAlumnoResponse.setIdAlumno(uniAlumnoEntity.getIdAlumno());
        uniAlumnoResponse.setApellidoAlumno(uniAlumnoEntity.getApellidoAlumno());
        uniAlumnoResponse.setSemestreAlumno(uniAlumnoEntity.getSemestreAlumno());
        uniAlumnoResponse.setCarrera(uniAlumnoEntity.getCarreraEntity().getNombreCarrera());
        uniAlumnoDao.actualizarUniAlumno(uniAlumnoEntity.getIdAlumno(), uniAlumnoEntity);
        return uniAlumnoResponse;
    }
    
    @Override
    public List<UniAlumnoResponse> listarUniAlumno() {
        log.info("UniAlumnoServiceImpl.listarUniAlumno");
        List<UniAlumnoResponse> uniAlumnoResponseList = new ArrayList<>();
        List<UniAlumnoEntity> uniAlumnoEntityList = uniAlumnoDao.listarUniAlumno();
        uniAlumnoEntityList.forEach(p-> {
            UniAlumnoResponse response = new UniAlumnoResponse();
            response.setIdAlumno(p.getIdAlumno());
            response.setCodigoAlumno(p.getCodigoAlumno());
            response.setNombreAlumno(p.getNombreAlumno());
            response.setApellidoAlumno(p.getApellidoAlumno());
            response.setSemestreAlumno(p.getSemestreAlumno());
            int idCarrera = p.getCarreraEntity().getIdCarrera();
            UniCarreraEntity uniCarreraEntity = uniCarreraDao.buscarUniCarrera(idCarrera);
            response.setCarrera(uniCarreraEntity.getNombreCarrera());
            uniAlumnoResponseList.add(response);
        });
        return uniAlumnoResponseList;
    }
    
    @Override
    public List<UniAlumnoResponse> paginadoUniAlumno(Pageable pegeable) {
        log.info("UniAlumnoServiceImpl.paginadoUniAlumno");
        List<UniAlumnoResponse> uniAlumnoResponseList = new ArrayList<>();
        Page<UniAlumnoEntity> pageEntity = uniAlumnoDao.paginadoUniAlumno(pegeable);
        pageEntity.forEach(p->{
            UniAlumnoResponse response = new UniAlumnoResponse();
            response.setIdAlumno(p.getIdAlumno());
            response.setNombreAlumno(p.getNombreAlumno());
            response.setApellidoAlumno(p.getApellidoAlumno());
            response.setSemestreAlumno(p.getSemestreAlumno());
            int idCarrera = p.getCarreraEntity().getIdCarrera();
            UniCarreraEntity uniCarreraEntity = uniCarreraDao.buscarUniCarrera(idCarrera);
            response.setCarrera(uniCarreraEntity.getNombreCarrera());
            uniAlumnoResponseList.add(response);
        });
        return uniAlumnoResponseList;
    }
    
    @Override
    public void eliminarTodoUniAlumno() {
        log.info("UniAlumnoServiceImpl.eliminarTodoUniAlumno");
        uniAlumnoDao.eliminarTodoUniAlumno();
    }
    
	@Override
	public UniAlumnoResponse buscarPorCodigoAlumno(String codigoAlumno) {
        log.info("UniCarreraServiceImpl.buscarPorCodigoAlumno");
        UniAlumnoEntity uniAlumnoEntity =uniAlumnoDao.buscarPorCodigoAlumno(codigoAlumno);
        UniAlumnoResponse response = new UniAlumnoResponse();
        response.setIdAlumno(uniAlumnoEntity.getIdAlumno());
        response.setCodigoAlumno(uniAlumnoEntity.getCodigoAlumno());
        response.setNombreAlumno(uniAlumnoEntity.getNombreAlumno());
        response.setApellidoAlumno(uniAlumnoEntity.getApellidoAlumno());
        response.setSemestreAlumno(uniAlumnoEntity.getSemestreAlumno());
        int idCarrera = uniAlumnoEntity.getCarreraEntity().getIdCarrera();
        UniCarreraEntity uniCarreraEntity = uniCarreraDao.buscarUniCarrera(idCarrera);
        response.setCarrera(uniCarreraEntity.getNombreCarrera());
        
        log.info("@@@@@@@@@@@@@@@@@@@@   CODIGO  @@@@@@@"+response.getCodigoAlumno());
        return  response;
    }
    
}