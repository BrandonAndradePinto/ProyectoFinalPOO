package vista;
import controlador.KeyboardInput;
import java.io.IOException;
/**
 *
 * @author brandon
 */
public class Vista {
    
    KeyboardInput input = new KeyboardInput();

    public Vista() {
    }
    
    public void mensajeDeInicio(int op){
        switch (op){
            case 0:
                break;
            case 1:
                System.out.println(title("Advertencia"));
                System.out.println("NO se han encontrado los archivos RegistrosAdmin.csv y \n"
                        + "RegistrosAlumnos.csv, los cuales son INDISPENSABLES para la\n"
                        + "CORRECTA EJECUCION del programa\n\n"
                        + "Este problema ocurre cuando es la PRIMERA VEZ que se ejecuta el\n"
                        + "el programa o cuando se a removido o eliminado los archivos antes\n"
                        + "mencionados\n\n"
                        + "A CONTINUACION se crearan los archivos faltantes para que se pueda\n"
                        + "               ejecutar el programa, COMO CONCECUENCIA los archivos\n"
                        + "               estaran VACIOS y solo se podra acceder como administrador\n"
                        + "               con las credenciales disponibles en la documentacion\n\n");
                break;
                
            case 2:
                System.out.println(title("Advertencia"));
                System.out.println("NO se ha encontrado el archivos RegistrosAdmin.csv,\n"
                        + "el cual es INDISPENSABLE para la CORRECTA EJECUCION del programa\n\n"
                        + "Este problema ocurre cuando se a removido o eliminado el archivo antes\n"
                        + "mencionado\n\n"
                        + "A CONTINUACION se creara el archivo faltante para que se pueda ejecutar\n"
                        + "               el programa, COMO CONCECUENCIA el archivo estara VACIO y\n"
                        + "               solo se podra acceder como administrador con las \n"
                        + "               credenciales disponibles en la documentacion\n\n");
                break;   
                
            case 3:
                System.out.println(title("Advertencia"));
                System.out.println("NO se ha encontrado el archivos RegistrosAlumnos.csv,\n"
                        + "el cual es INDISPENSABLE para la CORRECTA EJECUCION del programa\n\n"
                        + "Este problema ocurre cuando se a removido o eliminado el archivo antes\n"
                        + "mencionado"
                        + "A CONTINUACION se creara el archivo faltante para que se pueda ejecutar\n"
                        + "               el programa, COMO CONCECUENCIA el archivo estara VACIO,\n"
                        + "               es decir no abra alumnos registrados\n\n");
                break;
                
            default:
                break;
        }
    }
    
    public void menuDeIngreso(){
        System.out.println(title("Menu de Ingreso"));
        System.out.println("Bienvenido,¿Como deseas Ingresar?\n");
        System.out.println("\t1)Ingresar como Alumno");
        System.out.println("\t2)Ingresar como Administrador");
        System.out.println("\t3)Salir\n");
        System.out.print("Por favor ingrese la opcion deseada: ");
    }
    
    public String[] login(boolean admin){
        if(admin){                                                                              // admin == true para alumnos 
            String[] datosDeIngreso = new String[2];                                            // [0] Para Usuario y [1] Para la contraseña
            System.out.println(title("Ingeso de Alumnos"));
            System.out.println("Por favor ingrese los siguientes datos");
            System.out.print("Usuario (No.Cuenta): ");
            datosDeIngreso[0] = input.readString();
            System.out.print("Contaseña: ");
            datosDeIngreso[1] = input.readString();
            return datosDeIngreso;
        }else{                                                                                  // admin == false para Administradores
            String[] datosDeIngreso = new String[2];                                            // [0] Para Usuario y [1] Para la contraseña
            System.out.println(title("Ingeso de Personal Administrativo"));
            System.out.println("Por favor ingrese los siguientes datos");
            System.out.print("Usuario (RFC): ");
            datosDeIngreso[0] = input.readString();
            System.out.print("Contaseña: ");
            datosDeIngreso[1] = input.readString();
            return datosDeIngreso;
        }
    }
    
    public void menuOperacionesAdmin(){
        System.out.println(title("Administrador"));
        System.out.println("Bienvenido, que deseas hacer? >w<\n");
        System.out.println("\t1)Registrar alumno");
        System.out.println("\t2)Registrar Administrador");
        System.out.println("\t3)Actualizar datos de un alumno");
        System.out.println("\t4)Actualizar mis datos");
        System.out.println("\t5)Consultar datos de un alumno");
        System.out.println("\t6)Consultar mis datos");
        System.out.println("\t7)Eliminar registro de alumno");
        System.out.println("\t8)Eliminar registro de administrador");
        System.out.println("\t9)Generar y/o Actualizar numeros de inscripcion");
        System.out.println("\t10)Cerrar Sesion\n");                                              //Si van a agregar mas opciones (o quitar) siempre dejen a Salir como la ultima opcion
        System.out.print("Por favor, ingrese la opcion deseada: ");
        }
    
    public void menuOperacionesAlumno(){
        System.out.println(title("Alumno"));
        System.out.println("Bienvenido, que deseas hacer? >w<\n");
        System.out.println("\t1)Consultar mis datos personales");
        System.out.println("\t2)Consultar numero de Inscripcion");
        System.out.println("\t3)Cerrar Sesion\n");                                            //Si van a agregar mas opciones siempre dejen a Salir como la ultima opcion
        System.out.print("Por favor, ingrese la opcion deseada: ");
    }
    
    public void despedida(){
        System.out.println(title("ADIOS, VUELVE PRONTO :3"));
    }
    
    public void enterContinuar(){
        System.out.print("Porfavor Presione ENTER para continuar ...");
        input.readInteger();
    }
    
    public void limpiarPantalla(){
        try{
            String operatingSystem = System.getProperty("os.name"); //Check the current operating system
              
            if(operatingSystem.contains("Windows")){        
                ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "cls");
                Process startProcess = pb.inheritIO().start();
                startProcess.waitFor();
            } else {
                ProcessBuilder pb = new ProcessBuilder("clear");
                Process startProcess = pb.inheritIO().start();
                startProcess.waitFor();
            } 
        }catch(IOException | InterruptedException e){
            System.out.println("ERROR: " + e);
        }
    }
    
    public String title(String titulo){
        String newTitle;
        int mid =(titulo.length()/2);
        int mid2 = 35 - mid;
        newTitle = "[";
        for(int i = 0; i < mid2; i++){
            newTitle = newTitle + "-";
        }
        mid2 = 35 - (titulo.length() - mid);
        newTitle = newTitle + titulo;
        for(int i = 0; i < mid2; i++){
            newTitle = newTitle + "-";
        }
        newTitle = newTitle + "]";
        return newTitle.toUpperCase();
    }
}
