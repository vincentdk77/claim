/**
 * ReturnedBillMainInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.sinosoft.aip.webservice.server;

public class ReturnedBillMainInfo  implements java.io.Serializable {
    private java.lang.String caseNumber;

    private java.lang.String companyCode;

    private java.lang.String confirmSequenceNo;

    private java.lang.Long farmerCount;

    private java.lang.String policyNumber;

    private java.lang.Double returnedBillAmount;

    private java.util.Calendar returnedBillDate;

    private java.lang.String returnedBillType;

    private java.lang.Integer serialNo;

    public ReturnedBillMainInfo() {
    }

    public ReturnedBillMainInfo(
           java.lang.String caseNumber,
           java.lang.String companyCode,
           java.lang.String confirmSequenceNo,
           java.lang.Long farmerCount,
           java.lang.String policyNumber,
           java.lang.Double returnedBillAmount,
           java.util.Calendar returnedBillDate,
           java.lang.String returnedBillType,
           java.lang.Integer serialNo) {
           this.caseNumber = caseNumber;
           this.companyCode = companyCode;
           this.confirmSequenceNo = confirmSequenceNo;
           this.farmerCount = farmerCount;
           this.policyNumber = policyNumber;
           this.returnedBillAmount = returnedBillAmount;
           this.returnedBillDate = returnedBillDate;
           this.returnedBillType = returnedBillType;
           this.serialNo = serialNo;
    }


    /**
     * Gets the caseNumber value for this ReturnedBillMainInfo.
     * 
     * @return caseNumber
     */
    public java.lang.String getCaseNumber() {
        return caseNumber;
    }


    /**
     * Sets the caseNumber value for this ReturnedBillMainInfo.
     * 
     * @param caseNumber
     */
    public void setCaseNumber(java.lang.String caseNumber) {
        this.caseNumber = caseNumber;
    }


    /**
     * Gets the companyCode value for this ReturnedBillMainInfo.
     * 
     * @return companyCode
     */
    public java.lang.String getCompanyCode() {
        return companyCode;
    }


    /**
     * Sets the companyCode value for this ReturnedBillMainInfo.
     * 
     * @param companyCode
     */
    public void setCompanyCode(java.lang.String companyCode) {
        this.companyCode = companyCode;
    }


    /**
     * Gets the confirmSequenceNo value for this ReturnedBillMainInfo.
     * 
     * @return confirmSequenceNo
     */
    public java.lang.String getConfirmSequenceNo() {
        return confirmSequenceNo;
    }


    /**
     * Sets the confirmSequenceNo value for this ReturnedBillMainInfo.
     * 
     * @param confirmSequenceNo
     */
    public void setConfirmSequenceNo(java.lang.String confirmSequenceNo) {
        this.confirmSequenceNo = confirmSequenceNo;
    }


    /**
     * Gets the farmerCount value for this ReturnedBillMainInfo.
     * 
     * @return farmerCount
     */
    public java.lang.Long getFarmerCount() {
        return farmerCount;
    }


    /**
     * Sets the farmerCount value for this ReturnedBillMainInfo.
     * 
     * @param farmerCount
     */
    public void setFarmerCount(java.lang.Long farmerCount) {
        this.farmerCount = farmerCount;
    }


    /**
     * Gets the policyNumber value for this ReturnedBillMainInfo.
     * 
     * @return policyNumber
     */
    public java.lang.String getPolicyNumber() {
        return policyNumber;
    }


    /**
     * Sets the policyNumber value for this ReturnedBillMainInfo.
     * 
     * @param policyNumber
     */
    public void setPolicyNumber(java.lang.String policyNumber) {
        this.policyNumber = policyNumber;
    }


    /**
     * Gets the returnedBillAmount value for this ReturnedBillMainInfo.
     * 
     * @return returnedBillAmount
     */
    public java.lang.Double getReturnedBillAmount() {
        return returnedBillAmount;
    }


    /**
     * Sets the returnedBillAmount value for this ReturnedBillMainInfo.
     * 
     * @param returnedBillAmount
     */
    public void setReturnedBillAmount(java.lang.Double returnedBillAmount) {
        this.returnedBillAmount = returnedBillAmount;
    }


    /**
     * Gets the returnedBillDate value for this ReturnedBillMainInfo.
     * 
     * @return returnedBillDate
     */
    public java.util.Calendar getReturnedBillDate() {
        return returnedBillDate;
    }


    /**
     * Sets the returnedBillDate value for this ReturnedBillMainInfo.
     * 
     * @param returnedBillDate
     */
    public void setReturnedBillDate(java.util.Calendar returnedBillDate) {
        this.returnedBillDate = returnedBillDate;
    }


    /**
     * Gets the returnedBillType value for this ReturnedBillMainInfo.
     * 
     * @return returnedBillType
     */
    public java.lang.String getReturnedBillType() {
        return returnedBillType;
    }


    /**
     * Sets the returnedBillType value for this ReturnedBillMainInfo.
     * 
     * @param returnedBillType
     */
    public void setReturnedBillType(java.lang.String returnedBillType) {
        this.returnedBillType = returnedBillType;
    }


    /**
     * Gets the serialNo value for this ReturnedBillMainInfo.
     * 
     * @return serialNo
     */
    public java.lang.Integer getSerialNo() {
        return serialNo;
    }


    /**
     * Sets the serialNo value for this ReturnedBillMainInfo.
     * 
     * @param serialNo
     */
    public void setSerialNo(java.lang.Integer serialNo) {
        this.serialNo = serialNo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ReturnedBillMainInfo)) return false;
        ReturnedBillMainInfo other = (ReturnedBillMainInfo) obj;
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
            ((this.companyCode==null && other.getCompanyCode()==null) || 
             (this.companyCode!=null &&
              this.companyCode.equals(other.getCompanyCode()))) &&
            ((this.confirmSequenceNo==null && other.getConfirmSequenceNo()==null) || 
             (this.confirmSequenceNo!=null &&
              this.confirmSequenceNo.equals(other.getConfirmSequenceNo()))) &&
            ((this.farmerCount==null && other.getFarmerCount()==null) || 
             (this.farmerCount!=null &&
              this.farmerCount.equals(other.getFarmerCount()))) &&
            ((this.policyNumber==null && other.getPolicyNumber()==null) || 
             (this.policyNumber!=null &&
              this.policyNumber.equals(other.getPolicyNumber()))) &&
            ((this.returnedBillAmount==null && other.getReturnedBillAmount()==null) || 
             (this.returnedBillAmount!=null &&
              this.returnedBillAmount.equals(other.getReturnedBillAmount()))) &&
            ((this.returnedBillDate==null && other.getReturnedBillDate()==null) || 
             (this.returnedBillDate!=null &&
              this.returnedBillDate.equals(other.getReturnedBillDate()))) &&
            ((this.returnedBillType==null && other.getReturnedBillType()==null) || 
             (this.returnedBillType!=null &&
              this.returnedBillType.equals(other.getReturnedBillType()))) &&
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
        if (getCompanyCode() != null) {
            _hashCode += getCompanyCode().hashCode();
        }
        if (getConfirmSequenceNo() != null) {
            _hashCode += getConfirmSequenceNo().hashCode();
        }
        if (getFarmerCount() != null) {
            _hashCode += getFarmerCount().hashCode();
        }
        if (getPolicyNumber() != null) {
            _hashCode += getPolicyNumber().hashCode();
        }
        if (getReturnedBillAmount() != null) {
            _hashCode += getReturnedBillAmount().hashCode();
        }
        if (getReturnedBillDate() != null) {
            _hashCode += getReturnedBillDate().hashCode();
        }
        if (getReturnedBillType() != null) {
            _hashCode += getReturnedBillType().hashCode();
        }
        if (getSerialNo() != null) {
            _hashCode += getSerialNo().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ReturnedBillMainInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "returnedBillMainInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("caseNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("", "caseNumber"));
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
        elemField.setFieldName("policyNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("", "policyNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("returnedBillAmount");
        elemField.setXmlName(new javax.xml.namespace.QName("", "returnedBillAmount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("returnedBillDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "returnedBillDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("returnedBillType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "returnedBillType"));
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
