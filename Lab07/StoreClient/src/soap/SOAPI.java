/**
 * SOAPI.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package soap;

public interface SOAPI extends java.rmi.Remote {
    public void addItem(soap.Item arg0) throws java.rmi.RemoteException;
    public java.lang.String buyItem(java.lang.String arg0, int arg1) throws java.rmi.RemoteException;
    public soap.Item[] getItems() throws java.rmi.RemoteException;
    public void setItem(java.lang.String arg0, int arg1, double arg2) throws java.rmi.RemoteException;
}
