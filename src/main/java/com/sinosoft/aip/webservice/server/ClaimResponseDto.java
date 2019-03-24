/**
 * ClaimResponseDto.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.sinosoft.aip.webservice.server;

public class ClaimResponseDto  extends com.sinosoft.aip.webservice.server.CommonResponseDto  implements java.io.Serializable {
    private com.sinosoft.aip.webservice.server.ClaimResponseMainInfo[] claimResponseMainInfoList;

    public ClaimResponseDto() {
    }

    public ClaimResponseDto(
           java.lang.String batchNo,
           java.lang.String errorCode,
           java.lang.String errorDesc,
           java.lang.String responseCode,
           com.sinosoft.aip.webservice.server.ClaimResponseMainInfo[] claimResponseMainInfoList) {
        super(
            batchNo,
            errorCode,
            errorDesc,
            responseCode);
        this.claimResponseMainInfoList = claimResponseMainInfoList;
    }


    /**
     * Gets the claimResponseMainInfoList value for this ClaimResponseDto.
     * 
     * @return claimResponseMainInfoList
     */
    public com.sinosoft.aip.webservice.server.ClaimResponseMainInfo[] getClaimResponseMainInfoList() {
        return claimResponseMainInfoList;
    }


    /**
     * Sets the claimResponseMainInfoList value for this ClaimResponseDto.
     * 
     * @param claimResponseMainInfoList
     */
    public void setClaimResponseMainInfoList(com.sinosoft.aip.webservice.server.ClaimResponseMainInfo[] claimResponseMainInfoList) {
        this.claimResponseMainInfoList = claimResponseMainInfoList;
    }

    public com.sinosoft.aip.webservice.server.ClaimResponseMainInfo getClaimResponseMainInfoList(int i) {
        return this.claimResponseMainInfoList[i];
    }

    public void setClaimResponseMainInfoList(int i, com.sinosoft.aip.webservice.server.ClaimResponseMainInfo _value) {
        this.claimResponseMainInfoList[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ClaimResponseDto)) return false;
        ClaimResponseDto other = (ClaimResponseDto) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.claimResponseMainInfoList==null && other.getClaimResponseMainInfoList()==null) || 
             (this.claimResponseMainInfoList!=null &&
              java.util.Arrays.equals(this.claimResponseMainInfoList, other.getClaimResponseMainInfoList())));
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
        if (getClaimResponseMainInfoList() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getClaimResponseMainInfoList());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getClaimResponseMainInfoList(), i);
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
        new org.apache.axis.description.TypeDesc(ClaimResponseDto.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "claimResponseDto"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("claimResponseMainInfoList");
        elemField.setXmlName(new javax.xml.namespace.QName("", "claimResponseMainInfoList"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "claimResponseMainInfo"));
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
