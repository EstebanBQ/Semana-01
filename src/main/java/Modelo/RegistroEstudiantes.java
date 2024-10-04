/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dgarc
 */
public class RegistroEstudiantes {

    private List<Estudiante> estudiantes;

    public RegistroEstudiantes() {
        this.estudiantes = new ArrayList<>();
    }

    public void agregarEstudiante(Estudiante estudiante) {
        this.estudiantes.add(estudiante);
    }

    public void eliminarEstudiante(Estudiante estudiante) {
        this.estudiantes.remove(estudiante);
    }

    public void modificarEstudiante(Estudiante estudiante) {
        for (Estudiante e : this.estudiantes) {
            if (e.getDni().equals(estudiante.getDni())) {
                e.setNombre(estudiante.getNombre());
                e.setApellido(estudiante.getApellido());
                e.setFechaNacimiento(estudiante.getFechaNacimiento());
                break;
            }
        }
    }

    public Estudiante buscarEstudiante(String dni) {
        for (Estudiante estudiante : this.estudiantes) {
            if (estudiante.getDni().equals(dni)) {
                return estudiante;
            }
        }
        return null;
    }

    public List<Estudiante> getEstudiantes() {
        return this.estudiantes;
    }
}
