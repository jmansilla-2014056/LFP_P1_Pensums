/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejador;

import java.util.ArrayList;
import java.util.Collection;
import static manejador.CrearTxt.creacion;
import modelos.Curso;
import modelos.Pensum;
import modelos.Tokens;

/**
 *
 * @author User
 */
public class ManejarTokens {

    public static ArrayList<Pensum> HacerPensum(ArrayList<Tokens> LT){
        int estado=0;
        Pensum pensum = new Pensum();
        Curso curso = new Curso();
        Collection<Pensum> listaPensum = new ArrayList<>(); 
        
        for(Tokens t: LT){
            
            //Que venga la palabra reservada pensum
            if(estado==0){
                if(t.getId()==10){
                    estado=1;
                    continue;
                }else{
                  //Error no viene lo que se espera      
                }
            }
            
            //Que vengan dos puntos
            if(estado==1){
                if(t.getId()==20){
                    estado=2;
                    continue;
                }else{
                    
                }
            }
            
            //Que venga comillas
            if(estado==2){
                if(t.getId()==23){                    
                    estado=3;
                    continue;
                }else{
                    
                }
            }   
            
            //Que venga un nombre para el pensum
            if(estado==3){
                if(t.getId()==31){
                    pensum.setNombre(t.getLexema());
                    estado=4;
                    continue;
                }else{
                    
                }
            }   
            
            //Que venga las comillas que cierran el nombre del pensum
             if(estado==4){
                if(t.getId()==23){
                    estado=5;
                    continue;
                }else{
                    
                }
            }
            
             //que vengan los dos puntos despues del nombre del pensum
             if(estado==5){
                 if(t.getId()==20){
                     estado = 6;
                     continue;
                 }else{
                     
                 }
             }
             
            //Que vengan abrir llaves para poner cursos 
            if(estado==6){
                if(t.getId()==21){
                    estado=7;
                    continue;
                }else{
                    
                }
            }
            
            //Que vengan palabra curso o que se cierre llaves
            if(estado==7){
                if(t.getId()==11){
                    estado=8;
                    continue;
                }else if(t.getId()==22){
                    estado=0;
                    listaPensum.add(pensum);
                    pensum = new Pensum();
                    continue;
                }else{
                    
                }                
            }
            
            //que vengan dos puntos despues de la palabra curso
            if(estado==8){
                if(t.getId()==20){
                    estado=9;
                    continue;
                }else{
                    
                }                
            }
            
            //que vengan abrir llaves para poner propiedades del curso
            if(estado==9){
                if(t.getId()==21){
                    estado=10;
                    continue;
                }else{
                    
                }
            }
            
            //Que venga la palabra codigo, nombre, creditos o prerrequisitos o que se cierre con llaves
            if(estado==10){
                //codigo
                if(t.getId()==12){
                    estado = 122;
                    continue;
                }else if(t.getId()==13){
                    estado = 133;
                    continue;
                }else if(t.getId()==14){
                    estado = 144;
                    continue;
                }else if(t.getId()==15){
                    estado = 155;
                    continue;
                }else if(t.getId()==22){
                    pensum.getListaCurso().add(curso);
                    curso = new Curso();
                    estado=7;
                    continue;
                }else{
                    
                }
            }
            
            
            //se espera : puntos para codigo
            if(estado == 122){
             if(t.getId()==20){
                 estado=1222;
                 continue;
             }else{
                 
             }  
            }
            
            //se espera : puntos para nombre
            if(estado == 133){
             if(t.getId()==20){
                 estado = 1333;
                 continue;
             }else{
                 
             }  
            }
            
            //se espera : puntos para creditos
            if(estado == 144){
             if(t.getId()==20){
                 estado = 1444;
                 continue;
             }else{
                 
             }  
            }
            
            
            //se espera : puntos para prerrequisitos
            if(estado == 155){
             if(t.getId()==20){
                 estado = 1555;
                 continue;
             }else{
                 
             }  
            }
            
            
            
            //ingresar el entero para codigo 
            if(estado == 1222){
             if(t.getId()==30){
                 curso.setCodigo(Integer.parseInt(t.getLexema()));
                 estado = -1;
                 continue;
             }else{
                 
             }  
            }
            
            //ingresar el entero de los creditos del curso
            if(estado == 1444){
                if(t.getId()==30){
                 curso.setCreditos(Integer.parseInt(t.getLexema()));
                 estado = -1;
                 continue;
             }else{
                 
             }  
            }
            
            
            //esperar llaves para poner los prerequisitos del curso
            if(estado == 1555){
                if(t.getId()==21){
                    estado = 15555;
                    continue;
                }else{
                    
                }
            }
            
            //que venga el entero o cerrar llaves
            if(estado==15555){
                if(t.getId()==30){
                    curso.getCursospadre().add(Integer.parseInt(t.getLexema()));
                    estado = -15;
                    continue;
                    
                }else if(t.getId()==22){
                    estado = -1;
                    continue;
                }else{
                    
                }
            }
            
            //que venga una coma para colocar otro entero o cerrar llaves
            if(estado == -15){
                if(t.getId()==25){
                    estado = 15555;
                    continue;
                }else if(t.getId()==22){
                    estado = -1;
                    continue;
                }else{
                    
                }
            }
                        
            //esperar comillas para poner el nombre del curso
            if(estado == 1333){
                if(t.getId()==23){
                    estado = 13333;
                    continue;
                }else{
                    
                }                
            }
            
            //esperar el texto del curso
            if(estado == 13333){
                if(t.getId()==31){
                    curso.setNombre(t.getLexema());
                    estado = 133333;
                    continue;
                }else{
                    
                }
            }
            
            //esperar cierre de comilla del nombre del curso
            if(estado == 133333){
                if(t.getId()==23){
                    estado = -1;
                    continue;
                }else{
                    
                }
            }
            
            
            //esperar punto y como
            if(estado == -1){
                if(t.getId()==24){
                  estado = 10; 
                }else{
                    
                }            
            }
            
            
        }
        
        for(Pensum p: listaPensum){
            System.out.println("******************************************");
            System.out.println("NOMBRE DEL PENSUM: " + p.toString());
            for(Curso c: p.getListaCurso()){
                System.out.println("NOMBRE DEL CURSO: " + c.getNombre());
                System.out.println("CREDITOS: " + c.getCreditos());
                System.out.println("CODIGO: " + c.getCodigo());
                System.out.println("PREREQUSISTOS" + c.getCursospadre().toString());
            }
        }
        
        creacion(listaPensum);
       return (ArrayList<Pensum>) listaPensum;     
    }

    
}
