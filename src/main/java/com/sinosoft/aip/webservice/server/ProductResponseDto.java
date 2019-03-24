/**
 * ProductResponseDto.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.sinosoft.aip.webservice.server;

public class ProductResponseDto  extends com.sinosoft.aip.webservice.server.CommonResponseDto  implements java.io.Serializable {
    private com.sinosoft.aip.webservice.server.ProductResultInfo[] productResultInfoList;

    public ProductResponseDto() {
    }

    public ProductResponseDto(
           java.lang.String batchNo,
           java.lang.String errorCode,
           java.lang.String errorDesc,
           java.lang.String responseCode,
           com.sinosoft.aip.webservice.server.ProductResultInfo[] productResultInfoList) {
        super(
            batchNo,
            errorCode,
            errorDesc,
            responseCode);
        this.productResultInfoList = productResultInfoList;
    }


    /**
     * Gets the productResultInfoList value for this ProductResponseDto.
     * 
     * @return productResultInfoList
     */
    public com.sinosoft.aip.webservice.server.ProductResultInfo[] getProductResultInfoList() {
        return productResultInfoList;
    }


    /**
     * Sets the productResultInfoList value for this ProductResponseDto.
     * 
     * @param productResultInfoList
     */
    public void setProductResultInfoList(com.sinosoft.aip.webservice.server.ProductResultInfo[] productResultInfoList) {
        this.productResultInfoList = productResultInfoList;
    }

    public com.sinosoft.aip.webservice.server.ProductResultInfo getProductResultInfoList(int i) {
        return this.productResultInfoList[i];
    }

    public void setProductResultInfoList(int i, com.sinosoft.aip.webservice.server.ProductResultInfo _value) {
        this.productResultInfoList[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ProductResponseDto)) return false;
        ProductResponseDto other = (ProductResponseDto) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.productResultInfoList==null && other.getProductResultInfoList()==null) || 
             (this.productResultInfoList!=null &&
              java.util.Arrays.equals(this.productResultInfoList, other.getProductResultInfoList())));
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
        if (getProductResultInfoList() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getProductResultInfoList());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getProductResultInfoList(), i);
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
        new org.apache.axis.description.TypeDesc(ProductResponseDto.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "productResponseDto"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("productResultInfoList");
        elemField.setXmlName(new javax.xml.namespace.QName("", "productResultInfoList"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "productResultInfo"));
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
