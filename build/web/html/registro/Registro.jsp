
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
              <div>
                  <div class="registro__input">
                      <p>Nombre:</p>
                      <input class="input_registro" type="text">
                  </div>
                  <div class="registro__input">
                      <p>Apellido:</p>
                      <input class="input_registro" type="text">
                  </div>
                  <div class="registro__input">
                      <p>Ingresa tu documento:</p>
                      <input class="input_registro" type="number">
                  </div>
                  <div class="registro__input">
                    <p>Tipo de documento:</p>
                          <select class="input_registro" name="" id="">
                              <option value=""></option>
                              <option value="">Cedula de ciudadania</option>
                              <option value="">Tarjeta de identidad</option>
                              <option value="">Cedula extranjeria</option>
                          </select>
                  </div>
                  <div class="registro__input">
                    <p>Tipo de sangre:</p>
                          <select class="input_registro" name="" id="">
                              <option value=""></option>
                              <option value="">A +</option>
                              <option value="">O +</option>
                              <option value="">B +</option>
                              <option value="">AB +</option>
                              <option value="">A -</option>
                              <option value="">O -</option>
                              <option value="">B -</option>
                              <option value="">AB -</option>
                          </select>
                  </div>
                  <!-- <div class="registro__input--seleccion">
                      <div class=" registro__input--cuadro registro__input">
                          <p>Tipo de documento:</p>
                          <select class="input_registro--seleccion" name="" id="">
                              <option value=""></option>
                              <option value="">Cedula de ciudadania</option>
                              <option value="">Tarjeta de identidad</option>
                              <option value="">Cedula extranjeria</option>
                          </select>
                      </div>
                      <div class="registro__input--cuadro registro__input">
                          <p>Tipo de sangre:</p>
                          <select class="input_registro--seleccion" name="" id="">
                              <option value=""></option>
                              <option value="">A +</option>
                              <option value="">O +</option>
                              <option value="">B +</option>
                              <option value="">AB +</option>
                              <option value="">A -</option>
                              <option value="">O -</option>
                              <option value="">B -</option>
                              <option value="">AB -</option>
                          </select>
                      </div>
                  </div> -->
                  <div class="registro__input">
                      <p>Teléfono:</p>
                      <input class="input_registro" type="number">
                  </div>
                  <div class="registro__input">
                      <p>Escribe tu contraseña:</p>
                      <input class="input_registro" type="password">
                  </div>
                  <div class="registro__input">
                      <p>Ingresa tu correo:</p>
                      <input class="input_registro" type="email">
                  </div>
                  <div class="registro__input">
                      <p>Dirección:</p>
                      <input class="input_registro" type="text">
                  </div>
                  <div class="registro__input">
                      <p>Ingresa tu fecha de nacimiento:</p>
                      <input class="input_registro" type="date">
                  </div>
              </div>
              <div>
                  <a class="boton boton__registro" href="confir_registro.html">Regístrarse</a>
              </div>
          </div>
      </section>
    </main>
</body>
</html>