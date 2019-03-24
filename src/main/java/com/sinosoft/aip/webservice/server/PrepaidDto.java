/**
 * PrepaidDto.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.sinosoft.aip.webservice.server;

public class PrepaidDto  implements java.io.Serializable {
    private com.sinosoft.aip.webservice.server.PrepaidMainInfo prePaidMainInfo;

    private com.sinosoft.aip.webservice.server.PrepaidFarmerInfo[] prepaidFarmerInfoList;

    public PrepaidDto() {
    }

    public PrepaidDto(
           com.sinosoft.aip.webservice.server.PrepaidMainInfo prePaidMainInfo,
           com.sinosoft.aip.webservice.server.PrepaidFarmerInfo[] prepaidFarmerInfoList) {
           this.prePaidMainInfo = prePaidMainInfo;
           this.prepaidFarmerInfoList = prepaidFarmerInfoList;
    }


    /**
     * Gets the prePaidMainInfo value for this PrepaidDto.
     * 
     * @return prePaidMainInfo
     */
    public com.sinosoft.aip.webservice.server.PrepaidMainInfo getPrePaidMainInfo() {
        return prePaidMainInfo;
    }


    /**
     * Sets the prePaidMainInfo value for this PrepaidDto.
     * 
     * @param prePaidMainInfo
     */
    public void setPrePaidMainInfo(com.sinosoft.aip.webservice.server.PrepaidMainInfo prePaidMainInfo) {
        this.prePaidMainInfo = prePaidMainInfo;
    }


    /**
     * Gets the prepaidFarmerInfoList value for this PrepaidDto.
     * 
     * @return prepaidFarmerInfoList
     */
    public com.sinosoft.aip.webservice.server.PrepaidFarmerInfo[] getPrepaidFarmerInfoList() {
        return prepaidFarmerInfoList;
    }


    /**
     * Sets the prepaidFarmerInfoList value for this PrepaidDto.
     * 
     * @param prepaidFarmerInfoList
     */
    public void setPrepaidFarmerInfoList(com.sinosoft.aip.webservice.server.PrepaidFarmerInfo[] prepaidFarmerInfoList) {
        this.prepaidFarmerInfoList = prepaidFarmerInfoList;
    }

    public com.sinosoft.aip.webservice.server.PrepaidFarmerInfo getPrepaidFarmerInfoList(int i) {
        return this.prepaidFarmerInfoList[i];
    }

    public void setPrepaidFarmerInfoList(int i, com.sinosoft.aip.webservice.server.PrepaidFarmerInfo _value) {
        this.prepaidFarmerInfoList[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PrepaidDto)) return false;
        PrepaidDto other = (PrepaidDto) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.prePaidMainInfo==null && other.getPrePaidMainInfo()==null) || 
             (this.prePaidMainInfo!=null &&
              this.prePaidMainInfo.equals(other.getPrePaidMainInfo()))) &&
            ((this.prepaidFarmerInfoList==null && other.getPrepaidFarmerInfoList()==null) || 
             (this.prepaidFarmerInfoList!=null &&
              java.util.Arrays.equals(this.prepaidFarmerInfoList, other.getPrepaidFarmerInfoList())));
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
        if (getPrePaidMainInfo() != null) {
            _hashCode += getPrePaidMainInfo().hashCode();
        }
        if (getPrepaidFarmerInfoList() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPrepaidFarmerInfoList());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPrepaidFarmerInfoList(), i);
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
        new org.apache.axis.description.TypeDesc(PrepaidDto.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "prepaidDto"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("prePaidMainInfo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "prePaidMainInfo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "prepaidMainInfo"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("prepaidFarmerInfoList");
        elemField.setXmlName(new javax.xml.namespace.QName("", "prepaidFarmerInfoList"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "prepaidFarmerInfo"));
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
