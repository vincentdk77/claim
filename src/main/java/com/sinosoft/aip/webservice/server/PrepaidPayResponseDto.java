/**
 * PrepaidPayResponseDto.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.sinosoft.aip.webservice.server;

public class PrepaidPayResponseDto  extends com.sinosoft.aip.webservice.server.CommonResponseDto  implements java.io.Serializable {
    private com.sinosoft.aip.webservice.server.PrepaidPayResultInfo[] prepaidPayResultInfoList;

    public PrepaidPayResponseDto() {
    }

    public PrepaidPayResponseDto(
           java.lang.String batchNo,
           java.lang.String errorCode,
           java.lang.String errorDesc,
           java.lang.String responseCode,
           com.sinosoft.aip.webservice.server.PrepaidPayResultInfo[] prepaidPayResultInfoList) {
        super(
            batchNo,
            errorCode,
            errorDesc,
            responseCode);
        this.prepaidPayResultInfoList = prepaidPayResultInfoList;
    }


    /**
     * Gets the prepaidPayResultInfoList value for this PrepaidPayResponseDto.
     * 
     * @return prepaidPayResultInfoList
     */
    public com.sinosoft.aip.webservice.server.PrepaidPayResultInfo[] getPrepaidPayResultInfoList() {
        return prepaidPayResultInfoList;
    }


    /**
     * Sets the prepaidPayResultInfoList value for this PrepaidPayResponseDto.
     * 
     * @param prepaidPayResultInfoList
     */
    public void setPrepaidPayResultInfoList(com.sinosoft.aip.webservice.server.PrepaidPayResultInfo[] prepaidPayResultInfoList) {
        this.prepaidPayResultInfoList = prepaidPayResultInfoList;
    }

    public com.sinosoft.aip.webservice.server.PrepaidPayResultInfo getPrepaidPayResultInfoList(int i) {
        return this.prepaidPayResultInfoList[i];
    }

    public void setPrepaidPayResultInfoList(int i, com.sinosoft.aip.webservice.server.PrepaidPayResultInfo _value) {
        this.prepaidPayResultInfoList[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PrepaidPayResponseDto)) return false;
        PrepaidPayResponseDto other = (PrepaidPayResponseDto) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.prepaidPayResultInfoList==null && other.getPrepaidPayResultInfoList()==null) || 
             (this.prepaidPayResultInfoList!=null &&
              java.util.Arrays.equals(this.prepaidPayResultInfoList, other.getPrepaidPayResultInfoList())));
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
        if (getPrepaidPayResultInfoList() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPrepaidPayResultInfoList());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPrepaidPayResultInfoList(), i);
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
        new org.apache.axis.description.TypeDesc(PrepaidPayResponseDto.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "prepaidPayResponseDto"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("prepaidPayResultInfoList");
        elemField.setXmlName(new javax.xml.namespace.QName("", "prepaidPayResultInfoList"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "prepaidPayResultInfo"));
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
