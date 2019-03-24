/**
 * ProductInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.sinosoft.aip.webservice.server;

public class ProductInfo  implements java.io.Serializable {
    private java.lang.String clauseCode;

    private java.lang.String clausesName;

    private java.lang.String indefinitelyFlag;

    private java.lang.String insuranceClass;

    private java.lang.String insuredObjectCode;

    private java.lang.Double premiumRate;

    private java.lang.String productCode;

    private java.util.Calendar productEndDate;

    private java.util.Calendar productStartDate;

    private java.lang.String productType;

    private java.lang.String recordNumber;

    private java.lang.String saleDistrict;

    public ProductInfo() {
    }

    public ProductInfo(
           java.lang.String clauseCode,
           java.lang.String clausesName,
           java.lang.String indefinitelyFlag,
           java.lang.String insuranceClass,
           java.lang.String insuredObjectCode,
           java.lang.Double premiumRate,
           java.lang.String productCode,
           java.util.Calendar productEndDate,
           java.util.Calendar productStartDate,
           java.lang.String productType,
           java.lang.String recordNumber,
           java.lang.String saleDistrict) {
           this.clauseCode = clauseCode;
           this.clausesName = clausesName;
           this.indefinitelyFlag = indefinitelyFlag;
           this.insuranceClass = insuranceClass;
           this.insuredObjectCode = insuredObjectCode;
           this.premiumRate = premiumRate;
           this.productCode = productCode;
           this.productEndDate = productEndDate;
           this.productStartDate = productStartDate;
           this.productType = productType;
           this.recordNumber = recordNumber;
           this.saleDistrict = saleDistrict;
    }


    /**
     * Gets the clauseCode value for this ProductInfo.
     * 
     * @return clauseCode
     */
    public java.lang.String getClauseCode() {
        return clauseCode;
    }


    /**
     * Sets the clauseCode value for this ProductInfo.
     * 
     * @param clauseCode
     */
    public void setClauseCode(java.lang.String clauseCode) {
        this.clauseCode = clauseCode;
    }


    /**
     * Gets the clausesName value for this ProductInfo.
     * 
     * @return clausesName
     */
    public java.lang.String getClausesName() {
        return clausesName;
    }


    /**
     * Sets the clausesName value for this ProductInfo.
     * 
     * @param clausesName
     */
    public void setClausesName(java.lang.String clausesName) {
        this.clausesName = clausesName;
    }


    /**
     * Gets the indefinitelyFlag value for this ProductInfo.
     * 
     * @return indefinitelyFlag
     */
    public java.lang.String getIndefinitelyFlag() {
        return indefinitelyFlag;
    }


    /**
     * Sets the indefinitelyFlag value for this ProductInfo.
     * 
     * @param indefinitelyFlag
     */
    public void setIndefinitelyFlag(java.lang.String indefinitelyFlag) {
        this.indefinitelyFlag = indefinitelyFlag;
    }


    /**
     * Gets the insuranceClass value for this ProductInfo.
     * 
     * @return insuranceClass
     */
    public java.lang.String getInsuranceClass() {
        return insuranceClass;
    }


    /**
     * Sets the insuranceClass value for this ProductInfo.
     * 
     * @param insuranceClass
     */
    public void setInsuranceClass(java.lang.String insuranceClass) {
        this.insuranceClass = insuranceClass;
    }


    /**
     * Gets the insuredObjectCode value for this ProductInfo.
     * 
     * @return insuredObjectCode
     */
    public java.lang.String getInsuredObjectCode() {
        return insuredObjectCode;
    }


    /**
     * Sets the insuredObjectCode value for this ProductInfo.
     * 
     * @param insuredObjectCode
     */
    public void setInsuredObjectCode(java.lang.String insuredObjectCode) {
        this.insuredObjectCode = insuredObjectCode;
    }


    /**
     * Gets the premiumRate value for this ProductInfo.
     * 
     * @return premiumRate
     */
    public java.lang.Double getPremiumRate() {
        return premiumRate;
    }


    /**
     * Sets the premiumRate value for this ProductInfo.
     * 
     * @param premiumRate
     */
    public void setPremiumRate(java.lang.Double premiumRate) {
        this.premiumRate = premiumRate;
    }


    /**
     * Gets the productCode value for this ProductInfo.
     * 
     * @return productCode
     */
    public java.lang.String getProductCode() {
        return productCode;
    }


    /**
     * Sets the productCode value for this ProductInfo.
     * 
     * @param productCode
     */
    public void setProductCode(java.lang.String productCode) {
        this.productCode = productCode;
    }


    /**
     * Gets the productEndDate value for this ProductInfo.
     * 
     * @return productEndDate
     */
    public java.util.Calendar getProductEndDate() {
        return productEndDate;
    }


    /**
     * Sets the productEndDate value for this ProductInfo.
     * 
     * @param productEndDate
     */
    public void setProductEndDate(java.util.Calendar productEndDate) {
        this.productEndDate = productEndDate;
    }


    /**
     * Gets the productStartDate value for this ProductInfo.
     * 
     * @return productStartDate
     */
    public java.util.Calendar getProductStartDate() {
        return productStartDate;
    }


    /**
     * Sets the productStartDate value for this ProductInfo.
     * 
     * @param productStartDate
     */
    public void setProductStartDate(java.util.Calendar productStartDate) {
        this.productStartDate = productStartDate;
    }


    /**
     * Gets the productType value for this ProductInfo.
     * 
     * @return productType
     */
    public java.lang.String getProductType() {
        return productType;
    }


    /**
     * Sets the productType value for this ProductInfo.
     * 
     * @param productType
     */
    public void setProductType(java.lang.String productType) {
        this.productType = productType;
    }


    /**
     * Gets the recordNumber value for this ProductInfo.
     * 
     * @return recordNumber
     */
    public java.lang.String getRecordNumber() {
        return recordNumber;
    }


    /**
     * Sets the recordNumber value for this ProductInfo.
     * 
     * @param recordNumber
     */
    public void setRecordNumber(java.lang.String recordNumber) {
        this.recordNumber = recordNumber;
    }


    /**
     * Gets the saleDistrict value for this ProductInfo.
     * 
     * @return saleDistrict
     */
    public java.lang.String getSaleDistrict() {
        return saleDistrict;
    }


    /**
     * Sets the saleDistrict value for this ProductInfo.
     * 
     * @param saleDistrict
     */
    public void setSaleDistrict(java.lang.String saleDistrict) {
        this.saleDistrict = saleDistrict;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ProductInfo)) return false;
        ProductInfo other = (ProductInfo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.clauseCode==null && other.getClauseCode()==null) || 
             (this.clauseCode!=null &&
              this.clauseCode.equals(other.getClauseCode()))) &&
            ((this.clausesName==null && other.getClausesName()==null) || 
             (this.clausesName!=null &&
              this.clausesName.equals(other.getClausesName()))) &&
            ((this.indefinitelyFlag==null && other.getIndefinitelyFlag()==null) || 
             (this.indefinitelyFlag!=null &&
              this.indefinitelyFlag.equals(other.getIndefinitelyFlag()))) &&
            ((this.insuranceClass==null && other.getInsuranceClass()==null) || 
             (this.insuranceClass!=null &&
              this.insuranceClass.equals(other.getInsuranceClass()))) &&
            ((this.insuredObjectCode==null && other.getInsuredObjectCode()==null) || 
             (this.insuredObjectCode!=null &&
              this.insuredObjectCode.equals(other.getInsuredObjectCode()))) &&
            ((this.premiumRate==null && other.getPremiumRate()==null) || 
             (this.premiumRate!=null &&
              this.premiumRate.equals(other.getPremiumRate()))) &&
            ((this.productCode==null && other.getProductCode()==null) || 
             (this.productCode!=null &&
              this.productCode.equals(other.getProductCode()))) &&
            ((this.productEndDate==null && other.getProductEndDate()==null) || 
             (this.productEndDate!=null &&
              this.productEndDate.equals(other.getProductEndDate()))) &&
            ((this.productStartDate==null && other.getProductStartDate()==null) || 
             (this.productStartDate!=null &&
              this.productStartDate.equals(other.getProductStartDate()))) &&
            ((this.productType==null && other.getProductType()==null) || 
             (this.productType!=null &&
              this.productType.equals(other.getProductType()))) &&
            ((this.recordNumber==null && other.getRecordNumber()==null) || 
             (this.recordNumber!=null &&
              this.recordNumber.equals(other.getRecordNumber()))) &&
            ((this.saleDistrict==null && other.getSaleDistrict()==null) || 
             (this.saleDistrict!=null &&
              this.saleDistrict.equals(other.getSaleDistrict())));
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
        if (getClauseCode() != null) {
            _hashCode += getClauseCode().hashCode();
        }
        if (getClausesName() != null) {
            _hashCode += getClausesName().hashCode();
        }
        if (getIndefinitelyFlag() != null) {
            _hashCode += getIndefinitelyFlag().hashCode();
        }
        if (getInsuranceClass() != null) {
            _hashCode += getInsuranceClass().hashCode();
        }
        if (getInsuredObjectCode() != null) {
            _hashCode += getInsuredObjectCode().hashCode();
        }
        if (getPremiumRate() != null) {
            _hashCode += getPremiumRate().hashCode();
        }
        if (getProductCode() != null) {
            _hashCode += getProductCode().hashCode();
        }
        if (getProductEndDate() != null) {
            _hashCode += getProductEndDate().hashCode();
        }
        if (getProductStartDate() != null) {
            _hashCode += getProductStartDate().hashCode();
        }
        if (getProductType() != null) {
            _hashCode += getProductType().hashCode();
        }
        if (getRecordNumber() != null) {
            _hashCode += getRecordNumber().hashCode();
        }
        if (getSaleDistrict() != null) {
            _hashCode += getSaleDistrict().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ProductInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "productInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("clauseCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "clauseCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("clausesName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "clausesName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("indefinitelyFlag");
        elemField.setXmlName(new javax.xml.namespace.QName("", "indefinitelyFlag"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("insuranceClass");
        elemField.setXmlName(new javax.xml.namespace.QName("", "insuranceClass"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("insuredObjectCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "insuredObjectCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("premiumRate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "premiumRate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("productCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "productCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("productEndDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "productEndDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("productStartDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "productStartDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("productType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "productType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("recordNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("", "recordNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("saleDistrict");
        elemField.setXmlName(new javax.xml.namespace.QName("", "saleDistrict"));
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
