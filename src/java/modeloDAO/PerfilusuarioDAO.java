package modeloDAO;

import config.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import interfaces.perfil;
import java.util.ArrayList;
import java.util.List;
import modelo.Perfil_usuario;

public class PerfilusuarioDAO implements perfil {

    conexion cn = new conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Perfil_usuario tip = new Perfil_usuario();

    @Override
public List<Perfil_usuario> listar() {
    List<Perfil_usuario> list = new ArrayList<>();
    String sql = "SELECT * FROM perfil";
    
    try {
        con = cn.getConnection();
        ps = con.prepareStatement(sql);
        rs = ps.executeQuery();
        
        while (rs.next()) {
            Perfil_usuario tipo = new Perfil_usuario();
            tipo.setId(rs.getInt("id"));
            tipo.setNombre(rs.getString("nombre"));
            tipo.setApellido(rs.getString("apellido"));
            tipo.setTelefono((int) rs.getLong("telefono")); // Cambia a long si es necesario
            tipo.setEmail(rs.getString("email"));
            tipo.setFechaContrato(rs.getDate("fechaContrato"));
            tipo.setUsuarioId(rs.getInt("usuario_id"));
            tipo.setTipoDocId(rs.getInt("tipo_doc_id"));
            tipo.setSangreId(rs.getInt("sangre_id"));
            
            list.add(tipo);
        }
    } catch (Exception e) {
        System.err.println("Error al listar perfiles: " + e.getMessage());
        e.printStackTrace();
    } finally {
        try {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (con != null) con.close();
        } catch (Exception ex) {
            System.err.println("Error al cerrar la conexión: " + ex.getMessage());
        }
    }
    return list;
}



    @Override
    public Perfil_usuario list(int id) {
        String sql = "SELECT * FROM perfil WHERE Id=" + id;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                tip.setId(rs.getInt("id"));
                tip.setNombre(rs.getString("nombre"));
                tip.setApellido(rs.getString("apellido"));
                tip.setTelefono(rs.getInt("telefono"));
                tip.setEmail(rs.getString("email"));
                tip.setFechaContrato(rs.getDate("fechaContrato"));
                tip.setUsuarioId(rs.getInt("usuario_id"));
                tip.setTipoDocId(rs.getInt("tipo_doc_id"));
                tip.setSangreId(rs.getInt("sangre_id"));
            }
        } catch (Exception e) {
            System.err.println("Error al listar tipos de documento: " + e);
        }
        return tip;
    }


    @Override
public boolean add(Perfil_usuario Tipo)  {
    String sql = "INSERT INTO perfil (nombre, apellido, telefono, email, fechaContrato, usuario_id, tipo_doc_id, sangre_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    try {
        con = cn.getConnection();
        ps = con.prepareStatement(sql);
        ps.setString(1, Tipo.getNombre());
        ps.setString(2, Tipo.getApellido());
        ps.setInt(3, Tipo.getTelefono());
        ps.setString(4, Tipo.getEmail());
        ps.setDate(5, new java.sql.Date(Tipo.getFechaContrato().getTime()));
        ps.setInt(6, Tipo.getUsuarioId());
        ps.setInt(7, Tipo.getTipoDocId());
        ps.setInt(8, Tipo.getSangreId());
        ps.executeUpdate();
        return true;
    } catch (Exception e) {
        System.err.println("Error al agregar perfil: " + e);
    }
    return false;
}

    @Override
    public boolean edit(Perfil_usuario Tipo) {
        String sql = "UPDATE perfil SET nombre='" + Tipo.getNombre() + "' WHERE id=" + Tipo.getId();
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.err.println("Error al editar tipo de sangre: " + e);
        }
        return false;
    }

    @Override
public boolean eliminar(int id) {
    String sql = "DELETE FROM perfil WHERE id=" + id;
    try {
        con = cn.getConnection();
        ps = con.prepareStatement(sql);
        ps.executeUpdate();
        return true;
    } catch (Exception e) {
        System.err.println("Error al eliminar perfil: " + e);
    }
    return false;
}

}
