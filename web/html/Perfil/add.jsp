<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Agregar tipo de documneto</h1>
        
        <form action="ControlTipoDoc" method="GET">
            Nombres:<br>
            <input type="text" name="txtNom"><br>
            <input type="submit" name="accion" value="Agregar"><br>
        </form>
    </body>
</html>
