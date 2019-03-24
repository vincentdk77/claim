/**
 * InsurantInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.sinosoft.aip.webservice.server;

public class InsurantInfo  implements java.io.Serializable {
    private java.lang.String IDNumber;

    private java.lang.String IDType;

    private java.lang.String insurantAddress;

    private java.lang.String insurantName;

    private java.lang.String insurantPostcode;

    private java.lang.String insurantTelephone;

    public InsurantInfo() {
    }

    public InsurantInfo(
           java.lang.String IDNumber,
           java.lang.String IDType,
           java.lang.String insurantAddress,
           java.lang.String insurantName,
           java.lang.String insurantPostcode,
           java.lang.String insurantTelephone) {
           this.IDNumber = IDNumber;
           this.IDType = IDType;
           this.insurantAddress = insurantAddress;
           this.insurantName = insurantName;
           this.insurantPostcode = insurantPostcode;
           this.insurantTelephone = insurantTelephone;
    }


    /**
     * Gets the IDNumber value for this InsurantInfo.
     * 
     * @return IDNumber
     */
    public java.lang.String getIDNumber() {
        return IDNumber;
    }


    /**
     * Sets the IDNumber value for this InsurantInfo.
     * 
     * @param IDNumber
     */
    public void setIDNumber(java.lang.String IDNumber) {
        this.IDNumber = IDNumber;
    }


    /**
     * Gets the IDType value for this InsurantInfo.
     * 
     * @return IDType
     */
    public java.lang.String getIDType() {
        return IDType;
    }


    /**
     * Sets the IDType value for this InsurantInfo.
     * 
     * @param IDType
     */
    public void setIDType(java.lang.String IDType) {
        this.IDType = IDType;
    }


    /**
     * Gets the insurantAddress value for this InsurantInfo.
     * 
     * @return insurantAddress
     */
    public java.lang.String getInsurantAddress() {
        return insurantAddress;
    }


    /**
     * Sets the insurantAddress value for this InsurantInfo.
     * 
     * @param insurantAddress
     */
    public void setInsurantAddress(java.lang.String insurantAddress) {
        this.insurantAddress = insurantAddress;
    }


    /**
     * Gets the insurantName value for this InsurantInfo.
     * 
     * @return insurantName
     */
    public java.lang.String getInsurantName() {
        return insurantName;
    }


    /**
     * Sets the insurantName value for this InsurantInfo.
     * 
     * @param insurantName
     */
    public void setInsurantName(java.lang.String insurantName) {
        this.insurantName = insurantName;
    }


    /**
     * Gets the insurantPostcode value for this InsurantInfo.
     * 
     * @return insurantPostcode
     */
    public java.lang.String getInsurantPostcode() {
        return insurantPostcode;
    }


    /**
     * Sets the insurantPostcode value for this InsurantInfo.
     * 
     * @param insurantPostcode
     */
    public void setInsurantPostcode(java.lang.String insurantPostcode) {
        this.insurantPostcode = insurantPostcode;
    }


    /**
     * Gets the insurantTelephone value for this InsurantInfo.
     * 
     * @return insurantTelephone
     */
    public java.lang.String getInsurantTelephone() {
        return insurantTelephone;
    }


    /**
     * Sets the insurantTelephone value for this InsurantInfo.
     * 
     * @param insurantTelephone
     */
    public void setInsurantTelephone(java.lang.String insurantTelephone) {
        this.insurantTelephone = insurantTelephone;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof InsurantInfo)) return false;
        InsurantInfo other = (InsurantInfo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.IDNumber==null && other.getIDNumber()==null) || 
             (this.IDNumber!=null &&
              this.IDNumber.equals(other.getIDNumber()))) &&
            ((this.IDType==null && other.getIDType()==null) || 
             (this.IDType!=null &&
              this.IDType.equals(other.getIDType()))) &&
            ((this.insurantAddress==null && other.getInsurantAddress()==null) || 
             (this.insurantAddress!=null &&
              this.insurantAddress.equals(other.getInsurantAddress()))) &&
            ((this.insurantName==null && other.getInsurantName()==null) || 
             (this.insurantName!=null &&
              this.insurantName.equals(other.getInsurantName()))) &&
            ((this.insurantPostcode==null && other.getInsurantPostcode()==null) || 
             (this.insurantPostcode!=null &&
              this.insurantPostcode.equals(other.getInsurantPostcode()))) &&
            ((this.insurantTelephone==null && other.getInsurantTelephone()==null) || 
             (this.insurantTelephone!=null &&
              this.insurantTelephone.equals(other.getInsurantTelephone())));
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
        if (getIDNumber() != null) {
            _hashCode += getIDNumber().hashCode();
        }
        if (getIDType() != null) {
            _hashCode += getIDType().hashCode();
        }
        if (getInsurantAddress() != null) {
            _hashCode += getInsurantAddress().hashCode();
        }
        if (getInsurantName() != null) {
            _hashCode += getInsurantName().hashCode();
        }
        if (getInsurantPostcode() != null) {
            _hashCode += getInsurantPostcode().hashCode();
        }
        if (getInsurantTelephone() != null) {
            _hashCode += getInsurantTelephone().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(InsurantInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "insurantInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
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
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("insurantAddress");
        elemField.setXmlName(new javax.xml.namespace.QName("", "insurantAddress"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("insurantName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "insurantName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("insurantPostcode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "insurantPostcode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("insurantTelephone");
        elemField.setXmlName(new javax.xml.namespace.QName("", "insurantTelephone"));
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
