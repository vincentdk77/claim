/**
 * DirectExpenseInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.sinosoft.aip.webservice.server;

public class DirectExpenseInfo  implements java.io.Serializable {
    private java.lang.String caseNumber;

    private java.lang.Integer claimSerialNo;

    private java.lang.Double paidDirectExpense;

    private java.lang.String policyNumber;

    private java.lang.Long serialNo;

    public DirectExpenseInfo() {
    }

    public DirectExpenseInfo(
           java.lang.String caseNumber,
           java.lang.Integer claimSerialNo,
           java.lang.Double paidDirectExpense,
           java.lang.String policyNumber,
           java.lang.Long serialNo) {
           this.caseNumber = caseNumber;
           this.claimSerialNo = claimSerialNo;
           this.paidDirectExpense = paidDirectExpense;
           this.policyNumber = policyNumber;
           this.serialNo = serialNo;
    }


    /**
     * Gets the caseNumber value for this DirectExpenseInfo.
     * 
     * @return caseNumber
     */
    public java.lang.String getCaseNumber() {
        return caseNumber;
    }


    /**
     * Sets the caseNumber value for this DirectExpenseInfo.
     * 
     * @param caseNumber
     */
    public void setCaseNumber(java.lang.String caseNumber) {
        this.caseNumber = caseNumber;
    }


    /**
     * Gets the claimSerialNo value for this DirectExpenseInfo.
     * 
     * @return claimSerialNo
     */
    public java.lang.Integer getClaimSerialNo() {
        return claimSerialNo;
    }


    /**
     * Sets the claimSerialNo value for this DirectExpenseInfo.
     * 
     * @param claimSerialNo
     */
    public void setClaimSerialNo(java.lang.Integer claimSerialNo) {
        this.claimSerialNo = claimSerialNo;
    }


    /**
     * Gets the paidDirectExpense value for this DirectExpenseInfo.
     * 
     * @return paidDirectExpense
     */
    public java.lang.Double getPaidDirectExpense() {
        return paidDirectExpense;
    }


    /**
     * Sets the paidDirectExpense value for this DirectExpenseInfo.
     * 
     * @param paidDirectExpense
     */
    public void setPaidDirectExpense(java.lang.Double paidDirectExpense) {
        this.paidDirectExpense = paidDirectExpense;
    }


    /**
     * Gets the policyNumber value for this DirectExpenseInfo.
     * 
     * @return policyNumber
     */
    public java.lang.String getPolicyNumber() {
        return policyNumber;
    }


    /**
     * Sets the policyNumber value for this DirectExpenseInfo.
     * 
     * @param policyNumber
     */
    public void setPolicyNumber(java.lang.String policyNumber) {
        this.policyNumber = policyNumber;
    }


    /**
     * Gets the serialNo value for this DirectExpenseInfo.
     * 
     * @return serialNo
     */
    public java.lang.Long getSerialNo() {
        return serialNo;
    }


    /**
     * Sets the serialNo value for this DirectExpenseInfo.
     * 
     * @param serialNo
     */
    public void setSerialNo(java.lang.Long serialNo) {
        this.serialNo = serialNo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DirectExpenseInfo)) return false;
        DirectExpenseInfo other = (DirectExpenseInfo) obj;
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
            ((this.claimSerialNo==null && other.getClaimSerialNo()==null) || 
             (this.claimSerialNo!=null &&
              this.claimSerialNo.equals(other.getClaimSerialNo()))) &&
            ((this.paidDirectExpense==null && other.getPaidDirectExpense()==null) || 
             (this.paidDirectExpense!=null &&
              this.paidDirectExpense.equals(other.getPaidDirectExpense()))) &&
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
        if (getClaimSerialNo() != null) {
            _hashCode += getClaimSerialNo().hashCode();
        }
        if (getPaidDirectExpense() != null) {
            _hashCode += getPaidDirectExpense().hashCode();
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
        new org.apache.axis.description.TypeDesc(DirectExpenseInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "directExpenseInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("caseNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("", "caseNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("claimSerialNo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "claimSerialNo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
        elemField.setFieldName("policyNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("", "policyNumber"));
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
