<%-- 
    Document   : form
    Created on : Mar 17, 2022, 3:09:25 PM
    Author     : friend
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>nova compania!</h1>
        <form action="compania" method="post">
            Id <input type="text" name="id" value="12345678910"> <br>
            dominio <input type="text" name="dominio" value="João da Silva"> <br>
            ano <input type="text" name="email" value="jsilva@gmail.com"> <br>
            industria <input type="text" name="industria" value="47 99223 1213"> <br> 
            tamanho <input type="text" name="tamanho" value="47 99223 1213"> <br> 
            localizacao <input type="text" name="localizacao" value="47 99223 1213"> <br>
            pais <input type="text" name="pais" value="47 99223 1213"> <br>
            linkedin <input type="text" name="linkedin" value="47 99223 1213"> <br> 
            empregados_atual <input type="text" name="empregados_atual" value="123"> <br>
            empregados_total <input type="text" name="empregados_total" value="123"> <br>


            <input type="submit" value="Cadastrar">
        </form>
    </body>
</html>
