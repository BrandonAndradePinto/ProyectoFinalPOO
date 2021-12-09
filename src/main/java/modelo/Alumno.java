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
public class Alumno extends Usuario{
    private static final Carrera carrera = new Carrera();
    private String numeroDeCuenta;
    private String password;
    private int numeroDeInscripcion;
    private String semestreDeIngreso;
    private int semestresActivo;
    private double promedio;
    private double indicadorEscolar;
    private int creditosDelAlumno;                                              //Creditos que el alumno posee
    private int asignaturasInscritasEnOrdinario;
    private int asignaturasAprovadasEnOrdinario;
    private boolean regular;
    
    

    public Alumno() {
    }
    
    public Alumno(String datos) {
    }
    
    public void generarNumDeCuenta(){
        int numeroDeRegistros = 0;
        try{
            BufferedReader br;
            FileReader fr = new FileReader("RegistrosAlumnos.csv");
            br = new BufferedReader(fr);
            String datos = br.readLine();
            for(int cont = 0; cont < 2; cont++){
                StringTokenizer tokenizer = new StringTokenizer(datos,",");
                if(cont == 1){
                    numeroDeRegistros = Integer.parseInt(tokenizer.nextToken());
                }
                datos = br.readLine();
            }
        } catch (FileNotFoundException ex) {
            System.out.println("OCURRIO UN ERROR: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("OCURRIO UN ERROR: " + ex.getMessage());    
        }
        String str = semestreDeIngreso;
        str = str.substring(1, str.length() - 2);
        for(int i = 0; i < 2; i++){
            str = str + (int)(Math.random()*10);
        }
        numeroDeRegistros = numeroDeRegistros + 1;
        if(numeroDeRegistros < 10){
            str = str + "000" + numeroDeRegistros;
        }else if(numeroDeRegistros < 100){
            str = str + "00" + numeroDeRegistros;
        }else if(numeroDeRegistros < 1_000){
            str = str + "0" + numeroDeRegistros;
        }else if(numeroDeRegistros < 10_000){
            str = str + numeroDeRegistros;
        }
        numeroDeCuenta = str;
        ManejoDeArchivos file = new ManejoDeArchivos();
        file.modificarArchivoNumReg(1, numeroDeRegistros, true);
    }
    
    public void generarNumInscripcion(){
        
    }
    
    public void generarIndicadorEscolar(){
        int creditosDesdeElIngreso = 0;
        if(semestresActivo == 0){                                                            //Indica que el alumno es de primer ingreso y que por lo tanto no cuenta todavia con los datos necesarios para obtener el numero de inscripcion
            indicadorEscolar = 0;
            regular = true;
            return;
        }else{
            if(semestresActivo >= 10){
                creditosDesdeElIngreso = carrera.numDeCreditosTotales;
            }else{
                for(int i = 0; i < semestresActivo; i++){
                    for(int cont = 0; cont < 6; cont++){
                        creditosDesdeElIngreso = creditosDesdeElIngreso + carrera.creditosPorSemestre[i][cont];
                    }
                }
            }
        }
        if(creditosDelAlumno < creditosDesdeElIngreso){
            regular = false;
        }else{
            regular = true;
        }
        System.out.println("CreditosTotalesDesdeElIngreso: " + creditosDesdeElIngreso);
        double velocidad = ((double)creditosDelAlumno/(double)creditosDesdeElIngreso)*100;
        System.out.println("Velocidad = " + velocidad + "  creditosDelAlumno = " + creditosDelAlumno);
        double escolaridad = ((double)asignaturasAprovadasEnOrdinario/(double)asignaturasInscritasEnOrdinario)*100;
        System.out.println("escolaridad = " + escolaridad + "asignaturasAprovadasEnOrdinario = " + asignaturasAprovadasEnOrdinario + "  asignaturasInscritasEnOrdinario= " +asignaturasInscritasEnOrdinario);
        indicadorEscolar = promedio * velocidad * escolaridad;
    }

    public String generarLineaCSV(){
        Direccion dir = super.getDireccion();
        return numeroDeCuenta+","+password+","+super.getPrimerNombre()+","+
                super.getSegundoNombre()+","+super.getApellidoPaterno()+","+
                super.getApellidoMaterno()+","+super.getSexo()+","+
                super.getFechaNac()+","+super.getEdad()+","+super.getFechaDeRegistro()+","+
                dir.getPais()+","+dir.getEstado()+","+dir.getMunicipio()+","+
                dir.getCiudad()+","+dir.getCalle()+","+dir.getColonia()+","+
                dir.getNumeroExt()+","+dir.getNumeroInt()+","+dir.getCodigoPostal()+","+
                numeroDeInscripcion+","+promedio+","+indicadorEscolar+","+
                creditosDelAlumno+","+semestreDeIngreso+","+semestresActivo+","+
                asignaturasInscritasEnOrdinario+","+asignaturasAprovadasEnOrdinario+","+
                regular;
    }
    
    public boolean isRegular() {
        return regular;
    }

    public void setRegular(boolean regular) {
        this.regular = regular;
    }

    public int getSemestresActivo() {
        return semestresActivo;
    }

    public void setSemestresActivo(int emestresActivo) {
        this.semestresActivo = emestresActivo;
    }

    public String getSemestreDeIngreso() {
        return semestreDeIngreso;
    }

    public void setSemestreDeIngreso(String semestreDeIngreso) {
        this.semestreDeIngreso = semestreDeIngreso;
    }

    public int getNumeroDeInscripcion() {
        return numeroDeInscripcion;
    }

    public void setNumeroDeInscripcion(int numeroDeInscripcion) {
        this.numeroDeInscripcion = numeroDeInscripcion;
    }

    public double getPromedio() {
        return promedio;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }

    public double getIndicadorEscolar() {
        return indicadorEscolar;
    }

    public void setIndicadorEscolar(double indicadorEscolar) {
        this.indicadorEscolar = indicadorEscolar;
    }

    public int getCreditosDelAlumno() {
        return creditosDelAlumno;
    }

    public void setCreditosDelAlumno(int creditosDelAlumno) {
        this.creditosDelAlumno = creditosDelAlumno;
    }

    public int getAsignaturasInscritasEnOrdinario() {
        return asignaturasInscritasEnOrdinario;
    }

    public void setAsignaturasInscritasEnOrdinario(int asignaturasInscritasEnOrdinario) {
        this.asignaturasInscritasEnOrdinario = asignaturasInscritasEnOrdinario;
    }

    public int getAsignaturasAprovadasEnOrdinario() {
        return asignaturasAprovadasEnOrdinario;
    }

    public void setAsignaturasAprovadasEnOrdinario(int asignaturasAprovadasEnOrdinario) {
        this.asignaturasAprovadasEnOrdinario = asignaturasAprovadasEnOrdinario;
    }

    public String getNumeroDeCuenta() {
        return numeroDeCuenta;
    }

    public void setNumeroDeCuenta(String numeroDeCuenta) {
        this.numeroDeCuenta = numeroDeCuenta;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Alumno{" + "numeroDeCuenta=" + numeroDeCuenta + ", numeroDeInscripcion=" + numeroDeInscripcion + ", semestreDeIngreso=" + semestreDeIngreso + ", semestresActivo=" + semestresActivo + ", promedio=" + promedio + ", indicadorEscolar=" + indicadorEscolar + ", creditosDelAlumno=" + creditosDelAlumno + ", asignaturasInscritasEnOrdinario=" + asignaturasInscritasEnOrdinario + ", asignaturasAprovadasEnOrdinario=" + asignaturasAprovadasEnOrdinario + ", regular=" + regular + "}\n" + super.toString();
    }
    
}
