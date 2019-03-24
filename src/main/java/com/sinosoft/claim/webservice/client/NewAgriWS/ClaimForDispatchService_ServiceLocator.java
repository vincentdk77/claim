/**
 * ClaimForDispatchService_ServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.sinosoft.claim.webservice.client.NewAgriWS;

public class ClaimForDispatchService_ServiceLocator extends org.apache.axis.client.Service implements com.sinosoft.claim.webservice.client.NewAgriWS.ClaimForDispatchService_Service {

    public ClaimForDispatchService_ServiceLocator() {
    }


    public ClaimForDispatchService_ServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ClaimForDispatchService_ServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ClaimForDispatchServiceImplPort
    private java.lang.String ClaimForDispatchServiceImplPort_address = "http://9.0.2.33:9012/services/ClaimForDispatchService";

    public java.lang.String getClaimForDispatchServiceImplPortAddress() {
        return ClaimForDispatchServiceImplPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ClaimForDispatchServiceImplPortWSDDServiceName = "ClaimForDispatchServiceImplPort";

    public java.lang.String getClaimForDispatchServiceImplPortWSDDServiceName() {
        return ClaimForDispatchServiceImplPortWSDDServiceName;
    }

    public void setClaimForDispatchServiceImplPortWSDDServiceName(java.lang.String name) {
        ClaimForDispatchServiceImplPortWSDDServiceName = name;
    }

    public com.sinosoft.claim.webservice.client.NewAgriWS.ClaimForDispatchService_PortType getClaimForDispatchServiceImplPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ClaimForDispatchServiceImplPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getClaimForDispatchServiceImplPort(endpoint);
    }

    public com.sinosoft.claim.webservice.client.NewAgriWS.ClaimForDispatchService_PortType getClaimForDispatchServiceImplPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.sinosoft.claim.webservice.client.NewAgriWS.ClaimForDispatchServiceSoapBindingStub _stub = new com.sinosoft.claim.webservice.client.NewAgriWS.ClaimForDispatchServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getClaimForDispatchServiceImplPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setClaimForDispatchServiceImplPortEndpointAddress(java.lang.String address) {
        ClaimForDispatchServiceImplPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.sinosoft.claim.webservice.client.NewAgriWS.ClaimForDispatchService_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                com.sinosoft.claim.webservice.client.NewAgriWS.ClaimForDispatchServiceSoapBindingStub _stub = new com.sinosoft.claim.webservice.client.NewAgriWS.ClaimForDispatchServiceSoapBindingStub(new java.net.URL(ClaimForDispatchServiceImplPort_address), this);
                _stub.setPortName(getClaimForDispatchServiceImplPortWSDDServiceName());
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
        if ("ClaimForDispatchServiceImplPort".equals(inputPortName)) {
            return getClaimForDispatchServiceImplPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://agricliam.service.uap.sinosoft.com/", "ClaimForDispatchService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://agricliam.service.uap.sinosoft.com/", "ClaimForDispatchServiceImplPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ClaimForDispatchServiceImplPort".equals(portName)) {
            setClaimForDispatchServiceImplPortEndpointAddress(address);
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
