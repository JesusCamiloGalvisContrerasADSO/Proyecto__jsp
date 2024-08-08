
package modelo;

import java.util.Date;

    
public class Perfil {
    int idPerfil;
    String nombre;
    String apellido;
    int telefono;
    String email;
    String direccion;
    Date fechaNacimiento;
    Date fechaContrato;
    int usuarioId;
    int tipoDocId;
    int sangreId;

    public Perfil() {
    }

    public Perfil(int idPerfil, String nombre, String apellido, int telefono, String email, String direccion, Date fechaNacimiento, Date fechaContrato, int usuarioId, int tipoDocId, int sangreId) {
        this.idPerfil = idPerfil;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.email = email;
        this.direccion = direccion;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaContrato = fechaContrato;
        this.usuarioId = usuarioId;
        this.tipoDocId = tipoDocId;
        this.sangreId = sangreId;
    }

    public int getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(int idPerfil) {
        this.idPerfil = idPerfil;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Date getFechaContrato() {
        return fechaContrato;
    }

    public void setFechaContrato(Date fechaContrato) {
        this.fechaContrato = fechaContrato;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public int getTipoDocId() {
        return tipoDocId;
    }

    public void setTipoDocId(int tipoDocId) {
        this.tipoDocId = tipoDocId;
    }

    public int getSangreId() {
        return sangreId;
    }

    public void setSangreId(int sangreId) {
        this.sangreId = sangreId;
    }

    
    
    
    
    
}
