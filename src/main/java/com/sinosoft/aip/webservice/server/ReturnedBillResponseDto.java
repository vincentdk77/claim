/**
 * ReturnedBillResponseDto.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.sinosoft.aip.webservice.server;

public class ReturnedBillResponseDto  extends com.sinosoft.aip.webservice.server.CommonResponseDto  implements java.io.Serializable {
    private com.sinosoft.aip.webservice.server.ReturnedBillResultInfo[] returnedBillResultInfoList;

    public ReturnedBillResponseDto() {
    }

    public ReturnedBillResponseDto(
           java.lang.String batchNo,
           java.lang.String errorCode,
           java.lang.String errorDesc,
           java.lang.String responseCode,
           com.sinosoft.aip.webservice.server.ReturnedBillResultInfo[] returnedBillResultInfoList) {
        super(
            batchNo,
            errorCode,
            errorDesc,
            responseCode);
        this.returnedBillResultInfoList = returnedBillResultInfoList;
    }


    /**
     * Gets the returnedBillResultInfoList value for this ReturnedBillResponseDto.
     * 
     * @return returnedBillResultInfoList
     */
    public com.sinosoft.aip.webservice.server.ReturnedBillResultInfo[] getReturnedBillResultInfoList() {
        return returnedBillResultInfoList;
    }


    /**
     * Sets the returnedBillResultInfoList value for this ReturnedBillResponseDto.
     * 
     * @param returnedBillResultInfoList
     */
    public void setReturnedBillResultInfoList(com.sinosoft.aip.webservice.server.ReturnedBillResultInfo[] returnedBillResultInfoList) {
        this.returnedBillResultInfoList = returnedBillResultInfoList;
    }

    public com.sinosoft.aip.webservice.server.ReturnedBillResultInfo getReturnedBillResultInfoList(int i) {
        return this.returnedBillResultInfoList[i];
    }

    public void setReturnedBillResultInfoList(int i, com.sinosoft.aip.webservice.server.ReturnedBillResultInfo _value) {
        this.returnedBillResultInfoList[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ReturnedBillResponseDto)) return false;
        ReturnedBillResponseDto other = (ReturnedBillResponseDto) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.returnedBillResultInfoList==null && other.getReturnedBillResultInfoList()==null) || 
             (this.returnedBillResultInfoList!=null &&
              java.util.Arrays.equals(this.returnedBillResultInfoList, other.getReturnedBillResultInfoList())));
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
        if (getReturnedBillResultInfoList() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getReturnedBillResultInfoList());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getReturnedBillResultInfoList(), i);
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
        new org.apache.axis.description.TypeDesc(ReturnedBillResponseDto.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "returnedBillResponseDto"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("returnedBillResultInfoList");
        elemField.setXmlName(new javax.xml.namespace.QName("", "returnedBillResultInfoList"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "returnedBillResultInfo"));
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
