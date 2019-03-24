/**
 * CancelResponseDto.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.sinosoft.aip.webservice.server;

public class CancelResponseDto  extends com.sinosoft.aip.webservice.server.CommonResponseDto  implements java.io.Serializable {
    private com.sinosoft.aip.webservice.server.CancelResultInfo[] cancelResultInfoList;

    public CancelResponseDto() {
    }

    public CancelResponseDto(
           java.lang.String batchNo,
           java.lang.String errorCode,
           java.lang.String errorDesc,
           java.lang.String responseCode,
           com.sinosoft.aip.webservice.server.CancelResultInfo[] cancelResultInfoList) {
        super(
            batchNo,
            errorCode,
            errorDesc,
            responseCode);
        this.cancelResultInfoList = cancelResultInfoList;
    }


    /**
     * Gets the cancelResultInfoList value for this CancelResponseDto.
     * 
     * @return cancelResultInfoList
     */
    public com.sinosoft.aip.webservice.server.CancelResultInfo[] getCancelResultInfoList() {
        return cancelResultInfoList;
    }


    /**
     * Sets the cancelResultInfoList value for this CancelResponseDto.
     * 
     * @param cancelResultInfoList
     */
    public void setCancelResultInfoList(com.sinosoft.aip.webservice.server.CancelResultInfo[] cancelResultInfoList) {
        this.cancelResultInfoList = cancelResultInfoList;
    }

    public com.sinosoft.aip.webservice.server.CancelResultInfo getCancelResultInfoList(int i) {
        return this.cancelResultInfoList[i];
    }

    public void setCancelResultInfoList(int i, com.sinosoft.aip.webservice.server.CancelResultInfo _value) {
        this.cancelResultInfoList[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CancelResponseDto)) return false;
        CancelResponseDto other = (CancelResponseDto) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.cancelResultInfoList==null && other.getCancelResultInfoList()==null) || 
             (this.cancelResultInfoList!=null &&
              java.util.Arrays.equals(this.cancelResultInfoList, other.getCancelResultInfoList())));
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
        if (getCancelResultInfoList() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getCancelResultInfoList());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getCancelResultInfoList(), i);
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
        new org.apache.axis.description.TypeDesc(CancelResponseDto.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "cancelResponseDto"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cancelResultInfoList");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cancelResultInfoList"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "cancelResultInfo"));
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
