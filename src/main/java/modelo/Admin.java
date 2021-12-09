package modelo;
/**
 *
 * @author brandon
 */
public class Admin extends Usuario{
    private String rfc;                                                         //Debe tener 13 caracteres exactos
    private String password;

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String generarLineaCSV(){
        Direccion dir = super.getDireccion();
        return rfc+","+password+","+super.getPrimerNombre()+","+
                super.getSegundoNombre()+","+super.getApellidoPaterno()+","+
                super.getApellidoMaterno()+","+super.getSexo()+","+
                super.getFechaNac()+","+super.getEdad()+","+super.getFechaDeRegistro()+","+
                dir.getPais()+","+dir.getEstado()+","+dir.getMunicipio()+","+
                dir.getCiudad()+","+dir.getCalle()+","+dir.getColonia()+","+
                dir.getNumeroExt()+","+dir.getNumeroInt()+","+dir.getCodigoPostal();
    }
}
