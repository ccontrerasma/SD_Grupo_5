package demo;


import javax.xml.ws.Endpoint;

import soap.SOAPImpl;

public class PublishService {
	public static void main(String[] args) {
		Endpoint.publish("http://localhost:1516/WS/Users", new SOAPImpl());
	}

}
