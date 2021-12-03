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
    
}
