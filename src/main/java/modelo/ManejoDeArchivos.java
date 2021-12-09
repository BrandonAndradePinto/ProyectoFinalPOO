package modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
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
                    salida.println("\"Numero de Cuenta\",\"Password\",\"Primer Nombre\","
                            + "\"Segundo Nombre\",\"Apellido Paterno\",Apellido Materno\","
                            + "\"Sexo\",\"Fecha de Nacimiento\",\"Edad\",\"Fecha del Registro\","
                            + "\"Pais\",\"Estado\",\"Municipio\",\"Ciudad\",\"Calle\",\"Colonia\","
                            + "\"Numero Ext.\",\"Numero Int.\",\"Codigo Postal\","
                            + "\"Numero de Inscripcion\",\"Promedio\",\"Indicador Escolar\","
                            + "\"Creditos del Alumno\",\"Semeatre de Ingreso\","
                            + "\"Semestres Activo\","
                            + "\"Asignaturas inscritas en Ordinario\","
                            + "\"Asignaturas aprobadas en Ordinario\",\"Regular\"");
                    salida.println("0,0,0");
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
                            "\"Apellido Materno\",\"Sexo\",\"Fecha de Nacimiento\"," +
                            "\"Edad\",\"Fecha del Registro\",\"Pais\",\"Estado\"," +
                            "\"Municipio\",\"Ciudad\",\"Calle\",\"Colonia\"," +
                            "\"Numero Ext.\",\"Numero Int.\",\"Codigo Postal\"");
                    salida.println("0,0,0");
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
    
    public void modificarArchivoNumReg(int linea, int dato, boolean usuario){  //true para alumno y false para admin
        if(usuario){ //Alumnos
            String fileAluAux = "AlumnosAux.csv";
            File file = new File(fileAlum);
            File fileAux = new File(fileAluAux);
            try{
                if(!file.exists()){
                    CrearArchivoAdmin();
                }if(!fileAux.exists()){
                    fileAux.createNewFile();
                }
                //Arch de datos
                BufferedReader br;
                FileReader fr = new FileReader(fileAlum);
                br = new BufferedReader(fr);
                
                //Arch Aux
                FileWriter fw = new FileWriter(fileAluAux);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter salida = new PrintWriter(bw);
                
                int cont = 0;
                String datoLinea = br.readLine();
                while(datoLinea != null){
                    if(cont == linea){
                        salida.println(dato + "," + dato);
                    }else{
                        salida.println(datoLinea);
                    }
                    datoLinea = br.readLine();
                    cont++;
                }
                br.close();
                salida.close();
                
                file.delete();
                File newFile = new File(fileAlum);
                fileAux.renameTo(newFile);
                
            }catch(IOException ex){
                ex.getMessage();
                ex.getStackTrace();
            }
            
        }else{       // Admin
            String fileAluAux = "AdminAux.csv";
            File file = new File(fileAdmin);
            File fileAux = new File(fileAluAux);
            try{
                if(!file.exists()){
                    CrearArchivoAdmin();
                }if(!fileAux.exists()){
                    fileAux.createNewFile();
                }
                //Arch de datos
                BufferedReader br;
                FileReader fr = new FileReader(fileAdmin);
                br = new BufferedReader(fr);
                
                //Arch Aux
                FileWriter fw = new FileWriter(fileAluAux);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter salida = new PrintWriter(bw);
                
                int cont = 0;
                String datoLinea = br.readLine();
                while(datoLinea != null){
                    if(cont == linea){
                        salida.println(dato + "," + dato);
                    }else{
                        salida.println(datoLinea);
                    }
                    datoLinea = br.readLine();
                    cont++;
                }
                br.close();
                salida.close();
                
                file.delete();
                File newFile = new File(fileAdmin);
                fileAux.renameTo(newFile);
                
            }catch(IOException ex){
                ex.getMessage();
                ex.getStackTrace();
            }
        }
    }
    
    public void añadirReg(String datos, boolean usuario) throws IOException{ // usuario true para alumnos y false para admin
        if(usuario){ // Alumnos
            try{
                FileWriter fw = new FileWriter(fileAlum,true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter salida = new PrintWriter(bw);
                salida.println(datos);
                salida.close();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }else{
            try{
                FileWriter fw = new FileWriter(fileAdmin, true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter salida = new PrintWriter(bw);
                salida.println(datos);
                salida.close();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
    
    public String buscarRegistro(String key, boolean usuario){ //Usuario si es true -> para alumno, false -> para Admin
        String registro = "";
        if(usuario){
            String key2 = "";
            try {
            BufferedReader br;
            FileReader fr = new FileReader(fileAlum);
            br = new BufferedReader(fr);
            String datos = br.readLine();
            int cont = 0;
            while(datos != null){
                if(cont > 1){
                    StringTokenizer tokenizer = new StringTokenizer(datos,",");
                    key2 = tokenizer.nextToken();
                    if(key2.equals(key)){
                        return registro = datos;
                    }
                }
                cont++;
                datos = br.readLine();
            }
            br.close();
            } catch (FileNotFoundException ex) {
                System.out.println("OCURRIO UN ERROR: " + ex.getMessage());
            } catch (IOException ex) {
                System.out.println("OCURRIO UN ERROR: " + ex.getMessage());       
            }
        }else{
            String key2 = "";
            try {
            BufferedReader br;
            FileReader fr = new FileReader(fileAdmin);
            br = new BufferedReader(fr);
            String datos = br.readLine();
            int cont = 0;
            while(datos != null){
                if(cont > 1){
                    StringTokenizer tokenizer = new StringTokenizer(datos,",");
                    key2 = tokenizer.nextToken();
                    if(key2.equals(key)){
                        return registro = datos;
                    }
                }
                cont++;
                datos = br.readLine();
            }
            br.close();
            } catch (FileNotFoundException ex) {
                System.out.println("OCURRIO UN ERROR: " + ex.getMessage());
            } catch (IOException ex) {
                System.out.println("OCURRIO UN ERROR: " + ex.getMessage());       
            }
        }
        return registro;
    }
}
