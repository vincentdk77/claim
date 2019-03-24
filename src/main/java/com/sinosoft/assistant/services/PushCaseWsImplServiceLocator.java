/**
 * PushCaseWsImplServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.sinosoft.assistant.services;

import com.sinosoft.sysframework.reference.AppConfig;

public class PushCaseWsImplServiceLocator extends org.apache.axis.client.Service implements com.sinosoft.assistant.services.PushCaseWsImplService {

    public PushCaseWsImplServiceLocator() {
    }


    public PushCaseWsImplServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public PushCaseWsImplServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for acceptPushCaseService
    private java.lang.String acceptPushCaseService_address = AppConfig.get("sysconst.APP_ADDRESS");

    public java.lang.String getacceptPushCaseServiceAddress() {
        return acceptPushCaseService_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String acceptPushCaseServiceWSDDServiceName = "acceptPushCaseService";

    public java.lang.String getacceptPushCaseServiceWSDDServiceName() {
        return acceptPushCaseServiceWSDDServiceName;
    }

    public void setacceptPushCaseServiceWSDDServiceName(java.lang.String name) {
        acceptPushCaseServiceWSDDServiceName = name;
    }

    public com.sinosoft.assistant.services.PushCaseWsImpl getacceptPushCaseService() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(acceptPushCaseService_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getacceptPushCaseService(endpoint);
    }

    public com.sinosoft.assistant.services.PushCaseWsImpl getacceptPushCaseService(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.sinosoft.assistant.services.AcceptPushCaseServiceSoapBindingStub _stub = new com.sinosoft.assistant.services.AcceptPushCaseServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getacceptPushCaseServiceWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setacceptPushCaseServiceEndpointAddress(java.lang.String address) {
        acceptPushCaseService_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.sinosoft.assistant.services.PushCaseWsImpl.class.isAssignableFrom(serviceEndpointInterface)) {
                com.sinosoft.assistant.services.AcceptPushCaseServiceSoapBindingStub _stub = new com.sinosoft.assistant.services.AcceptPushCaseServiceSoapBindingStub(new java.net.URL(acceptPushCaseService_address), this);
                _stub.setPortName(getacceptPushCaseServiceWSDDServiceName());
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
        if ("acceptPushCaseService".equals(inputPortName)) {
            return getacceptPushCaseService();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("acceptPushCaseService_address", "PushCaseWsImplService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("acceptPushCaseService_address", "acceptPushCaseService"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("acceptPushCaseService".equals(portName)) {
            setacceptPushCaseServiceEndpointAddress(address);
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
