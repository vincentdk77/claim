/**
 * CancelDto.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.sinosoft.aip.webservice.server;

public class CancelDto  implements java.io.Serializable {
    private com.sinosoft.aip.webservice.server.CancelMainInfo cancelMainInfo;

    public CancelDto() {
    }

    public CancelDto(
           com.sinosoft.aip.webservice.server.CancelMainInfo cancelMainInfo) {
           this.cancelMainInfo = cancelMainInfo;
    }


    /**
     * Gets the cancelMainInfo value for this CancelDto.
     * 
     * @return cancelMainInfo
     */
    public com.sinosoft.aip.webservice.server.CancelMainInfo getCancelMainInfo() {
        return cancelMainInfo;
    }


    /**
     * Sets the cancelMainInfo value for this CancelDto.
     * 
     * @param cancelMainInfo
     */
    public void setCancelMainInfo(com.sinosoft.aip.webservice.server.CancelMainInfo cancelMainInfo) {
        this.cancelMainInfo = cancelMainInfo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CancelDto)) return false;
        CancelDto other = (CancelDto) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cancelMainInfo==null && other.getCancelMainInfo()==null) || 
             (this.cancelMainInfo!=null &&
              this.cancelMainInfo.equals(other.getCancelMainInfo())));
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
        if (getCancelMainInfo() != null) {
            _hashCode += getCancelMainInfo().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CancelDto.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "cancelDto"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cancelMainInfo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cancelMainInfo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "cancelMainInfo"));
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
