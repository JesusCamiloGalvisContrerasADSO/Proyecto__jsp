package modeloDAO;

import config.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import interfaces.lote;
import java.util.ArrayList;
import java.util.List;
import modelo.LoteM;

public class LoteDAO implements lote {

    conexion cn = new conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    LoteM lot = new LoteM();

    @Override
    public List<LoteM> listar() {
        List<LoteM> list = new ArrayList<>();
        String sql = "SELECT * FROM lote";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                LoteM lote = new LoteM();
                lote.setId(rs.getInt("id"));
                lote.setNum(rs.getInt("num"));
                list.add(lote);
            }
        } catch (Exception e) {
            System.err.println("Error al listar lotes: " + e);
        }
        return list;
    }

    @Override
public LoteM list(int id) {
    String sql = "SELECT * FROM lote WHERE Id=" + id;
    LoteM lote = new LoteM(); // Crear una nueva instancia aquí
    try {
        con = cn.getConnection();
        ps = con.prepareStatement(sql);
        rs = ps.executeQuery();
        while (rs.next()) {
            lote.setId(rs.getInt("id"));
            lote.setNum(rs.getInt("num"));
        }
    } catch (Exception e) {
        System.err.println("Error al listar lotes: " + e);
    }
    return lote;
}


    @Override
    public boolean add(LoteM Tipo)  {
        
        String sql = "insert into lote(num)values('"+Tipo.getNum()+"')";
        
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public boolean edit(LoteM Tipo) {
        
        return false;
        
    }

    @Override
    public boolean eliminar(int id) {
        
        return false;
        
    }


}
