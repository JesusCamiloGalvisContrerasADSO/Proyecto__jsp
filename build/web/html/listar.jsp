
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div>
            <h1>Persona</h1>
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
                    list<persona>list=dao.listar();
                    Iterator<persona>iter=list.iterator();
                    persona per=null;
                    
                    while(iter.hasNext()){
                    per =iter.next();
                    
                %>
                <tbody>
                    <tr>
                        <td><%= per.getId() %></td>
                        <td><%= per.getDni() %></td>
                        <td><%= per.getNom() %></td>
                        <td>
                            <a>Editar</a>
                            <a>Remove</a>
                        </td>
                    </tr>
                    <% } %>
                </tbody>
            </table>

        </div>
    </body>
</html>
