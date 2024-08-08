package modeloDAO;

import config.conexion;
import interfaces.usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.Perfil;
import modelo.Usuario;

public class UsuarioDAO implements usuario{
    conexion cn = new conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

//    @Override
//    public boolean add(Usuario usuario) {
//        String sql = "INSERT INTO usuarios (contraseña, documento) VALUES (?, ?)";
//        try {
//            con = cn.getConnection();
//            ps = con.prepareStatement(sql);
//            ps.setString(1, usuario.getContrasena());
//            ps.setInt(2, usuario.getDocumento());
//            ps.executeUpdate();
//            return true;
//        } catch (Exception e) {
//            System.err.println("Error al agregar usuario: " + e);
//        } finally {
//            
//        }
//        return false;
//    }
//
//    public int getLastInsertedId() {
//        String sql = "SELECT LAST_INSERT_ID() AS id";
//        int id = -1;
//        try {
//            con = cn.getConnection();
//            ps = con.prepareStatement(sql);
//            rs = ps.executeQuery();
//            if (rs.next()) {
//                id = rs.getInt("id");
//            }
//        } catch (Exception e) {
//            System.err.println("Error al obtener el último ID insertado: " + e);
//        } finally {
//            
//        }
//        return id;
//    }
//
//
//    @Override
//    public boolean edit(Usuario usuario) {
//        String sql = "UPDATE usuarios SET documento=?, contrasena=? WHERE id=?";
//        try {
//            con = cn.getConnection();
//            ps = con.prepareStatement(sql);
//            ps.setInt(1, usuario.getDocumento());
//            ps.setString(2, usuario.getContrasena());
//            ps.setInt(3, usuario.getIdUsuario());
//            ps.executeUpdate();
//            return true;
//        } catch (Exception e) {
//            System.err.println("Error al editar usuario: " + e);
//        } finally {
//            try {
//                if (ps != null) ps.close();
//                if (con != null) con.close();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//        return false;
//    }
//
//    @Override
//    public boolean eliminar(int id) {
//        String sql = "DELETE FROM usuarios WHERE id=?";
//        try {
//            con = cn.getConnection();
//            ps = con.prepareStatement(sql);
//            ps.setInt(1, id);
//            ps.executeUpdate();
//            return true;
//        } catch (Exception e) {
//            System.err.println("Error al eliminar usuario: " + e);
//        }
//        return false;
//    }

    @Override
    public List<Usuario> listar() {
        List<Usuario> lista = new ArrayList<>();
        String sql = "SELECT * FROM usuarios";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt("id"));
                usuario.setDocumento(rs.getInt("documento"));
                usuario.setContrasena(rs.getString("contrasena"));
                lista.add(usuario);
            }
        } catch (Exception e) {
            System.err.println("Error al listar usuarios: " + e);
        }
        return lista;
    }


    @Override
    public Usuario list(int id) {
        Usuario usuario = new Usuario();
        String sql = "SELECT * FROM usuarios WHERE id=?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                usuario.setIdUsuario(rs.getInt("id"));
                usuario.setDocumento(rs.getInt("documento"));
                usuario.setContrasena(rs.getString("contrasena"));
            }
        } catch (Exception e) {
            System.err.println("Error al obtener usuario por ID: " + e);
        } 
        return usuario;
    }

    @Override
    public boolean add(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean edit(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean eliminar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int getLastInsertedId() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


}


    

