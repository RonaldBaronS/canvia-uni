package com.canvia.ms.uni.controller;

import com.canvia.ms.uni.model.UniAlumnoResponse;
import com.canvia.ms.uni.model.UniCarreraResponse;
import com.canvia.ms.uni.model.UniMateriaResponse;
import com.canvia.ms.uni.model.UniProfesorResponse;
import com.canvia.ms.uni.service.UniAlumnoService;
import com.canvia.ms.uni.service.UniCarreraService;
import com.canvia.ms.uni.service.UniMateriaService;
import com.canvia.ms.uni.service.UniProfesorService;

import java.util.List;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * UniApisController.* 
 * @author Ronald Baron.
 * @version 1.0
 */
@Slf4j
@Controller
@RequestMapping("/universidad/v1")
public class UniApiController {
    
    @Autowired
    private UniCarreraService uniCarreraService;
    
    @Autowired
    private UniProfesorService uniProfesorService;
    
    @Autowired
    private UniAlumnoService uniAlumnoService;
    
    @Autowired
    private UniMateriaService uniMateriaService;
	
    /**
     * Metodo para obtener vista de inicio.
     */
    @GetMapping("/inicio")
    public String inicio() {
        log.info("UniApisController.inicio");
        return "index";
    }
    
    @GetMapping("/buscarAlumno")
    public String buscarAlumno() {
        log.info("UniApisController.buscarAlumno");
        return "buscarAlumno";
    }
    
    /**
     * Metodo para listar carreras
     */
    @GetMapping(value = "/carreras")
    public String listarCarrera(Model model) {
        log.info("UniApisController.listarCarrera");
        List<UniCarreraResponse> uniCarreraResponse = uniCarreraService.listarUniCarrera();
        model.addAttribute("idCarrera", "Código de Carrera");
        model.addAttribute("nombreCarrera","Carrera Profesional");
        model.addAttribute("tiempoCarrera","Duración");
        model.addAttribute("carreras", uniCarreraResponse);
        return "/views/form/listarCarrera";
    }
    
    /**
     * Metodo para listar profesores
     */
    @GetMapping(value = "/profesores")
    public String listarProfesor(Model model) {
        log.info("UniApisController.listarCarrera");
        List<UniProfesorResponse> uniProfesorResponse = uniProfesorService.listarUniProfesor();
        model.addAttribute("idProfesor", "Código de Profesor");
        model.addAttribute("nombreProfesor","Nombre");
        model.addAttribute("horarioProfesor","Horario");
        model.addAttribute("profesores", uniProfesorResponse);
        return "/views/form/listarProfesor";
    }
    
    /**
     * Metodo para listar cursos
     */
    @GetMapping(value = "/cursos")
    public String listarMateria(Model model) {
        log.info("UniApisController.listarCarrera");
        List<UniMateriaResponse> uniMateriaResponse = uniMateriaService.listarUniMateria();
        model.addAttribute("idMateria", "Código de Curso");
        model.addAttribute("nombreMateria", "Nombre del Curso");
        model.addAttribute("creditoMateria", "Créditos Académicos");
        model.addAttribute("materias", uniMateriaResponse);
        return "/views/form/listarMateria";
    }
    
    /**
     * Metodo para listar alumnos
     */
    @GetMapping(value = "/alumnos")
    public String listarAlumnos(Model model) {
        log.info("UniApisController.listarAlumnos");
        List<UniAlumnoResponse> uniAlumnoResponse = uniAlumnoService.listarUniAlumno();
        model.addAttribute("idAlumno", "ID Alumno");
        model.addAttribute("codigoAlumno", "Código de Alumno");
        model.addAttribute("nombreAlumno", "Nombre Alumno");
        model.addAttribute("apellidoAlumno", "Apellido Alumno");
        model.addAttribute("semestreAlumno", "Semestre Alumno");
        model.addAttribute("carrera", "Carrera Profesional");
        model.addAttribute("alumnos", uniAlumnoResponse);
        return "/views/form/listarAlumno";
    }
    
    /**
     * Metodo para buscar por codigo a un Alumno
     */
    
    @GetMapping(value = "/alumnoCodigo")
    public String buscarPorCodigoAlumno(@RequestParam(value="codigo",required = false) String codigo, Model model) {
        model.addAttribute("response",uniAlumnoService.buscarPorCodigoAlumno(codigo));
    	return "/buscarAlumno";
    }
}
