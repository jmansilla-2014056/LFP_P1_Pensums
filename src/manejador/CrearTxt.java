/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejador;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Collection;
import static manejador.CrearDiagrama.creacionDibujo;
import modelos.Curso;
import modelos.Pensum;

/**
 *
 * @author User
 */
public class CrearTxt {
    
    public static void creacion(Collection<Pensum> listaPensum){
        FileWriter fichero = null;
        PrintWriter pw = null;
        for(Pensum p : listaPensum){
                    
        try
        {
            
            File miDir = new File (".");
            fichero = new FileWriter(miDir.getCanonicalPath() + "//" + p.getNombre()+ ".txt");
            pw = new PrintWriter(fichero);
            
            pw.println("digraph structs {");
            pw.println("label="+"\"" + p.getNombre()+"\"");
            pw.println("node [shape=record];");
            
            for(Curso c: p.getListaCurso()){
                pw.print(  c.getCodigo() + "[label=\"{ " + c.getCodigo() + "|"+c.getCreditos()+"} |{ "+c.getNombre()+"}| {");
                int x = 0;
                for(Integer i: c.getCursospadre()){
                    x++;
                    if(x==c.getCursospadre().size()){
                         pw.print(String.valueOf(i));
                    }else{
                         pw.print(String.valueOf(i)+"|");
                    }        
                   
                }
                pw.print("}\"];");
                pw.println("\n");
            }
            
            for(Curso c: p.getListaCurso()){
                for(Integer i: c.getCursospadre()){
                    pw.println(String.valueOf(i)+ "->" + String.valueOf(c.getCodigo()));
                }
            }
            
            pw.println("}");
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           // Nuevamente aprovechamos el finally para 
           // asegurarnos que se cierra el fichero.
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
            //Llamar a la funcion que sacara la grafica del codigo ejecutado
            creacionDibujo(p.getNombre());
        }
    } 
}
