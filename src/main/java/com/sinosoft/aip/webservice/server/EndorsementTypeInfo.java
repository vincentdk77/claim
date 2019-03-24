/**
 * EndorsementTypeInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.sinosoft.aip.webservice.server;

public class EndorsementTypeInfo  implements java.io.Serializable {
    private java.lang.String endorsementNumber;

    private java.lang.String endorsementType;

    public EndorsementTypeInfo() {
    }

    public EndorsementTypeInfo(
           java.lang.String endorsementNumber,
           java.lang.String endorsementType) {
           this.endorsementNumber = endorsementNumber;
           this.endorsementType = endorsementType;
    }


    /**
     * Gets the endorsementNumber value for this EndorsementTypeInfo.
     * 
     * @return endorsementNumber
     */
    public java.lang.String getEndorsementNumber() {
        return endorsementNumber;
    }


    /**
     * Sets the endorsementNumber value for this EndorsementTypeInfo.
     * 
     * @param endorsementNumber
     */
    public void setEndorsementNumber(java.lang.String endorsementNumber) {
        this.endorsementNumber = endorsementNumber;
    }


    /**
     * Gets the endorsementType value for this EndorsementTypeInfo.
     * 
     * @return endorsementType
     */
    public java.lang.String getEndorsementType() {
        return endorsementType;
    }


    /**
     * Sets the endorsementType value for this EndorsementTypeInfo.
     * 
     * @param endorsementType
     */
    public void setEndorsementType(java.lang.String endorsementType) {
        this.endorsementType = endorsementType;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof EndorsementTypeInfo)) return false;
        EndorsementTypeInfo other = (EndorsementTypeInfo) obj;
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
            ((this.endorsementType==null && other.getEndorsementType()==null) || 
             (this.endorsementType!=null &&
              this.endorsementType.equals(other.getEndorsementType())));
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
        if (getEndorsementType() != null) {
            _hashCode += getEndorsementType().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(EndorsementTypeInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "endorsementTypeInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("endorsementNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("", "endorsementNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("endorsementType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "endorsementType"));
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
