package com.sinosoft.webservice.newpayment.autogr;

public class SavePayInforServiceImplProxy implements SavePayInforServiceImpl {
  private String _endpoint = null;
  private SavePayInforServiceImpl savePayInforServiceImpl = null;
  
  public SavePayInforServiceImplProxy() {
    _initSavePayInforServiceImplProxy();
  }
  
  public SavePayInforServiceImplProxy(String endpoint) {
    _endpoint = endpoint;
    _initSavePayInforServiceImplProxy();
  }
  
  private void _initSavePayInforServiceImplProxy() {
    try {
      savePayInforServiceImpl = (new SavePayInforServiceImplServiceLocator()).getSavePaymentInfo();
      if (savePayInforServiceImpl != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)savePayInforServiceImpl)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)savePayInforServiceImpl)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (savePayInforServiceImpl != null)
      ((javax.xml.rpc.Stub)savePayInforServiceImpl)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public SavePayInforServiceImpl getSavePayInforServiceImpl() {
    if (savePayInforServiceImpl == null)
      _initSavePayInforServiceImplProxy();
    return savePayInforServiceImpl;
  }
  
  public java.lang.String savePayInfor(java.lang.String xml) throws java.rmi.RemoteException{
    if (savePayInforServiceImpl == null)
      _initSavePayInforServiceImplProxy();
    return savePayInforServiceImpl.savePayInfor(xml);
  }
  
  
}