/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author User
 */
public class Pensum {
    private String nombre;
    private Collection<Curso> listaCurso;

    public Pensum(String nombre, Collection<Curso> listaCurso) {
        this.nombre = nombre;
        this.listaCurso = listaCurso;
    }

    public Pensum() {
        listaCurso = new ArrayList<>(); //To change body of generated methods, choose Tools | Templates.
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Collection<Curso> getListaCurso() {
        return listaCurso;
    }

    public void setListaCurso(Collection<Curso> listaCurso) {
        this.listaCurso = listaCurso;
    }


    
}
