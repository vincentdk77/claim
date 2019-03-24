/**
 * ClaimDto.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.sinosoft.aip.webservice.server;

public class ClaimDto  implements java.io.Serializable {
    private com.sinosoft.aip.webservice.server.ClaimMainInfo claimMainInfo;

    private com.sinosoft.aip.webservice.server.RegistInfo[] registInfoList;

    public ClaimDto() {
    }

    public ClaimDto(
           com.sinosoft.aip.webservice.server.ClaimMainInfo claimMainInfo,
           com.sinosoft.aip.webservice.server.RegistInfo[] registInfoList) {
           this.claimMainInfo = claimMainInfo;
           this.registInfoList = registInfoList;
    }


    /**
     * Gets the claimMainInfo value for this ClaimDto.
     * 
     * @return claimMainInfo
     */
    public com.sinosoft.aip.webservice.server.ClaimMainInfo getClaimMainInfo() {
        return claimMainInfo;
    }


    /**
     * Sets the claimMainInfo value for this ClaimDto.
     * 
     * @param claimMainInfo
     */
    public void setClaimMainInfo(com.sinosoft.aip.webservice.server.ClaimMainInfo claimMainInfo) {
        this.claimMainInfo = claimMainInfo;
    }


    /**
     * Gets the registInfoList value for this ClaimDto.
     * 
     * @return registInfoList
     */
    public com.sinosoft.aip.webservice.server.RegistInfo[] getRegistInfoList() {
        return registInfoList;
    }


    /**
     * Sets the registInfoList value for this ClaimDto.
     * 
     * @param registInfoList
     */
    public void setRegistInfoList(com.sinosoft.aip.webservice.server.RegistInfo[] registInfoList) {
        this.registInfoList = registInfoList;
    }

    public com.sinosoft.aip.webservice.server.RegistInfo getRegistInfoList(int i) {
        return this.registInfoList[i];
    }

    public void setRegistInfoList(int i, com.sinosoft.aip.webservice.server.RegistInfo _value) {
        this.registInfoList[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ClaimDto)) return false;
        ClaimDto other = (ClaimDto) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.claimMainInfo==null && other.getClaimMainInfo()==null) || 
             (this.claimMainInfo!=null &&
              this.claimMainInfo.equals(other.getClaimMainInfo()))) &&
            ((this.registInfoList==null && other.getRegistInfoList()==null) || 
             (this.registInfoList!=null &&
              java.util.Arrays.equals(this.registInfoList, other.getRegistInfoList())));
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
        if (getClaimMainInfo() != null) {
            _hashCode += getClaimMainInfo().hashCode();
        }
        if (getRegistInfoList() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getRegistInfoList());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getRegistInfoList(), i);
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
        new org.apache.axis.description.TypeDesc(ClaimDto.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "claimDto"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("claimMainInfo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "claimMainInfo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "claimMainInfo"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("registInfoList");
        elemField.setXmlName(new javax.xml.namespace.QName("", "registInfoList"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "registInfo"));
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
