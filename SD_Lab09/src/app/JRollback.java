package app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @web http://jc-mouse.net/
 * @author Mouse
 */
public class JRollback {

	public static void main(String[] args) {

		// Obtenemos conexion a la base de datos
		Connection connection = Database.getConnection();

		PreparedStatement stmt1 = null;
		PreparedStatement stmt2 = null;

		try {
			// se deshabilita el modo de confirmación automática
			connection.setAutoCommit(false);
			// Se preparan las sentencias SQL
			stmt1 = connection.prepareStatement("INSERT INTO miTabla VALUES( ?, ? );");
			stmt2 = connection.prepareStatement("INSERT INTO miOtraTabla VALUES( ?, ?, ? );");

			System.out.println("Primer INSERT tabla [miTabla] ");
			stmt1.setString(1, "000001");
			stmt1.setString(2, "micorreo@mail.com");
			stmt1.executeUpdate();
			System.out.println("Segundo INSERT tabla [miTabla] ");
			stmt1.setString(1, "000002");
			stmt1.setString(2, "amayuya@mail.com");
			stmt1.executeUpdate();

			System.out.println("Tercer INSERT tabla [miTabla] ");
			stmt1.setString(1, "000003");
			stmt1.setString(2, "diosdado@mail.com");
			stmt1.executeUpdate();

			System.out.println("Primer INSERT tabla [miOtraTabla]");
			stmt2.setString(1, "Juan");
			stmt2.setString(2, "Perez");
			//stmt2.setInt(3, 99); //Tipo de dato CORRECTO INT
			stmt2.setString(3, "Hola soy un error");// Tipo de dato INCORRECTO
			stmt2.executeUpdate();

			// se indica que se deben aplicar los cambios en la base de datos
			connection.commit();

		} catch (SQLException ex) {
			System.err.println("ERROR: " + ex.getMessage());
			if (connection != null) {
				System.out.println("Rollback");
				try {
					// deshace todos los cambios realizados en los datos
					connection.rollback();
				} catch (SQLException ex1) {
					System.err.println("No se pudo deshacer" + ex1.getMessage());
				}
			}
		} finally {
			System.out.println("cierra conexion a la base de datos");
			try {
				if (stmt1 != null)
					stmt1.close();
				if (stmt2 != null)
					stmt2.close();
				if (connection != null)
					connection.close();
			} catch (SQLException ex) {
				System.err.println(ex.getMessage());
			}
		}
	}// end:main
}