package modeloDAO;

import config.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import interfaces.Registro;
import java.util.ArrayList;
import java.util.List;
import modelo.Perfil;

public class PerfilDAO implements Registro {

    conexion cn = new conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Perfil tipo = new Perfil();

    @Override
    public List<Perfil> listar() {
        List<Perfil> list = new ArrayList<>();
        String sql = "SELECT * FROM perfil";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Perfil tipo = new Perfil();
                tipo.setIdPerfil(rs.getInt("id"));
                tipo.setNombre(rs.getString("nombre"));
                tipo.setApellido(rs.getString("apellido"));
                tipo.setTelefono(rs.getInt("telefono"));
                tipo.setEmail(rs.getString("email"));
                tipo.setDireccion(rs.getString("direccion"));
                tipo.setFechaNacimiento(rs.getDate("fecha_nacimiento"));
                tipo.setUsuarioId(rs.getInt("usuario_id"));
                tipo.setTipoDocId(rs.getInt("tipo_doc_id"));
                tipo.setSangreId(rs.getInt("sangre_id"));
                list.add(tipo);
            }
        } catch (Exception e) {
            System.err.println("Error al listar tipos de perfiles: " + e);
        }
        return list;
    }

    @Override
    public Perfil list(int id) {
        String sql = "SELECT * FROM perfil WHERE id=" + id;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                tipo.setIdPerfil(rs.getInt("id"));
                tipo.setNombre(rs.getString("nombre"));
                tipo.setApellido(rs.getString("apellido"));
                tipo.setTelefono(rs.getInt("telefono"));
                tipo.setEmail(rs.getString("email"));
                tipo.setDireccion(rs.getString("direccion"));
                tipo.setFechaNacimiento(rs.getDate("fecha_nacimiento"));
                tipo.setUsuarioId(rs.getInt("usuario_id"));
                tipo.setTipoDocId(rs.getInt("tipo_doc_id"));
                tipo.setSangreId(rs.getInt("sangre_id"));
            }
        } catch (Exception e) {
            System.err.println("Error al listar tipos de perfiles: " + e);
        }
        return tipo;
    }

    @Override
    public boolean add(Perfil perfil)  {
        String sql = "INSERT INTO perfil (nombre, apellido, telefono, email, direccion, fecha_nacimiento, usuario_id, tipo_doc_id, sangre_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, perfil.getNombre());
            ps.setString(2, perfil.getApellido());
            ps.setInt(3, perfil.getTelefono());
            ps.setString(4, perfil.getEmail());
            ps.setString(5, perfil.getDireccion());
             ps.setDate(6, new java.sql.Date(perfil.getFechaNacimiento().getTime()));
            ps.setInt(7, perfil.getUsuarioId());
            ps.setInt(8, perfil.getTipoDocId());
            ps.setInt(9, perfil.getSangreId());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.err.println("Error al agregar tipo de documento: " + e);
        }
        return false;
    }

    @Override
    public boolean edit(Perfil perfil) {
        String sql = "UPDATE perfil SET nombre=?, apellido=?, telefono=?, email=?, direccion=?, fecha_nacimiento=?, usuario_id=?, tipo_doc_id=?, sangre_id=? WHERE id_perfil=?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, perfil.getNombre());
            ps.setString(2, perfil.getApellido());
            ps.setInt(3, perfil.getTelefono());
            ps.setString(4, perfil.getEmail());
            ps.setString(5, perfil.getDireccion());
             ps.setDate(6, new java.sql.Date(perfil.getFechaNacimiento().getTime()));
            ps.setInt(7, perfil.getUsuarioId());
            ps.setInt(7, perfil.getUsuarioId());
            ps.setInt(8, perfil.getTipoDocId());
            ps.setInt(9, perfil.getSangreId());
            ps.setInt(10, perfil.getIdPerfil());
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
            System.err.println("Error al eliminar tipo de documento: " + e);
        }
        return false;
    }


}
