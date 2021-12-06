package mvc;
import controlador.Controlador;
import controlador.KeyboardInput;
import vista.Vista;
/**
 *
 * @author brandon
 */
public class Main {
    public static void main(String[] args) {
        Controlador controlador = new Controlador();
        Vista vista = new Vista();
        KeyboardInput input = new KeyboardInput();
        vista.limpiarPantalla();
        int op = 0;
        do{
            op = controlador.validarFileInicioDePrograma();
            vista.mensajeDeInicio(op);
            switch (op){
                case -1:
                    vista.limpiarPantalla();
                    System.out.println(vista.title("OCURRIO UN ERROR REINTENTANDO"));
                    break;
                    
                case 0:                                                         //Se encontraron los archivos csv para la correcta ejecucion del programa
                    break;
                    
                case 1:                                                         //No se encontraron los archivos csv
                    controlador.file.CrearArchivoAdmin();
                    controlador.file.CrearArchivoAlumno();
                    vista.enterContinuar();
                    vista.limpiarPantalla();
                    break;
                    
                case 2:                                                         //Falta el archivo de admin
                    controlador.file.CrearArchivoAdmin();
                    vista.enterContinuar();
                    vista.limpiarPantalla();
                    break;
                    
                case 3:                                                         //falta el archivo de alumno
                    controlador.file.CrearArchivoAlumno();
                    vista.enterContinuar();
                    vista.limpiarPantalla();
                    break;
                    
                default:
                    break;
            }
        }while(op != 0);
        
        do{
            boolean validarKeys = true;                                                                                //Variable que nos dice si las llaves de ingreso son o no validas
            String[] datosDeIngreso = new String[2];
            switch (op){
                case 0:
                    vista.menuDeIngreso();
                    op = input.readInteger();
                    controlador.validarOption(3, op);                                                                  // 3 porque son 3 opciones en el menu
                    vista.limpiarPantalla();
                    break;
                    
                case 1:                                                                                                //Login Alumnos
                    do{
                        datosDeIngreso = vista.login(true);
                        validarKeys = controlador.validarIngresoAlumno(datosDeIngreso);
                        vista.limpiarPantalla();
                        if(validarKeys){
                            do{
                                vista.menuOperacionesAlumno();
                                op = input.readInteger();
                                if(op > 3 || op < 1){
                                    op = 0;
                                }
                                switch (op){
                                    case 1:
                                        controlador.consultarDatosAlumno();
                                        break;
                                    
                                    case 2:
                                        controlador.consultarNumInscripcion();
                                        break;
                                    
                                    case 3:
                                        vista.limpiarPantalla();
                                        System.out.println(vista.title("Sesion Cerrada"));
                                        vista.enterContinuar();
                                        vista.limpiarPantalla();
                                        op = 0;
                                        break;
                                        
                                    default:
                                        vista.limpiarPantalla();
                                        System.out.println(vista.title("ERROR: Opcion NO valida :( "));
                                        //vista.enterContinuar();
                                        //vista.limpiarPantalla();
                                        op = -1;
                                        break;
                                }
                            }while(op != 0);
                        }else{
                            vista.limpiarPantalla();
                            System.out.println(vista.title("Usuario y/o contraseña incorrecta"));
                            op = 0;
                        }
                    }while(op != 0);
                    break;
                
                case 2:                                                                                         //Login Administrador
                    do{
                        
                        datosDeIngreso = vista.login(false);
                        validarKeys = controlador.validarIngresoAdmin(datosDeIngreso);
                        vista.limpiarPantalla();
                        if(validarKeys){
                            do{
                                vista.menuOperacionesAdmin();
                                op = input.readInteger();
                                if(op > 10 || op < 1){
                                    op = 0;
                                }
                                switch (op){
                                    case 1:
                                        vista.limpiarPantalla();
                                        System.out.println(vista.title("Registrar Alumno"));
                                        controlador.registrarAlumno();
                                        break;
                                        
                                    case 2:
                                        vista.limpiarPantalla();
                                        System.out.println(vista.title("Registrar Administrador"));
                                        controlador.registrarAdmin();
                                        break;
                                        
                                    case 3:
                                        controlador.actualizarDatosAlumno();
                                        break;
                                    
                                    case 4:
                                        controlador.actualizarMisDatosAdmin();
                                        break;
                                    
                                    case 5:
                                        controlador.consultarDatosAlumno();
                                        break;
                                        
                                    case 6:
                                        controlador.consultarMisDatosAdmin();
                                        break;
                                    
                                    case 7:
                                        controlador.eliminarRegistroAlumno();
                                        break;
                                    
                                    case 8:
                                        controlador.eliminarRegistroAdmin();
                                        break;
                                        
                                    case 9:
                                        controlador.generarNumInscripcion();
                                        break;
                                    
                                    case 10:
                                        vista.limpiarPantalla();
                                        System.out.println(vista.title("Sesion Cerrada"));
                                        vista.enterContinuar();
                                        vista.limpiarPantalla();
                                        op = 0;
                                        break;
                                    default:
                                        vista.limpiarPantalla();
                                        System.out.println(vista.title("ERROR: Opcion NO valida :( "));
                                        vista.enterContinuar();
                                        vista.limpiarPantalla();
                                        op = -1;
                                        break;
                                }
                            }while(op != 0);
                        }else{
                            vista.limpiarPantalla();
                            System.out.println(vista.title("Usuario y/o contraseña incorrecta"));
                            op = 0;
                        }
                    }while(op != 0);
                    break;
                
                case 3:
                    vista.limpiarPantalla();
                    vista.despedida();
                    //vista.enterContinuar();
                    //vista.limpiarPantalla();
                    op = -1;
                    break;
                    
                default:
                    System.out.println(vista.title("Opcion no valida :( "));
                    //vista.enterContinuar();
                    //vista.limpiarPantalla();
                    op = 0;
                    break;
            }
        }while(op != -1);
    }
}
