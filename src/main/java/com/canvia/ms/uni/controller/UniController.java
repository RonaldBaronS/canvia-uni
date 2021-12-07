package com.canvia.ms.uni.controller;

import com.canvia.ms.uni.model.MessageResponse;
import com.canvia.ms.uni.model.UniAlumnoRequest;
import com.canvia.ms.uni.model.UniAlumnoResponse;
import com.canvia.ms.uni.model.UniCarreraRequest;
import com.canvia.ms.uni.model.UniCarreraResponse;
import com.canvia.ms.uni.model.UniMateriaRequest;
import com.canvia.ms.uni.model.UniMateriaResponse;
import com.canvia.ms.uni.model.UniProfesorRequest;
import com.canvia.ms.uni.model.UniProfesorResponse;
import com.canvia.ms.uni.service.UniAlumnoService;
import com.canvia.ms.uni.service.UniCarreraService;
import com.canvia.ms.uni.service.UniMateriaService;
import com.canvia.ms.uni.service.UniProfesorService;
import com.canvia.ms.uni.util.UniConstantes;

import java.util.List;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * UniController.* 
 * @author Ronald Baron.
 * @version 1.0
 */
@Slf4j
@RestController
@RequestMapping("/universidad/api/v1")
public class UniController {
    
    @Autowired
    private UniCarreraService uniCarreraService;
    
    @Autowired
    private UniProfesorService uniProfesorService;
    
    @Autowired
    private UniAlumnoService uniAlumnoService;
    
    @Autowired
    private UniMateriaService uniMateriaService;
    
    /**
     * Metodo para registrar carreras.
     */
    @PostMapping(value = "/carrera", produces = UniConstantes.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<MessageResponse> registrarCarrera(@RequestBody UniCarreraRequest request) {
        log.info("UniController.registrarCarrera");
        uniCarreraService.registrarUniCarrera(request);
        return new ResponseEntity<>(new MessageResponse(UniConstantes.MENSAJE_EXITOSO), HttpStatus.CREATED);
    }
    
    /**
     * Metodo para buscar carrera
     */
    @GetMapping(value = "/carrera", produces = UniConstantes.APPLICATION_JSON_UTF8_VALUE)
    public UniCarreraResponse obtenerCarrera(@RequestParam(name = "id") int id ) {
       log.info("UniController.obtenerCarrera");
       return uniCarreraService.buscarUniCarrera(id);
    }
    
    /**
     * Metodo para modificar carrera
     */
    @PutMapping(value ="/carrera", produces = UniConstantes.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<MessageResponse> modificarCarrera(@RequestBody UniCarreraRequest request) {
        log.info("UniController.modificarCarrera");
        uniCarreraService.actualizarUniCarrera(request);
        return new ResponseEntity<>(new MessageResponse(UniConstantes.MENSAJE_ACTUALIZACION), HttpStatus.CREATED);
    }
    
    /**
     * Metodo para eliminar carrera
     */
    @DeleteMapping(value = "/carrera/{idCarrera}", produces = UniConstantes.APPLICATION_JSON_UTF8_VALUE )
    public ResponseEntity<MessageResponse> eliminarCarrera(@PathVariable("idCarrera") int idCarrera) {
        log.info("UniController.eliminarCarrera");
        uniCarreraService.eliminarUniCarrera(idCarrera);
        return new ResponseEntity<>(new MessageResponse(UniConstantes.MENSAJE_ELIMINACION), HttpStatus.NO_CONTENT);
    }
    
    /**
     * Metodo para listar todas las carreras
     */
    @GetMapping(value = "/carreras", produces = UniConstantes.APPLICATION_JSON_UTF8_VALUE)
    public List<UniCarreraResponse> listarCarrera() {
        log.info("UniController.listarCarrera");
        return uniCarreraService.listarUniCarrera();
    }
    
    /**
     * Metodo para paginar las carreras
     */
    @GetMapping(value = "/carrera/page/{page}", produces = UniConstantes.APPLICATION_JSON_UTF8_VALUE)
    public List<UniCarreraResponse> paginarCarrera(@PathVariable Integer page) {
        log.info("UniController.paginarCarrera");
        return uniCarreraService.paginadoUniCarrera(PageRequest.of(page, 3));
    }
    
    /**
     * Metodo eliminar todos los registros carrera
     */
    @DeleteMapping(value ="/carrera/todo")
    public ResponseEntity<MessageResponse> eliminarTodoCarrera() {
        log.info("UniController.eliminarTodoCarrera");
        uniCarreraService.eliminarTodoUniCarrera();
        return new ResponseEntity<>(new MessageResponse(UniConstantes.MENSAJE_ELIMINACION_TODO), HttpStatus.NO_CONTENT);
    }
    
    /**
     * Metodo para registrar profesor.
     */
    @PostMapping(value = "/profesor", produces = UniConstantes.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<MessageResponse> registrarProfesor(@RequestBody UniProfesorRequest request) {
        log.info("UniController.registrarProfesor");
        uniProfesorService.registrarUniProfesor(request);
        return new ResponseEntity<>(new MessageResponse(UniConstantes.MENSAJE_EXITOSO),HttpStatus.CREATED);
    }
    
    /**
     * Metodo para buscar profesor
     */
    @GetMapping(value = "/profesor", produces = UniConstantes.APPLICATION_JSON_UTF8_VALUE)
    public UniProfesorResponse obtenerProfesor(@RequestParam(name = "id") int id ) {
       log.info("UniController.obtenerProfesor");
       return uniProfesorService.buscarUniProfesor(id);
    }
    
    /**
     * Metodo para modificar profesor
     */
    @PutMapping(value ="/profesor", produces = UniConstantes.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<MessageResponse> modificarProfesor(@RequestBody UniProfesorRequest request) {
        log.info("UniController.modificarProfesor");
        uniProfesorService.actualizarUniProfesor(request);
        return new ResponseEntity<>(new MessageResponse(UniConstantes.MENSAJE_ACTUALIZACION), HttpStatus.CREATED);
    }
    
    /**
     * Metodo para eliminar profesor
     */
    @DeleteMapping(value = "/profesor/{idProfesor}", produces = UniConstantes.APPLICATION_JSON_UTF8_VALUE )
    public ResponseEntity<MessageResponse> eliminarProfesor(@PathVariable("idProfesor") int idProfesor) {
        log.info("UniController.eliminarProfesor");
        uniProfesorService.eliminarUniProfesor(idProfesor);
        return new ResponseEntity<>(new MessageResponse(UniConstantes.MENSAJE_ELIMINACION), HttpStatus.NO_CONTENT);
    }
    
    /**
     * Metodo para listar todas las profesores
     */
    @GetMapping(value = "/profesores", produces = UniConstantes.APPLICATION_JSON_UTF8_VALUE)
    public List<UniProfesorResponse> listarProfesor() {
        log.info("UniController.listarProfesor");
        return uniProfesorService.listarUniProfesor();
    }
    
    /**
     * Metodo para paginar las profesor
     */
    @GetMapping(value = "/profesor/page/{page}", produces = UniConstantes.APPLICATION_JSON_UTF8_VALUE)
    public List<UniProfesorResponse> paginarProfesor(@PathVariable Integer page) {
        log.info("UniController.paginarProfesor");
        return uniProfesorService.paginadoUniProfesor(PageRequest.of(page, 3));
    }
    
    /**
     * Metodo eliminar todos los registros de profesores
     */
    @DeleteMapping(value ="/profesor/todo")
    public ResponseEntity<MessageResponse> eliminarTodoProfesor() {
        log.info("UniController.eliminarTodoProfesor");
        uniProfesorService.eliminarTodoUniProfesor();
        return new ResponseEntity<>(new MessageResponse(UniConstantes.MENSAJE_ELIMINACION_TODO), HttpStatus.NO_CONTENT);
    }
    
    /**
     * Metodo para registrar alumnos con carrera.
     */
    @PostMapping(value = "/alumno", produces = UniConstantes.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<MessageResponse> registrarAlumno(@RequestBody UniAlumnoRequest request) {
        log.info("UniController.registrarAlumno");
        uniAlumnoService.registrarUniAlumno(request);
        return new ResponseEntity<>(new MessageResponse(UniConstantes.MENSAJE_EXITOSO),HttpStatus.CREATED);
    }
    
    /**
     * Metodo para buscar alumno
     */
    @GetMapping(value = "/alumno", produces = UniConstantes.APPLICATION_JSON_UTF8_VALUE)
    public UniAlumnoResponse obtenerAlumno(@RequestParam(name = "id") int id ) {
       log.info("UniController.obtenerAlumno");
       return uniAlumnoService.buscarUniAlumno(id);
    }
    
    /**
     * Metodo para modificar alumno
     */
    @PutMapping(value ="/alumno", produces = UniConstantes.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<MessageResponse> modificarAlumno(@RequestBody UniAlumnoRequest request) {
        log.info("UniController.modificarAlumno");
        uniAlumnoService.actualizarUniAlumno(request);
        return new ResponseEntity<>(new MessageResponse(UniConstantes.MENSAJE_ACTUALIZACION), HttpStatus.CREATED);
    }
    
    /**
     * Metodo para listar todas las carreras
     */
    @GetMapping(value = "/alumnos", produces = UniConstantes.APPLICATION_JSON_UTF8_VALUE)
    public List<UniAlumnoResponse> listarAlumno() {
        log.info("UniController.listarCarrera");
        return uniAlumnoService.listarUniAlumno();
    }
    
    /**
     * Metodo para paginar las alumnos
     */
    @GetMapping(value = "/alumno/page/{page}", produces = UniConstantes.APPLICATION_JSON_UTF8_VALUE)
    public List<UniAlumnoResponse> paginarAlumno(@PathVariable Integer page) {
        log.info("UniController.paginarAlumno");
        return uniAlumnoService.paginadoUniAlumno(PageRequest.of(page, 3));
    }
    
    /**
     * Metodo eliminar todos los registros alumno
     */
    @DeleteMapping(value ="/alumno/todo")
    public ResponseEntity<MessageResponse> eliminarTodoAlumno() {
        log.info("UniController.eliminarTodoCarrera");
        uniAlumnoService.eliminarTodoUniAlumno();
        return new ResponseEntity<>(new MessageResponse(UniConstantes.MENSAJE_ELIMINACION_TODO), HttpStatus.NO_CONTENT);
    }
    
    /**
     * Metodo para buscar alumno por codigo
     */
    @GetMapping(value = "/alumnoPorCodigo", produces = UniConstantes.APPLICATION_JSON_UTF8_VALUE)
    public UniAlumnoResponse obtenerAlumnoPorCodigo(@RequestParam(name = "codigoAlumno") String codigoAlumno ) {
       log.info("UniController.obtenerAlumnoPorCodigo");
       return uniAlumnoService.buscarPorCodigoAlumno(codigoAlumno);
    }
    
    /**
     * Metodo para registrar materias.
     */
    @PostMapping(value = "/materia", produces = UniConstantes.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<MessageResponse> registrarMateria(@RequestBody UniMateriaRequest request) {
        log.info("UniController.registrarMateria");
        uniMateriaService.registrarUniMateria(request);
        return new ResponseEntity<>(new MessageResponse(UniConstantes.MENSAJE_EXITOSO),HttpStatus.CREATED);
    }
    
    /**
     * Metodo para buscar materia
     */
    @GetMapping(value = "/materia", produces = UniConstantes.APPLICATION_JSON_UTF8_VALUE)
    public UniMateriaResponse obtenerMateria(@RequestParam(name = "id") int id ) {
       log.info("UniController.obtenerMateria");
       return uniMateriaService.buscarUniMateria(id);
    }
    
    /**
     * Metodo para modificar materia
     */
    @PutMapping(value ="/materia", produces = UniConstantes.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<MessageResponse> modificarMateria(@RequestBody UniMateriaRequest request) {
        log.info("UniController.modificarMateria");
        uniMateriaService.actualizarUniMateria(request);
        return new ResponseEntity<>(new MessageResponse(UniConstantes.MENSAJE_ACTUALIZACION), HttpStatus.CREATED);
    }
    
    /**
     * Metodo para eliminar materia
     */
    @DeleteMapping(value = "/materia/{idMateria}", produces = UniConstantes.APPLICATION_JSON_UTF8_VALUE )
    public ResponseEntity<MessageResponse> eliminarMateria(@PathVariable("idMateria") int idMateria) {
        log.info("UniController.eliminarMateria");
        uniMateriaService.eliminarUniMateria(idMateria);
        return new ResponseEntity<>(new MessageResponse(UniConstantes.MENSAJE_ELIMINACION), HttpStatus.NO_CONTENT);
    }
    
    /**
     * Metodo para listar todas las materias
     */
    @GetMapping(value = "/materias", produces = UniConstantes.APPLICATION_JSON_UTF8_VALUE)
    public List<UniMateriaResponse> listarMateria() {
        log.info("UniController.listarMateria");
        return uniMateriaService.listarUniMateria();
    }
    
    /**
     * Metodo para paginar las carreras
     */
    @GetMapping(value = "/materia/page/{page}", produces = UniConstantes.APPLICATION_JSON_UTF8_VALUE)
    public List<UniMateriaResponse> paginarMateria(@PathVariable Integer page) {
        log.info("UniController.paginaMateria");
        return uniMateriaService.paginadoUniMateria(PageRequest.of(page, 3));
    }
    
    /**
     * Metodo eliminar todos los registros materia
     */
    @DeleteMapping(value ="/materia/todo")
    public ResponseEntity<MessageResponse> eliminarTodoMateria() {
        log.info("UniController.eliminarTodoMateria");
        uniCarreraService.eliminarTodoUniCarrera();
        return new ResponseEntity<>(new MessageResponse(UniConstantes.MENSAJE_ELIMINACION_TODO), HttpStatus.NO_CONTENT);
    }
    
}