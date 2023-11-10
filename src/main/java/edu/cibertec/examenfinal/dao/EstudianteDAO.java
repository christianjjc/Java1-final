/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.cibertec.examenfinal.dao;

import edu.cibertec.examenfinal.ConexionBD;
import edu.cibertec.examenfinal.model.Estudiante;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author CJJC
 */
public class EstudianteDAO {
    
    private static final Logger LOGGER = Logger.getLogger(EstudianteDAO.class.getName());

    public List<Estudiante> obtenerEstudiantes() {
        List<Estudiante> listaEstudiantes = null;
        int codigo;
        String nombre;
        int edad;
        try {
            Connection cn = ConexionBD.getConnection();
            listaEstudiantes = new ArrayList<>();
            PreparedStatement st = cn.prepareStatement("SELECT * FROM examenfinal.estudiante");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                codigo = rs.getInt("codigo");
                nombre = rs.getString("nombre");
                edad = rs.getInt("edad");
                Estudiante e = new Estudiante(codigo, nombre, edad);
                listaEstudiantes.add(e);
            }
            ConexionBD.cierraResultSet(rs);
            ConexionBD.cierraConexion(cn);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            return listaEstudiantes;
        }
    }
    
    public void inserEstudiante(Estudiante e){
        try {
            Connection cn = ConexionBD.getConnection();
            PreparedStatement ps = cn.prepareStatement("INSERT INTO examenfinal.estudiante (codigo, nombre, edad) VALUES (?,?,?)");
            ps.setInt(1, e.getCodigo());
            ps.setString(2, e.getNombre());
            ps.setInt(3, e.getEdad());
            ps.execute();
            ConexionBD.cierraConexion(cn);
            LOGGER.log(Level.WARNING, "Estudiante Registrado! --> {0}", e.toString());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void updateEstudiante(Estudiante e){
        try {
            Connection cn = ConexionBD.getConnection();
            PreparedStatement ps = cn.prepareStatement("UPDATE examenfinal.estudiante SET nombre=?,edad=? WHERE codigo=?");
            ps.setString(1, e.getNombre());
            ps.setInt(2, e.getEdad());
            ps.setInt(3, e.getCodigo());
            ps.execute();
            ConexionBD.cierraConexion(cn);
            LOGGER.log(Level.WARNING, "Estudiante Actualizado! --> {0}", e.toString());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void deleteEstudiante(Estudiante e){
        try {
            Connection cn = ConexionBD.getConnection();
            PreparedStatement ps = cn.prepareStatement("DELETE FROM examenfinal.estudiante WHERE codigo=?");
            ps.setInt(1, e.getCodigo());
            ps.execute();
            ConexionBD.cierraConexion(cn);
            LOGGER.log(Level.WARNING, "Estudiante Eliminado! --> {0}", e.toString());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
        

        public void deleteEstudianteAll(){
        try {
            Connection cn = ConexionBD.getConnection();
            PreparedStatement ps = cn.prepareStatement("DELETE FROM examenfinal.estudiante");
            ps.execute();
            ConexionBD.cierraConexion(cn);
            System.out.println("*** TODOS LOS REGISTROS HAN SIDO ELIMINADOS PARA EMPEZAR NUEVAMENTE! ***");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    
    
}
