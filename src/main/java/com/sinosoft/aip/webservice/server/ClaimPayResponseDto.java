/**
 * ClaimPayResponseDto.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.sinosoft.aip.webservice.server;

public class ClaimPayResponseDto  extends com.sinosoft.aip.webservice.server.CommonResponseDto  implements java.io.Serializable {
    private com.sinosoft.aip.webservice.server.ClaimPayResultInfo[] claimPayResultInfoList;

    public ClaimPayResponseDto() {
    }

    public ClaimPayResponseDto(
           java.lang.String batchNo,
           java.lang.String errorCode,
           java.lang.String errorDesc,
           java.lang.String responseCode,
           com.sinosoft.aip.webservice.server.ClaimPayResultInfo[] claimPayResultInfoList) {
        super(
            batchNo,
            errorCode,
            errorDesc,
            responseCode);
        this.claimPayResultInfoList = claimPayResultInfoList;
    }


    /**
     * Gets the claimPayResultInfoList value for this ClaimPayResponseDto.
     * 
     * @return claimPayResultInfoList
     */
    public com.sinosoft.aip.webservice.server.ClaimPayResultInfo[] getClaimPayResultInfoList() {
        return claimPayResultInfoList;
    }


    /**
     * Sets the claimPayResultInfoList value for this ClaimPayResponseDto.
     * 
     * @param claimPayResultInfoList
     */
    public void setClaimPayResultInfoList(com.sinosoft.aip.webservice.server.ClaimPayResultInfo[] claimPayResultInfoList) {
        this.claimPayResultInfoList = claimPayResultInfoList;
    }

    public com.sinosoft.aip.webservice.server.ClaimPayResultInfo getClaimPayResultInfoList(int i) {
        return this.claimPayResultInfoList[i];
    }

    public void setClaimPayResultInfoList(int i, com.sinosoft.aip.webservice.server.ClaimPayResultInfo _value) {
        this.claimPayResultInfoList[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ClaimPayResponseDto)) return false;
        ClaimPayResponseDto other = (ClaimPayResponseDto) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.claimPayResultInfoList==null && other.getClaimPayResultInfoList()==null) || 
             (this.claimPayResultInfoList!=null &&
              java.util.Arrays.equals(this.claimPayResultInfoList, other.getClaimPayResultInfoList())));
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
        if (getClaimPayResultInfoList() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getClaimPayResultInfoList());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getClaimPayResultInfoList(), i);
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
        new org.apache.axis.description.TypeDesc(ClaimPayResponseDto.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "claimPayResponseDto"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("claimPayResultInfoList");
        elemField.setXmlName(new javax.xml.namespace.QName("", "claimPayResultInfoList"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "claimPayResultInfo"));
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
