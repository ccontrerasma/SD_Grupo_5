package JPS;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author angelo
 */
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(serviceName = "ComprobarUsuario")
public class ComprobarUsuario {

    private static final String usuario = "admin";
    private static final String contrasenia = "password";

    @WebMethod(operationName = "Comprobar")
    public boolean Comprobar(@WebParam(name = "usuario") String user1, @WebParam(name = "contrasenia") String contra) {
        try {
            if (usuario.equals(user1) && contrasenia.equals(contra)) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            // En caso de excepción, se redirige a la página de error
            throw new RuntimeException("Error al comprobar usuario", e);
        }
    }
}

