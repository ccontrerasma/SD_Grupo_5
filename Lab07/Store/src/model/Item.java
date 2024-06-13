package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;


public class Item implements Serializable {
	 
	private static final long serialVersionUID = 1L;
	 
	 public static List<Item> items = new ArrayList<>(Arrays.asList(
			 new Item(15, "Gaseosa", 5.2),
			 new Item(10, "Galletas", 1.6),
			 new Item(12, "Celular", 900)
			 ));
	 
	 private String nombre;
	 private int cantidad;
	 private double costo;
	 
	 public double getCosto() {
		return costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}

	public Item() {}
	 
	 public Item(int cantidad, String nombre, double costo) {
		 this.cantidad = cantidad;
		 this.nombre = nombre;
		 this.costo = costo;
	 }

	public static List<Item> getItems() {
		return items;
	}

	public static void setItems(List<Item> items) {
		Item.items = items;
	}
	
	public static void addItem(Item item) {
		Item.items.add(item);
	}
	
	public static String buyItem(String name, int cantidad) {
		for(int i = 0; i < Item.items.size(); ++i) {
			// Search for item
			if( Item.items.get(i).nombre.compareTo(name) == 0 ) {
				int cant = Item.items.get(i).getCantidad();
				// If we don't have enough items in store.
				if( cant - cantidad < 0) {
					return "Not enough items";
				}
				Item.items.get(i).setCantidad(cant-cantidad);
				return "Producto: "+ Item.items.get(i).getNombre() + 
						" Cantidad: " + cantidad +
						" Total: " + cantidad*Item.items.get(i).getCosto();
			}
		}
		return "Item no match";
	}
	
	
	public Item getItem(String name) {
		Item aux = null;
		for( Item i: items) {
			if(i.nombre.compareTo(name) == 0) {
				aux = i;
			}
		}
		return aux;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCantidad() {
		return cantidad;
	}
	
	public static void setItem(String name, int cantidad, double costo) {
		for(int i = 0; i < Item.items.size(); ++i) {
			if( Item.items.get(i).nombre.compareTo(name) == 0 ) {
				// add to older stock new items
				int cant = Item.items.get(i).getCantidad();
				Item.items.get(i).setCantidad(cantidad + cant);
				Item.items.get(i).setCosto(costo);
			}
		}
	}
	
	

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
}