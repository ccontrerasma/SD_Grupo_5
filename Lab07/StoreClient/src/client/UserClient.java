package client;

import java.rmi.RemoteException;
import java.util.Arrays;
import javax.xml.rpc.ServiceException;
import java.util.Scanner;

import soap.Item;
import soap.SOAPI;
import soap.SOAPImplServiceLocator;


public class UserClient {
	public static void main(String[] args) {
		SOAPImplServiceLocator locator = new SOAPImplServiceLocator();
		Scanner scanner = new Scanner(System.in);
		try {
			SOAPI storeService = locator.getSOAPImplPort();

			//Tienda:::::::
			int select = -1;
			String product;
			int cant = 0;
			
			//Mientras la opción elegida sea 0, preguntamos al usuario
			while(select != 0){
				//Try catch para evitar que el programa termine si hay un error
				try{
					System.out.println(
							"------------------\n" +
							"--Tienda Virtual--\n" +
							"------------------\n" +
							"Elige opción:\n1.- Ver Productos" +
							"\n2.- Comprar\n" +
							"3.- Soy Admin Agregar\n" +
							"0.- Salir");
					//Recoger una variable por consola
					select = Integer.parseInt(scanner.nextLine()); 
		
					switch(select){
					case 1: 
						System.out.println("Lista de productos: \n" + Arrays.toString(storeService.getItems()).toString());
						break;
					case 2: 
						System.out.println("Comprando productos:\n");
						String recibo = storeService.buyItem("Galletas", 2);
						System.out.println("Recibo compra: \n" + recibo);
						break;
					case 3: 
						System.out.println("Agregando Chicle");
						storeService.addItem(new Item(10, 1.4,"Chicle"));
						System.out.println("Actualizando stock de un producto");
						storeService.setItem("Galletas", 10, 2.4);
						break;
					case 0: 
						System.out.println("Adios!");
						break;
					default:
						System.out.println("Número no reconocido");break;
					}
					
					System.out.println("\n"); //Mostrar un salto de línea en Java
					
				}catch(Exception e){
					System.out.println("Uoop! Error!");
				}
			}
			
			// Se muestra la lista de usuarios
			//System.out.println("Lista de productos: \n" + Arrays.toString(storeService.getItems()).toString());

			/*
			storeService.addItem(new Item(10, 1.4,"Chicle"));
			*/
			
			/*
			System.out.println("Comprando productos:\n");
			String recibo = storeService.buyItem("Galletas", 2);
			System.out.println("Recibo compra: \n" + recibo);
			*/
			
			/*
			System.out.println("Actualizando stock de un producto");
			storeService.setItem("Galletas", 10, 2.4);
		*/
			//System.out.println("Lista de productos: \n" + Arrays.toString(storeService.getItems()).toString());
			

		} catch (ServiceException e) {
			e.printStackTrace();
		} /*catch (RemoteException e) {
			e.printStackTrace();
		}*/
	}
}
