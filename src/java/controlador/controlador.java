/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import modelo.persona;
import modeloDAO.personaDAO;


/**
 *
 * @author hp
 */
public class controlador extends HttpServlet {

   
    String listar="html/listar.jsp";
    String add="html/add.jsp";
    String edit="html/edit.jsp";
    persona p=new persona();
    personaDAO dao=new personaDAO();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet controlador</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet controlador at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
        
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acceso ="";
        String action= request.getParameter("accion");
        if (action.equalsIgnoreCase("listar")) {
            acceso=listar;
        }else if (action.equalsIgnoreCase("add")) {
            acceso=add;
        }else if (action.equalsIgnoreCase("Agregar")) {
            String dni=request.getParameter("txtDni");
            String nom=request.getParameter("txtNom");
            p.setDni(dni);
            p.setNom(nom);
            dao.add(p);
            acceso=listar;
        } else if(action.equalsIgnoreCase("editar")){
            request.setAttribute("idper",request.getParameter("id"));
            acceso=edit;
        }else if(action.equalsIgnoreCase("Actualizar")){
            int id = Integer.parseInt(request.getParameter("txtid"));
            String dni=request.getParameter("txtDni");
            String nom=request.getParameter("txtNom");
            p.setId(id);
            p.setDni(dni);
            p.setNom(nom);
            dao.edit(p);
            acceso=listar;
        }else if(action.equalsIgnoreCase("eliminar")){
            int id = Integer.parseInt(request.getParameter("id"));
            p.setId(id);
            dao.eliminar(id);
            acceso=listar;
        }
        RequestDispatcher vista=request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
