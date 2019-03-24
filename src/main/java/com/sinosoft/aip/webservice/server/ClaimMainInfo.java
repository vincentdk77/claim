/**
 * ClaimMainInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.sinosoft.aip.webservice.server;

import com.sinosoft.sysframework.common.datatype.DateTime;

public class ClaimMainInfo  implements java.io.Serializable {
    private DateTime accidentTime;

    private java.lang.Double affectedArea;

    private java.lang.String blueRuinCode;

    private java.lang.String blueRuinDesc;

    private DateTime claimDate;

    private java.lang.String claimNumber;

    private java.lang.String companyCode;

    private java.lang.String confirmSequenceNo;

    private java.lang.Double damagedArea;

    private java.lang.Double estimateLossAmout;

    private java.lang.Double lossArea;

    private java.lang.String lossOccurredCause;

    private java.lang.String lossOccurredLocation;

    private java.lang.Double lossQuantity;

    private java.lang.String lossSubject;

    private java.lang.String measuremantUnit;

    private java.lang.Long outstandingFamily;

    private java.lang.String policyNumber;

    public ClaimMainInfo() {
    }

    public ClaimMainInfo(
           DateTime accidentTime,
           java.lang.Double affectedArea,
           java.lang.String blueRuinCode,
           java.lang.String blueRuinDesc,
           DateTime claimDate,
           java.lang.String claimNumber,
           java.lang.String companyCode,
           java.lang.String confirmSequenceNo,
           java.lang.Double damagedArea,
           java.lang.Double estimateLossAmout,
           java.lang.Double lossArea,
           java.lang.String lossOccurredCause,
           java.lang.String lossOccurredLocation,
           java.lang.Double lossQuantity,
           java.lang.String lossSubject,
           java.lang.String measuremantUnit,
           java.lang.Long outstandingFamily,
           java.lang.String policyNumber) {
           this.accidentTime = accidentTime;
           this.affectedArea = affectedArea;
           this.blueRuinCode = blueRuinCode;
           this.blueRuinDesc = blueRuinDesc;
           this.claimDate = claimDate;
           this.claimNumber = claimNumber;
           this.companyCode = companyCode;
           this.confirmSequenceNo = confirmSequenceNo;
           this.damagedArea = damagedArea;
           this.estimateLossAmout = estimateLossAmout;
           this.lossArea = lossArea;
           this.lossOccurredCause = lossOccurredCause;
           this.lossOccurredLocation = lossOccurredLocation;
           this.lossQuantity = lossQuantity;
           this.lossSubject = lossSubject;
           this.measuremantUnit = measuremantUnit;
           this.outstandingFamily = outstandingFamily;
           this.policyNumber = policyNumber;
    }


    /**
     * Gets the accidentTime value for this ClaimMainInfo.
     * 
     * @return accidentTime
     */
    public DateTime getAccidentTime() {
        return accidentTime;
    }


    /**
     * Sets the accidentTime value for this ClaimMainInfo.
     * 
     * @param dateTime
     */
    public void setAccidentTime(DateTime dateTime) {
        this.accidentTime = dateTime;
    }


    /**
     * Gets the affectedArea value for this ClaimMainInfo.
     * 
     * @return affectedArea
     */
    public java.lang.Double getAffectedArea() {
        return affectedArea;
    }


    /**
     * Sets the affectedArea value for this ClaimMainInfo.
     * 
     * @param affectedArea
     */
    public void setAffectedArea(java.lang.Double affectedArea) {
        this.affectedArea = affectedArea;
    }


    /**
     * Gets the blueRuinCode value for this ClaimMainInfo.
     * 
     * @return blueRuinCode
     */
    public java.lang.String getBlueRuinCode() {
        return blueRuinCode;
    }


    /**
     * Sets the blueRuinCode value for this ClaimMainInfo.
     * 
     * @param blueRuinCode
     */
    public void setBlueRuinCode(java.lang.String blueRuinCode) {
        this.blueRuinCode = blueRuinCode;
    }


    /**
     * Gets the blueRuinDesc value for this ClaimMainInfo.
     * 
     * @return blueRuinDesc
     */
    public java.lang.String getBlueRuinDesc() {
        return blueRuinDesc;
    }


    /**
     * Sets the blueRuinDesc value for this ClaimMainInfo.
     * 
     * @param blueRuinDesc
     */
    public void setBlueRuinDesc(java.lang.String blueRuinDesc) {
        this.blueRuinDesc = blueRuinDesc;
    }


    /**
     * Gets the claimDate value for this ClaimMainInfo.
     * 
     * @return claimDate
     */
    public DateTime getClaimDate() {
        return claimDate;
    }


    /**
     * Sets the claimDate value for this ClaimMainInfo.
     * 
     * @param dateTime
     */
    public void setClaimDate(DateTime dateTime) {
        this.claimDate = dateTime;
    }


    /**
     * Gets the claimNumber value for this ClaimMainInfo.
     * 
     * @return claimNumber
     */
    public java.lang.String getClaimNumber() {
        return claimNumber;
    }


    /**
     * Sets the claimNumber value for this ClaimMainInfo.
     * 
     * @param claimNumber
     */
    public void setClaimNumber(java.lang.String claimNumber) {
        this.claimNumber = claimNumber;
    }


    /**
     * Gets the companyCode value for this ClaimMainInfo.
     * 
     * @return companyCode
     */
    public java.lang.String getCompanyCode() {
        return companyCode;
    }


    /**
     * Sets the companyCode value for this ClaimMainInfo.
     * 
     * @param companyCode
     */
    public void setCompanyCode(java.lang.String companyCode) {
        this.companyCode = companyCode;
    }


    /**
     * Gets the confirmSequenceNo value for this ClaimMainInfo.
     * 
     * @return confirmSequenceNo
     */
    public java.lang.String getConfirmSequenceNo() {
        return confirmSequenceNo;
    }


    /**
     * Sets the confirmSequenceNo value for this ClaimMainInfo.
     * 
     * @param confirmSequenceNo
     */
    public void setConfirmSequenceNo(java.lang.String confirmSequenceNo) {
        this.confirmSequenceNo = confirmSequenceNo;
    }


    /**
     * Gets the damagedArea value for this ClaimMainInfo.
     * 
     * @return damagedArea
     */
    public java.lang.Double getDamagedArea() {
        return damagedArea;
    }


    /**
     * Sets the damagedArea value for this ClaimMainInfo.
     * 
     * @param damagedArea
     */
    public void setDamagedArea(java.lang.Double damagedArea) {
        this.damagedArea = damagedArea;
    }


    /**
     * Gets the estimateLossAmout value for this ClaimMainInfo.
     * 
     * @return estimateLossAmout
     */
    public java.lang.Double getEstimateLossAmout() {
        return estimateLossAmout;
    }


    /**
     * Sets the estimateLossAmout value for this ClaimMainInfo.
     * 
     * @param estimateLossAmout
     */
    public void setEstimateLossAmout(java.lang.Double estimateLossAmout) {
        this.estimateLossAmout = estimateLossAmout;
    }


    /**
     * Gets the lossArea value for this ClaimMainInfo.
     * 
     * @return lossArea
     */
    public java.lang.Double getLossArea() {
        return lossArea;
    }


    /**
     * Sets the lossArea value for this ClaimMainInfo.
     * 
     * @param lossArea
     */
    public void setLossArea(java.lang.Double lossArea) {
        this.lossArea = lossArea;
    }


    /**
     * Gets the lossOccurredCause value for this ClaimMainInfo.
     * 
     * @return lossOccurredCause
     */
    public java.lang.String getLossOccurredCause() {
        return lossOccurredCause;
    }


    /**
     * Sets the lossOccurredCause value for this ClaimMainInfo.
     * 
     * @param lossOccurredCause
     */
    public void setLossOccurredCause(java.lang.String lossOccurredCause) {
        this.lossOccurredCause = lossOccurredCause;
    }


    /**
     * Gets the lossOccurredLocation value for this ClaimMainInfo.
     * 
     * @return lossOccurredLocation
     */
    public java.lang.String getLossOccurredLocation() {
        return lossOccurredLocation;
    }


    /**
     * Sets the lossOccurredLocation value for this ClaimMainInfo.
     * 
     * @param lossOccurredLocation
     */
    public void setLossOccurredLocation(java.lang.String lossOccurredLocation) {
        this.lossOccurredLocation = lossOccurredLocation;
    }


    /**
     * Gets the lossQuantity value for this ClaimMainInfo.
     * 
     * @return lossQuantity
     */
    public java.lang.Double getLossQuantity() {
        return lossQuantity;
    }


    /**
     * Sets the lossQuantity value for this ClaimMainInfo.
     * 
     * @param lossQuantity
     */
    public void setLossQuantity(java.lang.Double lossQuantity) {
        this.lossQuantity = lossQuantity;
    }


    /**
     * Gets the lossSubject value for this ClaimMainInfo.
     * 
     * @return lossSubject
     */
    public java.lang.String getLossSubject() {
        return lossSubject;
    }


    /**
     * Sets the lossSubject value for this ClaimMainInfo.
     * 
     * @param lossSubject
     */
    public void setLossSubject(java.lang.String lossSubject) {
        this.lossSubject = lossSubject;
    }


    /**
     * Gets the measuremantUnit value for this ClaimMainInfo.
     * 
     * @return measuremantUnit
     */
    public java.lang.String getMeasuremantUnit() {
        return measuremantUnit;
    }


    /**
     * Sets the measuremantUnit value for this ClaimMainInfo.
     * 
     * @param measuremantUnit
     */
    public void setMeasuremantUnit(java.lang.String measuremantUnit) {
        this.measuremantUnit = measuremantUnit;
    }


    /**
     * Gets the outstandingFamily value for this ClaimMainInfo.
     * 
     * @return outstandingFamily
     */
    public java.lang.Long getOutstandingFamily() {
        return outstandingFamily;
    }


    /**
     * Sets the outstandingFamily value for this ClaimMainInfo.
     * 
     * @param outstandingFamily
     */
    public void setOutstandingFamily(java.lang.Long outstandingFamily) {
        this.outstandingFamily = outstandingFamily;
    }


    /**
     * Gets the policyNumber value for this ClaimMainInfo.
     * 
     * @return policyNumber
     */
    public java.lang.String getPolicyNumber() {
        return policyNumber;
    }


    /**
     * Sets the policyNumber value for this ClaimMainInfo.
     * 
     * @param policyNumber
     */
    public void setPolicyNumber(java.lang.String policyNumber) {
        this.policyNumber = policyNumber;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ClaimMainInfo)) return false;
        ClaimMainInfo other = (ClaimMainInfo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.accidentTime==null && other.getAccidentTime()==null) || 
             (this.accidentTime!=null &&
              this.accidentTime.equals(other.getAccidentTime()))) &&
            ((this.affectedArea==null && other.getAffectedArea()==null) || 
             (this.affectedArea!=null &&
              this.affectedArea.equals(other.getAffectedArea()))) &&
            ((this.blueRuinCode==null && other.getBlueRuinCode()==null) || 
             (this.blueRuinCode!=null &&
              this.blueRuinCode.equals(other.getBlueRuinCode()))) &&
            ((this.blueRuinDesc==null && other.getBlueRuinDesc()==null) || 
             (this.blueRuinDesc!=null &&
              this.blueRuinDesc.equals(other.getBlueRuinDesc()))) &&
            ((this.claimDate==null && other.getClaimDate()==null) || 
             (this.claimDate!=null &&
              this.claimDate.equals(other.getClaimDate()))) &&
            ((this.claimNumber==null && other.getClaimNumber()==null) || 
             (this.claimNumber!=null &&
              this.claimNumber.equals(other.getClaimNumber()))) &&
            ((this.companyCode==null && other.getCompanyCode()==null) || 
             (this.companyCode!=null &&
              this.companyCode.equals(other.getCompanyCode()))) &&
            ((this.confirmSequenceNo==null && other.getConfirmSequenceNo()==null) || 
             (this.confirmSequenceNo!=null &&
              this.confirmSequenceNo.equals(other.getConfirmSequenceNo()))) &&
            ((this.damagedArea==null && other.getDamagedArea()==null) || 
             (this.damagedArea!=null &&
              this.damagedArea.equals(other.getDamagedArea()))) &&
            ((this.estimateLossAmout==null && other.getEstimateLossAmout()==null) || 
             (this.estimateLossAmout!=null &&
              this.estimateLossAmout.equals(other.getEstimateLossAmout()))) &&
            ((this.lossArea==null && other.getLossArea()==null) || 
             (this.lossArea!=null &&
              this.lossArea.equals(other.getLossArea()))) &&
            ((this.lossOccurredCause==null && other.getLossOccurredCause()==null) || 
             (this.lossOccurredCause!=null &&
              this.lossOccurredCause.equals(other.getLossOccurredCause()))) &&
            ((this.lossOccurredLocation==null && other.getLossOccurredLocation()==null) || 
             (this.lossOccurredLocation!=null &&
              this.lossOccurredLocation.equals(other.getLossOccurredLocation()))) &&
            ((this.lossQuantity==null && other.getLossQuantity()==null) || 
             (this.lossQuantity!=null &&
              this.lossQuantity.equals(other.getLossQuantity()))) &&
            ((this.lossSubject==null && other.getLossSubject()==null) || 
             (this.lossSubject!=null &&
              this.lossSubject.equals(other.getLossSubject()))) &&
            ((this.measuremantUnit==null && other.getMeasuremantUnit()==null) || 
             (this.measuremantUnit!=null &&
              this.measuremantUnit.equals(other.getMeasuremantUnit()))) &&
            ((this.outstandingFamily==null && other.getOutstandingFamily()==null) || 
             (this.outstandingFamily!=null &&
              this.outstandingFamily.equals(other.getOutstandingFamily()))) &&
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
        if (getAccidentTime() != null) {
            _hashCode += getAccidentTime().hashCode();
        }
        if (getAffectedArea() != null) {
            _hashCode += getAffectedArea().hashCode();
        }
        if (getBlueRuinCode() != null) {
            _hashCode += getBlueRuinCode().hashCode();
        }
        if (getBlueRuinDesc() != null) {
            _hashCode += getBlueRuinDesc().hashCode();
        }
        if (getClaimDate() != null) {
            _hashCode += getClaimDate().hashCode();
        }
        if (getClaimNumber() != null) {
            _hashCode += getClaimNumber().hashCode();
        }
        if (getCompanyCode() != null) {
            _hashCode += getCompanyCode().hashCode();
        }
        if (getConfirmSequenceNo() != null) {
            _hashCode += getConfirmSequenceNo().hashCode();
        }
        if (getDamagedArea() != null) {
            _hashCode += getDamagedArea().hashCode();
        }
        if (getEstimateLossAmout() != null) {
            _hashCode += getEstimateLossAmout().hashCode();
        }
        if (getLossArea() != null) {
            _hashCode += getLossArea().hashCode();
        }
        if (getLossOccurredCause() != null) {
            _hashCode += getLossOccurredCause().hashCode();
        }
        if (getLossOccurredLocation() != null) {
            _hashCode += getLossOccurredLocation().hashCode();
        }
        if (getLossQuantity() != null) {
            _hashCode += getLossQuantity().hashCode();
        }
        if (getLossSubject() != null) {
            _hashCode += getLossSubject().hashCode();
        }
        if (getMeasuremantUnit() != null) {
            _hashCode += getMeasuremantUnit().hashCode();
        }
        if (getOutstandingFamily() != null) {
            _hashCode += getOutstandingFamily().hashCode();
        }
        if (getPolicyNumber() != null) {
            _hashCode += getPolicyNumber().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ClaimMainInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "claimMainInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("accidentTime");
        elemField.setXmlName(new javax.xml.namespace.QName("", "accidentTime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("affectedArea");
        elemField.setXmlName(new javax.xml.namespace.QName("", "affectedArea"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("blueRuinCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "blueRuinCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("blueRuinDesc");
        elemField.setXmlName(new javax.xml.namespace.QName("", "blueRuinDesc"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("claimDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "claimDate"));
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
        elemField.setFieldName("damagedArea");
        elemField.setXmlName(new javax.xml.namespace.QName("", "damagedArea"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("estimateLossAmout");
        elemField.setXmlName(new javax.xml.namespace.QName("", "estimateLossAmout"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
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
        elemField.setFieldName("lossOccurredCause");
        elemField.setXmlName(new javax.xml.namespace.QName("", "lossOccurredCause"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lossOccurredLocation");
        elemField.setXmlName(new javax.xml.namespace.QName("", "lossOccurredLocation"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lossQuantity");
        elemField.setXmlName(new javax.xml.namespace.QName("", "lossQuantity"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lossSubject");
        elemField.setXmlName(new javax.xml.namespace.QName("", "lossSubject"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
        elemField.setFieldName("outstandingFamily");
        elemField.setXmlName(new javax.xml.namespace.QName("", "outstandingFamily"));
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
