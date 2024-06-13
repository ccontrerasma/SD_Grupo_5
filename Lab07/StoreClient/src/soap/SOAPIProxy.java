package soap;

public class SOAPIProxy implements soap.SOAPI {
  private String _endpoint = null;
  private soap.SOAPI sOAPI = null;
  
  public SOAPIProxy() {
    _initSOAPIProxy();
  }
  
  public SOAPIProxy(String endpoint) {
    _endpoint = endpoint;
    _initSOAPIProxy();
  }
  
  private void _initSOAPIProxy() {
    try {
      sOAPI = (new soap.SOAPImplServiceLocator()).getSOAPImplPort();
      if (sOAPI != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)sOAPI)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)sOAPI)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (sOAPI != null)
      ((javax.xml.rpc.Stub)sOAPI)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public soap.SOAPI getSOAPI() {
    if (sOAPI == null)
      _initSOAPIProxy();
    return sOAPI;
  }
  
  public void addItem(soap.Item arg0) throws java.rmi.RemoteException{
    if (sOAPI == null)
      _initSOAPIProxy();
    sOAPI.addItem(arg0);
  }
  
  public java.lang.String buyItem(java.lang.String arg0, int arg1) throws java.rmi.RemoteException{
    if (sOAPI == null)
      _initSOAPIProxy();
    return sOAPI.buyItem(arg0, arg1);
  }
  
  public soap.Item[] getItems() throws java.rmi.RemoteException{
    if (sOAPI == null)
      _initSOAPIProxy();
    return sOAPI.getItems();
  }
  
  public void setItem(java.lang.String arg0, int arg1, double arg2) throws java.rmi.RemoteException{
    if (sOAPI == null)
      _initSOAPIProxy();
    sOAPI.setItem(arg0, arg1, arg2);
  }
  
  
}