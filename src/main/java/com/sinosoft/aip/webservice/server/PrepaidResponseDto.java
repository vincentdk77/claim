/**
 * PrepaidResponseDto.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.sinosoft.aip.webservice.server;

public class PrepaidResponseDto  extends com.sinosoft.aip.webservice.server.CommonResponseDto  implements java.io.Serializable {
    private com.sinosoft.aip.webservice.server.PrepaidResultInfo[] prepaidResultInfoList;

    public PrepaidResponseDto() {
    }

    public PrepaidResponseDto(
           java.lang.String batchNo,
           java.lang.String errorCode,
           java.lang.String errorDesc,
           java.lang.String responseCode,
           com.sinosoft.aip.webservice.server.PrepaidResultInfo[] prepaidResultInfoList) {
        super(
            batchNo,
            errorCode,
            errorDesc,
            responseCode);
        this.prepaidResultInfoList = prepaidResultInfoList;
    }


    /**
     * Gets the prepaidResultInfoList value for this PrepaidResponseDto.
     * 
     * @return prepaidResultInfoList
     */
    public com.sinosoft.aip.webservice.server.PrepaidResultInfo[] getPrepaidResultInfoList() {
        return prepaidResultInfoList;
    }


    /**
     * Sets the prepaidResultInfoList value for this PrepaidResponseDto.
     * 
     * @param prepaidResultInfoList
     */
    public void setPrepaidResultInfoList(com.sinosoft.aip.webservice.server.PrepaidResultInfo[] prepaidResultInfoList) {
        this.prepaidResultInfoList = prepaidResultInfoList;
    }

    public com.sinosoft.aip.webservice.server.PrepaidResultInfo getPrepaidResultInfoList(int i) {
        return this.prepaidResultInfoList[i];
    }

    public void setPrepaidResultInfoList(int i, com.sinosoft.aip.webservice.server.PrepaidResultInfo _value) {
        this.prepaidResultInfoList[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PrepaidResponseDto)) return false;
        PrepaidResponseDto other = (PrepaidResponseDto) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.prepaidResultInfoList==null && other.getPrepaidResultInfoList()==null) || 
             (this.prepaidResultInfoList!=null &&
              java.util.Arrays.equals(this.prepaidResultInfoList, other.getPrepaidResultInfoList())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = super.hashCode();
        if (getPrepaidResultInfoList() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPrepaidResultInfoList());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPrepaidResultInfoList(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PrepaidResponseDto.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "prepaidResponseDto"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("prepaidResultInfoList");
        elemField.setXmlName(new javax.xml.namespace.QName("", "prepaidResultInfoList"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "prepaidResultInfo"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
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
