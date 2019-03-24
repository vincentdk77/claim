/**
 * EliteDBWSImpl.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.sinosoft.claim.webservice.client.EliteGeneralWS;

public interface EliteDBWSImpl extends java.rmi.Remote {
    public java.lang.String query(java.lang.String queryId, java.lang.String paramsXml) throws java.rmi.RemoteException;
    public java.lang.String update(java.lang.String updateId, java.lang.String paramsXml) throws java.rmi.RemoteException;
    public java.lang.String batchUpdate(java.lang.String batchUpdateId, java.lang.String paramsXml) throws java.rmi.RemoteException;
    public java.lang.String callProcedure(java.lang.String spxml) throws java.rmi.RemoteException;
    public java.lang.String callEnhancedProcedure(java.lang.String procedureId, java.lang.String spxml, java.lang.String encryptPassword) throws java.rmi.RemoteException;
}
