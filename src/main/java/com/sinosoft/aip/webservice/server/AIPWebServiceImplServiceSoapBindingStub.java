/**
 * AIPWebServiceImplServiceSoapBindingStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.sinosoft.aip.webservice.server;

import org.apache.axis.transport.http.HTTPConstants;

public class AIPWebServiceImplServiceSoapBindingStub extends org.apache.axis.client.Stub implements com.sinosoft.aip.webservice.server.AIPWebService {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[12];
        _initOperationDesc1();
        _initOperationDesc2();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("uploadProductInfo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "clientInfo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "clientInfo"), com.sinosoft.aip.webservice.server.ClientInfo.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "productDtoList"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "productDto"), com.sinosoft.aip.webservice.server.ProductDto[].class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "productResponseDto"));
        oper.setReturnClass(com.sinosoft.aip.webservice.server.ProductResponseDto.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "productResponseDto"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("uploadReturnedBillInfo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "clientInfo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "clientInfo"), com.sinosoft.aip.webservice.server.ClientInfo.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "returnedBillDtoList"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "returnedBillDto"), com.sinosoft.aip.webservice.server.ReturnedBillDto[].class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "returnedBillResponseDto"));
        oper.setReturnClass(com.sinosoft.aip.webservice.server.ReturnedBillResponseDto.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "returnedBillResponseDto"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[1] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("uploadPrepaidPayInfoc");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "clientInfo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "clientInfo"), com.sinosoft.aip.webservice.server.ClientInfo.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "prepaidPayDtoList"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "prepaidPayDto"), com.sinosoft.aip.webservice.server.PrepaidPayDto[].class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "prepaidPayResponseDto"));
        oper.setReturnClass(com.sinosoft.aip.webservice.server.PrepaidPayResponseDto.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "prepaidClaimResponseDto"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[2] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("uploadPolicyInfo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "clientInfo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "clientInfo"), com.sinosoft.aip.webservice.server.ClientInfo.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "policyDtoList"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "policyDto"), com.sinosoft.aip.webservice.server.PolicyDto[].class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "policyResponseDto"));
        oper.setReturnClass(com.sinosoft.aip.webservice.server.PolicyResponseDto.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "policyResponseDto"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[3] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("uploadEndorsementInfo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "clientInfo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "clientInfo"), com.sinosoft.aip.webservice.server.ClientInfo.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "endorsementDtoList"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "endorsementDto"), com.sinosoft.aip.webservice.server.EndorsementDto[].class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "endorsementResponseDto"));
        oper.setReturnClass(com.sinosoft.aip.webservice.server.EndorsementResponseDto.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "endorsementResponseDto"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[4] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("uploadPremiumPayInfo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "clientInfo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "clientInfo"), com.sinosoft.aip.webservice.server.ClientInfo.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "premiumPayDtoList"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "premiumPayDto"), com.sinosoft.aip.webservice.server.PremiumPayDto[].class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "premiumPayResponseDto"));
        oper.setReturnClass(com.sinosoft.aip.webservice.server.PremiumPayResponseDto.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "premiumPayResponseDto"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[5] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("uploadClaimPayInfo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "clientInfo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "clientInfo"), com.sinosoft.aip.webservice.server.ClientInfo.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "claimPayDtoList"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "claimPayDto"), com.sinosoft.aip.webservice.server.ClaimPayDto[].class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "claimPayResponseDto"));
        oper.setReturnClass(com.sinosoft.aip.webservice.server.ClaimPayResponseDto.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "claimPayResponseDto"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[6] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("uploadFarmerInfo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "clientInfo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "clientInfo"), com.sinosoft.aip.webservice.server.ClientInfo.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "farmerDtoList"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "farmerDto"), com.sinosoft.aip.webservice.server.FarmerDto[].class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "farmerResponseDto"));
        oper.setReturnClass(com.sinosoft.aip.webservice.server.FarmerResponseDto.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "farmerResponseDto"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[7] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("uploadCancelInfo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "clientInfo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "clientInfo"), com.sinosoft.aip.webservice.server.ClientInfo.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "cancelDtoList"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "cancelDto"), com.sinosoft.aip.webservice.server.CancelDto[].class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "cancelResponseDto"));
        oper.setReturnClass(com.sinosoft.aip.webservice.server.CancelResponseDto.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "cancelResponseDto"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[8] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("uploadCaseInfo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "clientInfo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "clientInfo"), com.sinosoft.aip.webservice.server.ClientInfo.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "caseDtoList"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "caseDto"), com.sinosoft.aip.webservice.server.CaseDto[].class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "caseResponseDto"));
        oper.setReturnClass(com.sinosoft.aip.webservice.server.CaseResponseDto.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "caseResponseDto"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[9] = oper;

    }

    private static void _initOperationDesc2(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("uploadPrepaidInfo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "clientInfo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "clientInfo"), com.sinosoft.aip.webservice.server.ClientInfo.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "prepaidDtoList"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "prepaidDto"), com.sinosoft.aip.webservice.server.PrepaidDto[].class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "prepaidResponseDto"));
        oper.setReturnClass(com.sinosoft.aip.webservice.server.PrepaidResponseDto.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "prepaidResponseDto"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[10] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("uploadClaimInfo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "clientInfo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "clientInfo"), com.sinosoft.aip.webservice.server.ClientInfo.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "claimDtoList"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "claimDto"), com.sinosoft.aip.webservice.server.ClaimDto[].class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "claimResponseDto"));
        oper.setReturnClass(com.sinosoft.aip.webservice.server.ClaimResponseDto.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "claimResponseDto"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[11] = oper;

    }

    public AIPWebServiceImplServiceSoapBindingStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public AIPWebServiceImplServiceSoapBindingStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public AIPWebServiceImplServiceSoapBindingStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
        if (service == null) {
            super.service = new org.apache.axis.client.Service();
        } else {
            super.service = service;
        }
        ((org.apache.axis.client.Service)super.service).setTypeMappingVersion("1.2");
            java.lang.Class cls;
            javax.xml.namespace.QName qName;
            javax.xml.namespace.QName qName2;
            java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            java.lang.Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            java.lang.Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            java.lang.Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            java.lang.Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            java.lang.Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
            java.lang.Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
            qName = new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "applicantInfo");
            cachedSerQNames.add(qName);
            cls = com.sinosoft.aip.webservice.server.ApplicantInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "cancelDto");
            cachedSerQNames.add(qName);
            cls = com.sinosoft.aip.webservice.server.CancelDto.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "cancelMainInfo");
            cachedSerQNames.add(qName);
            cls = com.sinosoft.aip.webservice.server.CancelMainInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "cancelResponseDto");
            cachedSerQNames.add(qName);
            cls = com.sinosoft.aip.webservice.server.CancelResponseDto.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "cancelResultInfo");
            cachedSerQNames.add(qName);
            cls = com.sinosoft.aip.webservice.server.CancelResultInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "caseDto");
            cachedSerQNames.add(qName);
            cls = com.sinosoft.aip.webservice.server.CaseDto.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "caseMainInfo");
            cachedSerQNames.add(qName);
            cls = com.sinosoft.aip.webservice.server.CaseMainInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "caseResponseDto");
            cachedSerQNames.add(qName);
            cls = com.sinosoft.aip.webservice.server.CaseResponseDto.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "caseResultInfo");
            cachedSerQNames.add(qName);
            cls = com.sinosoft.aip.webservice.server.CaseResultInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "claimDto");
            cachedSerQNames.add(qName);
            cls = com.sinosoft.aip.webservice.server.ClaimDto.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "claimFarmerInfo");
            cachedSerQNames.add(qName);
            cls = com.sinosoft.aip.webservice.server.ClaimFarmerInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "claimMainInfo");
            cachedSerQNames.add(qName);
            cls = com.sinosoft.aip.webservice.server.ClaimMainInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "claimPayDto");
            cachedSerQNames.add(qName);
            cls = com.sinosoft.aip.webservice.server.ClaimPayDto.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "claimPayFarmerInfo");
            cachedSerQNames.add(qName);
            cls = com.sinosoft.aip.webservice.server.ClaimPayFarmerInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "claimPayMainInfo");
            cachedSerQNames.add(qName);
            cls = com.sinosoft.aip.webservice.server.ClaimPayMainInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "claimPayResponseDto");
            cachedSerQNames.add(qName);
            cls = com.sinosoft.aip.webservice.server.ClaimPayResponseDto.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "claimPayResultInfo");
            cachedSerQNames.add(qName);
            cls = com.sinosoft.aip.webservice.server.ClaimPayResultInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "claimResponseDto");
            cachedSerQNames.add(qName);
            cls = com.sinosoft.aip.webservice.server.ClaimResponseDto.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "claimResponseMainInfo");
            cachedSerQNames.add(qName);
            cls = com.sinosoft.aip.webservice.server.ClaimResponseMainInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "clientInfo");
            cachedSerQNames.add(qName);
            cls = com.sinosoft.aip.webservice.server.ClientInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "commonResponseDto");
            cachedSerQNames.add(qName);
            cls = com.sinosoft.aip.webservice.server.CommonResponseDto.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "directExpenseInfo");
            cachedSerQNames.add(qName);
            cls = com.sinosoft.aip.webservice.server.DirectExpenseInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "endorsementDto");
            cachedSerQNames.add(qName);
            cls = com.sinosoft.aip.webservice.server.EndorsementDto.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "endorsementInfo");
            cachedSerQNames.add(qName);
            cls = com.sinosoft.aip.webservice.server.EndorsementInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "endorsementResponseDto");
            cachedSerQNames.add(qName);
            cls = com.sinosoft.aip.webservice.server.EndorsementResponseDto.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "endorsementResultInfo");
            cachedSerQNames.add(qName);
            cls = com.sinosoft.aip.webservice.server.EndorsementResultInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "endorsementTypeInfo");
            cachedSerQNames.add(qName);
            cls = com.sinosoft.aip.webservice.server.EndorsementTypeInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "farmerDto");
            cachedSerQNames.add(qName);
            cls = com.sinosoft.aip.webservice.server.FarmerDto.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "farmerResponseDto");
            cachedSerQNames.add(qName);
            cls = com.sinosoft.aip.webservice.server.FarmerResponseDto.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "farmerResultInfo");
            cachedSerQNames.add(qName);
            cls = com.sinosoft.aip.webservice.server.FarmerResultInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "insurantInfo");
            cachedSerQNames.add(qName);
            cls = com.sinosoft.aip.webservice.server.InsurantInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "insuredObject");
            cachedSerQNames.add(qName);
            cls = com.sinosoft.aip.webservice.server.InsuredObject.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "organizerInfo");
            cachedSerQNames.add(qName);
            cls = com.sinosoft.aip.webservice.server.OrganizerInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "policyDto");
            cachedSerQNames.add(qName);
            cls = com.sinosoft.aip.webservice.server.PolicyDto.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "policyFarmerInfo");
            cachedSerQNames.add(qName);
            cls = com.sinosoft.aip.webservice.server.PolicyFarmerInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "policyMainInfo");
            cachedSerQNames.add(qName);
            cls = com.sinosoft.aip.webservice.server.PolicyMainInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "policyResponseDto");
            cachedSerQNames.add(qName);
            cls = com.sinosoft.aip.webservice.server.PolicyResponseDto.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "policyResultInfo");
            cachedSerQNames.add(qName);
            cls = com.sinosoft.aip.webservice.server.PolicyResultInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "premiumInfo");
            cachedSerQNames.add(qName);
            cls = com.sinosoft.aip.webservice.server.PremiumInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "premiumPayDto");
            cachedSerQNames.add(qName);
            cls = com.sinosoft.aip.webservice.server.PremiumPayDto.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "premiumPayMainInfo");
            cachedSerQNames.add(qName);
            cls = com.sinosoft.aip.webservice.server.PremiumPayMainInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "premiumPayResponseDto");
            cachedSerQNames.add(qName);
            cls = com.sinosoft.aip.webservice.server.PremiumPayResponseDto.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "premiumPayResultInfo");
            cachedSerQNames.add(qName);
            cls = com.sinosoft.aip.webservice.server.PremiumPayResultInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "prepaidDto");
            cachedSerQNames.add(qName);
            cls = com.sinosoft.aip.webservice.server.PrepaidDto.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "prepaidFarmerInfo");
            cachedSerQNames.add(qName);
            cls = com.sinosoft.aip.webservice.server.PrepaidFarmerInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "prepaidMainInfo");
            cachedSerQNames.add(qName);
            cls = com.sinosoft.aip.webservice.server.PrepaidMainInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "prepaidPayDto");
            cachedSerQNames.add(qName);
            cls = com.sinosoft.aip.webservice.server.PrepaidPayDto.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "prepaidPayMainInfo");
            cachedSerQNames.add(qName);
            cls = com.sinosoft.aip.webservice.server.PrepaidPayMainInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "prepaidPayResponseDto");
            cachedSerQNames.add(qName);
            cls = com.sinosoft.aip.webservice.server.PrepaidPayResponseDto.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "prepaidPayResultInfo");
            cachedSerQNames.add(qName);
            cls = com.sinosoft.aip.webservice.server.PrepaidPayResultInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "prepaidResponseDto");
            cachedSerQNames.add(qName);
            cls = com.sinosoft.aip.webservice.server.PrepaidResponseDto.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "prepaidResultInfo");
            cachedSerQNames.add(qName);
            cls = com.sinosoft.aip.webservice.server.PrepaidResultInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "productDto");
            cachedSerQNames.add(qName);
            cls = com.sinosoft.aip.webservice.server.ProductDto.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "productInfo");
            cachedSerQNames.add(qName);
            cls = com.sinosoft.aip.webservice.server.ProductInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "productResponseDto");
            cachedSerQNames.add(qName);
            cls = com.sinosoft.aip.webservice.server.ProductResponseDto.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "productResultInfo");
            cachedSerQNames.add(qName);
            cls = com.sinosoft.aip.webservice.server.ProductResultInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "registInfo");
            cachedSerQNames.add(qName);
            cls = com.sinosoft.aip.webservice.server.RegistInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "returnedBillDetailInfo");
            cachedSerQNames.add(qName);
            cls = com.sinosoft.aip.webservice.server.ReturnedBillDetailInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "returnedBillDto");
            cachedSerQNames.add(qName);
            cls = com.sinosoft.aip.webservice.server.ReturnedBillDto.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "returnedBillMainInfo");
            cachedSerQNames.add(qName);
            cls = com.sinosoft.aip.webservice.server.ReturnedBillMainInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "returnedBillResponseDto");
            cachedSerQNames.add(qName);
            cls = com.sinosoft.aip.webservice.server.ReturnedBillResponseDto.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "returnedBillResultInfo");
            cachedSerQNames.add(qName);
            cls = com.sinosoft.aip.webservice.server.ReturnedBillResultInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

    }

    protected org.apache.axis.client.Call createCall() throws java.rmi.RemoteException {
        try {
            org.apache.axis.client.Call _call = super._createCall();
            if (super.maintainSessionSet) {
                _call.setMaintainSession(super.maintainSession);
            }
            if (super.cachedUsername != null) {
                _call.setUsername(super.cachedUsername);
            }
            if (super.cachedPassword != null) {
                _call.setPassword(super.cachedPassword);
            }
            if (super.cachedEndpoint != null) {
                _call.setTargetEndpointAddress(super.cachedEndpoint);
            }
            if (super.cachedTimeout != null) {
                _call.setTimeout(super.cachedTimeout);
            }
            if (super.cachedPortName != null) {
                _call.setPortName(super.cachedPortName);
            }
            java.util.Enumeration keys = super.cachedProperties.keys();
            while (keys.hasMoreElements()) {
                java.lang.String key = (java.lang.String) keys.nextElement();
                _call.setProperty(key, super.cachedProperties.get(key));
            }
            // All the type mapping information is registered
            // when the first call is made.
            // The type mapping information is actually registered in
            // the TypeMappingRegistry of the service, which
            // is the reason why registration is only needed for the first call.
            synchronized (this) {
                if (firstCall()) {
                    // must set encoding style before registering serializers
                    _call.setEncodingStyle(null);
                    for (int i = 0; i < cachedSerFactories.size(); ++i) {
                        java.lang.Class cls = (java.lang.Class) cachedSerClasses.get(i);
                        javax.xml.namespace.QName qName =
                                (javax.xml.namespace.QName) cachedSerQNames.get(i);
                        java.lang.Object x = cachedSerFactories.get(i);
                        if (x instanceof Class) {
                            java.lang.Class sf = (java.lang.Class)
                                 cachedSerFactories.get(i);
                            java.lang.Class df = (java.lang.Class)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                        else if (x instanceof javax.xml.rpc.encoding.SerializerFactory) {
                            org.apache.axis.encoding.SerializerFactory sf = (org.apache.axis.encoding.SerializerFactory)
                                 cachedSerFactories.get(i);
                            org.apache.axis.encoding.DeserializerFactory df = (org.apache.axis.encoding.DeserializerFactory)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                    }
                }
            }
            return _call;
        }
        catch (java.lang.Throwable _t) {
            throw new org.apache.axis.AxisFault("Failure trying to get the Call object", _t);
        }
    }

    public com.sinosoft.aip.webservice.server.ProductResponseDto uploadProductInfo(com.sinosoft.aip.webservice.server.ClientInfo clientInfo, com.sinosoft.aip.webservice.server.ProductDto[] productDtoList) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "uploadProductInfo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {clientInfo, productDtoList});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.sinosoft.aip.webservice.server.ProductResponseDto) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.sinosoft.aip.webservice.server.ProductResponseDto) org.apache.axis.utils.JavaUtils.convert(_resp, com.sinosoft.aip.webservice.server.ProductResponseDto.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.sinosoft.aip.webservice.server.ReturnedBillResponseDto uploadReturnedBillInfo(com.sinosoft.aip.webservice.server.ClientInfo clientInfo, com.sinosoft.aip.webservice.server.ReturnedBillDto[] returnedBillDtoList) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "uploadReturnedBillInfo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {clientInfo, returnedBillDtoList});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.sinosoft.aip.webservice.server.ReturnedBillResponseDto) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.sinosoft.aip.webservice.server.ReturnedBillResponseDto) org.apache.axis.utils.JavaUtils.convert(_resp, com.sinosoft.aip.webservice.server.ReturnedBillResponseDto.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.sinosoft.aip.webservice.server.PrepaidPayResponseDto uploadPrepaidPayInfoc(com.sinosoft.aip.webservice.server.ClientInfo clientInfo, com.sinosoft.aip.webservice.server.PrepaidPayDto[] prepaidPayDtoList) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[2]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "uploadPrepaidPayInfoc"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {clientInfo, prepaidPayDtoList});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.sinosoft.aip.webservice.server.PrepaidPayResponseDto) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.sinosoft.aip.webservice.server.PrepaidPayResponseDto) org.apache.axis.utils.JavaUtils.convert(_resp, com.sinosoft.aip.webservice.server.PrepaidPayResponseDto.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.sinosoft.aip.webservice.server.PolicyResponseDto uploadPolicyInfo(com.sinosoft.aip.webservice.server.ClientInfo clientInfo, com.sinosoft.aip.webservice.server.PolicyDto[] policyDtoList) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[3]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "uploadPolicyInfo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {clientInfo, policyDtoList});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.sinosoft.aip.webservice.server.PolicyResponseDto) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.sinosoft.aip.webservice.server.PolicyResponseDto) org.apache.axis.utils.JavaUtils.convert(_resp, com.sinosoft.aip.webservice.server.PolicyResponseDto.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.sinosoft.aip.webservice.server.EndorsementResponseDto uploadEndorsementInfo(com.sinosoft.aip.webservice.server.ClientInfo clientInfo, com.sinosoft.aip.webservice.server.EndorsementDto[] endorsementDtoList) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[4]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "uploadEndorsementInfo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {clientInfo, endorsementDtoList});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.sinosoft.aip.webservice.server.EndorsementResponseDto) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.sinosoft.aip.webservice.server.EndorsementResponseDto) org.apache.axis.utils.JavaUtils.convert(_resp, com.sinosoft.aip.webservice.server.EndorsementResponseDto.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.sinosoft.aip.webservice.server.PremiumPayResponseDto uploadPremiumPayInfo(com.sinosoft.aip.webservice.server.ClientInfo clientInfo, com.sinosoft.aip.webservice.server.PremiumPayDto[] premiumPayDtoList) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[5]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "uploadPremiumPayInfo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {clientInfo, premiumPayDtoList});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.sinosoft.aip.webservice.server.PremiumPayResponseDto) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.sinosoft.aip.webservice.server.PremiumPayResponseDto) org.apache.axis.utils.JavaUtils.convert(_resp, com.sinosoft.aip.webservice.server.PremiumPayResponseDto.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.sinosoft.aip.webservice.server.ClaimPayResponseDto uploadClaimPayInfo(com.sinosoft.aip.webservice.server.ClientInfo clientInfo, com.sinosoft.aip.webservice.server.ClaimPayDto[] claimPayDtoList) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[6]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "uploadClaimPayInfo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {clientInfo, claimPayDtoList});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.sinosoft.aip.webservice.server.ClaimPayResponseDto) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.sinosoft.aip.webservice.server.ClaimPayResponseDto) org.apache.axis.utils.JavaUtils.convert(_resp, com.sinosoft.aip.webservice.server.ClaimPayResponseDto.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.sinosoft.aip.webservice.server.FarmerResponseDto uploadFarmerInfo(com.sinosoft.aip.webservice.server.ClientInfo clientInfo, com.sinosoft.aip.webservice.server.FarmerDto[] farmerDtoList) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[7]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(HTTPConstants.MC_GZIP_REQUEST, Boolean.TRUE);
        _call.setProperty(HTTPConstants.MC_ACCEPT_GZIP, Boolean.TRUE);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "uploadFarmerInfo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {clientInfo, farmerDtoList});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.sinosoft.aip.webservice.server.FarmerResponseDto) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.sinosoft.aip.webservice.server.FarmerResponseDto) org.apache.axis.utils.JavaUtils.convert(_resp, com.sinosoft.aip.webservice.server.FarmerResponseDto.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.sinosoft.aip.webservice.server.CancelResponseDto uploadCancelInfo(com.sinosoft.aip.webservice.server.ClientInfo clientInfo, com.sinosoft.aip.webservice.server.CancelDto[] cancelDtoList) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[8]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(HTTPConstants.MC_GZIP_REQUEST, Boolean.TRUE);
        _call.setProperty(HTTPConstants.MC_ACCEPT_GZIP, Boolean.TRUE);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "uploadCancelInfo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {clientInfo, cancelDtoList});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.sinosoft.aip.webservice.server.CancelResponseDto) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.sinosoft.aip.webservice.server.CancelResponseDto) org.apache.axis.utils.JavaUtils.convert(_resp, com.sinosoft.aip.webservice.server.CancelResponseDto.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.sinosoft.aip.webservice.server.CaseResponseDto uploadCaseInfo(com.sinosoft.aip.webservice.server.ClientInfo clientInfo, com.sinosoft.aip.webservice.server.CaseDto[] caseDtoList) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[9]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(HTTPConstants.MC_GZIP_REQUEST, Boolean.TRUE);
        _call.setProperty(HTTPConstants.MC_ACCEPT_GZIP, Boolean.TRUE);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "uploadCaseInfo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {clientInfo, caseDtoList});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.sinosoft.aip.webservice.server.CaseResponseDto) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.sinosoft.aip.webservice.server.CaseResponseDto) org.apache.axis.utils.JavaUtils.convert(_resp, com.sinosoft.aip.webservice.server.CaseResponseDto.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.sinosoft.aip.webservice.server.PrepaidResponseDto uploadPrepaidInfo(com.sinosoft.aip.webservice.server.ClientInfo clientInfo, com.sinosoft.aip.webservice.server.PrepaidDto[] prepaidDtoList) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[10]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(HTTPConstants.MC_GZIP_REQUEST, Boolean.TRUE);
        _call.setProperty(HTTPConstants.MC_ACCEPT_GZIP, Boolean.TRUE);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "uploadPrepaidInfo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {clientInfo, prepaidDtoList});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.sinosoft.aip.webservice.server.PrepaidResponseDto) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.sinosoft.aip.webservice.server.PrepaidResponseDto) org.apache.axis.utils.JavaUtils.convert(_resp, com.sinosoft.aip.webservice.server.PrepaidResponseDto.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.sinosoft.aip.webservice.server.ClaimResponseDto uploadClaimInfo(com.sinosoft.aip.webservice.server.ClientInfo clientInfo, com.sinosoft.aip.webservice.server.ClaimDto[] claimDtoList) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[11]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(HTTPConstants.MC_GZIP_REQUEST, Boolean.TRUE);
        _call.setProperty(HTTPConstants.MC_ACCEPT_GZIP, Boolean.TRUE);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "uploadClaimInfo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {clientInfo, claimDtoList});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.sinosoft.aip.webservice.server.ClaimResponseDto) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.sinosoft.aip.webservice.server.ClaimResponseDto) org.apache.axis.utils.JavaUtils.convert(_resp, com.sinosoft.aip.webservice.server.ClaimResponseDto.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

}
