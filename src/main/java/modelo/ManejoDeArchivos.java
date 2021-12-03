package modelo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
/**
 *
 * @author brandon
 */
public class ManejoDeArchivos {
    private final String fileAlum = "RegistrosAlumnos.csv";
    private final String fileAdmin = "RegistrosAdmin.csv";

    public ManejoDeArchivos() {
    }
    
    public boolean verificarExistenciaFileAlumno(){
        File file = new File(fileAlum);
        return file.exists();
    }
    
    public boolean verificarExistenciaFileAdmin(){
        File file = new File(fileAdmin);
        return file.exists();
    }
    
    public boolean CrearArchivoAlumno(){
        File file = new File(fileAlum);
        if(!file.exists()){
            try{
                file.createNewFile();
                FileWriter fw = new FileWriter(fileAlum);
                BufferedWriter bw = new BufferedWriter(fw);
                try (PrintWriter salida = new PrintWriter(bw)) {
                    salida.println("\"RFC\",\"Password\",\"Primer Nombre\"," +                                      //Cambiar la salida para alumnos
                            "\"Segundo Nombre\",\"Apellido Paterno\"," +
                            "\"Apellido Materno\",\"Fecha de Nacimiento\"," +
                            "\"Edad\",\"Fecha del Registro\",\"Pais\",\"Estado\"," +
                            "\"Municipio\",\"Ciudad\",\"Calle\",\"Colonia\"," +
                            "\"Numero Ext.\",\"Numero Int.\",\"Codigo Postal\"");
                    salida.println("123456789,123456789,,,,,,,,,,,,,,,,09745");
                    salida.close();
                }
            } catch (IOException ex) {
                ex.getMessage();
                ex.getStackTrace();
            }
        }
        return !file.exists();
    }
    
    public boolean CrearArchivoAdmin(){
        File file = new File(fileAdmin);
        if(!file.exists()){
            try{
                file.createNewFile();
                FileWriter fw = new FileWriter(fileAdmin);
                BufferedWriter bw = new BufferedWriter(fw);
                try (PrintWriter salida = new PrintWriter(bw)) {
                    salida.println("\"RFC\",\"Password\",\"Primer Nombre\"," +
                            "\"Segundo Nombre\",\"Apellido Paterno\"," +
                            "\"Apellido Materno\",\"Fecha de Nacimiento\"," +
                            "\"Edad\",\"Fecha del Registro\",\"Pais\",\"Estado\"," +
                            "\"Municipio\",\"Ciudad\",\"Calle\",\"Colonia\"," +
                            "\"Numero Ext.\",\"Numero Int.\",\"Codigo Postal\"");
                    salida.println("123456789,123456789,,,,,,,,,,,,,,,,09745");
                    salida.close();
                }
            } catch (IOException ex) {
                ex.getMessage();
                ex.getStackTrace();
            }
        }
        return !file.exists();
    }
}
