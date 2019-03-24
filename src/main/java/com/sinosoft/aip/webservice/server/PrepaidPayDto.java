/**
 * PrepaidPayDto.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.sinosoft.aip.webservice.server;

public class PrepaidPayDto  implements java.io.Serializable {
    private com.sinosoft.aip.webservice.server.PrepaidPayMainInfo prepaidPayMainInfo;

    public PrepaidPayDto() {
    }

    public PrepaidPayDto(
           com.sinosoft.aip.webservice.server.PrepaidPayMainInfo prepaidPayMainInfo) {
           this.prepaidPayMainInfo = prepaidPayMainInfo;
    }


    /**
     * Gets the prepaidPayMainInfo value for this PrepaidPayDto.
     * 
     * @return prepaidPayMainInfo
     */
    public com.sinosoft.aip.webservice.server.PrepaidPayMainInfo getPrepaidPayMainInfo() {
        return prepaidPayMainInfo;
    }


    /**
     * Sets the prepaidPayMainInfo value for this PrepaidPayDto.
     * 
     * @param prepaidPayMainInfo
     */
    public void setPrepaidPayMainInfo(com.sinosoft.aip.webservice.server.PrepaidPayMainInfo prepaidPayMainInfo) {
        this.prepaidPayMainInfo = prepaidPayMainInfo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PrepaidPayDto)) return false;
        PrepaidPayDto other = (PrepaidPayDto) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.prepaidPayMainInfo==null && other.getPrepaidPayMainInfo()==null) || 
             (this.prepaidPayMainInfo!=null &&
              this.prepaidPayMainInfo.equals(other.getPrepaidPayMainInfo())));
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
        if (getPrepaidPayMainInfo() != null) {
            _hashCode += getPrepaidPayMainInfo().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PrepaidPayDto.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "prepaidPayDto"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("prepaidPayMainInfo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "prepaidPayMainInfo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "prepaidPayMainInfo"));
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
