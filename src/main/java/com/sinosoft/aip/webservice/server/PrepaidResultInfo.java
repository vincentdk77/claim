/**
 * PrepaidResultInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.sinosoft.aip.webservice.server;

public class PrepaidResultInfo  implements java.io.Serializable {
    private java.lang.String claimSequenceNo;

    private java.lang.String errorCode;

    private java.lang.String errorDesc;

    private java.lang.String prepayCaseNumber;

    private java.lang.String responseCode;

    public PrepaidResultInfo() {
    }

    public PrepaidResultInfo(
           java.lang.String claimSequenceNo,
           java.lang.String errorCode,
           java.lang.String errorDesc,
           java.lang.String prepayCaseNumber,
           java.lang.String responseCode) {
           this.claimSequenceNo = claimSequenceNo;
           this.errorCode = errorCode;
           this.errorDesc = errorDesc;
           this.prepayCaseNumber = prepayCaseNumber;
           this.responseCode = responseCode;
    }


    /**
     * Gets the claimSequenceNo value for this PrepaidResultInfo.
     * 
     * @return claimSequenceNo
     */
    public java.lang.String getClaimSequenceNo() {
        return claimSequenceNo;
    }


    /**
     * Sets the claimSequenceNo value for this PrepaidResultInfo.
     * 
     * @param claimSequenceNo
     */
    public void setClaimSequenceNo(java.lang.String claimSequenceNo) {
        this.claimSequenceNo = claimSequenceNo;
    }


    /**
     * Gets the errorCode value for this PrepaidResultInfo.
     * 
     * @return errorCode
     */
    public java.lang.String getErrorCode() {
        return errorCode;
    }


    /**
     * Sets the errorCode value for this PrepaidResultInfo.
     * 
     * @param errorCode
     */
    public void setErrorCode(java.lang.String errorCode) {
        this.errorCode = errorCode;
    }


    /**
     * Gets the errorDesc value for this PrepaidResultInfo.
     * 
     * @return errorDesc
     */
    public java.lang.String getErrorDesc() {
        return errorDesc;
    }


    /**
     * Sets the errorDesc value for this PrepaidResultInfo.
     * 
     * @param errorDesc
     */
    public void setErrorDesc(java.lang.String errorDesc) {
        this.errorDesc = errorDesc;
    }


    /**
     * Gets the prepayCaseNumber value for this PrepaidResultInfo.
     * 
     * @return prepayCaseNumber
     */
    public java.lang.String getPrepayCaseNumber() {
        return prepayCaseNumber;
    }


    /**
     * Sets the prepayCaseNumber value for this PrepaidResultInfo.
     * 
     * @param prepayCaseNumber
     */
    public void setPrepayCaseNumber(java.lang.String prepayCaseNumber) {
        this.prepayCaseNumber = prepayCaseNumber;
    }


    /**
     * Gets the responseCode value for this PrepaidResultInfo.
     * 
     * @return responseCode
     */
    public java.lang.String getResponseCode() {
        return responseCode;
    }


    /**
     * Sets the responseCode value for this PrepaidResultInfo.
     * 
     * @param responseCode
     */
    public void setResponseCode(java.lang.String responseCode) {
        this.responseCode = responseCode;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PrepaidResultInfo)) return false;
        PrepaidResultInfo other = (PrepaidResultInfo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.claimSequenceNo==null && other.getClaimSequenceNo()==null) || 
             (this.claimSequenceNo!=null &&
              this.claimSequenceNo.equals(other.getClaimSequenceNo()))) &&
            ((this.errorCode==null && other.getErrorCode()==null) || 
             (this.errorCode!=null &&
              this.errorCode.equals(other.getErrorCode()))) &&
            ((this.errorDesc==null && other.getErrorDesc()==null) || 
             (this.errorDesc!=null &&
              this.errorDesc.equals(other.getErrorDesc()))) &&
            ((this.prepayCaseNumber==null && other.getPrepayCaseNumber()==null) || 
             (this.prepayCaseNumber!=null &&
              this.prepayCaseNumber.equals(other.getPrepayCaseNumber()))) &&
            ((this.responseCode==null && other.getResponseCode()==null) || 
             (this.responseCode!=null &&
              this.responseCode.equals(other.getResponseCode())));
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
        if (getClaimSequenceNo() != null) {
            _hashCode += getClaimSequenceNo().hashCode();
        }
        if (getErrorCode() != null) {
            _hashCode += getErrorCode().hashCode();
        }
        if (getErrorDesc() != null) {
            _hashCode += getErrorDesc().hashCode();
        }
        if (getPrepayCaseNumber() != null) {
            _hashCode += getPrepayCaseNumber().hashCode();
        }
        if (getResponseCode() != null) {
            _hashCode += getResponseCode().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PrepaidResultInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "prepaidResultInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("claimSequenceNo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "claimSequenceNo"));
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
        elemField.setFieldName("prepayCaseNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("", "prepayCaseNumber"));
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
