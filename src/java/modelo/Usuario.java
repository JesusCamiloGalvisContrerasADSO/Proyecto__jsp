
package modelo;

    
public class Usuario {
    
    int idUsuario;
    int documento;
    String contrasena;

    public Usuario() {
    }

    public Usuario(int idUsuario, int documento, String contrasena) {
        this.idUsuario = idUsuario;
        this.documento = documento;
        this.contrasena = contrasena;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }


    
}
