package controlador;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Usuario;
import modelo.Perfil;
import modeloDAO.UsuarioDAO;
import modeloDAO.PerfilDAO;

public class controladorRegistro extends HttpServlet {

    String listar = "html/Usuarios/listar.jsp";
    String add = "html/Usuarios/add.jsp";
    String edit = "html/Usuarios/edit.jsp";
    Usuario usu = new Usuario();
    UsuarioDAO usudao = new UsuarioDAO();
    Perfil per = new Perfil();
    PerfilDAO perdao = new PerfilDAO();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet controladorRegistro</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet controladorRegistro at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acceso = "";
        String action = request.getParameter("accion");
        System.out.println("Accion: " + action);

        if (action.equalsIgnoreCase("listar")) {
            acceso = listar;
        } else if (action.equalsIgnoreCase("add")) {
            acceso = add;
        } else if (action.equalsIgnoreCase("Agregar")) {
            String nom = request.getParameter("txtNom");
            String apell = request.getParameter("txtApell");
            int numDoc = Integer.parseInt(request.getParameter("txtNumDoc"));
            int tipDoc = Integer.parseInt(request.getParameter("txtTipDoc"));  
            int tipSang = Integer.parseInt(request.getParameter("txtTipSang"));
            int tel = Integer.parseInt(request.getParameter("txtTel"));
            String contra = request.getParameter("txtContra");
            String correo = request.getParameter("txtCorreo");
            String direc = request.getParameter("txtDirec");
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            Date fechNaci = null;
            try {
                fechNaci = formatter.parse(request.getParameter("txtFechNaci"));
            } catch (ParseException e) {
                e.printStackTrace(); // Maneja el error de parsing según tu necesidad
            }
            Date fechContrato = new Date(); // Fecha actual

            usu.setDocumento(numDoc);
            usu.setContrasena(contra);

            boolean usuarioAgregado = usudao.add(usu);
            if (usuarioAgregado) {
                UsuarioDAO usuarioId = usudao;
                per.setNombre(nom);
                per.setApellido(apell);
                per.setTelefono(tel);
                per.setEmail(correo);
                per.setDireccion(direc);
                per.setFechaNacimiento(fechNaci);

                per.setTipoDocId(tipDoc);
                per.setSangreId(tipSang);
                per.setFechaContrato(fechContrato);

                boolean perfilAgregado = perdao.add(per);
                if (perfilAgregado) {
                    acceso = "registroExitoso.jsp";
                } else {
                    acceso = "registroError.jsp";
                }
            } else {
                acceso = "registroError.jsp";
            }
        } else if (action.equalsIgnoreCase("editar")) {
            request.setAttribute("idUsuario", request.getParameter("id"));
            acceso = edit;
        } else if (action.equalsIgnoreCase("Actualizar")) {
            int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
            String nom = request.getParameter("txtNom");
            String apell = request.getParameter("txtApell");
            int numDoc = Integer.parseInt(request.getParameter("txtNumDoc"));
            int tipDoc = Integer.parseInt(request.getParameter("txtTipDoc"));  
            int tipSang = Integer.parseInt(request.getParameter("txtTipSang"));
            int tel = Integer.parseInt(request.getParameter("txtTel"));
            String contra = request.getParameter("txtContra");
            String correo = request.getParameter("txtCorreo");
            String direc = request.getParameter("txtDirec");
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            Date fechNaci = null;
            try {
                fechNaci = formatter.parse(request.getParameter("txtFechNaci"));
            } catch (ParseException e) {
                e.printStackTrace(); // Maneja el error de parsing según tu necesidad
            }
            Date fechContrato = new Date(); // Fecha actual

            // Actualizar usuario
            usu.setIdUsuario(idUsuario);
            usu.setDocumento(numDoc);
            usu.setContrasena(contra);
            boolean usuarioActualizado = usudao.edit(usu);

            // Actualizar perfil
            per.setUsuarioId(idUsuario);
            per.setNombre(nom);
            per.setApellido(apell);
            per.setTelefono(tel);
            per.setEmail(correo);
            per.setDireccion(direc);
            per.setFechaNacimiento(fechNaci);
            per.setTipoDocId(tipDoc);
            per.setSangreId(tipSang);
            per.setFechaContrato(fechContrato);
            boolean perfilActualizado = perdao.edit(per);

            if (usuarioActualizado && perfilActualizado) {
                acceso = listar;
            } else {
                acceso = "registroError.jsp";
            }
        } else if (action.equalsIgnoreCase("eliminar")) {
            int id = Integer.parseInt(request.getParameter("id"));
            per.setIdPerfil(id);
            perdao.eliminar(id);
            acceso = listar;
        }

        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
