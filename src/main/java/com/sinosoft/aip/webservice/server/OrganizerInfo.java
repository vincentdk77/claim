/**
 * OrganizerInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.sinosoft.aip.webservice.server;

public class OrganizerInfo  implements java.io.Serializable {
    private java.lang.String IDNumber;

    private java.lang.String IDType;

    private java.lang.String linkPersonName;

    private java.lang.String linkPersonTelephone;

    private java.lang.String organizerAddress;

    private java.lang.String organizerName;

    private java.lang.String organizerPostcode;

    public OrganizerInfo() {
    }

    public OrganizerInfo(
           java.lang.String IDNumber,
           java.lang.String IDType,
           java.lang.String linkPersonName,
           java.lang.String linkPersonTelephone,
           java.lang.String organizerAddress,
           java.lang.String organizerName,
           java.lang.String organizerPostcode) {
           this.IDNumber = IDNumber;
           this.IDType = IDType;
           this.linkPersonName = linkPersonName;
           this.linkPersonTelephone = linkPersonTelephone;
           this.organizerAddress = organizerAddress;
           this.organizerName = organizerName;
           this.organizerPostcode = organizerPostcode;
    }


    /**
     * Gets the IDNumber value for this OrganizerInfo.
     * 
     * @return IDNumber
     */
    public java.lang.String getIDNumber() {
        return IDNumber;
    }


    /**
     * Sets the IDNumber value for this OrganizerInfo.
     * 
     * @param IDNumber
     */
    public void setIDNumber(java.lang.String IDNumber) {
        this.IDNumber = IDNumber;
    }


    /**
     * Gets the IDType value for this OrganizerInfo.
     * 
     * @return IDType
     */
    public java.lang.String getIDType() {
        return IDType;
    }


    /**
     * Sets the IDType value for this OrganizerInfo.
     * 
     * @param IDType
     */
    public void setIDType(java.lang.String IDType) {
        this.IDType = IDType;
    }


    /**
     * Gets the linkPersonName value for this OrganizerInfo.
     * 
     * @return linkPersonName
     */
    public java.lang.String getLinkPersonName() {
        return linkPersonName;
    }


    /**
     * Sets the linkPersonName value for this OrganizerInfo.
     * 
     * @param linkPersonName
     */
    public void setLinkPersonName(java.lang.String linkPersonName) {
        this.linkPersonName = linkPersonName;
    }


    /**
     * Gets the linkPersonTelephone value for this OrganizerInfo.
     * 
     * @return linkPersonTelephone
     */
    public java.lang.String getLinkPersonTelephone() {
        return linkPersonTelephone;
    }


    /**
     * Sets the linkPersonTelephone value for this OrganizerInfo.
     * 
     * @param linkPersonTelephone
     */
    public void setLinkPersonTelephone(java.lang.String linkPersonTelephone) {
        this.linkPersonTelephone = linkPersonTelephone;
    }


    /**
     * Gets the organizerAddress value for this OrganizerInfo.
     * 
     * @return organizerAddress
     */
    public java.lang.String getOrganizerAddress() {
        return organizerAddress;
    }


    /**
     * Sets the organizerAddress value for this OrganizerInfo.
     * 
     * @param organizerAddress
     */
    public void setOrganizerAddress(java.lang.String organizerAddress) {
        this.organizerAddress = organizerAddress;
    }


    /**
     * Gets the organizerName value for this OrganizerInfo.
     * 
     * @return organizerName
     */
    public java.lang.String getOrganizerName() {
        return organizerName;
    }


    /**
     * Sets the organizerName value for this OrganizerInfo.
     * 
     * @param organizerName
     */
    public void setOrganizerName(java.lang.String organizerName) {
        this.organizerName = organizerName;
    }


    /**
     * Gets the organizerPostcode value for this OrganizerInfo.
     * 
     * @return organizerPostcode
     */
    public java.lang.String getOrganizerPostcode() {
        return organizerPostcode;
    }


    /**
     * Sets the organizerPostcode value for this OrganizerInfo.
     * 
     * @param organizerPostcode
     */
    public void setOrganizerPostcode(java.lang.String organizerPostcode) {
        this.organizerPostcode = organizerPostcode;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof OrganizerInfo)) return false;
        OrganizerInfo other = (OrganizerInfo) obj;
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
            ((this.linkPersonName==null && other.getLinkPersonName()==null) || 
             (this.linkPersonName!=null &&
              this.linkPersonName.equals(other.getLinkPersonName()))) &&
            ((this.linkPersonTelephone==null && other.getLinkPersonTelephone()==null) || 
             (this.linkPersonTelephone!=null &&
              this.linkPersonTelephone.equals(other.getLinkPersonTelephone()))) &&
            ((this.organizerAddress==null && other.getOrganizerAddress()==null) || 
             (this.organizerAddress!=null &&
              this.organizerAddress.equals(other.getOrganizerAddress()))) &&
            ((this.organizerName==null && other.getOrganizerName()==null) || 
             (this.organizerName!=null &&
              this.organizerName.equals(other.getOrganizerName()))) &&
            ((this.organizerPostcode==null && other.getOrganizerPostcode()==null) || 
             (this.organizerPostcode!=null &&
              this.organizerPostcode.equals(other.getOrganizerPostcode())));
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
        if (getLinkPersonName() != null) {
            _hashCode += getLinkPersonName().hashCode();
        }
        if (getLinkPersonTelephone() != null) {
            _hashCode += getLinkPersonTelephone().hashCode();
        }
        if (getOrganizerAddress() != null) {
            _hashCode += getOrganizerAddress().hashCode();
        }
        if (getOrganizerName() != null) {
            _hashCode += getOrganizerName().hashCode();
        }
        if (getOrganizerPostcode() != null) {
            _hashCode += getOrganizerPostcode().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(OrganizerInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "organizerInfo"));
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
        elemField.setFieldName("linkPersonName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "linkPersonName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("linkPersonTelephone");
        elemField.setXmlName(new javax.xml.namespace.QName("", "linkPersonTelephone"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("organizerAddress");
        elemField.setXmlName(new javax.xml.namespace.QName("", "organizerAddress"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("organizerName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "organizerName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("organizerPostcode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "organizerPostcode"));
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
