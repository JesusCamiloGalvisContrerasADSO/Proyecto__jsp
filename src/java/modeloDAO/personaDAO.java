
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
    public List listar() {
        ArrayList<persona> list = new ArrayList<>();
        String sql = "select * from persona";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                persona per = new persona();
                per.setId(rs.getInt("id"));
                per.setDni(rs.getString("DNI"));
                per.setNom(rs.getString("nombre"));
                list.add(per);
            }
        } catch (Exception e) {
            System.err.println("Error:" + e);
        }
        return list;
    }

    @Override
    public persona list(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean add(persona per) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
