/**
 * TempConverterServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.metacube.webservices;

public class TempConverterServiceLocator extends org.apache.axis.client.Service implements com.metacube.webservices.TempConverterService {

    public TempConverterServiceLocator() {
    }


    public TempConverterServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public TempConverterServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for TempConverter
    private java.lang.String TempConverter_address = "http://localhost:8080/TemperatureConverter/services/TempConverter";

    public java.lang.String getTempConverterAddress() {
        return TempConverter_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String TempConverterWSDDServiceName = "TempConverter";

    public java.lang.String getTempConverterWSDDServiceName() {
        return TempConverterWSDDServiceName;
    }

    public void setTempConverterWSDDServiceName(java.lang.String name) {
        TempConverterWSDDServiceName = name;
    }

    public com.metacube.webservices.TempConverter getTempConverter() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(TempConverter_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getTempConverter(endpoint);
    }

    public com.metacube.webservices.TempConverter getTempConverter(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.metacube.webservices.TempConverterSoapBindingStub _stub = new com.metacube.webservices.TempConverterSoapBindingStub(portAddress, this);
            _stub.setPortName(getTempConverterWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setTempConverterEndpointAddress(java.lang.String address) {
        TempConverter_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.metacube.webservices.TempConverter.class.isAssignableFrom(serviceEndpointInterface)) {
                com.metacube.webservices.TempConverterSoapBindingStub _stub = new com.metacube.webservices.TempConverterSoapBindingStub(new java.net.URL(TempConverter_address), this);
                _stub.setPortName(getTempConverterWSDDServiceName());
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
        if ("TempConverter".equals(inputPortName)) {
            return getTempConverter();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://webservices.metacube.com", "TempConverterService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://webservices.metacube.com", "TempConverter"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("TempConverter".equals(portName)) {
            setTempConverterEndpointAddress(address);
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
