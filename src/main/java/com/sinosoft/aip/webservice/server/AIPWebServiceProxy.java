package com.sinosoft.aip.webservice.server;

public class AIPWebServiceProxy implements com.sinosoft.aip.webservice.server.AIPWebService {
  private String _endpoint = null;
  private com.sinosoft.aip.webservice.server.AIPWebService aIPWebService = null;
  
  public AIPWebServiceProxy() {
    _initAIPWebServiceProxy();
  }
  
  public AIPWebServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initAIPWebServiceProxy();
  }
  
  private void _initAIPWebServiceProxy() {
    try {
      aIPWebService = (new com.sinosoft.aip.webservice.server.AIPWebServiceImplServiceLocator()).getAIPWebServiceImplPort();
      if (aIPWebService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)aIPWebService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)aIPWebService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (aIPWebService != null)
      ((javax.xml.rpc.Stub)aIPWebService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.sinosoft.aip.webservice.server.AIPWebService getAIPWebService() {
    if (aIPWebService == null)
      _initAIPWebServiceProxy();
    return aIPWebService;
  }
  
  public com.sinosoft.aip.webservice.server.ProductResponseDto uploadProductInfo(com.sinosoft.aip.webservice.server.ClientInfo clientInfo, com.sinosoft.aip.webservice.server.ProductDto[] productDtoList) throws java.rmi.RemoteException{
    if (aIPWebService == null)
      _initAIPWebServiceProxy();
    return aIPWebService.uploadProductInfo(clientInfo, productDtoList);
  }
  
  public com.sinosoft.aip.webservice.server.ReturnedBillResponseDto uploadReturnedBillInfo(com.sinosoft.aip.webservice.server.ClientInfo clientInfo, com.sinosoft.aip.webservice.server.ReturnedBillDto[] returnedBillDtoList) throws java.rmi.RemoteException{
    if (aIPWebService == null)
      _initAIPWebServiceProxy();
    return aIPWebService.uploadReturnedBillInfo(clientInfo, returnedBillDtoList);
  }
  
  public com.sinosoft.aip.webservice.server.PrepaidPayResponseDto uploadPrepaidPayInfoc(com.sinosoft.aip.webservice.server.ClientInfo clientInfo, com.sinosoft.aip.webservice.server.PrepaidPayDto[] prepaidPayDtoList) throws java.rmi.RemoteException{
    if (aIPWebService == null)
      _initAIPWebServiceProxy();
    return aIPWebService.uploadPrepaidPayInfoc(clientInfo, prepaidPayDtoList);
  }
  
  public com.sinosoft.aip.webservice.server.PolicyResponseDto uploadPolicyInfo(com.sinosoft.aip.webservice.server.ClientInfo clientInfo, com.sinosoft.aip.webservice.server.PolicyDto[] policyDtoList) throws java.rmi.RemoteException{
    if (aIPWebService == null)
      _initAIPWebServiceProxy();
    return aIPWebService.uploadPolicyInfo(clientInfo, policyDtoList);
  }
  
  public com.sinosoft.aip.webservice.server.EndorsementResponseDto uploadEndorsementInfo(com.sinosoft.aip.webservice.server.ClientInfo clientInfo, com.sinosoft.aip.webservice.server.EndorsementDto[] endorsementDtoList) throws java.rmi.RemoteException{
    if (aIPWebService == null)
      _initAIPWebServiceProxy();
    return aIPWebService.uploadEndorsementInfo(clientInfo, endorsementDtoList);
  }
  
  public com.sinosoft.aip.webservice.server.PremiumPayResponseDto uploadPremiumPayInfo(com.sinosoft.aip.webservice.server.ClientInfo clientInfo, com.sinosoft.aip.webservice.server.PremiumPayDto[] premiumPayDtoList) throws java.rmi.RemoteException{
    if (aIPWebService == null)
      _initAIPWebServiceProxy();
    return aIPWebService.uploadPremiumPayInfo(clientInfo, premiumPayDtoList);
  }
  
  public com.sinosoft.aip.webservice.server.ClaimPayResponseDto uploadClaimPayInfo(com.sinosoft.aip.webservice.server.ClientInfo clientInfo, com.sinosoft.aip.webservice.server.ClaimPayDto[] claimPayDtoList) throws java.rmi.RemoteException{
    if (aIPWebService == null)
      _initAIPWebServiceProxy();
    return aIPWebService.uploadClaimPayInfo(clientInfo, claimPayDtoList);
  }
  
  public com.sinosoft.aip.webservice.server.FarmerResponseDto uploadFarmerInfo(com.sinosoft.aip.webservice.server.ClientInfo clientInfo, com.sinosoft.aip.webservice.server.FarmerDto[] farmerDtoList) throws java.rmi.RemoteException{
    if (aIPWebService == null)
      _initAIPWebServiceProxy();
    return aIPWebService.uploadFarmerInfo(clientInfo, farmerDtoList);
  }
  
  public com.sinosoft.aip.webservice.server.CancelResponseDto uploadCancelInfo(com.sinosoft.aip.webservice.server.ClientInfo clientInfo, com.sinosoft.aip.webservice.server.CancelDto[] cancelDtoList) throws java.rmi.RemoteException{
    if (aIPWebService == null)
      _initAIPWebServiceProxy();
    return aIPWebService.uploadCancelInfo(clientInfo, cancelDtoList);
  }
  
  public com.sinosoft.aip.webservice.server.CaseResponseDto uploadCaseInfo(com.sinosoft.aip.webservice.server.ClientInfo clientInfo, com.sinosoft.aip.webservice.server.CaseDto[] caseDtoList) throws java.rmi.RemoteException{
    if (aIPWebService == null)
      _initAIPWebServiceProxy();
    return aIPWebService.uploadCaseInfo(clientInfo, caseDtoList);
  }
  
  public com.sinosoft.aip.webservice.server.PrepaidResponseDto uploadPrepaidInfo(com.sinosoft.aip.webservice.server.ClientInfo clientInfo, com.sinosoft.aip.webservice.server.PrepaidDto[] prepaidDtoList) throws java.rmi.RemoteException{
    if (aIPWebService == null)
      _initAIPWebServiceProxy();
    return aIPWebService.uploadPrepaidInfo(clientInfo, prepaidDtoList);
  }
  
  public com.sinosoft.aip.webservice.server.ClaimResponseDto uploadClaimInfo(com.sinosoft.aip.webservice.server.ClientInfo clientInfo, com.sinosoft.aip.webservice.server.ClaimDto[] claimDtoList) throws java.rmi.RemoteException{
    if (aIPWebService == null)
      _initAIPWebServiceProxy();
    return aIPWebService.uploadClaimInfo(clientInfo, claimDtoList);
  }
  
  
}