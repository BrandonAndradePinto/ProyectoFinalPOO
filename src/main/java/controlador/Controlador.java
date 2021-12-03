package controlador;

import modelo.Login;
import modelo.ManejoDeArchivos;

/**
 *
 * @author brandon
 */
public class Controlador {
    
    public ManejoDeArchivos file = new ManejoDeArchivos();

    public Controlador() {
    }
    
    //[----------Metodos para Validar Datos----------]
    
    public int validarFileInicioDePrograma(){                                                           //La funcion regresa 0 si se encuentran los archivos necesarios para ejecutar el programa
        ManejoDeArchivos file = new ManejoDeArchivos();                                                 //1 si faltan los dos archivos necesarios para la ejcucion
        boolean existeFileAdmin = file.verificarExistenciaFileAdmin();                                  //2 si flata solo el archivo de administrador
        boolean existeFileAlum = file.verificarExistenciaFileAlumno();                                  //3 si falta el archivo de alumnos
        if(existeFileAdmin && existeFileAlum){                                                          //-1 si ocurrio un error
            return 0;
        }else if(!existeFileAdmin && !existeFileAlum){
            return 1;
        }else if(!existeFileAdmin && existeFileAlum){
            return 2;
        }else if(existeFileAdmin && !existeFileAlum){
            return 3;
        }
        return -1;
    }
    
    public boolean validarIngresoAdmin(String[] datosDeIngreso){
        Login login = new Login();
        return login.validarAdmin(datosDeIngreso[0], datosDeIngreso[1]);
    }
    
    public boolean validarIngresoAlumno(String[] datosDeIngreso){
        Login login = new Login();
        return login.validarAlumno(datosDeIngreso[0], datosDeIngreso[1]);
    }
    
    //[----------Metodos para acciones del Administrador----------] Algunos tambien sirven para Alumno
    
    public void registrarAlumno(){
        System.out.println("Metodo Registrar Alumno");
    }
    
    public void registrarAdmin(){
        System.out.println("Metdod Registrar Administrador");
    }
    
    public void actualizarDatosAlumno(){
        System.out.println("Metodo para Actualizar Datos del Alumno");
    }
    
    public void actualizarMisDatosAdmin(){
        System.out.println("Metodo para Actualizar Datos del Administrador");
    }
    
    public void consultarDatosAlumno(){
        System.out.println("Metodo para Consultar datos de un Alumno");
    }
    
    public void consultarMisDatosAdmin(){
        System.out.println("Metodo para Consultar datos del administrador");
    }
    
    public void eliminarRegistroAlumno(){
        System.out.println("Metodo para Eliminar registro de un Alumno");
    }
    
    public void eliminarRegistroAdmin(){
        System.out.println("Metodo para Eliminar registro de un Admin");
    }
    
    public void generarNumInscripcion(){
        System.out.println("Metodo para generar y/o actualizar num de inscripcion");
    }
    
    //[----------Metodos para acciones del Alumno----------]
    
    public void consultarNumInscripcion(){
        System.out.println("Metodo para consultar Num de Inscripcion");
    }
    
    //Utilidades para el programa
    
    public int validarOption(int optionMax, int option){
        int op = option;
        if(op < 1 || op > optionMax){
            op = -1;
        }
        return op;
    }
}
