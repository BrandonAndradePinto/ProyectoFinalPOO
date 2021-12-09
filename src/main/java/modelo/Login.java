package modelo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 *
 * @author brandon
 */
public class Login {
    private String usuario;
    private String contrasena;

    public Login() {
    }
    
    public boolean validarAdmin(String usuario, String contrasena){
        boolean validar = false;
        try {
            BufferedReader br;
            FileReader fr = new FileReader("RegistrosAdmin.csv");
            br = new BufferedReader(fr);
            String datos = br.readLine();
            int cont = 0;
            while(datos != null && !validar){
                if(cont == 0 || cont == 1){
                    datos = br.readLine();
                    cont++;
                }else{
                    StringTokenizer tokenizer = new StringTokenizer(datos,",");
                    for(int i = 0; i < 2; i++){
                        if(i == 0){
                            this.usuario = tokenizer.nextToken();
                        }else{
                            this.contrasena = tokenizer.nextToken();
                        }
                    }
                    validar = usuario.equals(this.usuario) && contrasena.equals(this.contrasena);
                    datos = br.readLine();
                    cont++;
                }
            }
            br.close();
        } catch (FileNotFoundException ex) {
            System.out.println("OCURRIO UN ERROR: " + ex.getMessage());
            validar = false;
        } catch (IOException ex) {
            System.out.println("OCURRIO UN ERROR: " + ex.getMessage());
            validar = false;        
        }
        return validar;
    }
    
    public boolean validarAlumno(String usuario, String contrasena){
        boolean validar = false;
        try {
            BufferedReader br;
            FileReader fr = new FileReader("RegistrosAlumnos.csv");
            br = new BufferedReader(fr);
            String datos = br.readLine();
            int cont = 0;
            while(datos != null && !validar){
                if(cont == 0 || cont == 1){
                    datos = br.readLine();
                    cont++;
                }else{
                    StringTokenizer tokenizer = new StringTokenizer(datos,",");
                    for(int i = 0; i < 2; i++){
                        if(i == 0){
                            this.usuario = tokenizer.nextToken();
                        }else{
                            this.contrasena = tokenizer.nextToken();
                        }
                    }
                    validar = usuario.equals(this.usuario) && contrasena.equals(this.contrasena);
                    datos = br.readLine();
                    cont++;
                }   
            }
            br.close();
        } catch (FileNotFoundException ex) {
            System.out.println("OCURRIO UN ERROR: " + ex.getMessage());
            validar = false;
        } catch (IOException ex) {
            System.out.println("OCURRIO UN ERROR: " + ex.getMessage());
            validar = false;        
        }
        return validar;
    }
}
