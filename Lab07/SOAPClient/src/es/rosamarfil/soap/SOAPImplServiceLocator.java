/**
 * SOAPImplServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package es.rosamarfil.soap;

public class SOAPImplServiceLocator extends org.apache.axis.client.Service implements es.rosamarfil.soap.SOAPImplService {

    public SOAPImplServiceLocator() {
    }


    public SOAPImplServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public SOAPImplServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for SOAPImplPort
    private java.lang.String SOAPImplPort_address = "http://localhost:1516/WS/Users";

    public java.lang.String getSOAPImplPortAddress() {
        return SOAPImplPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String SOAPImplPortWSDDServiceName = "SOAPImplPort";

    public java.lang.String getSOAPImplPortWSDDServiceName() {
        return SOAPImplPortWSDDServiceName;
    }

    public void setSOAPImplPortWSDDServiceName(java.lang.String name) {
        SOAPImplPortWSDDServiceName = name;
    }

    public es.rosamarfil.soap.SOAPI getSOAPImplPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(SOAPImplPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getSOAPImplPort(endpoint);
    }

    public es.rosamarfil.soap.SOAPI getSOAPImplPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            es.rosamarfil.soap.SOAPImplPortBindingStub _stub = new es.rosamarfil.soap.SOAPImplPortBindingStub(portAddress, this);
            _stub.setPortName(getSOAPImplPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setSOAPImplPortEndpointAddress(java.lang.String address) {
        SOAPImplPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (es.rosamarfil.soap.SOAPI.class.isAssignableFrom(serviceEndpointInterface)) {
                es.rosamarfil.soap.SOAPImplPortBindingStub _stub = new es.rosamarfil.soap.SOAPImplPortBindingStub(new java.net.URL(SOAPImplPort_address), this);
                _stub.setPortName(getSOAPImplPortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("SOAPImplPort".equals(inputPortName)) {
            return getSOAPImplPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://soap.rosamarfil.es/", "SOAPImplService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://soap.rosamarfil.es/", "SOAPImplPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("SOAPImplPort".equals(portName)) {
            setSOAPImplPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
