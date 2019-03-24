/**
 * FarmerDto.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.sinosoft.aip.webservice.server;

public class FarmerDto  implements java.io.Serializable {
    private java.lang.String companyCode;

    private java.lang.String confirmSequenceNo;

    private java.lang.Long farmerCount;

    private com.sinosoft.aip.webservice.server.PolicyFarmerInfo[] farmerInfoList;

    private java.lang.String listType;

    private java.lang.String policyNumber;

    public FarmerDto() {
    }

    public FarmerDto(
           java.lang.String companyCode,
           java.lang.String confirmSequenceNo,
           java.lang.Long farmerCount,
           com.sinosoft.aip.webservice.server.PolicyFarmerInfo[] farmerInfoList,
           java.lang.String listType,
           java.lang.String policyNumber) {
           this.companyCode = companyCode;
           this.confirmSequenceNo = confirmSequenceNo;
           this.farmerCount = farmerCount;
           this.farmerInfoList = farmerInfoList;
           this.listType = listType;
           this.policyNumber = policyNumber;
    }


    /**
     * Gets the companyCode value for this FarmerDto.
     * 
     * @return companyCode
     */
    public java.lang.String getCompanyCode() {
        return companyCode;
    }


    /**
     * Sets the companyCode value for this FarmerDto.
     * 
     * @param companyCode
     */
    public void setCompanyCode(java.lang.String companyCode) {
        this.companyCode = companyCode;
    }


    /**
     * Gets the confirmSequenceNo value for this FarmerDto.
     * 
     * @return confirmSequenceNo
     */
    public java.lang.String getConfirmSequenceNo() {
        return confirmSequenceNo;
    }


    /**
     * Sets the confirmSequenceNo value for this FarmerDto.
     * 
     * @param confirmSequenceNo
     */
    public void setConfirmSequenceNo(java.lang.String confirmSequenceNo) {
        this.confirmSequenceNo = confirmSequenceNo;
    }


    /**
     * Gets the farmerCount value for this FarmerDto.
     * 
     * @return farmerCount
     */
    public java.lang.Long getFarmerCount() {
        return farmerCount;
    }


    /**
     * Sets the farmerCount value for this FarmerDto.
     * 
     * @param farmerCount
     */
    public void setFarmerCount(java.lang.Long farmerCount) {
        this.farmerCount = farmerCount;
    }


    /**
     * Gets the farmerInfoList value for this FarmerDto.
     * 
     * @return farmerInfoList
     */
    public com.sinosoft.aip.webservice.server.PolicyFarmerInfo[] getFarmerInfoList() {
        return farmerInfoList;
    }


    /**
     * Sets the farmerInfoList value for this FarmerDto.
     * 
     * @param farmerInfoList
     */
    public void setFarmerInfoList(com.sinosoft.aip.webservice.server.PolicyFarmerInfo[] farmerInfoList) {
        this.farmerInfoList = farmerInfoList;
    }

    public com.sinosoft.aip.webservice.server.PolicyFarmerInfo getFarmerInfoList(int i) {
        return this.farmerInfoList[i];
    }

    public void setFarmerInfoList(int i, com.sinosoft.aip.webservice.server.PolicyFarmerInfo _value) {
        this.farmerInfoList[i] = _value;
    }


    /**
     * Gets the listType value for this FarmerDto.
     * 
     * @return listType
     */
    public java.lang.String getListType() {
        return listType;
    }


    /**
     * Sets the listType value for this FarmerDto.
     * 
     * @param listType
     */
    public void setListType(java.lang.String listType) {
        this.listType = listType;
    }


    /**
     * Gets the policyNumber value for this FarmerDto.
     * 
     * @return policyNumber
     */
    public java.lang.String getPolicyNumber() {
        return policyNumber;
    }


    /**
     * Sets the policyNumber value for this FarmerDto.
     * 
     * @param policyNumber
     */
    public void setPolicyNumber(java.lang.String policyNumber) {
        this.policyNumber = policyNumber;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof FarmerDto)) return false;
        FarmerDto other = (FarmerDto) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.companyCode==null && other.getCompanyCode()==null) || 
             (this.companyCode!=null &&
              this.companyCode.equals(other.getCompanyCode()))) &&
            ((this.confirmSequenceNo==null && other.getConfirmSequenceNo()==null) || 
             (this.confirmSequenceNo!=null &&
              this.confirmSequenceNo.equals(other.getConfirmSequenceNo()))) &&
            ((this.farmerCount==null && other.getFarmerCount()==null) || 
             (this.farmerCount!=null &&
              this.farmerCount.equals(other.getFarmerCount()))) &&
            ((this.farmerInfoList==null && other.getFarmerInfoList()==null) || 
             (this.farmerInfoList!=null &&
              java.util.Arrays.equals(this.farmerInfoList, other.getFarmerInfoList()))) &&
            ((this.listType==null && other.getListType()==null) || 
             (this.listType!=null &&
              this.listType.equals(other.getListType()))) &&
            ((this.policyNumber==null && other.getPolicyNumber()==null) || 
             (this.policyNumber!=null &&
              this.policyNumber.equals(other.getPolicyNumber())));
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
        if (getCompanyCode() != null) {
            _hashCode += getCompanyCode().hashCode();
        }
        if (getConfirmSequenceNo() != null) {
            _hashCode += getConfirmSequenceNo().hashCode();
        }
        if (getFarmerCount() != null) {
            _hashCode += getFarmerCount().hashCode();
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
        if (getListType() != null) {
            _hashCode += getListType().hashCode();
        }
        if (getPolicyNumber() != null) {
            _hashCode += getPolicyNumber().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(FarmerDto.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "farmerDto"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("companyCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "companyCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("confirmSequenceNo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "confirmSequenceNo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("farmerCount");
        elemField.setXmlName(new javax.xml.namespace.QName("", "farmerCount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("farmerInfoList");
        elemField.setXmlName(new javax.xml.namespace.QName("", "farmerInfoList"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "policyFarmerInfo"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "listType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("policyNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("", "policyNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
