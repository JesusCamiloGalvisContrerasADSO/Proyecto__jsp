package interfaces;

import java.util.List;
import modelo.Perfil;

public interface Registro {
    public List listar();
    public Perfil list(int id);
    public boolean add(Perfil Tipo);
    public boolean edit(Perfil Tipo);
    public boolean eliminar(int id);
}