/**
 * CaseMainInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.sinosoft.aip.webservice.server;

import com.sinosoft.sysframework.common.datatype.DateTime;

public class CaseMainInfo  implements java.io.Serializable {
    private java.lang.Double affectedArea;

    private DateTime assessmentDate;

    private java.lang.String caseNumber;

    private java.lang.Double claimAmout;

    private java.lang.String claimNumber;

    private java.lang.String claimSequenceNo;

    private java.lang.String companyCode;

    private java.lang.Double damagedArea;

    private java.lang.Double directExpense;

    private java.lang.Long farmerCount;

    private java.lang.String lawsuitFlag;

    
    private java.lang.Double lossArea;

    private java.lang.String measuremantUnit;

    private java.lang.String policyNumber;

    private java.lang.Double prepaidAmount;

    private java.lang.Double prepaidDirectExpense;

    private java.lang.Integer reopenedTimes;

    private java.lang.String reopenedType;

    private java.lang.Double setteledAmount;

    private java.lang.Double setteledDirectExpense;

    private java.lang.Long settledFamilyNumber;

    private java.lang.Double settledObjectNumber;

    private DateTime settlementDate;

    public CaseMainInfo() {
    }

    public CaseMainInfo(
           java.lang.Double affectedArea,
           DateTime assessmentDate,
           java.lang.String caseNumber,
           java.lang.Double claimAmout,
           java.lang.String claimNumber,
           java.lang.String claimSequenceNo,
           java.lang.String companyCode,
           java.lang.Double damagedArea,
           java.lang.Double directExpense,
           java.lang.Long farmerCount,
           java.lang.String lawsuitFlag,
           java.lang.Double lossArea,
           java.lang.String measuremantUnit,
           java.lang.String policyNumber,
           java.lang.Double prepaidAmount,
           java.lang.Double prepaidDirectExpense,
           java.lang.Integer reopenedTimes,
           java.lang.String reopenedType,
           java.lang.Double setteledAmount,
           java.lang.Double setteledDirectExpense,
           java.lang.Long settledFamilyNumber,
           java.lang.Double settledObjectNumber,
           DateTime settlementDate) {
           this.affectedArea = affectedArea;
           this.assessmentDate = assessmentDate;
           this.caseNumber = caseNumber;
           this.claimAmout = claimAmout;
           this.claimNumber = claimNumber;
           this.claimSequenceNo = claimSequenceNo;
           this.companyCode = companyCode;
           this.damagedArea = damagedArea;
           this.directExpense = directExpense;
           this.farmerCount = farmerCount;
           this.lawsuitFlag = lawsuitFlag;
           this.lossArea = lossArea;
           this.measuremantUnit = measuremantUnit;
           this.policyNumber = policyNumber;
           this.prepaidAmount = prepaidAmount;
           this.prepaidDirectExpense = prepaidDirectExpense;
           this.reopenedTimes = reopenedTimes;
           this.reopenedType = reopenedType;
           this.setteledAmount = setteledAmount;
           this.setteledDirectExpense = setteledDirectExpense;
           this.settledFamilyNumber = settledFamilyNumber;
           this.settledObjectNumber = settledObjectNumber;
           this.settlementDate = settlementDate;
    }


    /**
     * Gets the affectedArea value for this CaseMainInfo.
     * 
     * @return affectedArea
     */
    public java.lang.Double getAffectedArea() {
        return affectedArea;
    }


    /**
     * Sets the affectedArea value for this CaseMainInfo.
     * 
     * @param affectedArea
     */
    public void setAffectedArea(java.lang.Double affectedArea) {
        this.affectedArea = affectedArea;
    }


    /**
     * Gets the assessmentDate value for this CaseMainInfo.
     * 
     * @return assessmentDate
     */
    public DateTime getAssessmentDate() {
        return assessmentDate;
    }


    /**
     * Sets the assessmentDate value for this CaseMainInfo.
     * 
     * @param dateTime
     */
    public void setAssessmentDate(DateTime dateTime) {
        this.assessmentDate = dateTime;
    }


    /**
     * Gets the caseNumber value for this CaseMainInfo.
     * 
     * @return caseNumber
     */
    public java.lang.String getCaseNumber() {
        return caseNumber;
    }


    /**
     * Sets the caseNumber value for this CaseMainInfo.
     * 
     * @param caseNumber
     */
    public void setCaseNumber(java.lang.String caseNumber) {
        this.caseNumber = caseNumber;
    }


    /**
     * Gets the claimAmout value for this CaseMainInfo.
     * 
     * @return claimAmout
     */
    public java.lang.Double getClaimAmout() {
        return claimAmout;
    }


    /**
     * Sets the claimAmout value for this CaseMainInfo.
     * 
     * @param claimAmout
     */
    public void setClaimAmout(java.lang.Double claimAmout) {
        this.claimAmout = claimAmout;
    }


    /**
     * Gets the claimNumber value for this CaseMainInfo.
     * 
     * @return claimNumber
     */
    public java.lang.String getClaimNumber() {
        return claimNumber;
    }


    /**
     * Sets the claimNumber value for this CaseMainInfo.
     * 
     * @param claimNumber
     */
    public void setClaimNumber(java.lang.String claimNumber) {
        this.claimNumber = claimNumber;
    }


    /**
     * Gets the claimSequenceNo value for this CaseMainInfo.
     * 
     * @return claimSequenceNo
     */
    public java.lang.String getClaimSequenceNo() {
        return claimSequenceNo;
    }


    /**
     * Sets the claimSequenceNo value for this CaseMainInfo.
     * 
     * @param claimSequenceNo
     */
    public void setClaimSequenceNo(java.lang.String claimSequenceNo) {
        this.claimSequenceNo = claimSequenceNo;
    }


    /**
     * Gets the companyCode value for this CaseMainInfo.
     * 
     * @return companyCode
     */
    public java.lang.String getCompanyCode() {
        return companyCode;
    }


    /**
     * Sets the companyCode value for this CaseMainInfo.
     * 
     * @param companyCode
     */
    public void setCompanyCode(java.lang.String companyCode) {
        this.companyCode = companyCode;
    }


    /**
     * Gets the damagedArea value for this CaseMainInfo.
     * 
     * @return damagedArea
     */
    public java.lang.Double getDamagedArea() {
        return damagedArea;
    }


    /**
     * Sets the damagedArea value for this CaseMainInfo.
     * 
     * @param damagedArea
     */
    public void setDamagedArea(java.lang.Double damagedArea) {
        this.damagedArea = damagedArea;
    }


    /**
     * Gets the directExpense value for this CaseMainInfo.
     * 
     * @return directExpense
     */
    public java.lang.Double getDirectExpense() {
        return directExpense;
    }


    /**
     * Sets the directExpense value for this CaseMainInfo.
     * 
     * @param directExpense
     */
    public void setDirectExpense(java.lang.Double directExpense) {
        this.directExpense = directExpense;
    }


    /**
     * Gets the farmerCount value for this CaseMainInfo.
     * 
     * @return farmerCount
     */
    public java.lang.Long getFarmerCount() {
        return farmerCount;
    }


    /**
     * Sets the farmerCount value for this CaseMainInfo.
     * 
     * @param farmerCount
     */
    public void setFarmerCount(java.lang.Long farmerCount) {
        this.farmerCount = farmerCount;
    }


    /**
     * Gets the lawsuitFlag value for this CaseMainInfo.
     * 
     * @return lawsuitFlag
     */
    public java.lang.String getLawsuitFlag() {
        return lawsuitFlag;
    }


    /**
     * Sets the lawsuitFlag value for this CaseMainInfo.
     * 
     * @param lawsuitFlag
     */
    public void setLawsuitFlag(java.lang.String lawsuitFlag) {
        this.lawsuitFlag = lawsuitFlag;
    }


    /**
     * Gets the lossArea value for this CaseMainInfo.
     * 
     * @return lossArea
     */
    public java.lang.Double getLossArea() {
        return lossArea;
    }


    /**
     * Sets the lossArea value for this CaseMainInfo.
     * 
     * @param lossArea
     */
    public void setLossArea(java.lang.Double lossArea) {
        this.lossArea = lossArea;
    }


    /**
     * Gets the measuremantUnit value for this CaseMainInfo.
     * 
     * @return measuremantUnit
     */
    public java.lang.String getMeasuremantUnit() {
        return measuremantUnit;
    }


    /**
     * Sets the measuremantUnit value for this CaseMainInfo.
     * 
     * @param measuremantUnit
     */
    public void setMeasuremantUnit(java.lang.String measuremantUnit) {
        this.measuremantUnit = measuremantUnit;
    }


    /**
     * Gets the policyNumber value for this CaseMainInfo.
     * 
     * @return policyNumber
     */
    public java.lang.String getPolicyNumber() {
        return policyNumber;
    }


    /**
     * Sets the policyNumber value for this CaseMainInfo.
     * 
     * @param policyNumber
     */
    public void setPolicyNumber(java.lang.String policyNumber) {
        this.policyNumber = policyNumber;
    }


    /**
     * Gets the prepaidAmount value for this CaseMainInfo.
     * 
     * @return prepaidAmount
     */
    public java.lang.Double getPrepaidAmount() {
        return prepaidAmount;
    }


    /**
     * Sets the prepaidAmount value for this CaseMainInfo.
     * 
     * @param prepaidAmount
     */
    public void setPrepaidAmount(java.lang.Double prepaidAmount) {
        this.prepaidAmount = prepaidAmount;
    }


    /**
     * Gets the prepaidDirectExpense value for this CaseMainInfo.
     * 
     * @return prepaidDirectExpense
     */
    public java.lang.Double getPrepaidDirectExpense() {
        return prepaidDirectExpense;
    }


    /**
     * Sets the prepaidDirectExpense value for this CaseMainInfo.
     * 
     * @param prepaidDirectExpense
     */
    public void setPrepaidDirectExpense(java.lang.Double prepaidDirectExpense) {
        this.prepaidDirectExpense = prepaidDirectExpense;
    }


    /**
     * Gets the reopenedTimes value for this CaseMainInfo.
     * 
     * @return reopenedTimes
     */
    public java.lang.Integer getReopenedTimes() {
        return reopenedTimes;
    }


    /**
     * Sets the reopenedTimes value for this CaseMainInfo.
     * 
     * @param reopenedTimes
     */
    public void setReopenedTimes(java.lang.Integer reopenedTimes) {
        this.reopenedTimes = reopenedTimes;
    }


    /**
     * Gets the reopenedType value for this CaseMainInfo.
     * 
     * @return reopenedType
     */
    public java.lang.String getReopenedType() {
        return reopenedType;
    }


    /**
     * Sets the reopenedType value for this CaseMainInfo.
     * 
     * @param reopenedType
     */
    public void setReopenedType(java.lang.String reopenedType) {
        this.reopenedType = reopenedType;
    }


    /**
     * Gets the setteledAmount value for this CaseMainInfo.
     * 
     * @return setteledAmount
     */
    public java.lang.Double getSetteledAmount() {
        return setteledAmount;
    }


    /**
     * Sets the setteledAmount value for this CaseMainInfo.
     * 
     * @param setteledAmount
     */
    public void setSetteledAmount(java.lang.Double setteledAmount) {
        this.setteledAmount = setteledAmount;
    }


    /**
     * Gets the setteledDirectExpense value for this CaseMainInfo.
     * 
     * @return setteledDirectExpense
     */
    public java.lang.Double getSetteledDirectExpense() {
        return setteledDirectExpense;
    }


    /**
     * Sets the setteledDirectExpense value for this CaseMainInfo.
     * 
     * @param setteledDirectExpense
     */
    public void setSetteledDirectExpense(java.lang.Double setteledDirectExpense) {
        this.setteledDirectExpense = setteledDirectExpense;
    }


    /**
     * Gets the settledFamilyNumber value for this CaseMainInfo.
     * 
     * @return settledFamilyNumber
     */
    public java.lang.Long getSettledFamilyNumber() {
        return settledFamilyNumber;
    }


    /**
     * Sets the settledFamilyNumber value for this CaseMainInfo.
     * 
     * @param settledFamilyNumber
     */
    public void setSettledFamilyNumber(java.lang.Long settledFamilyNumber) {
        this.settledFamilyNumber = settledFamilyNumber;
    }


    /**
     * Gets the settledObjectNumber value for this CaseMainInfo.
     * 
     * @return settledObjectNumber
     */
    public java.lang.Double getSettledObjectNumber() {
        return settledObjectNumber;
    }


    /**
     * Sets the settledObjectNumber value for this CaseMainInfo.
     * 
     * @param settledObjectNumber
     */
    public void setSettledObjectNumber(java.lang.Double settledObjectNumber) {
        this.settledObjectNumber = settledObjectNumber;
    }


    /**
     * Gets the settlementDate value for this CaseMainInfo.
     * 
     * @return settlementDate
     */
    public DateTime getSettlementDate() {
        return settlementDate;
    }


    /**
     * Sets the settlementDate value for this CaseMainInfo.
     * 
     * @param dateTime
     */
    public void setSettlementDate(DateTime dateTime) {
        this.settlementDate = dateTime;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CaseMainInfo)) return false;
        CaseMainInfo other = (CaseMainInfo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.affectedArea==null && other.getAffectedArea()==null) || 
             (this.affectedArea!=null &&
              this.affectedArea.equals(other.getAffectedArea()))) &&
            ((this.assessmentDate==null && other.getAssessmentDate()==null) || 
             (this.assessmentDate!=null &&
              this.assessmentDate.equals(other.getAssessmentDate()))) &&
            ((this.caseNumber==null && other.getCaseNumber()==null) || 
             (this.caseNumber!=null &&
              this.caseNumber.equals(other.getCaseNumber()))) &&
            ((this.claimAmout==null && other.getClaimAmout()==null) || 
             (this.claimAmout!=null &&
              this.claimAmout.equals(other.getClaimAmout()))) &&
            ((this.claimNumber==null && other.getClaimNumber()==null) || 
             (this.claimNumber!=null &&
              this.claimNumber.equals(other.getClaimNumber()))) &&
            ((this.claimSequenceNo==null && other.getClaimSequenceNo()==null) || 
             (this.claimSequenceNo!=null &&
              this.claimSequenceNo.equals(other.getClaimSequenceNo()))) &&
            ((this.companyCode==null && other.getCompanyCode()==null) || 
             (this.companyCode!=null &&
              this.companyCode.equals(other.getCompanyCode()))) &&
            ((this.damagedArea==null && other.getDamagedArea()==null) || 
             (this.damagedArea!=null &&
              this.damagedArea.equals(other.getDamagedArea()))) &&
            ((this.directExpense==null && other.getDirectExpense()==null) || 
             (this.directExpense!=null &&
              this.directExpense.equals(other.getDirectExpense()))) &&
            ((this.farmerCount==null && other.getFarmerCount()==null) || 
             (this.farmerCount!=null &&
              this.farmerCount.equals(other.getFarmerCount()))) &&
            ((this.lawsuitFlag==null && other.getLawsuitFlag()==null) || 
             (this.lawsuitFlag!=null &&
              this.lawsuitFlag.equals(other.getLawsuitFlag()))) &&
            ((this.lossArea==null && other.getLossArea()==null) || 
             (this.lossArea!=null &&
              this.lossArea.equals(other.getLossArea()))) &&
            ((this.measuremantUnit==null && other.getMeasuremantUnit()==null) || 
             (this.measuremantUnit!=null &&
              this.measuremantUnit.equals(other.getMeasuremantUnit()))) &&
            ((this.policyNumber==null && other.getPolicyNumber()==null) || 
             (this.policyNumber!=null &&
              this.policyNumber.equals(other.getPolicyNumber()))) &&
            ((this.prepaidAmount==null && other.getPrepaidAmount()==null) || 
             (this.prepaidAmount!=null &&
              this.prepaidAmount.equals(other.getPrepaidAmount()))) &&
            ((this.prepaidDirectExpense==null && other.getPrepaidDirectExpense()==null) || 
             (this.prepaidDirectExpense!=null &&
              this.prepaidDirectExpense.equals(other.getPrepaidDirectExpense()))) &&
            ((this.reopenedTimes==null && other.getReopenedTimes()==null) || 
             (this.reopenedTimes!=null &&
              this.reopenedTimes.equals(other.getReopenedTimes()))) &&
            ((this.reopenedType==null && other.getReopenedType()==null) || 
             (this.reopenedType!=null &&
              this.reopenedType.equals(other.getReopenedType()))) &&
            ((this.setteledAmount==null && other.getSetteledAmount()==null) || 
             (this.setteledAmount!=null &&
              this.setteledAmount.equals(other.getSetteledAmount()))) &&
            ((this.setteledDirectExpense==null && other.getSetteledDirectExpense()==null) || 
             (this.setteledDirectExpense!=null &&
              this.setteledDirectExpense.equals(other.getSetteledDirectExpense()))) &&
            ((this.settledFamilyNumber==null && other.getSettledFamilyNumber()==null) || 
             (this.settledFamilyNumber!=null &&
              this.settledFamilyNumber.equals(other.getSettledFamilyNumber()))) &&
            ((this.settledObjectNumber==null && other.getSettledObjectNumber()==null) || 
             (this.settledObjectNumber!=null &&
              this.settledObjectNumber.equals(other.getSettledObjectNumber()))) &&
            ((this.settlementDate==null && other.getSettlementDate()==null) || 
             (this.settlementDate!=null &&
              this.settlementDate.equals(other.getSettlementDate())));
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
        if (getAffectedArea() != null) {
            _hashCode += getAffectedArea().hashCode();
        }
        if (getAssessmentDate() != null) {
            _hashCode += getAssessmentDate().hashCode();
        }
        if (getCaseNumber() != null) {
            _hashCode += getCaseNumber().hashCode();
        }
        if (getClaimAmout() != null) {
            _hashCode += getClaimAmout().hashCode();
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
        if (getDamagedArea() != null) {
            _hashCode += getDamagedArea().hashCode();
        }
        if (getDirectExpense() != null) {
            _hashCode += getDirectExpense().hashCode();
        }
        if (getFarmerCount() != null) {
            _hashCode += getFarmerCount().hashCode();
        }
        if (getLawsuitFlag() != null) {
            _hashCode += getLawsuitFlag().hashCode();
        }
        if (getLossArea() != null) {
            _hashCode += getLossArea().hashCode();
        }
        if (getMeasuremantUnit() != null) {
            _hashCode += getMeasuremantUnit().hashCode();
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
        if (getReopenedTimes() != null) {
            _hashCode += getReopenedTimes().hashCode();
        }
        if (getReopenedType() != null) {
            _hashCode += getReopenedType().hashCode();
        }
        if (getSetteledAmount() != null) {
            _hashCode += getSetteledAmount().hashCode();
        }
        if (getSetteledDirectExpense() != null) {
            _hashCode += getSetteledDirectExpense().hashCode();
        }
        if (getSettledFamilyNumber() != null) {
            _hashCode += getSettledFamilyNumber().hashCode();
        }
        if (getSettledObjectNumber() != null) {
            _hashCode += getSettledObjectNumber().hashCode();
        }
        if (getSettlementDate() != null) {
            _hashCode += getSettlementDate().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CaseMainInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "caseMainInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("affectedArea");
        elemField.setXmlName(new javax.xml.namespace.QName("", "affectedArea"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("assessmentDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "assessmentDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("caseNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("", "caseNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("claimAmout");
        elemField.setXmlName(new javax.xml.namespace.QName("", "claimAmout"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
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
        elemField.setFieldName("damagedArea");
        elemField.setXmlName(new javax.xml.namespace.QName("", "damagedArea"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("directExpense");
        elemField.setXmlName(new javax.xml.namespace.QName("", "directExpense"));
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
        elemField.setFieldName("lawsuitFlag");
        elemField.setXmlName(new javax.xml.namespace.QName("", "lawsuitFlag"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lossArea");
        elemField.setXmlName(new javax.xml.namespace.QName("", "lossArea"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("measuremantUnit");
        elemField.setXmlName(new javax.xml.namespace.QName("", "measuremantUnit"));
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
        elemField.setFieldName("reopenedTimes");
        elemField.setXmlName(new javax.xml.namespace.QName("", "reopenedTimes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("reopenedType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "reopenedType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("setteledAmount");
        elemField.setXmlName(new javax.xml.namespace.QName("", "setteledAmount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("setteledDirectExpense");
        elemField.setXmlName(new javax.xml.namespace.QName("", "setteledDirectExpense"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("settledFamilyNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("", "settledFamilyNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("settledObjectNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("", "settledObjectNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("settlementDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "settlementDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
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
