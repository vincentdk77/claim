/**
 * PolicyResponseDto.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.sinosoft.aip.webservice.server;

public class PolicyResponseDto  extends com.sinosoft.aip.webservice.server.CommonResponseDto  implements java.io.Serializable {
    private com.sinosoft.aip.webservice.server.PolicyResultInfo[] policyResultInfoList;

    public PolicyResponseDto() {
    }

    public PolicyResponseDto(
           java.lang.String batchNo,
           java.lang.String errorCode,
           java.lang.String errorDesc,
           java.lang.String responseCode,
           com.sinosoft.aip.webservice.server.PolicyResultInfo[] policyResultInfoList) {
        super(
            batchNo,
            errorCode,
            errorDesc,
            responseCode);
        this.policyResultInfoList = policyResultInfoList;
    }


    /**
     * Gets the policyResultInfoList value for this PolicyResponseDto.
     * 
     * @return policyResultInfoList
     */
    public com.sinosoft.aip.webservice.server.PolicyResultInfo[] getPolicyResultInfoList() {
        return policyResultInfoList;
    }


    /**
     * Sets the policyResultInfoList value for this PolicyResponseDto.
     * 
     * @param policyResultInfoList
     */
    public void setPolicyResultInfoList(com.sinosoft.aip.webservice.server.PolicyResultInfo[] policyResultInfoList) {
        this.policyResultInfoList = policyResultInfoList;
    }

    public com.sinosoft.aip.webservice.server.PolicyResultInfo getPolicyResultInfoList(int i) {
        return this.policyResultInfoList[i];
    }

    public void setPolicyResultInfoList(int i, com.sinosoft.aip.webservice.server.PolicyResultInfo _value) {
        this.policyResultInfoList[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PolicyResponseDto)) return false;
        PolicyResponseDto other = (PolicyResponseDto) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.policyResultInfoList==null && other.getPolicyResultInfoList()==null) || 
             (this.policyResultInfoList!=null &&
              java.util.Arrays.equals(this.policyResultInfoList, other.getPolicyResultInfoList())));
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
        if (getPolicyResultInfoList() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPolicyResultInfoList());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPolicyResultInfoList(), i);
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
        new org.apache.axis.description.TypeDesc(PolicyResponseDto.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "policyResponseDto"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("policyResultInfoList");
        elemField.setXmlName(new javax.xml.namespace.QName("", "policyResultInfoList"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "policyResultInfo"));
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
