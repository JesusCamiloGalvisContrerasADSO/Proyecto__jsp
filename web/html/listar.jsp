<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="modelo.persona" %>
<%@ page import="modeloDAO.personaDAO" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div>
            <h1>Persona</h1>
            <a href="controlador?accion=add">Agregar Nuevo</a>
            <table border="1">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>DNI</th>
                        <th>Nombre</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <% 
                    personaDAO dao = new personaDAO();
                    List<persona> lista = dao.listar();
                    Iterator<persona> iter = lista.iterator();
                    persona per = null;
                    while (iter.hasNext()) {
                    per = iter.next();
                %>
                <tbody>
                    <tr>
                        <td><%= per.getId() %></td>
                        <td><%= per.getDni() %></td>
                        <td><%= per.getNom() %></td>
                        <td>
                            <a href="Controlador?accion=editar&id=<%= per.getId() %>">Editar</a>
                            <a href="Controlador?accion=eliminar&id=<%= per.getId() %>">Eliminar</a>
                        </td>
                    </tr>
                <% } %>
                </tbody>
            </table>
        </div>
    </body>
</html>
