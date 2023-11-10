/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.cibertec.examenfinal;

import edu.cibertec.examenfinal.dao.EstudianteDAO;
import edu.cibertec.examenfinal.model.Estudiante;
import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author CJJC
 */
public class Ejecutora {
    
    private static final Logger LOGGER = Logger.getLogger(Ejecutora.class.getName());
    
    public static void main(String[] args) {
        EstudianteDAO ed = new EstudianteDAO();
        List<Estudiante> listaestudiantes = new ArrayList<>();
        ed.deleteEstudianteAll();
        cargarEstudiantes(ed);
        listaestudiantes.add(new Estudiante(1, "Christian Jiménez", 15));
        listaestudiantes.add(new Estudiante(2, "Emily Castro", 14));
        listaestudiantes.add(new Estudiante(3, "Hanna Jiménez", 13));
        listaestudiantes.add(new Estudiante(4, "Chimi Jiménez", 16));
        listaestudiantes.add(new Estudiante(5, "Luppy la Cuenta", 18));
        System.out.println("********** REGISTRO DE 5 ESTUDIANTES **********");
        for (Estudiante e : listaestudiantes) {
            insertEstudiante(ed, e);
        }
        System.out.println("");
        System.out.println("********** LISTADO DE ESTUDIANTES **********");
        cargarEstudiantes(ed);
        System.out.println("");
        System.out.println("********** ACTUALIZACION DE 2 ESTUDIANTES **********");
        Estudiante e1 = new Estudiante(4, "Nueva actualización 1", 6);
        updateEstudiante(ed, e1);
        Estudiante e2 = new Estudiante(5, "Nueva actualización 2", 5);
        updateEstudiante(ed, e2);
        //cargarEstudiantes(ed);
        System.out.println("");
        System.out.println("********** ELIMINACIÓN DE 1 ESTUDIANTE **********");
        deleteEstudiante(ed, e2);
        
        // cargamos los nuevos datos en el arrayList
        System.out.println("");
        System.out.println("********** DATOS FINALES **********");
        listaestudiantes.clear();
        listaestudiantes.addAll(cargarEstudiantes(ed));
        System.out.println("");
        System.out.println("********** ESTADISTICAS CON LA EDAD **********");
        //sacamos los datos kpi:
        DoubleSummaryStatistics kpisEdad = listaestudiantes.stream()
                .mapToDouble((Estudiante e) -> e.getEdad())
                .summaryStatistics();
        LOGGER.info("=============================================");
        LOGGER.log(Level.INFO, "La suma total de edades es: {0}", kpisEdad.getSum());
        LOGGER.log(Level.INFO, "La edad mayor es: {0}", kpisEdad.getMax());
        LOGGER.log(Level.INFO, "La edad menor es: {0}", kpisEdad.getMin());
        LOGGER.log(Level.INFO, "El promedio de edades es: {0}", kpisEdad.getAverage());
        LOGGER.info("=============================================");
        
    }
    
    static List<Estudiante> cargarEstudiantes(EstudianteDAO ed) {
           List<Estudiante> listaEstudiantes = ed.obtenerEstudiantes();
           listaEstudiantes.stream().forEach((Estudiante e)->{
                LOGGER.warning(e.toString()); 
           });
           return listaEstudiantes;
       }

    static void insertEstudiante(EstudianteDAO ed, Estudiante e)  {
        ed.inserEstudiante(e);
    }
    
    static void updateEstudiante(EstudianteDAO ed, Estudiante e) {
        ed.updateEstudiante(e);
    }
    
    static void deleteEstudiante(EstudianteDAO ed, Estudiante e) {
        ed.deleteEstudiante(e);
    }

}
