package com.sinosoft.assistant.services;

public class PushCaseWsImplProxy implements com.sinosoft.assistant.services.PushCaseWsImpl {
  private String _endpoint = null;
  private com.sinosoft.assistant.services.PushCaseWsImpl pushCaseWsImpl = null;
  
  public PushCaseWsImplProxy() {
    _initPushCaseWsImplProxy();
  }
  
  public PushCaseWsImplProxy(String endpoint) {
    _endpoint = endpoint;
    _initPushCaseWsImplProxy();
  }
  
  private void _initPushCaseWsImplProxy() {
    try {
      pushCaseWsImpl = (new com.sinosoft.assistant.services.PushCaseWsImplServiceLocator()).getacceptPushCaseService();
      if (pushCaseWsImpl != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)pushCaseWsImpl)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)pushCaseWsImpl)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (pushCaseWsImpl != null)
      ((javax.xml.rpc.Stub)pushCaseWsImpl)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.sinosoft.assistant.services.PushCaseWsImpl getPushCaseWsImpl() {
    if (pushCaseWsImpl == null)
      _initPushCaseWsImplProxy();
    return pushCaseWsImpl;
  }
  
  public java.lang.String accept(java.lang.String data) throws java.rmi.RemoteException{
    if (pushCaseWsImpl == null)
      _initPushCaseWsImplProxy();
    return pushCaseWsImpl.accept(data);
  }
  
  
}