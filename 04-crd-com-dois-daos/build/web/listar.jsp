<%-- 
    Document   : listar.jsp
    Created on : Mar 18, 2022, 5:32:43 AM
    Author     : friend
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"
        import="java.util.*"
        import="modelo.Compania" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Listagem de Companias</h1>
        <%
            
        // goncalves2007, pg 420
        ArrayList<Compania> registros = (ArrayList<Compania>) request.getAttribute("registros");
                 
        for (Compania i : registros) {
        
        %>

        <%= i.getId() %>, <%= i.getNome() %>, <%= i.getDominio() %>, <%= i.getAno() %> 
        
        | <a href="compania?d=<%= i.getId() %>">remover</a> | 
        <a href="compania?r=<%= i.getId() %>">exibir |</a><br>

        <%
            }
        %>
        <a href="compania?pmenos=<%= request.getAttribute("pagina")%>">pagina anterior</a>
        <a href="compania?pmais=<%= request.getAttribute("pagina")%>">proxima pagina</a>
        Fim da listagem

    </body>
</html>
