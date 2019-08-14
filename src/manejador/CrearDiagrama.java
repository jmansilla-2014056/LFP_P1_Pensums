/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejador;

import java.io.File;

/**
 *
 * @author User
 */
public class CrearDiagrama {
    
    public static void creacionDibujo(String titulo){
        try{
                
      String dotPath = "C:\\Program Files (x86)\\Graphviz2.38\\bin\\dot.exe";
      File miDir = new File (".");
      System.out.println(miDir.getCanonicalPath());
      String fileInputPath = miDir.getCanonicalPath() +"\\"+ titulo +".txt";
      String fileOutputPath = miDir.getCanonicalPath()  +"\\"+titulo+".png";
      
      String tParam = "-Tpng";
      String tOParam = "-o";
        
      String[] cmd = new String[5];
      cmd[0] = dotPath;
      cmd[1] = tParam;
      cmd[2] = fileInputPath;
      cmd[3] = tOParam;
      cmd[4] = fileOutputPath;
                  
      Runtime rt = Runtime.getRuntime();
      
      rt.exec( cmd );
      
    } catch (Exception ex) {
      ex.printStackTrace();
    } finally {
    }

    }
    
}
