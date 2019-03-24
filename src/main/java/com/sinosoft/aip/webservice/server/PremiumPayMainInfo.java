/**
 * PremiumPayMainInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.sinosoft.aip.webservice.server;

public class PremiumPayMainInfo  implements java.io.Serializable {
    private java.lang.String applicantName;

    private java.lang.String companyCode;

    private java.lang.String insuredName;

    private java.lang.String policyNumber;

    private java.lang.String premiumPayerCode;

    private java.lang.Double receivedAmount;

    private java.util.Calendar receivedDate;

    private java.lang.String receivedType;

    private java.lang.Integer serialNo;

    public PremiumPayMainInfo() {
    }

    public PremiumPayMainInfo(
           java.lang.String applicantName,
           java.lang.String companyCode,
           java.lang.String insuredName,
           java.lang.String policyNumber,
           java.lang.String premiumPayerCode,
           java.lang.Double receivedAmount,
           java.util.Calendar receivedDate,
           java.lang.String receivedType,
           java.lang.Integer serialNo) {
           this.applicantName = applicantName;
           this.companyCode = companyCode;
           this.insuredName = insuredName;
           this.policyNumber = policyNumber;
           this.premiumPayerCode = premiumPayerCode;
           this.receivedAmount = receivedAmount;
           this.receivedDate = receivedDate;
           this.receivedType = receivedType;
           this.serialNo = serialNo;
    }


    /**
     * Gets the applicantName value for this PremiumPayMainInfo.
     * 
     * @return applicantName
     */
    public java.lang.String getApplicantName() {
        return applicantName;
    }


    /**
     * Sets the applicantName value for this PremiumPayMainInfo.
     * 
     * @param applicantName
     */
    public void setApplicantName(java.lang.String applicantName) {
        this.applicantName = applicantName;
    }


    /**
     * Gets the companyCode value for this PremiumPayMainInfo.
     * 
     * @return companyCode
     */
    public java.lang.String getCompanyCode() {
        return companyCode;
    }


    /**
     * Sets the companyCode value for this PremiumPayMainInfo.
     * 
     * @param companyCode
     */
    public void setCompanyCode(java.lang.String companyCode) {
        this.companyCode = companyCode;
    }


    /**
     * Gets the insuredName value for this PremiumPayMainInfo.
     * 
     * @return insuredName
     */
    public java.lang.String getInsuredName() {
        return insuredName;
    }


    /**
     * Sets the insuredName value for this PremiumPayMainInfo.
     * 
     * @param insuredName
     */
    public void setInsuredName(java.lang.String insuredName) {
        this.insuredName = insuredName;
    }


    /**
     * Gets the policyNumber value for this PremiumPayMainInfo.
     * 
     * @return policyNumber
     */
    public java.lang.String getPolicyNumber() {
        return policyNumber;
    }


    /**
     * Sets the policyNumber value for this PremiumPayMainInfo.
     * 
     * @param policyNumber
     */
    public void setPolicyNumber(java.lang.String policyNumber) {
        this.policyNumber = policyNumber;
    }


    /**
     * Gets the premiumPayerCode value for this PremiumPayMainInfo.
     * 
     * @return premiumPayerCode
     */
    public java.lang.String getPremiumPayerCode() {
        return premiumPayerCode;
    }


    /**
     * Sets the premiumPayerCode value for this PremiumPayMainInfo.
     * 
     * @param premiumPayerCode
     */
    public void setPremiumPayerCode(java.lang.String premiumPayerCode) {
        this.premiumPayerCode = premiumPayerCode;
    }


    /**
     * Gets the receivedAmount value for this PremiumPayMainInfo.
     * 
     * @return receivedAmount
     */
    public java.lang.Double getReceivedAmount() {
        return receivedAmount;
    }


    /**
     * Sets the receivedAmount value for this PremiumPayMainInfo.
     * 
     * @param receivedAmount
     */
    public void setReceivedAmount(java.lang.Double receivedAmount) {
        this.receivedAmount = receivedAmount;
    }


    /**
     * Gets the receivedDate value for this PremiumPayMainInfo.
     * 
     * @return receivedDate
     */
    public java.util.Calendar getReceivedDate() {
        return receivedDate;
    }


    /**
     * Sets the receivedDate value for this PremiumPayMainInfo.
     * 
     * @param receivedDate
     */
    public void setReceivedDate(java.util.Calendar receivedDate) {
        this.receivedDate = receivedDate;
    }


    /**
     * Gets the receivedType value for this PremiumPayMainInfo.
     * 
     * @return receivedType
     */
    public java.lang.String getReceivedType() {
        return receivedType;
    }


    /**
     * Sets the receivedType value for this PremiumPayMainInfo.
     * 
     * @param receivedType
     */
    public void setReceivedType(java.lang.String receivedType) {
        this.receivedType = receivedType;
    }


    /**
     * Gets the serialNo value for this PremiumPayMainInfo.
     * 
     * @return serialNo
     */
    public java.lang.Integer getSerialNo() {
        return serialNo;
    }


    /**
     * Sets the serialNo value for this PremiumPayMainInfo.
     * 
     * @param serialNo
     */
    public void setSerialNo(java.lang.Integer serialNo) {
        this.serialNo = serialNo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PremiumPayMainInfo)) return false;
        PremiumPayMainInfo other = (PremiumPayMainInfo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.applicantName==null && other.getApplicantName()==null) || 
             (this.applicantName!=null &&
              this.applicantName.equals(other.getApplicantName()))) &&
            ((this.companyCode==null && other.getCompanyCode()==null) || 
             (this.companyCode!=null &&
              this.companyCode.equals(other.getCompanyCode()))) &&
            ((this.insuredName==null && other.getInsuredName()==null) || 
             (this.insuredName!=null &&
              this.insuredName.equals(other.getInsuredName()))) &&
            ((this.policyNumber==null && other.getPolicyNumber()==null) || 
             (this.policyNumber!=null &&
              this.policyNumber.equals(other.getPolicyNumber()))) &&
            ((this.premiumPayerCode==null && other.getPremiumPayerCode()==null) || 
             (this.premiumPayerCode!=null &&
              this.premiumPayerCode.equals(other.getPremiumPayerCode()))) &&
            ((this.receivedAmount==null && other.getReceivedAmount()==null) || 
             (this.receivedAmount!=null &&
              this.receivedAmount.equals(other.getReceivedAmount()))) &&
            ((this.receivedDate==null && other.getReceivedDate()==null) || 
             (this.receivedDate!=null &&
              this.receivedDate.equals(other.getReceivedDate()))) &&
            ((this.receivedType==null && other.getReceivedType()==null) || 
             (this.receivedType!=null &&
              this.receivedType.equals(other.getReceivedType()))) &&
            ((this.serialNo==null && other.getSerialNo()==null) || 
             (this.serialNo!=null &&
              this.serialNo.equals(other.getSerialNo())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getApplicantName() != null) {
            _hashCode += getApplicantName().hashCode();
        }
        if (getCompanyCode() != null) {
            _hashCode += getCompanyCode().hashCode();
        }
        if (getInsuredName() != null) {
            _hashCode += getInsuredName().hashCode();
        }
        if (getPolicyNumber() != null) {
            _hashCode += getPolicyNumber().hashCode();
        }
        if (getPremiumPayerCode() != null) {
            _hashCode += getPremiumPayerCode().hashCode();
        }
        if (getReceivedAmount() != null) {
            _hashCode += getReceivedAmount().hashCode();
        }
        if (getReceivedDate() != null) {
            _hashCode += getReceivedDate().hashCode();
        }
        if (getReceivedType() != null) {
            _hashCode += getReceivedType().hashCode();
        }
        if (getSerialNo() != null) {
            _hashCode += getSerialNo().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PremiumPayMainInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "premiumPayMainInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("applicantName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "applicantName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("companyCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "companyCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("insuredName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "insuredName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("policyNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("", "policyNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("premiumPayerCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "premiumPayerCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("receivedAmount");
        elemField.setXmlName(new javax.xml.namespace.QName("", "receivedAmount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("receivedDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "receivedDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("receivedType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "receivedType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("serialNo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "serialNo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
