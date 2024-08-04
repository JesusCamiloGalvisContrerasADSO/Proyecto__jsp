<%-- 
    Document   : add
    Created on : 2/08/2024, 9:50:17 p. m.
    Author     : hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Agregar persona</h1>
        
        <form action="Controlador" method="GET">
            DNI:<br>
            <input type="text" name="txtDni"><br>
            Nombres:<br>
            <input type="text" name="txtNom"><br>
            <input type="submit" name="accion" value="Agregar"><br>
        </form>

    </body>
</html>
