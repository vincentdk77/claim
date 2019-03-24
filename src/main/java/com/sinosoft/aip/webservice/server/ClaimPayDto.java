/**
 * ClaimPayDto.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.sinosoft.aip.webservice.server;

public class ClaimPayDto  implements java.io.Serializable {
    private com.sinosoft.aip.webservice.server.ClaimPayFarmerInfo[] claimPayFarmerInfoList;

    private com.sinosoft.aip.webservice.server.ClaimPayMainInfo claimPayMainInfo;

    private com.sinosoft.aip.webservice.server.DirectExpenseInfo[] directExpenseInfoList;

    public ClaimPayDto() {
    }

    public ClaimPayDto(
           com.sinosoft.aip.webservice.server.ClaimPayFarmerInfo[] claimPayFarmerInfoList,
           com.sinosoft.aip.webservice.server.ClaimPayMainInfo claimPayMainInfo,
           com.sinosoft.aip.webservice.server.DirectExpenseInfo[] directExpenseInfoList) {
           this.claimPayFarmerInfoList = claimPayFarmerInfoList;
           this.claimPayMainInfo = claimPayMainInfo;
           this.directExpenseInfoList = directExpenseInfoList;
    }


    /**
     * Gets the claimPayFarmerInfoList value for this ClaimPayDto.
     * 
     * @return claimPayFarmerInfoList
     */
    public com.sinosoft.aip.webservice.server.ClaimPayFarmerInfo[] getClaimPayFarmerInfoList() {
        return claimPayFarmerInfoList;
    }


    /**
     * Sets the claimPayFarmerInfoList value for this ClaimPayDto.
     * 
     * @param claimPayFarmerInfoList
     */
    public void setClaimPayFarmerInfoList(com.sinosoft.aip.webservice.server.ClaimPayFarmerInfo[] claimPayFarmerInfoList) {
        this.claimPayFarmerInfoList = claimPayFarmerInfoList;
    }

    public com.sinosoft.aip.webservice.server.ClaimPayFarmerInfo getClaimPayFarmerInfoList(int i) {
        return this.claimPayFarmerInfoList[i];
    }

    public void setClaimPayFarmerInfoList(int i, com.sinosoft.aip.webservice.server.ClaimPayFarmerInfo _value) {
        this.claimPayFarmerInfoList[i] = _value;
    }


    /**
     * Gets the claimPayMainInfo value for this ClaimPayDto.
     * 
     * @return claimPayMainInfo
     */
    public com.sinosoft.aip.webservice.server.ClaimPayMainInfo getClaimPayMainInfo() {
        return claimPayMainInfo;
    }


    /**
     * Sets the claimPayMainInfo value for this ClaimPayDto.
     * 
     * @param claimPayMainInfo
     */
    public void setClaimPayMainInfo(com.sinosoft.aip.webservice.server.ClaimPayMainInfo claimPayMainInfo) {
        this.claimPayMainInfo = claimPayMainInfo;
    }


    /**
     * Gets the directExpenseInfoList value for this ClaimPayDto.
     * 
     * @return directExpenseInfoList
     */
    public com.sinosoft.aip.webservice.server.DirectExpenseInfo[] getDirectExpenseInfoList() {
        return directExpenseInfoList;
    }


    /**
     * Sets the directExpenseInfoList value for this ClaimPayDto.
     * 
     * @param directExpenseInfoList
     */
    public void setDirectExpenseInfoList(com.sinosoft.aip.webservice.server.DirectExpenseInfo[] directExpenseInfoList) {
        this.directExpenseInfoList = directExpenseInfoList;
    }

    public com.sinosoft.aip.webservice.server.DirectExpenseInfo getDirectExpenseInfoList(int i) {
        return this.directExpenseInfoList[i];
    }

    public void setDirectExpenseInfoList(int i, com.sinosoft.aip.webservice.server.DirectExpenseInfo _value) {
        this.directExpenseInfoList[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ClaimPayDto)) return false;
        ClaimPayDto other = (ClaimPayDto) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.claimPayFarmerInfoList==null && other.getClaimPayFarmerInfoList()==null) || 
             (this.claimPayFarmerInfoList!=null &&
              java.util.Arrays.equals(this.claimPayFarmerInfoList, other.getClaimPayFarmerInfoList()))) &&
            ((this.claimPayMainInfo==null && other.getClaimPayMainInfo()==null) || 
             (this.claimPayMainInfo!=null &&
              this.claimPayMainInfo.equals(other.getClaimPayMainInfo()))) &&
            ((this.directExpenseInfoList==null && other.getDirectExpenseInfoList()==null) || 
             (this.directExpenseInfoList!=null &&
              java.util.Arrays.equals(this.directExpenseInfoList, other.getDirectExpenseInfoList())));
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
        if (getClaimPayFarmerInfoList() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getClaimPayFarmerInfoList());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getClaimPayFarmerInfoList(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getClaimPayMainInfo() != null) {
            _hashCode += getClaimPayMainInfo().hashCode();
        }
        if (getDirectExpenseInfoList() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDirectExpenseInfoList());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDirectExpenseInfoList(), i);
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
        new org.apache.axis.description.TypeDesc(ClaimPayDto.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "claimPayDto"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("claimPayFarmerInfoList");
        elemField.setXmlName(new javax.xml.namespace.QName("", "claimPayFarmerInfoList"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "claimPayFarmerInfo"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("claimPayMainInfo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "claimPayMainInfo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "claimPayMainInfo"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("directExpenseInfoList");
        elemField.setXmlName(new javax.xml.namespace.QName("", "directExpenseInfoList"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "directExpenseInfo"));
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
