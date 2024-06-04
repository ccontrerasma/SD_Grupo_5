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

    private static final String USUARIO = "admin";
    private static final String CONTRASENIA = "password";

    @WebMethod(operationName = "Comprobar")
    public boolean Comprobar(@WebParam(name = "usuario") String user1, @WebParam(name = "contrasenia") String contra) {
        try {
            return USUARIO.equals(user1) && CONTRASENIA.equals(contra);
        } catch (Exception e) {
            throw new RuntimeException("Error al comprobar usuario", e);
        }
    }
}

