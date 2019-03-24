/**
 * EndorsementResultInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.sinosoft.aip.webservice.server;

public class EndorsementResultInfo  implements java.io.Serializable {
    private java.lang.String endorsementNumber;

    private java.lang.String endorsementSequenceNo;

    private java.lang.String errorCode;

    private java.lang.String errorDesc;

    private java.lang.String responseCode;

    public EndorsementResultInfo() {
    }

    public EndorsementResultInfo(
           java.lang.String endorsementNumber,
           java.lang.String endorsementSequenceNo,
           java.lang.String errorCode,
           java.lang.String errorDesc,
           java.lang.String responseCode) {
           this.endorsementNumber = endorsementNumber;
           this.endorsementSequenceNo = endorsementSequenceNo;
           this.errorCode = errorCode;
           this.errorDesc = errorDesc;
           this.responseCode = responseCode;
    }


    /**
     * Gets the endorsementNumber value for this EndorsementResultInfo.
     * 
     * @return endorsementNumber
     */
    public java.lang.String getEndorsementNumber() {
        return endorsementNumber;
    }


    /**
     * Sets the endorsementNumber value for this EndorsementResultInfo.
     * 
     * @param endorsementNumber
     */
    public void setEndorsementNumber(java.lang.String endorsementNumber) {
        this.endorsementNumber = endorsementNumber;
    }


    /**
     * Gets the endorsementSequenceNo value for this EndorsementResultInfo.
     * 
     * @return endorsementSequenceNo
     */
    public java.lang.String getEndorsementSequenceNo() {
        return endorsementSequenceNo;
    }


    /**
     * Sets the endorsementSequenceNo value for this EndorsementResultInfo.
     * 
     * @param endorsementSequenceNo
     */
    public void setEndorsementSequenceNo(java.lang.String endorsementSequenceNo) {
        this.endorsementSequenceNo = endorsementSequenceNo;
    }


    /**
     * Gets the errorCode value for this EndorsementResultInfo.
     * 
     * @return errorCode
     */
    public java.lang.String getErrorCode() {
        return errorCode;
    }


    /**
     * Sets the errorCode value for this EndorsementResultInfo.
     * 
     * @param errorCode
     */
    public void setErrorCode(java.lang.String errorCode) {
        this.errorCode = errorCode;
    }


    /**
     * Gets the errorDesc value for this EndorsementResultInfo.
     * 
     * @return errorDesc
     */
    public java.lang.String getErrorDesc() {
        return errorDesc;
    }


    /**
     * Sets the errorDesc value for this EndorsementResultInfo.
     * 
     * @param errorDesc
     */
    public void setErrorDesc(java.lang.String errorDesc) {
        this.errorDesc = errorDesc;
    }


    /**
     * Gets the responseCode value for this EndorsementResultInfo.
     * 
     * @return responseCode
     */
    public java.lang.String getResponseCode() {
        return responseCode;
    }


    /**
     * Sets the responseCode value for this EndorsementResultInfo.
     * 
     * @param responseCode
     */
    public void setResponseCode(java.lang.String responseCode) {
        this.responseCode = responseCode;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof EndorsementResultInfo)) return false;
        EndorsementResultInfo other = (EndorsementResultInfo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.endorsementNumber==null && other.getEndorsementNumber()==null) || 
             (this.endorsementNumber!=null &&
              this.endorsementNumber.equals(other.getEndorsementNumber()))) &&
            ((this.endorsementSequenceNo==null && other.getEndorsementSequenceNo()==null) || 
             (this.endorsementSequenceNo!=null &&
              this.endorsementSequenceNo.equals(other.getEndorsementSequenceNo()))) &&
            ((this.errorCode==null && other.getErrorCode()==null) || 
             (this.errorCode!=null &&
              this.errorCode.equals(other.getErrorCode()))) &&
            ((this.errorDesc==null && other.getErrorDesc()==null) || 
             (this.errorDesc!=null &&
              this.errorDesc.equals(other.getErrorDesc()))) &&
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
        if (getEndorsementNumber() != null) {
            _hashCode += getEndorsementNumber().hashCode();
        }
        if (getEndorsementSequenceNo() != null) {
            _hashCode += getEndorsementSequenceNo().hashCode();
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
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(EndorsementResultInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "endorsementResultInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("endorsementNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("", "endorsementNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("endorsementSequenceNo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "endorsementSequenceNo"));
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
