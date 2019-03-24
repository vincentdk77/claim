package com.sinosoft.claim.webservice.client.EliteGeneralWS;

public class EliteDBWSImplProxy implements EliteDBWSImpl {
  private String _endpoint = null;
  private EliteDBWSImpl eliteDBWSImpl = null;
  
  public EliteDBWSImplProxy() {
    _initEliteDBWSImplProxy();
  }
  
  public EliteDBWSImplProxy(String endpoint) {
    _endpoint = endpoint;
    _initEliteDBWSImplProxy();
  }
  
  private void _initEliteDBWSImplProxy() {
    try {
      eliteDBWSImpl = (new EliteDBWSImplServiceLocator()).getEliteDBWSImpl();
      if (eliteDBWSImpl != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)eliteDBWSImpl)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)eliteDBWSImpl)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (eliteDBWSImpl != null)
      ((javax.xml.rpc.Stub)eliteDBWSImpl)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public EliteDBWSImpl getEliteDBWSImpl() {
    if (eliteDBWSImpl == null)
      _initEliteDBWSImplProxy();
    return eliteDBWSImpl;
  }
  
  public java.lang.String query(java.lang.String queryId, java.lang.String paramsXml) throws java.rmi.RemoteException{
    if (eliteDBWSImpl == null)
      _initEliteDBWSImplProxy();
    return eliteDBWSImpl.query(queryId, paramsXml);
  }
  
  public java.lang.String update(java.lang.String updateId, java.lang.String paramsXml) throws java.rmi.RemoteException{
    if (eliteDBWSImpl == null)
      _initEliteDBWSImplProxy();
    return eliteDBWSImpl.update(updateId, paramsXml);
  }
  
  public java.lang.String batchUpdate(java.lang.String batchUpdateId, java.lang.String paramsXml) throws java.rmi.RemoteException{
    if (eliteDBWSImpl == null)
      _initEliteDBWSImplProxy();
    return eliteDBWSImpl.batchUpdate(batchUpdateId, paramsXml);
  }
  
  public java.lang.String callProcedure(java.lang.String spxml) throws java.rmi.RemoteException{
    if (eliteDBWSImpl == null)
      _initEliteDBWSImplProxy();
    return eliteDBWSImpl.callProcedure(spxml);
  }
  
  public java.lang.String callEnhancedProcedure(java.lang.String procedureId, java.lang.String spxml, java.lang.String encryptPassword) throws java.rmi.RemoteException{
    if (eliteDBWSImpl == null)
      _initEliteDBWSImplProxy();
    return eliteDBWSImpl.callEnhancedProcedure(procedureId, spxml, encryptPassword);
  }
  
  
}