/**
 * EndorsementInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.sinosoft.aip.webservice.server;

public class EndorsementInfo  implements java.io.Serializable {
    private java.lang.String companyCode;

    private java.lang.String confirmSequenceNo;

    private java.util.Calendar endorsementDate;

    private java.lang.String endorsementNumber;

    private java.lang.String endorsementReason;

    private com.sinosoft.aip.webservice.server.EndorsementTypeInfo[] endorsementTypeInfoList;

    private java.util.Calendar endorsementUnderwritingDate;

    private java.util.Calendar endorsementValidateDate;

    private java.lang.Double famersNumberChangeAmount;

    private java.lang.Long farmerCount;

    private java.lang.Double objectNumberChangeAmount;

    private java.lang.String policyNumber;

    private java.lang.Double premiumChangeAmount;

    private java.lang.Double sumInsuredChangeAmount;

    public EndorsementInfo() {
    }

    public EndorsementInfo(
           java.lang.String companyCode,
           java.lang.String confirmSequenceNo,
           java.util.Calendar endorsementDate,
           java.lang.String endorsementNumber,
           java.lang.String endorsementReason,
           com.sinosoft.aip.webservice.server.EndorsementTypeInfo[] endorsementTypeInfoList,
           java.util.Calendar endorsementUnderwritingDate,
           java.util.Calendar endorsementValidateDate,
           java.lang.Double famersNumberChangeAmount,
           java.lang.Long farmerCount,
           java.lang.Double objectNumberChangeAmount,
           java.lang.String policyNumber,
           java.lang.Double premiumChangeAmount,
           java.lang.Double sumInsuredChangeAmount) {
           this.companyCode = companyCode;
           this.confirmSequenceNo = confirmSequenceNo;
           this.endorsementDate = endorsementDate;
           this.endorsementNumber = endorsementNumber;
           this.endorsementReason = endorsementReason;
           this.endorsementTypeInfoList = endorsementTypeInfoList;
           this.endorsementUnderwritingDate = endorsementUnderwritingDate;
           this.endorsementValidateDate = endorsementValidateDate;
           this.famersNumberChangeAmount = famersNumberChangeAmount;
           this.farmerCount = farmerCount;
           this.objectNumberChangeAmount = objectNumberChangeAmount;
           this.policyNumber = policyNumber;
           this.premiumChangeAmount = premiumChangeAmount;
           this.sumInsuredChangeAmount = sumInsuredChangeAmount;
    }


    /**
     * Gets the companyCode value for this EndorsementInfo.
     * 
     * @return companyCode
     */
    public java.lang.String getCompanyCode() {
        return companyCode;
    }


    /**
     * Sets the companyCode value for this EndorsementInfo.
     * 
     * @param companyCode
     */
    public void setCompanyCode(java.lang.String companyCode) {
        this.companyCode = companyCode;
    }


    /**
     * Gets the confirmSequenceNo value for this EndorsementInfo.
     * 
     * @return confirmSequenceNo
     */
    public java.lang.String getConfirmSequenceNo() {
        return confirmSequenceNo;
    }


    /**
     * Sets the confirmSequenceNo value for this EndorsementInfo.
     * 
     * @param confirmSequenceNo
     */
    public void setConfirmSequenceNo(java.lang.String confirmSequenceNo) {
        this.confirmSequenceNo = confirmSequenceNo;
    }


    /**
     * Gets the endorsementDate value for this EndorsementInfo.
     * 
     * @return endorsementDate
     */
    public java.util.Calendar getEndorsementDate() {
        return endorsementDate;
    }


    /**
     * Sets the endorsementDate value for this EndorsementInfo.
     * 
     * @param endorsementDate
     */
    public void setEndorsementDate(java.util.Calendar endorsementDate) {
        this.endorsementDate = endorsementDate;
    }


    /**
     * Gets the endorsementNumber value for this EndorsementInfo.
     * 
     * @return endorsementNumber
     */
    public java.lang.String getEndorsementNumber() {
        return endorsementNumber;
    }


    /**
     * Sets the endorsementNumber value for this EndorsementInfo.
     * 
     * @param endorsementNumber
     */
    public void setEndorsementNumber(java.lang.String endorsementNumber) {
        this.endorsementNumber = endorsementNumber;
    }


    /**
     * Gets the endorsementReason value for this EndorsementInfo.
     * 
     * @return endorsementReason
     */
    public java.lang.String getEndorsementReason() {
        return endorsementReason;
    }


    /**
     * Sets the endorsementReason value for this EndorsementInfo.
     * 
     * @param endorsementReason
     */
    public void setEndorsementReason(java.lang.String endorsementReason) {
        this.endorsementReason = endorsementReason;
    }


    /**
     * Gets the endorsementTypeInfoList value for this EndorsementInfo.
     * 
     * @return endorsementTypeInfoList
     */
    public com.sinosoft.aip.webservice.server.EndorsementTypeInfo[] getEndorsementTypeInfoList() {
        return endorsementTypeInfoList;
    }


    /**
     * Sets the endorsementTypeInfoList value for this EndorsementInfo.
     * 
     * @param endorsementTypeInfoList
     */
    public void setEndorsementTypeInfoList(com.sinosoft.aip.webservice.server.EndorsementTypeInfo[] endorsementTypeInfoList) {
        this.endorsementTypeInfoList = endorsementTypeInfoList;
    }

    public com.sinosoft.aip.webservice.server.EndorsementTypeInfo getEndorsementTypeInfoList(int i) {
        return this.endorsementTypeInfoList[i];
    }

    public void setEndorsementTypeInfoList(int i, com.sinosoft.aip.webservice.server.EndorsementTypeInfo _value) {
        this.endorsementTypeInfoList[i] = _value;
    }


    /**
     * Gets the endorsementUnderwritingDate value for this EndorsementInfo.
     * 
     * @return endorsementUnderwritingDate
     */
    public java.util.Calendar getEndorsementUnderwritingDate() {
        return endorsementUnderwritingDate;
    }


    /**
     * Sets the endorsementUnderwritingDate value for this EndorsementInfo.
     * 
     * @param endorsementUnderwritingDate
     */
    public void setEndorsementUnderwritingDate(java.util.Calendar endorsementUnderwritingDate) {
        this.endorsementUnderwritingDate = endorsementUnderwritingDate;
    }


    /**
     * Gets the endorsementValidateDate value for this EndorsementInfo.
     * 
     * @return endorsementValidateDate
     */
    public java.util.Calendar getEndorsementValidateDate() {
        return endorsementValidateDate;
    }


    /**
     * Sets the endorsementValidateDate value for this EndorsementInfo.
     * 
     * @param endorsementValidateDate
     */
    public void setEndorsementValidateDate(java.util.Calendar endorsementValidateDate) {
        this.endorsementValidateDate = endorsementValidateDate;
    }


    /**
     * Gets the famersNumberChangeAmount value for this EndorsementInfo.
     * 
     * @return famersNumberChangeAmount
     */
    public java.lang.Double getFamersNumberChangeAmount() {
        return famersNumberChangeAmount;
    }


    /**
     * Sets the famersNumberChangeAmount value for this EndorsementInfo.
     * 
     * @param famersNumberChangeAmount
     */
    public void setFamersNumberChangeAmount(java.lang.Double famersNumberChangeAmount) {
        this.famersNumberChangeAmount = famersNumberChangeAmount;
    }


    /**
     * Gets the farmerCount value for this EndorsementInfo.
     * 
     * @return farmerCount
     */
    public java.lang.Long getFarmerCount() {
        return farmerCount;
    }


    /**
     * Sets the farmerCount value for this EndorsementInfo.
     * 
     * @param farmerCount
     */
    public void setFarmerCount(java.lang.Long farmerCount) {
        this.farmerCount = farmerCount;
    }


    /**
     * Gets the objectNumberChangeAmount value for this EndorsementInfo.
     * 
     * @return objectNumberChangeAmount
     */
    public java.lang.Double getObjectNumberChangeAmount() {
        return objectNumberChangeAmount;
    }


    /**
     * Sets the objectNumberChangeAmount value for this EndorsementInfo.
     * 
     * @param objectNumberChangeAmount
     */
    public void setObjectNumberChangeAmount(java.lang.Double objectNumberChangeAmount) {
        this.objectNumberChangeAmount = objectNumberChangeAmount;
    }


    /**
     * Gets the policyNumber value for this EndorsementInfo.
     * 
     * @return policyNumber
     */
    public java.lang.String getPolicyNumber() {
        return policyNumber;
    }


    /**
     * Sets the policyNumber value for this EndorsementInfo.
     * 
     * @param policyNumber
     */
    public void setPolicyNumber(java.lang.String policyNumber) {
        this.policyNumber = policyNumber;
    }


    /**
     * Gets the premiumChangeAmount value for this EndorsementInfo.
     * 
     * @return premiumChangeAmount
     */
    public java.lang.Double getPremiumChangeAmount() {
        return premiumChangeAmount;
    }


    /**
     * Sets the premiumChangeAmount value for this EndorsementInfo.
     * 
     * @param premiumChangeAmount
     */
    public void setPremiumChangeAmount(java.lang.Double premiumChangeAmount) {
        this.premiumChangeAmount = premiumChangeAmount;
    }


    /**
     * Gets the sumInsuredChangeAmount value for this EndorsementInfo.
     * 
     * @return sumInsuredChangeAmount
     */
    public java.lang.Double getSumInsuredChangeAmount() {
        return sumInsuredChangeAmount;
    }


    /**
     * Sets the sumInsuredChangeAmount value for this EndorsementInfo.
     * 
     * @param sumInsuredChangeAmount
     */
    public void setSumInsuredChangeAmount(java.lang.Double sumInsuredChangeAmount) {
        this.sumInsuredChangeAmount = sumInsuredChangeAmount;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof EndorsementInfo)) return false;
        EndorsementInfo other = (EndorsementInfo) obj;
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
            ((this.endorsementDate==null && other.getEndorsementDate()==null) || 
             (this.endorsementDate!=null &&
              this.endorsementDate.equals(other.getEndorsementDate()))) &&
            ((this.endorsementNumber==null && other.getEndorsementNumber()==null) || 
             (this.endorsementNumber!=null &&
              this.endorsementNumber.equals(other.getEndorsementNumber()))) &&
            ((this.endorsementReason==null && other.getEndorsementReason()==null) || 
             (this.endorsementReason!=null &&
              this.endorsementReason.equals(other.getEndorsementReason()))) &&
            ((this.endorsementTypeInfoList==null && other.getEndorsementTypeInfoList()==null) || 
             (this.endorsementTypeInfoList!=null &&
              java.util.Arrays.equals(this.endorsementTypeInfoList, other.getEndorsementTypeInfoList()))) &&
            ((this.endorsementUnderwritingDate==null && other.getEndorsementUnderwritingDate()==null) || 
             (this.endorsementUnderwritingDate!=null &&
              this.endorsementUnderwritingDate.equals(other.getEndorsementUnderwritingDate()))) &&
            ((this.endorsementValidateDate==null && other.getEndorsementValidateDate()==null) || 
             (this.endorsementValidateDate!=null &&
              this.endorsementValidateDate.equals(other.getEndorsementValidateDate()))) &&
            ((this.famersNumberChangeAmount==null && other.getFamersNumberChangeAmount()==null) || 
             (this.famersNumberChangeAmount!=null &&
              this.famersNumberChangeAmount.equals(other.getFamersNumberChangeAmount()))) &&
            ((this.farmerCount==null && other.getFarmerCount()==null) || 
             (this.farmerCount!=null &&
              this.farmerCount.equals(other.getFarmerCount()))) &&
            ((this.objectNumberChangeAmount==null && other.getObjectNumberChangeAmount()==null) || 
             (this.objectNumberChangeAmount!=null &&
              this.objectNumberChangeAmount.equals(other.getObjectNumberChangeAmount()))) &&
            ((this.policyNumber==null && other.getPolicyNumber()==null) || 
             (this.policyNumber!=null &&
              this.policyNumber.equals(other.getPolicyNumber()))) &&
            ((this.premiumChangeAmount==null && other.getPremiumChangeAmount()==null) || 
             (this.premiumChangeAmount!=null &&
              this.premiumChangeAmount.equals(other.getPremiumChangeAmount()))) &&
            ((this.sumInsuredChangeAmount==null && other.getSumInsuredChangeAmount()==null) || 
             (this.sumInsuredChangeAmount!=null &&
              this.sumInsuredChangeAmount.equals(other.getSumInsuredChangeAmount())));
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
        if (getEndorsementDate() != null) {
            _hashCode += getEndorsementDate().hashCode();
        }
        if (getEndorsementNumber() != null) {
            _hashCode += getEndorsementNumber().hashCode();
        }
        if (getEndorsementReason() != null) {
            _hashCode += getEndorsementReason().hashCode();
        }
        if (getEndorsementTypeInfoList() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getEndorsementTypeInfoList());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getEndorsementTypeInfoList(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getEndorsementUnderwritingDate() != null) {
            _hashCode += getEndorsementUnderwritingDate().hashCode();
        }
        if (getEndorsementValidateDate() != null) {
            _hashCode += getEndorsementValidateDate().hashCode();
        }
        if (getFamersNumberChangeAmount() != null) {
            _hashCode += getFamersNumberChangeAmount().hashCode();
        }
        if (getFarmerCount() != null) {
            _hashCode += getFarmerCount().hashCode();
        }
        if (getObjectNumberChangeAmount() != null) {
            _hashCode += getObjectNumberChangeAmount().hashCode();
        }
        if (getPolicyNumber() != null) {
            _hashCode += getPolicyNumber().hashCode();
        }
        if (getPremiumChangeAmount() != null) {
            _hashCode += getPremiumChangeAmount().hashCode();
        }
        if (getSumInsuredChangeAmount() != null) {
            _hashCode += getSumInsuredChangeAmount().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(EndorsementInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "endorsementInfo"));
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
        elemField.setFieldName("endorsementDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "endorsementDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("endorsementNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("", "endorsementNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("endorsementReason");
        elemField.setXmlName(new javax.xml.namespace.QName("", "endorsementReason"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("endorsementTypeInfoList");
        elemField.setXmlName(new javax.xml.namespace.QName("", "endorsementTypeInfoList"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "endorsementTypeInfo"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("endorsementUnderwritingDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "endorsementUnderwritingDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("endorsementValidateDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "endorsementValidateDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("famersNumberChangeAmount");
        elemField.setXmlName(new javax.xml.namespace.QName("", "famersNumberChangeAmount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
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
        elemField.setFieldName("objectNumberChangeAmount");
        elemField.setXmlName(new javax.xml.namespace.QName("", "objectNumberChangeAmount"));
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
        elemField.setFieldName("premiumChangeAmount");
        elemField.setXmlName(new javax.xml.namespace.QName("", "premiumChangeAmount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sumInsuredChangeAmount");
        elemField.setXmlName(new javax.xml.namespace.QName("", "sumInsuredChangeAmount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
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
