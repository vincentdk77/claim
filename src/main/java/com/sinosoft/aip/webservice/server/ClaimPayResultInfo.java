/**
 * ClaimPayResultInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.sinosoft.aip.webservice.server;

public class ClaimPayResultInfo  implements java.io.Serializable {
    private java.lang.String caseNumber;

    private java.lang.String errorCode;

    private java.lang.String errorDesc;

    private java.lang.String responseCode;

    private java.lang.Integer serialNo;

    public ClaimPayResultInfo() {
    }

    public ClaimPayResultInfo(
           java.lang.String caseNumber,
           java.lang.String errorCode,
           java.lang.String errorDesc,
           java.lang.String responseCode,
           java.lang.Integer serialNo) {
           this.caseNumber = caseNumber;
           this.errorCode = errorCode;
           this.errorDesc = errorDesc;
           this.responseCode = responseCode;
           this.serialNo = serialNo;
    }


    /**
     * Gets the caseNumber value for this ClaimPayResultInfo.
     * 
     * @return caseNumber
     */
    public java.lang.String getCaseNumber() {
        return caseNumber;
    }


    /**
     * Sets the caseNumber value for this ClaimPayResultInfo.
     * 
     * @param caseNumber
     */
    public void setCaseNumber(java.lang.String caseNumber) {
        this.caseNumber = caseNumber;
    }


    /**
     * Gets the errorCode value for this ClaimPayResultInfo.
     * 
     * @return errorCode
     */
    public java.lang.String getErrorCode() {
        return errorCode;
    }


    /**
     * Sets the errorCode value for this ClaimPayResultInfo.
     * 
     * @param errorCode
     */
    public void setErrorCode(java.lang.String errorCode) {
        this.errorCode = errorCode;
    }


    /**
     * Gets the errorDesc value for this ClaimPayResultInfo.
     * 
     * @return errorDesc
     */
    public java.lang.String getErrorDesc() {
        return errorDesc;
    }


    /**
     * Sets the errorDesc value for this ClaimPayResultInfo.
     * 
     * @param errorDesc
     */
    public void setErrorDesc(java.lang.String errorDesc) {
        this.errorDesc = errorDesc;
    }


    /**
     * Gets the responseCode value for this ClaimPayResultInfo.
     * 
     * @return responseCode
     */
    public java.lang.String getResponseCode() {
        return responseCode;
    }


    /**
     * Sets the responseCode value for this ClaimPayResultInfo.
     * 
     * @param responseCode
     */
    public void setResponseCode(java.lang.String responseCode) {
        this.responseCode = responseCode;
    }


    /**
     * Gets the serialNo value for this ClaimPayResultInfo.
     * 
     * @return serialNo
     */
    public java.lang.Integer getSerialNo() {
        return serialNo;
    }


    /**
     * Sets the serialNo value for this ClaimPayResultInfo.
     * 
     * @param serialNo
     */
    public void setSerialNo(java.lang.Integer serialNo) {
        this.serialNo = serialNo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ClaimPayResultInfo)) return false;
        ClaimPayResultInfo other = (ClaimPayResultInfo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.caseNumber==null && other.getCaseNumber()==null) || 
             (this.caseNumber!=null &&
              this.caseNumber.equals(other.getCaseNumber()))) &&
            ((this.errorCode==null && other.getErrorCode()==null) || 
             (this.errorCode!=null &&
              this.errorCode.equals(other.getErrorCode()))) &&
            ((this.errorDesc==null && other.getErrorDesc()==null) || 
             (this.errorDesc!=null &&
              this.errorDesc.equals(other.getErrorDesc()))) &&
            ((this.responseCode==null && other.getResponseCode()==null) || 
             (this.responseCode!=null &&
              this.responseCode.equals(other.getResponseCode()))) &&
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
        if (getCaseNumber() != null) {
            _hashCode += getCaseNumber().hashCode();
        }
        if (getErrorCode() != null) {
            _hashCode += getErrorCode().hashCode();
        }
        if (getErrorDesc() != null) {
            _hashCode += getErrorDesc().hashCode();
        }
        if (getResponseCode() != null) {
            _hashCode += getResponseCode().hashCode();
        }
        if (getSerialNo() != null) {
            _hashCode += getSerialNo().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ClaimPayResultInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "claimPayResultInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("caseNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("", "caseNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("errorCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "errorCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("errorDesc");
        elemField.setXmlName(new javax.xml.namespace.QName("", "errorDesc"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("responseCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "responseCode"));
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
