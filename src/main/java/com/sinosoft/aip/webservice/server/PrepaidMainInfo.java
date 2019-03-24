/**
 * PrepaidMainInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.sinosoft.aip.webservice.server;

import com.sinosoft.sysframework.common.datatype.DateTime;

public class PrepaidMainInfo  implements java.io.Serializable {
    private DateTime assessmentDate;

    private java.lang.String claimNumber;

    private java.lang.String claimSequenceNo;

    private java.lang.String companyCode;

    private java.lang.Long farmerCount;

    private java.lang.String policyNumber;

    private java.lang.Double prepaidAmount;

    private java.lang.Double prepaidDirectExpense;

    private java.lang.String prepayCaseNumber;

    private java.lang.Long serialNo;

    public PrepaidMainInfo() {
    }

    public PrepaidMainInfo(
           DateTime assessmentDate,
           java.lang.String claimNumber,
           java.lang.String claimSequenceNo,
           java.lang.String companyCode,
           java.lang.Long farmerCount,
           java.lang.String policyNumber,
           java.lang.Double prepaidAmount,
           java.lang.Double prepaidDirectExpense,
           java.lang.String prepayCaseNumber,
           java.lang.Long serialNo) {
           this.assessmentDate = assessmentDate;
           this.claimNumber = claimNumber;
           this.claimSequenceNo = claimSequenceNo;
           this.companyCode = companyCode;
           this.farmerCount = farmerCount;
           this.policyNumber = policyNumber;
           this.prepaidAmount = prepaidAmount;
           this.prepaidDirectExpense = prepaidDirectExpense;
           this.prepayCaseNumber = prepayCaseNumber;
           this.serialNo = serialNo;
    }


    /**
     * Gets the assessmentDate value for this PrepaidMainInfo.
     * 
     * @return assessmentDate
     */
    public DateTime getAssessmentDate() {
        return assessmentDate;
    }


    /**
     * Sets the assessmentDate value for this PrepaidMainInfo.
     * 
     * @param dateTime
     */
    public void setAssessmentDate(DateTime dateTime) {
        this.assessmentDate = dateTime;
    }


    /**
     * Gets the claimNumber value for this PrepaidMainInfo.
     * 
     * @return claimNumber
     */
    public java.lang.String getClaimNumber() {
        return claimNumber;
    }


    /**
     * Sets the claimNumber value for this PrepaidMainInfo.
     * 
     * @param claimNumber
     */
    public void setClaimNumber(java.lang.String claimNumber) {
        this.claimNumber = claimNumber;
    }


    /**
     * Gets the claimSequenceNo value for this PrepaidMainInfo.
     * 
     * @return claimSequenceNo
     */
    public java.lang.String getClaimSequenceNo() {
        return claimSequenceNo;
    }


    /**
     * Sets the claimSequenceNo value for this PrepaidMainInfo.
     * 
     * @param claimSequenceNo
     */
    public void setClaimSequenceNo(java.lang.String claimSequenceNo) {
        this.claimSequenceNo = claimSequenceNo;
    }


    /**
     * Gets the companyCode value for this PrepaidMainInfo.
     * 
     * @return companyCode
     */
    public java.lang.String getCompanyCode() {
        return companyCode;
    }


    /**
     * Sets the companyCode value for this PrepaidMainInfo.
     * 
     * @param companyCode
     */
    public void setCompanyCode(java.lang.String companyCode) {
        this.companyCode = companyCode;
    }


    /**
     * Gets the farmerCount value for this PrepaidMainInfo.
     * 
     * @return farmerCount
     */
    public java.lang.Long getFarmerCount() {
        return farmerCount;
    }


    /**
     * Sets the farmerCount value for this PrepaidMainInfo.
     * 
     * @param farmerCount
     */
    public void setFarmerCount(java.lang.Long farmerCount) {
        this.farmerCount = farmerCount;
    }


    /**
     * Gets the policyNumber value for this PrepaidMainInfo.
     * 
     * @return policyNumber
     */
    public java.lang.String getPolicyNumber() {
        return policyNumber;
    }


    /**
     * Sets the policyNumber value for this PrepaidMainInfo.
     * 
     * @param policyNumber
     */
    public void setPolicyNumber(java.lang.String policyNumber) {
        this.policyNumber = policyNumber;
    }


    /**
     * Gets the prepaidAmount value for this PrepaidMainInfo.
     * 
     * @return prepaidAmount
     */
    public java.lang.Double getPrepaidAmount() {
        return prepaidAmount;
    }


    /**
     * Sets the prepaidAmount value for this PrepaidMainInfo.
     * 
     * @param prepaidAmount
     */
    public void setPrepaidAmount(java.lang.Double prepaidAmount) {
        this.prepaidAmount = prepaidAmount;
    }


    /**
     * Gets the prepaidDirectExpense value for this PrepaidMainInfo.
     * 
     * @return prepaidDirectExpense
     */
    public java.lang.Double getPrepaidDirectExpense() {
        return prepaidDirectExpense;
    }


    /**
     * Sets the prepaidDirectExpense value for this PrepaidMainInfo.
     * 
     * @param prepaidDirectExpense
     */
    public void setPrepaidDirectExpense(java.lang.Double prepaidDirectExpense) {
        this.prepaidDirectExpense = prepaidDirectExpense;
    }


    /**
     * Gets the prepayCaseNumber value for this PrepaidMainInfo.
     * 
     * @return prepayCaseNumber
     */
    public java.lang.String getPrepayCaseNumber() {
        return prepayCaseNumber;
    }


    /**
     * Sets the prepayCaseNumber value for this PrepaidMainInfo.
     * 
     * @param prepayCaseNumber
     */
    public void setPrepayCaseNumber(java.lang.String prepayCaseNumber) {
        this.prepayCaseNumber = prepayCaseNumber;
    }


    /**
     * Gets the serialNo value for this PrepaidMainInfo.
     * 
     * @return serialNo
     */
    public java.lang.Long getSerialNo() {
        return serialNo;
    }


    /**
     * Sets the serialNo value for this PrepaidMainInfo.
     * 
     * @param serialNo
     */
    public void setSerialNo(java.lang.Long serialNo) {
        this.serialNo = serialNo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PrepaidMainInfo)) return false;
        PrepaidMainInfo other = (PrepaidMainInfo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.assessmentDate==null && other.getAssessmentDate()==null) || 
             (this.assessmentDate!=null &&
              this.assessmentDate.equals(other.getAssessmentDate()))) &&
            ((this.claimNumber==null && other.getClaimNumber()==null) || 
             (this.claimNumber!=null &&
              this.claimNumber.equals(other.getClaimNumber()))) &&
            ((this.claimSequenceNo==null && other.getClaimSequenceNo()==null) || 
             (this.claimSequenceNo!=null &&
              this.claimSequenceNo.equals(other.getClaimSequenceNo()))) &&
            ((this.companyCode==null && other.getCompanyCode()==null) || 
             (this.companyCode!=null &&
              this.companyCode.equals(other.getCompanyCode()))) &&
            ((this.farmerCount==null && other.getFarmerCount()==null) || 
             (this.farmerCount!=null &&
              this.farmerCount.equals(other.getFarmerCount()))) &&
            ((this.policyNumber==null && other.getPolicyNumber()==null) || 
             (this.policyNumber!=null &&
              this.policyNumber.equals(other.getPolicyNumber()))) &&
            ((this.prepaidAmount==null && other.getPrepaidAmount()==null) || 
             (this.prepaidAmount!=null &&
              this.prepaidAmount.equals(other.getPrepaidAmount()))) &&
            ((this.prepaidDirectExpense==null && other.getPrepaidDirectExpense()==null) || 
             (this.prepaidDirectExpense!=null &&
              this.prepaidDirectExpense.equals(other.getPrepaidDirectExpense()))) &&
            ((this.prepayCaseNumber==null && other.getPrepayCaseNumber()==null) || 
             (this.prepayCaseNumber!=null &&
              this.prepayCaseNumber.equals(other.getPrepayCaseNumber()))) &&
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
        if (getAssessmentDate() != null) {
            _hashCode += getAssessmentDate().hashCode();
        }
        if (getClaimNumber() != null) {
            _hashCode += getClaimNumber().hashCode();
        }
        if (getClaimSequenceNo() != null) {
            _hashCode += getClaimSequenceNo().hashCode();
        }
        if (getCompanyCode() != null) {
            _hashCode += getCompanyCode().hashCode();
        }
        if (getFarmerCount() != null) {
            _hashCode += getFarmerCount().hashCode();
        }
        if (getPolicyNumber() != null) {
            _hashCode += getPolicyNumber().hashCode();
        }
        if (getPrepaidAmount() != null) {
            _hashCode += getPrepaidAmount().hashCode();
        }
        if (getPrepaidDirectExpense() != null) {
            _hashCode += getPrepaidDirectExpense().hashCode();
        }
        if (getPrepayCaseNumber() != null) {
            _hashCode += getPrepayCaseNumber().hashCode();
        }
        if (getSerialNo() != null) {
            _hashCode += getSerialNo().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PrepaidMainInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "prepaidMainInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("assessmentDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "assessmentDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("claimNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("", "claimNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("claimSequenceNo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "claimSequenceNo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
        elemField.setFieldName("policyNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("", "policyNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("prepaidAmount");
        elemField.setXmlName(new javax.xml.namespace.QName("", "prepaidAmount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("prepaidDirectExpense");
        elemField.setXmlName(new javax.xml.namespace.QName("", "prepaidDirectExpense"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("prepayCaseNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("", "prepayCaseNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("serialNo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "serialNo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
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
