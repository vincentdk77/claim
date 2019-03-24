/**
 * ClaimForRegistService_ServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.sinosoft.claim.webservice.client.NewAgriWS;

public class ClaimForRegistService_ServiceLocator extends org.apache.axis.client.Service implements com.sinosoft.claim.webservice.client.NewAgriWS.ClaimForRegistService_Service {

    public ClaimForRegistService_ServiceLocator() {
    }


    public ClaimForRegistService_ServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ClaimForRegistService_ServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ClaimForRegistServiceImplPort
    private java.lang.String ClaimForRegistServiceImplPort_address = "http://9.0.2.33:9012/services/ClaimForRegistService";

    public java.lang.String getClaimForRegistServiceImplPortAddress() {
        return ClaimForRegistServiceImplPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ClaimForRegistServiceImplPortWSDDServiceName = "ClaimForRegistServiceImplPort";

    public java.lang.String getClaimForRegistServiceImplPortWSDDServiceName() {
        return ClaimForRegistServiceImplPortWSDDServiceName;
    }

    public void setClaimForRegistServiceImplPortWSDDServiceName(java.lang.String name) {
        ClaimForRegistServiceImplPortWSDDServiceName = name;
    }

    public com.sinosoft.claim.webservice.client.NewAgriWS.ClaimForRegistService_PortType getClaimForRegistServiceImplPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ClaimForRegistServiceImplPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getClaimForRegistServiceImplPort(endpoint);
    }

    public com.sinosoft.claim.webservice.client.NewAgriWS.ClaimForRegistService_PortType getClaimForRegistServiceImplPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.sinosoft.claim.webservice.client.NewAgriWS.ClaimForRegistServiceSoapBindingStub _stub = new com.sinosoft.claim.webservice.client.NewAgriWS.ClaimForRegistServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getClaimForRegistServiceImplPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setClaimForRegistServiceImplPortEndpointAddress(java.lang.String address) {
        ClaimForRegistServiceImplPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.sinosoft.claim.webservice.client.NewAgriWS.ClaimForRegistService_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                com.sinosoft.claim.webservice.client.NewAgriWS.ClaimForRegistServiceSoapBindingStub _stub = new com.sinosoft.claim.webservice.client.NewAgriWS.ClaimForRegistServiceSoapBindingStub(new java.net.URL(ClaimForRegistServiceImplPort_address), this);
                _stub.setPortName(getClaimForRegistServiceImplPortWSDDServiceName());
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
        if ("ClaimForRegistServiceImplPort".equals(inputPortName)) {
            return getClaimForRegistServiceImplPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://agricliam.service.uap.sinosoft.com/", "ClaimForRegistService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://agricliam.service.uap.sinosoft.com/", "ClaimForRegistServiceImplPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ClaimForRegistServiceImplPort".equals(portName)) {
            setClaimForRegistServiceImplPortEndpointAddress(address);
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
