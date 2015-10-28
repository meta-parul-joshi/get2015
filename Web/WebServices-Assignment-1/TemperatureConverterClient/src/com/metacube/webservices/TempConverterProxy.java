package com.metacube.webservices;

public class TempConverterProxy implements com.metacube.webservices.TempConverter {
  private String _endpoint = null;
  private com.metacube.webservices.TempConverter tempConverter = null;
  
  public TempConverterProxy() {
    _initTempConverterProxy();
  }
  
  public TempConverterProxy(String endpoint) {
    _endpoint = endpoint;
    _initTempConverterProxy();
  }
  
  private void _initTempConverterProxy() {
    try {
      tempConverter = (new com.metacube.webservices.TempConverterServiceLocator()).getTempConverter();
      if (tempConverter != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)tempConverter)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)tempConverter)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (tempConverter != null)
      ((javax.xml.rpc.Stub)tempConverter)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.metacube.webservices.TempConverter getTempConverter() {
    if (tempConverter == null)
      _initTempConverterProxy();
    return tempConverter;
  }
  
  public double fahrenhiteToCelsiusConverter(double temperatureInFahrenhite) throws java.rmi.RemoteException{
    if (tempConverter == null)
      _initTempConverterProxy();
    return tempConverter.fahrenhiteToCelsiusConverter(temperatureInFahrenhite);
  }
  
  
}