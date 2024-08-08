package interfaces;

import java.util.List;
import modelo.Usuario;

public interface usuario {
    public boolean add(Usuario usuario);
    public List<Usuario> listar();
    public Usuario list(int id);
    public boolean edit(Usuario usuario);
    public boolean eliminar(int id);
}
