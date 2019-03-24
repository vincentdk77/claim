/**
 * CancelMainInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.sinosoft.aip.webservice.server;

import com.sinosoft.sysframework.common.datatype.DateTime;

public class CancelMainInfo  implements java.io.Serializable {
    private java.lang.String cancelReason;

    private DateTime cancelTime;

    private java.lang.String cancelType;

    private java.lang.String claimNumber;

    private java.lang.String claimSequenceNo;

    private java.lang.String companyCode;

    private java.lang.String policyNumber;

    public CancelMainInfo() {
    }

    public CancelMainInfo(
           java.lang.String cancelReason,
           DateTime cancelTime,
           java.lang.String cancelType,
           java.lang.String claimNumber,
           java.lang.String claimSequenceNo,
           java.lang.String companyCode,
           java.lang.String policyNumber) {
           this.cancelReason = cancelReason;
           this.cancelTime = cancelTime;
           this.cancelType = cancelType;
           this.claimNumber = claimNumber;
           this.claimSequenceNo = claimSequenceNo;
           this.companyCode = companyCode;
           this.policyNumber = policyNumber;
    }


    /**
     * Gets the cancelReason value for this CancelMainInfo.
     * 
     * @return cancelReason
     */
    public java.lang.String getCancelReason() {
        return cancelReason;
    }


    /**
     * Sets the cancelReason value for this CancelMainInfo.
     * 
     * @param cancelReason
     */
    public void setCancelReason(java.lang.String cancelReason) {
        this.cancelReason = cancelReason;
    }


    /**
     * Gets the cancelTime value for this CancelMainInfo.
     * 
     * @return cancelTime
     */
    public DateTime getCancelTime() {
        return cancelTime;
    }


    /**
     * Sets the cancelTime value for this CancelMainInfo.
     * 
     * @param dateTime
     */
    public void setCancelTime(DateTime dateTime) {
        this.cancelTime = dateTime;
    }


    /**
     * Gets the cancelType value for this CancelMainInfo.
     * 
     * @return cancelType
     */
    public java.lang.String getCancelType() {
        return cancelType;
    }


    /**
     * Sets the cancelType value for this CancelMainInfo.
     * 
     * @param cancelType
     */
    public void setCancelType(java.lang.String cancelType) {
        this.cancelType = cancelType;
    }


    /**
     * Gets the claimNumber value for this CancelMainInfo.
     * 
     * @return claimNumber
     */
    public java.lang.String getClaimNumber() {
        return claimNumber;
    }


    /**
     * Sets the claimNumber value for this CancelMainInfo.
     * 
     * @param claimNumber
     */
    public void setClaimNumber(java.lang.String claimNumber) {
        this.claimNumber = claimNumber;
    }


    /**
     * Gets the claimSequenceNo value for this CancelMainInfo.
     * 
     * @return claimSequenceNo
     */
    public java.lang.String getClaimSequenceNo() {
        return claimSequenceNo;
    }


    /**
     * Sets the claimSequenceNo value for this CancelMainInfo.
     * 
     * @param claimSequenceNo
     */
    public void setClaimSequenceNo(java.lang.String claimSequenceNo) {
        this.claimSequenceNo = claimSequenceNo;
    }


    /**
     * Gets the companyCode value for this CancelMainInfo.
     * 
     * @return companyCode
     */
    public java.lang.String getCompanyCode() {
        return companyCode;
    }


    /**
     * Sets the companyCode value for this CancelMainInfo.
     * 
     * @param companyCode
     */
    public void setCompanyCode(java.lang.String companyCode) {
        this.companyCode = companyCode;
    }


    /**
     * Gets the policyNumber value for this CancelMainInfo.
     * 
     * @return policyNumber
     */
    public java.lang.String getPolicyNumber() {
        return policyNumber;
    }


    /**
     * Sets the policyNumber value for this CancelMainInfo.
     * 
     * @param policyNumber
     */
    public void setPolicyNumber(java.lang.String policyNumber) {
        this.policyNumber = policyNumber;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CancelMainInfo)) return false;
        CancelMainInfo other = (CancelMainInfo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cancelReason==null && other.getCancelReason()==null) || 
             (this.cancelReason!=null &&
              this.cancelReason.equals(other.getCancelReason()))) &&
            ((this.cancelTime==null && other.getCancelTime()==null) || 
             (this.cancelTime!=null &&
              this.cancelTime.equals(other.getCancelTime()))) &&
            ((this.cancelType==null && other.getCancelType()==null) || 
             (this.cancelType!=null &&
              this.cancelType.equals(other.getCancelType()))) &&
            ((this.claimNumber==null && other.getClaimNumber()==null) || 
             (this.claimNumber!=null &&
              this.claimNumber.equals(other.getClaimNumber()))) &&
            ((this.claimSequenceNo==null && other.getClaimSequenceNo()==null) || 
             (this.claimSequenceNo!=null &&
              this.claimSequenceNo.equals(other.getClaimSequenceNo()))) &&
            ((this.companyCode==null && other.getCompanyCode()==null) || 
             (this.companyCode!=null &&
              this.companyCode.equals(other.getCompanyCode()))) &&
            ((this.policyNumber==null && other.getPolicyNumber()==null) || 
             (this.policyNumber!=null &&
              this.policyNumber.equals(other.getPolicyNumber())));
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
        if (getCancelReason() != null) {
            _hashCode += getCancelReason().hashCode();
        }
        if (getCancelTime() != null) {
            _hashCode += getCancelTime().hashCode();
        }
        if (getCancelType() != null) {
            _hashCode += getCancelType().hashCode();
        }
        if (getClaimNumber() != null) {
            _hashCode += getClaimNumber().hashCode();
        }
        if (getClaimSequenceNo() != null) {
            _hashCode += getClaimSequenceNo().hashCode();
        }
        if (getCompanyCode() != null) {
            _hashCode += getCompanyCode().hashCode();
        }
        if (getPolicyNumber() != null) {
            _hashCode += getPolicyNumber().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CancelMainInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "cancelMainInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cancelReason");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cancelReason"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cancelTime");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cancelTime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cancelType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cancelType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("claimNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("", "claimNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("claimSequenceNo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "claimSequenceNo"));
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
        elemField.setFieldName("policyNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("", "policyNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
