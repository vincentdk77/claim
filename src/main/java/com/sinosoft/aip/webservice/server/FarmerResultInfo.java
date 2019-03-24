/**
 * FarmerResultInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.sinosoft.aip.webservice.server;

public class FarmerResultInfo  implements java.io.Serializable {
    private java.lang.String confirmSequenceNo;

    private java.lang.String errorCode;

    private java.lang.String errorDesc;

    private java.lang.String policyNumber;

    private java.lang.String responseCode;

    private java.lang.Long serialNo;

    public FarmerResultInfo() {
    }

    public FarmerResultInfo(
           java.lang.String confirmSequenceNo,
           java.lang.String errorCode,
           java.lang.String errorDesc,
           java.lang.String policyNumber,
           java.lang.String responseCode,
           java.lang.Long serialNo) {
           this.confirmSequenceNo = confirmSequenceNo;
           this.errorCode = errorCode;
           this.errorDesc = errorDesc;
           this.policyNumber = policyNumber;
           this.responseCode = responseCode;
           this.serialNo = serialNo;
    }


    /**
     * Gets the confirmSequenceNo value for this FarmerResultInfo.
     * 
     * @return confirmSequenceNo
     */
    public java.lang.String getConfirmSequenceNo() {
        return confirmSequenceNo;
    }


    /**
     * Sets the confirmSequenceNo value for this FarmerResultInfo.
     * 
     * @param confirmSequenceNo
     */
    public void setConfirmSequenceNo(java.lang.String confirmSequenceNo) {
        this.confirmSequenceNo = confirmSequenceNo;
    }


    /**
     * Gets the errorCode value for this FarmerResultInfo.
     * 
     * @return errorCode
     */
    public java.lang.String getErrorCode() {
        return errorCode;
    }


    /**
     * Sets the errorCode value for this FarmerResultInfo.
     * 
     * @param errorCode
     */
    public void setErrorCode(java.lang.String errorCode) {
        this.errorCode = errorCode;
    }


    /**
     * Gets the errorDesc value for this FarmerResultInfo.
     * 
     * @return errorDesc
     */
    public java.lang.String getErrorDesc() {
        return errorDesc;
    }


    /**
     * Sets the errorDesc value for this FarmerResultInfo.
     * 
     * @param errorDesc
     */
    public void setErrorDesc(java.lang.String errorDesc) {
        this.errorDesc = errorDesc;
    }


    /**
     * Gets the policyNumber value for this FarmerResultInfo.
     * 
     * @return policyNumber
     */
    public java.lang.String getPolicyNumber() {
        return policyNumber;
    }


    /**
     * Sets the policyNumber value for this FarmerResultInfo.
     * 
     * @param policyNumber
     */
    public void setPolicyNumber(java.lang.String policyNumber) {
        this.policyNumber = policyNumber;
    }


    /**
     * Gets the responseCode value for this FarmerResultInfo.
     * 
     * @return responseCode
     */
    public java.lang.String getResponseCode() {
        return responseCode;
    }


    /**
     * Sets the responseCode value for this FarmerResultInfo.
     * 
     * @param responseCode
     */
    public void setResponseCode(java.lang.String responseCode) {
        this.responseCode = responseCode;
    }


    /**
     * Gets the serialNo value for this FarmerResultInfo.
     * 
     * @return serialNo
     */
    public java.lang.Long getSerialNo() {
        return serialNo;
    }


    /**
     * Sets the serialNo value for this FarmerResultInfo.
     * 
     * @param serialNo
     */
    public void setSerialNo(java.lang.Long serialNo) {
        this.serialNo = serialNo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof FarmerResultInfo)) return false;
        FarmerResultInfo other = (FarmerResultInfo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.confirmSequenceNo==null && other.getConfirmSequenceNo()==null) || 
             (this.confirmSequenceNo!=null &&
              this.confirmSequenceNo.equals(other.getConfirmSequenceNo()))) &&
            ((this.errorCode==null && other.getErrorCode()==null) || 
             (this.errorCode!=null &&
              this.errorCode.equals(other.getErrorCode()))) &&
            ((this.errorDesc==null && other.getErrorDesc()==null) || 
             (this.errorDesc!=null &&
              this.errorDesc.equals(other.getErrorDesc()))) &&
            ((this.policyNumber==null && other.getPolicyNumber()==null) || 
             (this.policyNumber!=null &&
              this.policyNumber.equals(other.getPolicyNumber()))) &&
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
        if (getConfirmSequenceNo() != null) {
            _hashCode += getConfirmSequenceNo().hashCode();
        }
        if (getErrorCode() != null) {
            _hashCode += getErrorCode().hashCode();
        }
        if (getErrorDesc() != null) {
            _hashCode += getErrorDesc().hashCode();
        }
        if (getPolicyNumber() != null) {
            _hashCode += getPolicyNumber().hashCode();
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
        new org.apache.axis.description.TypeDesc(FarmerResultInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "farmerResultInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("confirmSequenceNo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "confirmSequenceNo"));
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
        elemField.setFieldName("policyNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("", "policyNumber"));
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
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
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
