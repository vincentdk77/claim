/**
 * SavePayInforServiceImplServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.sinosoft.webservice.newpayment.autogr;

public class SavePayInforServiceImplServiceLocator extends org.apache.axis.client.Service implements SavePayInforServiceImplService {

    public SavePayInforServiceImplServiceLocator() {
    }


    public SavePayInforServiceImplServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public SavePayInforServiceImplServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for SavePaymentInfo
    private java.lang.String SavePaymentInfo_address = "http://192.168.0.64:8081/payment-service/services/SavePaymentInfo";

    public java.lang.String getSavePaymentInfoAddress() {
        return SavePaymentInfo_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String SavePaymentInfoWSDDServiceName = "SavePaymentInfo";

    public java.lang.String getSavePaymentInfoWSDDServiceName() {
        return SavePaymentInfoWSDDServiceName;
    }

    public void setSavePaymentInfoWSDDServiceName(java.lang.String name) {
        SavePaymentInfoWSDDServiceName = name;
    }

    public SavePayInforServiceImpl getSavePaymentInfo() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(SavePaymentInfo_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getSavePaymentInfo(endpoint);
    }

    public SavePayInforServiceImpl getSavePaymentInfo(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            SavePaymentInfoSoapBindingStub _stub = new SavePaymentInfoSoapBindingStub(portAddress, this);
            _stub.setPortName(getSavePaymentInfoWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setSavePaymentInfoEndpointAddress(java.lang.String address) {
        SavePaymentInfo_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (SavePayInforServiceImpl.class.isAssignableFrom(serviceEndpointInterface)) {
                SavePaymentInfoSoapBindingStub _stub = new SavePaymentInfoSoapBindingStub(new java.net.URL(SavePaymentInfo_address), this);
                _stub.setPortName(getSavePaymentInfoWSDDServiceName());
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
        if ("SavePaymentInfo".equals(inputPortName)) {
            return getSavePaymentInfo();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://localhost:8081/payment-service/services/SavePaymentInfo", "SavePayInforServiceImplService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://localhost:8081/payment-service/services/SavePaymentInfo", "SavePaymentInfo"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("SavePaymentInfo".equals(portName)) {
            setSavePaymentInfoEndpointAddress(address);
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
