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
public class Curso {

    private int codigo;
    private String nombre;
    private int creditos;
    private ArrayList<Integer> cursospadre;

    public Curso(int codigo, String nombre, int creditos, ArrayList<Integer> cursospadre) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.creditos = creditos;
        this.cursospadre = cursospadre;
    }

    public Curso() {
        cursospadre = new ArrayList<>();//To change body of generated methods, choose Tools | Templates.
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public ArrayList<Integer> getCursospadre() {
        return cursospadre;
    }

    public void setCursospadre(ArrayList<Integer> cursospadre) {
        this.cursospadre = cursospadre;
    }
       
}
