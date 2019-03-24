/**
 * AIPWebServiceImplServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.sinosoft.aip.webservice.server;

import com.sinosoft.sysframework.reference.AppConfig;

public class AIPWebServiceImplServiceLocator extends org.apache.axis.client.Service implements com.sinosoft.aip.webservice.server.AIPWebServiceImplService {

    public AIPWebServiceImplServiceLocator() {
    }


    public AIPWebServiceImplServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public AIPWebServiceImplServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for AIPWebServiceImplPort
    private java.lang.String AIPWebServiceImplPort_address = AppConfig.get("sysconst.AGRI_ADDRESS");

    public java.lang.String getAIPWebServiceImplPortAddress() {
        return AIPWebServiceImplPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String AIPWebServiceImplPortWSDDServiceName = "AIPWebServiceImplPort";

    public java.lang.String getAIPWebServiceImplPortWSDDServiceName() {
        return AIPWebServiceImplPortWSDDServiceName;
    }

    public void setAIPWebServiceImplPortWSDDServiceName(java.lang.String name) {
        AIPWebServiceImplPortWSDDServiceName = name;
    }

    public com.sinosoft.aip.webservice.server.AIPWebService getAIPWebServiceImplPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(AIPWebServiceImplPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getAIPWebServiceImplPort(endpoint);
    }

    public com.sinosoft.aip.webservice.server.AIPWebService getAIPWebServiceImplPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.sinosoft.aip.webservice.server.AIPWebServiceImplServiceSoapBindingStub _stub = new com.sinosoft.aip.webservice.server.AIPWebServiceImplServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getAIPWebServiceImplPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setAIPWebServiceImplPortEndpointAddress(java.lang.String address) {
        AIPWebServiceImplPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.sinosoft.aip.webservice.server.AIPWebService.class.isAssignableFrom(serviceEndpointInterface)) {
                com.sinosoft.aip.webservice.server.AIPWebServiceImplServiceSoapBindingStub _stub = new com.sinosoft.aip.webservice.server.AIPWebServiceImplServiceSoapBindingStub(new java.net.URL(AIPWebServiceImplPort_address), this);
                _stub.setPortName(getAIPWebServiceImplPortWSDDServiceName());
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
        if ("AIPWebServiceImplPort".equals(inputPortName)) {
            return getAIPWebServiceImplPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "AIPWebServiceImplService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "AIPWebServiceImplPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("AIPWebServiceImplPort".equals(portName)) {
            setAIPWebServiceImplPortEndpointAddress(address);
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
