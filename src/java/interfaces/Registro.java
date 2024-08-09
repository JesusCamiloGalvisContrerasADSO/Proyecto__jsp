package interfaces;

import java.util.List;
import modelo.Perfil;

public interface Registro {
    public List<Perfil> listar();
    public Perfil list(int id);
    public boolean add(Perfil perfil);
    public boolean edit(Perfil perfil);
    public boolean eliminar(int id);
}
