/**
 * EliteDBWSImplServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.sinosoft.claim.webservice.client.EliteGeneralWS;

import com.sinosoft.sysframework.reference.AppConfig;

public class EliteDBWSImplServiceLocator extends org.apache.axis.client.Service implements EliteDBWSImplService {

    public EliteDBWSImplServiceLocator() {
    }


    public EliteDBWSImplServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public EliteDBWSImplServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for EliteDBWSImpl
    private java.lang.String EliteDBWSImpl_address = "";

    public java.lang.String getEliteDBWSImplAddress() {
        return EliteDBWSImpl_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String EliteDBWSImplWSDDServiceName = "EliteDBWSImpl";

    public java.lang.String getEliteDBWSImplWSDDServiceName() {
        return EliteDBWSImplWSDDServiceName;
    }

    public void setEliteDBWSImplWSDDServiceName(java.lang.String name) {
        EliteDBWSImplWSDDServiceName = name;
    }

    public EliteDBWSImpl getEliteDBWSImpl() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(EliteDBWSImpl_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getEliteDBWSImpl(endpoint);
    }

    public EliteDBWSImpl getEliteDBWSImpl(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            EliteDBWSImplSoapBindingStub _stub = new EliteDBWSImplSoapBindingStub(portAddress, this);
            _stub.setPortName(getEliteDBWSImplWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setEliteDBWSImplEndpointAddress(java.lang.String address) {
        EliteDBWSImpl_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (EliteDBWSImpl.class.isAssignableFrom(serviceEndpointInterface)) {
                EliteDBWSImplSoapBindingStub _stub = new EliteDBWSImplSoapBindingStub(new java.net.URL(EliteDBWSImpl_address), this);
                _stub.setPortName(getEliteDBWSImplWSDDServiceName());
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
        if ("EliteDBWSImpl".equals(inputPortName)) {
            return getEliteDBWSImpl();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
    	String SERVER_URL = AppConfig.get("sysconst.GHBSYNSTATUS_URL");
        return new javax.xml.namespace.QName(SERVER_URL, "EliteDBWSImplService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            String SERVER_URL = AppConfig.get("sysconst.GHBSYNSTATUS_URL");
            ports.add(new javax.xml.namespace.QName(SERVER_URL, "EliteDBWSImpl"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("EliteDBWSImpl".equals(portName)) {
            setEliteDBWSImplEndpointAddress(address);
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
