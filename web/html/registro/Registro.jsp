
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="modelo.TipoSangre" %>
<%@ page import="modeloDAO.TipoSangreDAO" %>
<%@ page import="controlador.controladorTipSan" %>
<%@ page import="modelo.TipoDocum" %>
<%@ page import="modeloDAO.TipoDocDAO" %>
<%@ page import="controlador.ControlTipoDoc" %>
<%@ page import="controlador.controladorRegistro" %>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registro</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
    <link rel="stylesheet" href="../../css/style.css">
    
</head>
<body>
    <!-- este es el encabezado de la pagina -->
    <header class=" fondo_header">
        <div class="container encabezado">
            
          <div class="encabezado">
              <button class="boton_salir"><i class="bi bi-chevron-left"></i></button>
              <img class="logo" src="../../Recursos/logo-BoviControl.png" alt="">
                <p>BoviControl</p>
            </div>
            <div class="encabezado">
                <ul class="encabezado__lista">
                    <li><a class="encabezado__lista--texto" href="../../Index.html">Ingresar</a></li>
                    <li class="encabezado__lista--icono"><i class="bi bi-person-circle"></i></li>
                </ul>
            </div>
        </div>
    </header>
    <!-- en este estan cada uno de los campos del registro como, nombre, apellidos, fecha de nacimiento, tipo de documento entre otros -->
    <main>
      <section class="center registro__fondo">
          <div  class="container center registro ii">
              <div>
                  <h1 class="registro__titulo">Registrate para continuar</h1>
                  <hr class="registro__linea">
              </div>
              <form action="UsuarioControlador" method="POST">
                <div class="registro__input">
                    <p>Nombre:</p>
                    <input class="input_registro" name="txtNom" type="text">
                </div>
                <div class="registro__input">
                    <p>Apellido:</p>
                    <input class="input_registro" name="txtApell" type="text">
                </div>
                <div class="registro__input">
                    <p>Ingresa tu documento:</p>
                    <input class="input_registro" name="txtNumDoc" type="number">
                </div>
                <div class="registro__input">
                    <p>Tipo de documento:</p>
                    <select class="input_registro" name="txtTipDoc">
                        <option value="" disabled selected>Selecciona</option>
                        <% 
                        TipoDocDAO docDao = new TipoDocDAO();
                        List<TipoDocum> docLista = docDao.listar();
                        for (TipoDocum docTipo : docLista) {
                        %>
                            <option value="<%= docTipo.getId() %>"><%= docTipo.getNom() %></option>
                        <% } %>
                    </select>
                </div>
                <div class="registro__input">
                    <p>Tipo de sangre:</p>
                    <select class="input_registro" name="txtTipSang">
                        <option value="" disabled selected>Selecciona</option>
                        <% 
                        TipoSangreDAO sangreDao = new TipoSangreDAO();
                        List<TipoSangre> sangreLista = sangreDao.listar();
                        for (TipoSangre sangreTipo : sangreLista) {
                        %>
                            <option value="<%= sangreTipo.getId() %>"><%= sangreTipo.getNom() %></option>
                        <% } %>
                    </select>
                </div>
                <div class="registro__input">
                    <p>Teléfono:</p>
                    <input class="input_registro" name="txtTel" type="number">
                </div>
                <div class="registro__input">
                    <p>Escribe tu contraseña:</p>
                    <input class="input_registro" name="txtContra" type="password">
                </div>
                <div class="registro__input">
                    <p>Ingresa tu correo:</p>
                    <input class="input_registro" name="txtCorreo" type="email">
                </div>
                <div class="registro__input">
                    <button type="submit">Enviar</button>
                </div>
            </form>

              <div>
                  <a class="boton boton__registro" href="confir_registro.html">Regístrarse</a>
              </div>
          </div>
      </section>
    </main>
</body>
</html>