/**
 * TempConverterService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.metacube.webservices;

public interface TempConverterService extends javax.xml.rpc.Service {
    public java.lang.String getTempConverterAddress();

    public com.metacube.webservices.TempConverter getTempConverter() throws javax.xml.rpc.ServiceException;

    public com.metacube.webservices.TempConverter getTempConverter(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
