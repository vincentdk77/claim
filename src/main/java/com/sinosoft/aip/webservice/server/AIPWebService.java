/**
 * AIPWebService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.sinosoft.aip.webservice.server;

public interface AIPWebService extends java.rmi.Remote {
    public com.sinosoft.aip.webservice.server.ProductResponseDto uploadProductInfo(com.sinosoft.aip.webservice.server.ClientInfo clientInfo, com.sinosoft.aip.webservice.server.ProductDto[] productDtoList) throws java.rmi.RemoteException;
    public com.sinosoft.aip.webservice.server.ReturnedBillResponseDto uploadReturnedBillInfo(com.sinosoft.aip.webservice.server.ClientInfo clientInfo, com.sinosoft.aip.webservice.server.ReturnedBillDto[] returnedBillDtoList) throws java.rmi.RemoteException;
    public com.sinosoft.aip.webservice.server.PrepaidPayResponseDto uploadPrepaidPayInfoc(com.sinosoft.aip.webservice.server.ClientInfo clientInfo, com.sinosoft.aip.webservice.server.PrepaidPayDto[] prepaidPayDtoList) throws java.rmi.RemoteException;
    public com.sinosoft.aip.webservice.server.PolicyResponseDto uploadPolicyInfo(com.sinosoft.aip.webservice.server.ClientInfo clientInfo, com.sinosoft.aip.webservice.server.PolicyDto[] policyDtoList) throws java.rmi.RemoteException;
    public com.sinosoft.aip.webservice.server.EndorsementResponseDto uploadEndorsementInfo(com.sinosoft.aip.webservice.server.ClientInfo clientInfo, com.sinosoft.aip.webservice.server.EndorsementDto[] endorsementDtoList) throws java.rmi.RemoteException;
    public com.sinosoft.aip.webservice.server.PremiumPayResponseDto uploadPremiumPayInfo(com.sinosoft.aip.webservice.server.ClientInfo clientInfo, com.sinosoft.aip.webservice.server.PremiumPayDto[] premiumPayDtoList) throws java.rmi.RemoteException;
    public com.sinosoft.aip.webservice.server.ClaimPayResponseDto uploadClaimPayInfo(com.sinosoft.aip.webservice.server.ClientInfo clientInfo, com.sinosoft.aip.webservice.server.ClaimPayDto[] claimPayDtoList) throws java.rmi.RemoteException;
    public com.sinosoft.aip.webservice.server.FarmerResponseDto uploadFarmerInfo(com.sinosoft.aip.webservice.server.ClientInfo clientInfo, com.sinosoft.aip.webservice.server.FarmerDto[] farmerDtoList) throws java.rmi.RemoteException;
    public com.sinosoft.aip.webservice.server.CancelResponseDto uploadCancelInfo(com.sinosoft.aip.webservice.server.ClientInfo clientInfo, com.sinosoft.aip.webservice.server.CancelDto[] cancelDtoList) throws java.rmi.RemoteException;
    public com.sinosoft.aip.webservice.server.CaseResponseDto uploadCaseInfo(com.sinosoft.aip.webservice.server.ClientInfo clientInfo, com.sinosoft.aip.webservice.server.CaseDto[] caseDtoList) throws java.rmi.RemoteException;
    public com.sinosoft.aip.webservice.server.PrepaidResponseDto uploadPrepaidInfo(com.sinosoft.aip.webservice.server.ClientInfo clientInfo, com.sinosoft.aip.webservice.server.PrepaidDto[] prepaidDtoList) throws java.rmi.RemoteException;
    public com.sinosoft.aip.webservice.server.ClaimResponseDto uploadClaimInfo(com.sinosoft.aip.webservice.server.ClientInfo clientInfo, com.sinosoft.aip.webservice.server.ClaimDto[] claimDtoList) throws java.rmi.RemoteException;
}
