package soap;


import java.util.List;

import javax.jws.WebService;

import model.Item;

@WebService(endpointInterface = "soap.SOAPI")
public class SOAPImpl implements SOAPI{

	@Override
	public List<Item> getItems() {
		// TODO Auto-generated method stub
		return Item.getItems();
	}

	@Override
	public String buyItem(String name, int cantidad) {
		// TODO Auto-generated method stub
		return Item.buyItem(name, cantidad);
	}

	@Override
	public void addItem(Item item) {
		// TODO Auto-generated method stub
		Item.addItem(item);
	}

	@Override
	public void setItem(String name, int cantidad, double precio) {
		// TODO Auto-generated method stub
		Item.setItem(name, cantidad, precio);
	}

}
