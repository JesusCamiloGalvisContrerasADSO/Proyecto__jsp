package interfaces;

import java.util.List;
import modelo.Perfil_usuario;

public interface perfil {
    public List listar();
    public Perfil_usuario list(int id);
    public boolean add(Perfil_usuario Tipo);
    public boolean edit(Perfil_usuario Tipo);
    public boolean eliminar(int id);
}