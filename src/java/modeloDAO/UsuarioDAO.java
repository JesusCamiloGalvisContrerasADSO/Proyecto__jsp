package modeloDAO;

import config.conexion;
import interfaces.usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.Usuario;

public class UsuarioDAO implements usuario {
    conexion cn = new conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

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
        String sql = "INSERT INTO usuarios (documento, contrasena) VALUES (?, ?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, usuario.getDocumento());
            ps.setString(2, usuario.getContrasena());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.err.println("Error al agregar usuario: " + e);
        }
        return false;
    }

    @Override
    public boolean edit(Usuario usuario) {
        String sql = "UPDATE usuarios SET documento=?, contrasena=? WHERE id=?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, usuario.getDocumento());
            ps.setString(2, usuario.getContrasena());
            ps.setInt(3, usuario.getIdUsuario());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.err.println("Error al editar usuario: " + e);
        }
        return false;
    }

    @Override
    public boolean eliminar(int id) {
        String sql = "DELETE FROM usuarios WHERE id=?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.err.println("Error al eliminar usuario: " + e);
        }
        return false;
    }
}
