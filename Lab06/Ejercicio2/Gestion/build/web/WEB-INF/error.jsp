<%-- 
    Document   : error
    Author     : angelo
--%>

<%@ page isErrorPage="true" contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Error</title>
    <style>
        body { font-family: Arial, sans-serif; background-color: #f0f0f0; margin: 0; padding: 0; }
        .container { max-width: 600px; margin: 50px auto; padding: 20px; background-color: #fff; 
                    border-radius: 5px; box-shadow: 0 0 10px rgba(0,0,0,0.1); }
        .error-message { color: red; font-weight: bold; }
        h1 { color: #333; }
        ul { color: #555; }
    </style>
</head>
<body>
    <div class="container">
        <h1>Se ha producido un error</h1>
        <p class="error-message"><%= exception.getMessage() %></p>
        <ul>
            <% 
                if (request.getAttribute("mensajes") != null) {
                    java.util.List<String> mensajes = (java.util.List<String>) request.getAttribute("mensajes");
                    for (String mensaje : mensajes) {
            %>
                <li><%= mensaje %></li>
            <% 
                    }
                }
            %>
        </ul>
    </div>
</body>
</html>
