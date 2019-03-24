/**
 * CaseDto.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.sinosoft.aip.webservice.server;

public class CaseDto  implements java.io.Serializable {
    private com.sinosoft.aip.webservice.server.CaseMainInfo caseMainInfo;

    private com.sinosoft.aip.webservice.server.ClaimFarmerInfo[] farmerInfoList;

    public CaseDto() {
    }

    public CaseDto(
           com.sinosoft.aip.webservice.server.CaseMainInfo caseMainInfo,
           com.sinosoft.aip.webservice.server.ClaimFarmerInfo[] farmerInfoList) {
           this.caseMainInfo = caseMainInfo;
           this.farmerInfoList = farmerInfoList;
    }


    /**
     * Gets the caseMainInfo value for this CaseDto.
     * 
     * @return caseMainInfo
     */
    public com.sinosoft.aip.webservice.server.CaseMainInfo getCaseMainInfo() {
        return caseMainInfo;
    }


    /**
     * Sets the caseMainInfo value for this CaseDto.
     * 
     * @param caseMainInfo
     */
    public void setCaseMainInfo(com.sinosoft.aip.webservice.server.CaseMainInfo caseMainInfo) {
        this.caseMainInfo = caseMainInfo;
    }


    /**
     * Gets the farmerInfoList value for this CaseDto.
     * 
     * @return farmerInfoList
     */
    public com.sinosoft.aip.webservice.server.ClaimFarmerInfo[] getFarmerInfoList() {
        return farmerInfoList;
    }


    /**
     * Sets the farmerInfoList value for this CaseDto.
     * 
     * @param farmerInfoList
     */
    public void setFarmerInfoList(com.sinosoft.aip.webservice.server.ClaimFarmerInfo[] farmerInfoList) {
        this.farmerInfoList = farmerInfoList;
    }

    public com.sinosoft.aip.webservice.server.ClaimFarmerInfo getFarmerInfoList(int i) {
        return this.farmerInfoList[i];
    }

    public void setFarmerInfoList(int i, com.sinosoft.aip.webservice.server.ClaimFarmerInfo _value) {
        this.farmerInfoList[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CaseDto)) return false;
        CaseDto other = (CaseDto) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.caseMainInfo==null && other.getCaseMainInfo()==null) || 
             (this.caseMainInfo!=null &&
              this.caseMainInfo.equals(other.getCaseMainInfo()))) &&
            ((this.farmerInfoList==null && other.getFarmerInfoList()==null) || 
             (this.farmerInfoList!=null &&
              java.util.Arrays.equals(this.farmerInfoList, other.getFarmerInfoList())));
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
        if (getCaseMainInfo() != null) {
            _hashCode += getCaseMainInfo().hashCode();
        }
        if (getFarmerInfoList() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getFarmerInfoList());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getFarmerInfoList(), i);
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
        new org.apache.axis.description.TypeDesc(CaseDto.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "caseDto"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("caseMainInfo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "caseMainInfo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "caseMainInfo"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("farmerInfoList");
        elemField.setXmlName(new javax.xml.namespace.QName("", "farmerInfoList"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "claimFarmerInfo"));
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
