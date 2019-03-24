/**
 * ClaimPayMainInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.sinosoft.aip.webservice.server;

public class ClaimPayMainInfo  implements java.io.Serializable {
    private java.lang.String caseNumber;

    private java.util.Calendar casePayDate;

    private java.lang.String companyCode;

    private java.lang.Long farmerCount;

    private java.util.Calendar paidDate;

    private java.lang.Double paidDirectExpense;

    private java.lang.Double paidLoss;

    private java.lang.String policyNumber;

    private java.lang.Integer serialNo;

    public ClaimPayMainInfo() {
    }

    public ClaimPayMainInfo(
           java.lang.String caseNumber,
           java.util.Calendar casePayDate,
           java.lang.String companyCode,
           java.lang.Long farmerCount,
           java.util.Calendar paidDate,
           java.lang.Double paidDirectExpense,
           java.lang.Double paidLoss,
           java.lang.String policyNumber,
           java.lang.Integer serialNo) {
           this.caseNumber = caseNumber;
           this.casePayDate = casePayDate;
           this.companyCode = companyCode;
           this.farmerCount = farmerCount;
           this.paidDate = paidDate;
           this.paidDirectExpense = paidDirectExpense;
           this.paidLoss = paidLoss;
           this.policyNumber = policyNumber;
           this.serialNo = serialNo;
    }


    /**
     * Gets the caseNumber value for this ClaimPayMainInfo.
     * 
     * @return caseNumber
     */
    public java.lang.String getCaseNumber() {
        return caseNumber;
    }


    /**
     * Sets the caseNumber value for this ClaimPayMainInfo.
     * 
     * @param caseNumber
     */
    public void setCaseNumber(java.lang.String caseNumber) {
        this.caseNumber = caseNumber;
    }


    /**
     * Gets the casePayDate value for this ClaimPayMainInfo.
     * 
     * @return casePayDate
     */
    public java.util.Calendar getCasePayDate() {
        return casePayDate;
    }


    /**
     * Sets the casePayDate value for this ClaimPayMainInfo.
     * 
     * @param casePayDate
     */
    public void setCasePayDate(java.util.Calendar casePayDate) {
        this.casePayDate = casePayDate;
    }


    /**
     * Gets the companyCode value for this ClaimPayMainInfo.
     * 
     * @return companyCode
     */
    public java.lang.String getCompanyCode() {
        return companyCode;
    }


    /**
     * Sets the companyCode value for this ClaimPayMainInfo.
     * 
     * @param companyCode
     */
    public void setCompanyCode(java.lang.String companyCode) {
        this.companyCode = companyCode;
    }


    /**
     * Gets the farmerCount value for this ClaimPayMainInfo.
     * 
     * @return farmerCount
     */
    public java.lang.Long getFarmerCount() {
        return farmerCount;
    }


    /**
     * Sets the farmerCount value for this ClaimPayMainInfo.
     * 
     * @param farmerCount
     */
    public void setFarmerCount(java.lang.Long farmerCount) {
        this.farmerCount = farmerCount;
    }


    /**
     * Gets the paidDate value for this ClaimPayMainInfo.
     * 
     * @return paidDate
     */
    public java.util.Calendar getPaidDate() {
        return paidDate;
    }


    /**
     * Sets the paidDate value for this ClaimPayMainInfo.
     * 
     * @param paidDate
     */
    public void setPaidDate(java.util.Calendar paidDate) {
        this.paidDate = paidDate;
    }


    /**
     * Gets the paidDirectExpense value for this ClaimPayMainInfo.
     * 
     * @return paidDirectExpense
     */
    public java.lang.Double getPaidDirectExpense() {
        return paidDirectExpense;
    }


    /**
     * Sets the paidDirectExpense value for this ClaimPayMainInfo.
     * 
     * @param paidDirectExpense
     */
    public void setPaidDirectExpense(java.lang.Double paidDirectExpense) {
        this.paidDirectExpense = paidDirectExpense;
    }


    /**
     * Gets the paidLoss value for this ClaimPayMainInfo.
     * 
     * @return paidLoss
     */
    public java.lang.Double getPaidLoss() {
        return paidLoss;
    }


    /**
     * Sets the paidLoss value for this ClaimPayMainInfo.
     * 
     * @param paidLoss
     */
    public void setPaidLoss(java.lang.Double paidLoss) {
        this.paidLoss = paidLoss;
    }


    /**
     * Gets the policyNumber value for this ClaimPayMainInfo.
     * 
     * @return policyNumber
     */
    public java.lang.String getPolicyNumber() {
        return policyNumber;
    }


    /**
     * Sets the policyNumber value for this ClaimPayMainInfo.
     * 
     * @param policyNumber
     */
    public void setPolicyNumber(java.lang.String policyNumber) {
        this.policyNumber = policyNumber;
    }


    /**
     * Gets the serialNo value for this ClaimPayMainInfo.
     * 
     * @return serialNo
     */
    public java.lang.Integer getSerialNo() {
        return serialNo;
    }


    /**
     * Sets the serialNo value for this ClaimPayMainInfo.
     * 
     * @param serialNo
     */
    public void setSerialNo(java.lang.Integer serialNo) {
        this.serialNo = serialNo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ClaimPayMainInfo)) return false;
        ClaimPayMainInfo other = (ClaimPayMainInfo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.caseNumber==null && other.getCaseNumber()==null) || 
             (this.caseNumber!=null &&
              this.caseNumber.equals(other.getCaseNumber()))) &&
            ((this.casePayDate==null && other.getCasePayDate()==null) || 
             (this.casePayDate!=null &&
              this.casePayDate.equals(other.getCasePayDate()))) &&
            ((this.companyCode==null && other.getCompanyCode()==null) || 
             (this.companyCode!=null &&
              this.companyCode.equals(other.getCompanyCode()))) &&
            ((this.farmerCount==null && other.getFarmerCount()==null) || 
             (this.farmerCount!=null &&
              this.farmerCount.equals(other.getFarmerCount()))) &&
            ((this.paidDate==null && other.getPaidDate()==null) || 
             (this.paidDate!=null &&
              this.paidDate.equals(other.getPaidDate()))) &&
            ((this.paidDirectExpense==null && other.getPaidDirectExpense()==null) || 
             (this.paidDirectExpense!=null &&
              this.paidDirectExpense.equals(other.getPaidDirectExpense()))) &&
            ((this.paidLoss==null && other.getPaidLoss()==null) || 
             (this.paidLoss!=null &&
              this.paidLoss.equals(other.getPaidLoss()))) &&
            ((this.policyNumber==null && other.getPolicyNumber()==null) || 
             (this.policyNumber!=null &&
              this.policyNumber.equals(other.getPolicyNumber()))) &&
            ((this.serialNo==null && other.getSerialNo()==null) || 
             (this.serialNo!=null &&
              this.serialNo.equals(other.getSerialNo())));
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
        if (getCaseNumber() != null) {
            _hashCode += getCaseNumber().hashCode();
        }
        if (getCasePayDate() != null) {
            _hashCode += getCasePayDate().hashCode();
        }
        if (getCompanyCode() != null) {
            _hashCode += getCompanyCode().hashCode();
        }
        if (getFarmerCount() != null) {
            _hashCode += getFarmerCount().hashCode();
        }
        if (getPaidDate() != null) {
            _hashCode += getPaidDate().hashCode();
        }
        if (getPaidDirectExpense() != null) {
            _hashCode += getPaidDirectExpense().hashCode();
        }
        if (getPaidLoss() != null) {
            _hashCode += getPaidLoss().hashCode();
        }
        if (getPolicyNumber() != null) {
            _hashCode += getPolicyNumber().hashCode();
        }
        if (getSerialNo() != null) {
            _hashCode += getSerialNo().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ClaimPayMainInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "claimPayMainInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("caseNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("", "caseNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("casePayDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "casePayDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("companyCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "companyCode"));
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
        elemField.setFieldName("paidDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "paidDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("paidDirectExpense");
        elemField.setXmlName(new javax.xml.namespace.QName("", "paidDirectExpense"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("paidLoss");
        elemField.setXmlName(new javax.xml.namespace.QName("", "paidLoss"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
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
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("serialNo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "serialNo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
