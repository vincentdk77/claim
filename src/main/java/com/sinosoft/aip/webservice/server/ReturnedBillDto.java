/**
 * ReturnedBillDto.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.sinosoft.aip.webservice.server;

public class ReturnedBillDto  implements java.io.Serializable {
    private com.sinosoft.aip.webservice.server.ReturnedBillDetailInfo[] returnedBillDetailInfoList;

    private com.sinosoft.aip.webservice.server.ReturnedBillMainInfo returnedBillMainInfo;

    public ReturnedBillDto() {
    }

    public ReturnedBillDto(
           com.sinosoft.aip.webservice.server.ReturnedBillDetailInfo[] returnedBillDetailInfoList,
           com.sinosoft.aip.webservice.server.ReturnedBillMainInfo returnedBillMainInfo) {
           this.returnedBillDetailInfoList = returnedBillDetailInfoList;
           this.returnedBillMainInfo = returnedBillMainInfo;
    }


    /**
     * Gets the returnedBillDetailInfoList value for this ReturnedBillDto.
     * 
     * @return returnedBillDetailInfoList
     */
    public com.sinosoft.aip.webservice.server.ReturnedBillDetailInfo[] getReturnedBillDetailInfoList() {
        return returnedBillDetailInfoList;
    }


    /**
     * Sets the returnedBillDetailInfoList value for this ReturnedBillDto.
     * 
     * @param returnedBillDetailInfoList
     */
    public void setReturnedBillDetailInfoList(com.sinosoft.aip.webservice.server.ReturnedBillDetailInfo[] returnedBillDetailInfoList) {
        this.returnedBillDetailInfoList = returnedBillDetailInfoList;
    }

    public com.sinosoft.aip.webservice.server.ReturnedBillDetailInfo getReturnedBillDetailInfoList(int i) {
        return this.returnedBillDetailInfoList[i];
    }

    public void setReturnedBillDetailInfoList(int i, com.sinosoft.aip.webservice.server.ReturnedBillDetailInfo _value) {
        this.returnedBillDetailInfoList[i] = _value;
    }


    /**
     * Gets the returnedBillMainInfo value for this ReturnedBillDto.
     * 
     * @return returnedBillMainInfo
     */
    public com.sinosoft.aip.webservice.server.ReturnedBillMainInfo getReturnedBillMainInfo() {
        return returnedBillMainInfo;
    }


    /**
     * Sets the returnedBillMainInfo value for this ReturnedBillDto.
     * 
     * @param returnedBillMainInfo
     */
    public void setReturnedBillMainInfo(com.sinosoft.aip.webservice.server.ReturnedBillMainInfo returnedBillMainInfo) {
        this.returnedBillMainInfo = returnedBillMainInfo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ReturnedBillDto)) return false;
        ReturnedBillDto other = (ReturnedBillDto) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.returnedBillDetailInfoList==null && other.getReturnedBillDetailInfoList()==null) || 
             (this.returnedBillDetailInfoList!=null &&
              java.util.Arrays.equals(this.returnedBillDetailInfoList, other.getReturnedBillDetailInfoList()))) &&
            ((this.returnedBillMainInfo==null && other.getReturnedBillMainInfo()==null) || 
             (this.returnedBillMainInfo!=null &&
              this.returnedBillMainInfo.equals(other.getReturnedBillMainInfo())));
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
        if (getReturnedBillDetailInfoList() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getReturnedBillDetailInfoList());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getReturnedBillDetailInfoList(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getReturnedBillMainInfo() != null) {
            _hashCode += getReturnedBillMainInfo().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ReturnedBillDto.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "returnedBillDto"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("returnedBillDetailInfoList");
        elemField.setXmlName(new javax.xml.namespace.QName("", "returnedBillDetailInfoList"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "returnedBillDetailInfo"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("returnedBillMainInfo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "returnedBillMainInfo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "returnedBillMainInfo"));
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
