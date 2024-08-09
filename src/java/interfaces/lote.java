package interfaces;

import java.util.List;
import modelo.LoteM;

public interface lote {
    public List listar();
    public LoteM list(int id);
    public boolean add(LoteM lot);
    public boolean edit(LoteM lot);
    public boolean eliminar(int id);
}