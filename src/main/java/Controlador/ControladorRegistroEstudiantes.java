/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Estudiante;
import Modelo.RegistroEstudiantes;
import Vista.VRegEst;
import java.util.Date;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author dgarc
 */
public class ControladorRegistroEstudiantes {

    private VRegEst vista;
    private RegistroEstudiantes registroEstudiantes;

    public ControladorRegistroEstudiantes(VRegEst vista, RegistroEstudiantes registroEstudiantes) {
        this.vista = vista;
        this.registroEstudiantes = registroEstudiantes;
    }

    public void agregarEstudiante(String nombre, String apellido, String dni, Date fechaNacimiento) {
        Estudiante estudiante = new Estudiante(nombre, apellido, dni, fechaNacimiento);
        registroEstudiantes.agregarEstudiante(estudiante);
        vista.agregarEstudianteATabla(estudiante);
        JOptionPane.showMessageDialog(null, "Estudiante agregado correctamente.");
    }

    public void eliminarEstudiante(String dni) {
        Estudiante estudiante = registroEstudiantes.buscarEstudiante(dni);
        if (estudiante != null) {
            registroEstudiantes.eliminarEstudiante(estudiante);
            vista.eliminarEstudianteDeTabla(dni);
            JOptionPane.showMessageDialog(null, "Estudiante eliminado correctamente.");
        } else {
            JOptionPane.showMessageDialog(null, "Estudiante no encontrado.");
        }
    }

    public void modificarEstudiante(String dni, String nuevoNombre, String nuevoApellido, Date nuevaFechaNacimiento) {
        Estudiante estudiante = registroEstudiantes.buscarEstudiante(dni);
        if (estudiante != null) {
            estudiante.setNombre(nuevoNombre);
            estudiante.setApellido(nuevoApellido);
            estudiante.setFechaNacimiento(nuevaFechaNacimiento);
            registroEstudiantes.modificarEstudiante(estudiante);
            vista.modificarEstudianteEnTabla(estudiante);
            JOptionPane.showMessageDialog(null, "Estudiante modificado correctamente.");
        } else {
            JOptionPane.showMessageDialog(null, "Estudiante no encontrado.");
        }
    }
    
    
    public List<Estudiante> buscarEstudiantes(String valor) {
        List<Estudiante> estudiantesEncontrados = new ArrayList<>();
        for (Estudiante estudiante : registroEstudiantes.getEstudiantes()) {
            if (estudiante.getNombre().toLowerCase().contains(valor.toLowerCase())
                    || estudiante.getApellido().toLowerCase().contains(valor.toLowerCase())
                    || estudiante.getDni().toLowerCase().contains(valor.toLowerCase())) {
                estudiantesEncontrados.add(estudiante);
            }
        }
        return estudiantesEncontrados;
    }

    public void mostrarEstudiantes() {
        for (Estudiante estudiante : registroEstudiantes.getEstudiantes()) {
            System.out.println(estudiante.getNombre() + " " + estudiante.getApellido() + " - DNI: " + estudiante.getDni());
        }
    }
}
