/**
 * PrepaidPayMainInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.sinosoft.aip.webservice.server;

public class PrepaidPayMainInfo  implements java.io.Serializable {
    private java.lang.String claimNumber;

    private java.lang.String companyCode;

    private java.lang.String payeeAccountNumber;

    private java.lang.String payeeBankName;

    private java.lang.String payeeDepositBank;

    private java.lang.String payeeName;

    private java.lang.String policyNumber;

    private java.util.Calendar prepaidDate;

    private java.lang.Double prepayAmount;

    private java.lang.String prepayCaseNumber;

    private java.util.Calendar prepayDate;

    private java.lang.String prepayExpenseType;

    private java.lang.Integer serialNo;

    public PrepaidPayMainInfo() {
    }

    public PrepaidPayMainInfo(
           java.lang.String claimNumber,
           java.lang.String companyCode,
           java.lang.String payeeAccountNumber,
           java.lang.String payeeBankName,
           java.lang.String payeeDepositBank,
           java.lang.String payeeName,
           java.lang.String policyNumber,
           java.util.Calendar prepaidDate,
           java.lang.Double prepayAmount,
           java.lang.String prepayCaseNumber,
           java.util.Calendar prepayDate,
           java.lang.String prepayExpenseType,
           java.lang.Integer serialNo) {
           this.claimNumber = claimNumber;
           this.companyCode = companyCode;
           this.payeeAccountNumber = payeeAccountNumber;
           this.payeeBankName = payeeBankName;
           this.payeeDepositBank = payeeDepositBank;
           this.payeeName = payeeName;
           this.policyNumber = policyNumber;
           this.prepaidDate = prepaidDate;
           this.prepayAmount = prepayAmount;
           this.prepayCaseNumber = prepayCaseNumber;
           this.prepayDate = prepayDate;
           this.prepayExpenseType = prepayExpenseType;
           this.serialNo = serialNo;
    }


    /**
     * Gets the claimNumber value for this PrepaidPayMainInfo.
     * 
     * @return claimNumber
     */
    public java.lang.String getClaimNumber() {
        return claimNumber;
    }


    /**
     * Sets the claimNumber value for this PrepaidPayMainInfo.
     * 
     * @param claimNumber
     */
    public void setClaimNumber(java.lang.String claimNumber) {
        this.claimNumber = claimNumber;
    }


    /**
     * Gets the companyCode value for this PrepaidPayMainInfo.
     * 
     * @return companyCode
     */
    public java.lang.String getCompanyCode() {
        return companyCode;
    }


    /**
     * Sets the companyCode value for this PrepaidPayMainInfo.
     * 
     * @param companyCode
     */
    public void setCompanyCode(java.lang.String companyCode) {
        this.companyCode = companyCode;
    }


    /**
     * Gets the payeeAccountNumber value for this PrepaidPayMainInfo.
     * 
     * @return payeeAccountNumber
     */
    public java.lang.String getPayeeAccountNumber() {
        return payeeAccountNumber;
    }


    /**
     * Sets the payeeAccountNumber value for this PrepaidPayMainInfo.
     * 
     * @param payeeAccountNumber
     */
    public void setPayeeAccountNumber(java.lang.String payeeAccountNumber) {
        this.payeeAccountNumber = payeeAccountNumber;
    }


    /**
     * Gets the payeeBankName value for this PrepaidPayMainInfo.
     * 
     * @return payeeBankName
     */
    public java.lang.String getPayeeBankName() {
        return payeeBankName;
    }


    /**
     * Sets the payeeBankName value for this PrepaidPayMainInfo.
     * 
     * @param payeeBankName
     */
    public void setPayeeBankName(java.lang.String payeeBankName) {
        this.payeeBankName = payeeBankName;
    }


    /**
     * Gets the payeeDepositBank value for this PrepaidPayMainInfo.
     * 
     * @return payeeDepositBank
     */
    public java.lang.String getPayeeDepositBank() {
        return payeeDepositBank;
    }


    /**
     * Sets the payeeDepositBank value for this PrepaidPayMainInfo.
     * 
     * @param payeeDepositBank
     */
    public void setPayeeDepositBank(java.lang.String payeeDepositBank) {
        this.payeeDepositBank = payeeDepositBank;
    }


    /**
     * Gets the payeeName value for this PrepaidPayMainInfo.
     * 
     * @return payeeName
     */
    public java.lang.String getPayeeName() {
        return payeeName;
    }


    /**
     * Sets the payeeName value for this PrepaidPayMainInfo.
     * 
     * @param payeeName
     */
    public void setPayeeName(java.lang.String payeeName) {
        this.payeeName = payeeName;
    }


    /**
     * Gets the policyNumber value for this PrepaidPayMainInfo.
     * 
     * @return policyNumber
     */
    public java.lang.String getPolicyNumber() {
        return policyNumber;
    }


    /**
     * Sets the policyNumber value for this PrepaidPayMainInfo.
     * 
     * @param policyNumber
     */
    public void setPolicyNumber(java.lang.String policyNumber) {
        this.policyNumber = policyNumber;
    }


    /**
     * Gets the prepaidDate value for this PrepaidPayMainInfo.
     * 
     * @return prepaidDate
     */
    public java.util.Calendar getPrepaidDate() {
        return prepaidDate;
    }


    /**
     * Sets the prepaidDate value for this PrepaidPayMainInfo.
     * 
     * @param prepaidDate
     */
    public void setPrepaidDate(java.util.Calendar prepaidDate) {
        this.prepaidDate = prepaidDate;
    }


    /**
     * Gets the prepayAmount value for this PrepaidPayMainInfo.
     * 
     * @return prepayAmount
     */
    public java.lang.Double getPrepayAmount() {
        return prepayAmount;
    }


    /**
     * Sets the prepayAmount value for this PrepaidPayMainInfo.
     * 
     * @param prepayAmount
     */
    public void setPrepayAmount(java.lang.Double prepayAmount) {
        this.prepayAmount = prepayAmount;
    }


    /**
     * Gets the prepayCaseNumber value for this PrepaidPayMainInfo.
     * 
     * @return prepayCaseNumber
     */
    public java.lang.String getPrepayCaseNumber() {
        return prepayCaseNumber;
    }


    /**
     * Sets the prepayCaseNumber value for this PrepaidPayMainInfo.
     * 
     * @param prepayCaseNumber
     */
    public void setPrepayCaseNumber(java.lang.String prepayCaseNumber) {
        this.prepayCaseNumber = prepayCaseNumber;
    }


    /**
     * Gets the prepayDate value for this PrepaidPayMainInfo.
     * 
     * @return prepayDate
     */
    public java.util.Calendar getPrepayDate() {
        return prepayDate;
    }


    /**
     * Sets the prepayDate value for this PrepaidPayMainInfo.
     * 
     * @param prepayDate
     */
    public void setPrepayDate(java.util.Calendar prepayDate) {
        this.prepayDate = prepayDate;
    }


    /**
     * Gets the prepayExpenseType value for this PrepaidPayMainInfo.
     * 
     * @return prepayExpenseType
     */
    public java.lang.String getPrepayExpenseType() {
        return prepayExpenseType;
    }


    /**
     * Sets the prepayExpenseType value for this PrepaidPayMainInfo.
     * 
     * @param prepayExpenseType
     */
    public void setPrepayExpenseType(java.lang.String prepayExpenseType) {
        this.prepayExpenseType = prepayExpenseType;
    }


    /**
     * Gets the serialNo value for this PrepaidPayMainInfo.
     * 
     * @return serialNo
     */
    public java.lang.Integer getSerialNo() {
        return serialNo;
    }


    /**
     * Sets the serialNo value for this PrepaidPayMainInfo.
     * 
     * @param serialNo
     */
    public void setSerialNo(java.lang.Integer serialNo) {
        this.serialNo = serialNo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PrepaidPayMainInfo)) return false;
        PrepaidPayMainInfo other = (PrepaidPayMainInfo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.claimNumber==null && other.getClaimNumber()==null) || 
             (this.claimNumber!=null &&
              this.claimNumber.equals(other.getClaimNumber()))) &&
            ((this.companyCode==null && other.getCompanyCode()==null) || 
             (this.companyCode!=null &&
              this.companyCode.equals(other.getCompanyCode()))) &&
            ((this.payeeAccountNumber==null && other.getPayeeAccountNumber()==null) || 
             (this.payeeAccountNumber!=null &&
              this.payeeAccountNumber.equals(other.getPayeeAccountNumber()))) &&
            ((this.payeeBankName==null && other.getPayeeBankName()==null) || 
             (this.payeeBankName!=null &&
              this.payeeBankName.equals(other.getPayeeBankName()))) &&
            ((this.payeeDepositBank==null && other.getPayeeDepositBank()==null) || 
             (this.payeeDepositBank!=null &&
              this.payeeDepositBank.equals(other.getPayeeDepositBank()))) &&
            ((this.payeeName==null && other.getPayeeName()==null) || 
             (this.payeeName!=null &&
              this.payeeName.equals(other.getPayeeName()))) &&
            ((this.policyNumber==null && other.getPolicyNumber()==null) || 
             (this.policyNumber!=null &&
              this.policyNumber.equals(other.getPolicyNumber()))) &&
            ((this.prepaidDate==null && other.getPrepaidDate()==null) || 
             (this.prepaidDate!=null &&
              this.prepaidDate.equals(other.getPrepaidDate()))) &&
            ((this.prepayAmount==null && other.getPrepayAmount()==null) || 
             (this.prepayAmount!=null &&
              this.prepayAmount.equals(other.getPrepayAmount()))) &&
            ((this.prepayCaseNumber==null && other.getPrepayCaseNumber()==null) || 
             (this.prepayCaseNumber!=null &&
              this.prepayCaseNumber.equals(other.getPrepayCaseNumber()))) &&
            ((this.prepayDate==null && other.getPrepayDate()==null) || 
             (this.prepayDate!=null &&
              this.prepayDate.equals(other.getPrepayDate()))) &&
            ((this.prepayExpenseType==null && other.getPrepayExpenseType()==null) || 
             (this.prepayExpenseType!=null &&
              this.prepayExpenseType.equals(other.getPrepayExpenseType()))) &&
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
        if (getClaimNumber() != null) {
            _hashCode += getClaimNumber().hashCode();
        }
        if (getCompanyCode() != null) {
            _hashCode += getCompanyCode().hashCode();
        }
        if (getPayeeAccountNumber() != null) {
            _hashCode += getPayeeAccountNumber().hashCode();
        }
        if (getPayeeBankName() != null) {
            _hashCode += getPayeeBankName().hashCode();
        }
        if (getPayeeDepositBank() != null) {
            _hashCode += getPayeeDepositBank().hashCode();
        }
        if (getPayeeName() != null) {
            _hashCode += getPayeeName().hashCode();
        }
        if (getPolicyNumber() != null) {
            _hashCode += getPolicyNumber().hashCode();
        }
        if (getPrepaidDate() != null) {
            _hashCode += getPrepaidDate().hashCode();
        }
        if (getPrepayAmount() != null) {
            _hashCode += getPrepayAmount().hashCode();
        }
        if (getPrepayCaseNumber() != null) {
            _hashCode += getPrepayCaseNumber().hashCode();
        }
        if (getPrepayDate() != null) {
            _hashCode += getPrepayDate().hashCode();
        }
        if (getPrepayExpenseType() != null) {
            _hashCode += getPrepayExpenseType().hashCode();
        }
        if (getSerialNo() != null) {
            _hashCode += getSerialNo().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PrepaidPayMainInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "prepaidPayMainInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("claimNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("", "claimNumber"));
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
        elemField.setFieldName("payeeAccountNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("", "payeeAccountNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("payeeBankName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "payeeBankName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("payeeDepositBank");
        elemField.setXmlName(new javax.xml.namespace.QName("", "payeeDepositBank"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("payeeName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "payeeName"));
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
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("prepaidDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "prepaidDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("prepayAmount");
        elemField.setXmlName(new javax.xml.namespace.QName("", "prepayAmount"));
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
        elemField.setFieldName("prepayDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "prepayDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("prepayExpenseType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "prepayExpenseType"));
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
