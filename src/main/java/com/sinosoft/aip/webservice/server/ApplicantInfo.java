/**
 * ApplicantInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.sinosoft.aip.webservice.server;

public class ApplicantInfo  implements java.io.Serializable {
    private java.lang.String applicantAddress;

    private java.lang.String applicantName;

    private java.lang.String applicantPostcode;

    private java.lang.String applicantTelephone;

    private java.lang.String IDNumber;

    private java.lang.String IDType;

    public ApplicantInfo() {
    }

    public ApplicantInfo(
           java.lang.String applicantAddress,
           java.lang.String applicantName,
           java.lang.String applicantPostcode,
           java.lang.String applicantTelephone,
           java.lang.String IDNumber,
           java.lang.String IDType) {
           this.applicantAddress = applicantAddress;
           this.applicantName = applicantName;
           this.applicantPostcode = applicantPostcode;
           this.applicantTelephone = applicantTelephone;
           this.IDNumber = IDNumber;
           this.IDType = IDType;
    }


    /**
     * Gets the applicantAddress value for this ApplicantInfo.
     * 
     * @return applicantAddress
     */
    public java.lang.String getApplicantAddress() {
        return applicantAddress;
    }


    /**
     * Sets the applicantAddress value for this ApplicantInfo.
     * 
     * @param applicantAddress
     */
    public void setApplicantAddress(java.lang.String applicantAddress) {
        this.applicantAddress = applicantAddress;
    }


    /**
     * Gets the applicantName value for this ApplicantInfo.
     * 
     * @return applicantName
     */
    public java.lang.String getApplicantName() {
        return applicantName;
    }


    /**
     * Sets the applicantName value for this ApplicantInfo.
     * 
     * @param applicantName
     */
    public void setApplicantName(java.lang.String applicantName) {
        this.applicantName = applicantName;
    }


    /**
     * Gets the applicantPostcode value for this ApplicantInfo.
     * 
     * @return applicantPostcode
     */
    public java.lang.String getApplicantPostcode() {
        return applicantPostcode;
    }


    /**
     * Sets the applicantPostcode value for this ApplicantInfo.
     * 
     * @param applicantPostcode
     */
    public void setApplicantPostcode(java.lang.String applicantPostcode) {
        this.applicantPostcode = applicantPostcode;
    }


    /**
     * Gets the applicantTelephone value for this ApplicantInfo.
     * 
     * @return applicantTelephone
     */
    public java.lang.String getApplicantTelephone() {
        return applicantTelephone;
    }


    /**
     * Sets the applicantTelephone value for this ApplicantInfo.
     * 
     * @param applicantTelephone
     */
    public void setApplicantTelephone(java.lang.String applicantTelephone) {
        this.applicantTelephone = applicantTelephone;
    }


    /**
     * Gets the IDNumber value for this ApplicantInfo.
     * 
     * @return IDNumber
     */
    public java.lang.String getIDNumber() {
        return IDNumber;
    }


    /**
     * Sets the IDNumber value for this ApplicantInfo.
     * 
     * @param IDNumber
     */
    public void setIDNumber(java.lang.String IDNumber) {
        this.IDNumber = IDNumber;
    }


    /**
     * Gets the IDType value for this ApplicantInfo.
     * 
     * @return IDType
     */
    public java.lang.String getIDType() {
        return IDType;
    }


    /**
     * Sets the IDType value for this ApplicantInfo.
     * 
     * @param IDType
     */
    public void setIDType(java.lang.String IDType) {
        this.IDType = IDType;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ApplicantInfo)) return false;
        ApplicantInfo other = (ApplicantInfo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.applicantAddress==null && other.getApplicantAddress()==null) || 
             (this.applicantAddress!=null &&
              this.applicantAddress.equals(other.getApplicantAddress()))) &&
            ((this.applicantName==null && other.getApplicantName()==null) || 
             (this.applicantName!=null &&
              this.applicantName.equals(other.getApplicantName()))) &&
            ((this.applicantPostcode==null && other.getApplicantPostcode()==null) || 
             (this.applicantPostcode!=null &&
              this.applicantPostcode.equals(other.getApplicantPostcode()))) &&
            ((this.applicantTelephone==null && other.getApplicantTelephone()==null) || 
             (this.applicantTelephone!=null &&
              this.applicantTelephone.equals(other.getApplicantTelephone()))) &&
            ((this.IDNumber==null && other.getIDNumber()==null) || 
             (this.IDNumber!=null &&
              this.IDNumber.equals(other.getIDNumber()))) &&
            ((this.IDType==null && other.getIDType()==null) || 
             (this.IDType!=null &&
              this.IDType.equals(other.getIDType())));
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
        if (getApplicantAddress() != null) {
            _hashCode += getApplicantAddress().hashCode();
        }
        if (getApplicantName() != null) {
            _hashCode += getApplicantName().hashCode();
        }
        if (getApplicantPostcode() != null) {
            _hashCode += getApplicantPostcode().hashCode();
        }
        if (getApplicantTelephone() != null) {
            _hashCode += getApplicantTelephone().hashCode();
        }
        if (getIDNumber() != null) {
            _hashCode += getIDNumber().hashCode();
        }
        if (getIDType() != null) {
            _hashCode += getIDType().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ApplicantInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "applicantInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("applicantAddress");
        elemField.setXmlName(new javax.xml.namespace.QName("", "applicantAddress"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("applicantName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "applicantName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("applicantPostcode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "applicantPostcode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("applicantTelephone");
        elemField.setXmlName(new javax.xml.namespace.QName("", "applicantTelephone"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("IDNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("", "IDNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("IDType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "IDType"));
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
