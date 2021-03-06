/**
 * CaseResponseDto.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.sinosoft.aip.webservice.server;

public class CaseResponseDto  extends com.sinosoft.aip.webservice.server.CommonResponseDto  implements java.io.Serializable {
    private com.sinosoft.aip.webservice.server.CaseResultInfo[] caseResultInfoList;

    public CaseResponseDto() {
    }

    public CaseResponseDto(
           java.lang.String batchNo,
           java.lang.String errorCode,
           java.lang.String errorDesc,
           java.lang.String responseCode,
           com.sinosoft.aip.webservice.server.CaseResultInfo[] caseResultInfoList) {
        super(
            batchNo,
            errorCode,
            errorDesc,
            responseCode);
        this.caseResultInfoList = caseResultInfoList;
    }


    /**
     * Gets the caseResultInfoList value for this CaseResponseDto.
     * 
     * @return caseResultInfoList
     */
    public com.sinosoft.aip.webservice.server.CaseResultInfo[] getCaseResultInfoList() {
        return caseResultInfoList;
    }


    /**
     * Sets the caseResultInfoList value for this CaseResponseDto.
     * 
     * @param caseResultInfoList
     */
    public void setCaseResultInfoList(com.sinosoft.aip.webservice.server.CaseResultInfo[] caseResultInfoList) {
        this.caseResultInfoList = caseResultInfoList;
    }

    public com.sinosoft.aip.webservice.server.CaseResultInfo getCaseResultInfoList(int i) {
        return this.caseResultInfoList[i];
    }

    public void setCaseResultInfoList(int i, com.sinosoft.aip.webservice.server.CaseResultInfo _value) {
        this.caseResultInfoList[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CaseResponseDto)) return false;
        CaseResponseDto other = (CaseResponseDto) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.caseResultInfoList==null && other.getCaseResultInfoList()==null) || 
             (this.caseResultInfoList!=null &&
              java.util.Arrays.equals(this.caseResultInfoList, other.getCaseResultInfoList())));
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
        if (getCaseResultInfoList() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getCaseResultInfoList());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getCaseResultInfoList(), i);
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
        new org.apache.axis.description.TypeDesc(CaseResponseDto.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "caseResponseDto"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("caseResultInfoList");
        elemField.setXmlName(new javax.xml.namespace.QName("", "caseResultInfoList"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "caseResultInfo"));
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
