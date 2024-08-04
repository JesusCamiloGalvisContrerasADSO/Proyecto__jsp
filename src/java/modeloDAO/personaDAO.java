
package modeloDAO;

import config.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import interfaces.CRUD;
import java.util.ArrayList;
import java.util.List;
import modelo.persona;


public class personaDAO implements  CRUD{

    conexion cn = new conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    persona p = new persona();

    @Override
    public List<persona> listar() {
    List<persona> list = new ArrayList<>();
    String sql = "SELECT * FROM persona";
    try {
        con = cn.getConnection();
        ps = con.prepareStatement(sql);
        rs = ps.executeQuery();
        while (rs.next()) {
            persona per = new persona();
            per.setId(rs.getInt("id")); // Asegúrate de que el nombre de columna es correcto
            per.setDni(rs.getString("DNI")); // Asegúrate de que el nombre de columna es correcto
            per.setNom(rs.getString("Nombres")); // Asegúrate de que el nombre de columna es correcto
            list.add(per);
        }
    } catch (Exception e) {
        System.err.println("Error al listar personas: " + e);
    }
    return list;
}

    @Override
    public persona list(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean add(persona per) {
        String sql = "insert into persona(DNI, Nombres)values('"+per.getDni()+"','"+per.getNom()+"')";
        
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public boolean edit(persona per) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean eliminar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    

}
