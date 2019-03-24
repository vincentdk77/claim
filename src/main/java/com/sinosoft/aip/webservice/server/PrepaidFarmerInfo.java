/**
 * PrepaidFarmerInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.sinosoft.aip.webservice.server;

public class PrepaidFarmerInfo  implements java.io.Serializable {
    private java.lang.String farmerIDNumber;

    private java.lang.String farmerIDType;

    private java.lang.String farmerName;

    private java.lang.String farmerTelephone;

    private java.lang.Double prepaidLoss;

    private java.lang.String prepayCaseNumber;

    private java.lang.Long serialNo;

    public PrepaidFarmerInfo() {
    }

    public PrepaidFarmerInfo(
           java.lang.String farmerIDNumber,
           java.lang.String farmerIDType,
           java.lang.String farmerName,
           java.lang.String farmerTelephone,
           java.lang.Double prepaidLoss,
           java.lang.String prepayCaseNumber,
           java.lang.Long serialNo) {
           this.farmerIDNumber = farmerIDNumber;
           this.farmerIDType = farmerIDType;
           this.farmerName = farmerName;
           this.farmerTelephone = farmerTelephone;
           this.prepaidLoss = prepaidLoss;
           this.prepayCaseNumber = prepayCaseNumber;
           this.serialNo = serialNo;
    }


    /**
     * Gets the farmerIDNumber value for this PrepaidFarmerInfo.
     * 
     * @return farmerIDNumber
     */
    public java.lang.String getFarmerIDNumber() {
        return farmerIDNumber;
    }


    /**
     * Sets the farmerIDNumber value for this PrepaidFarmerInfo.
     * 
     * @param farmerIDNumber
     */
    public void setFarmerIDNumber(java.lang.String farmerIDNumber) {
        this.farmerIDNumber = farmerIDNumber;
    }


    /**
     * Gets the farmerIDType value for this PrepaidFarmerInfo.
     * 
     * @return farmerIDType
     */
    public java.lang.String getFarmerIDType() {
        return farmerIDType;
    }


    /**
     * Sets the farmerIDType value for this PrepaidFarmerInfo.
     * 
     * @param farmerIDType
     */
    public void setFarmerIDType(java.lang.String farmerIDType) {
        this.farmerIDType = farmerIDType;
    }


    /**
     * Gets the farmerName value for this PrepaidFarmerInfo.
     * 
     * @return farmerName
     */
    public java.lang.String getFarmerName() {
        return farmerName;
    }


    /**
     * Sets the farmerName value for this PrepaidFarmerInfo.
     * 
     * @param farmerName
     */
    public void setFarmerName(java.lang.String farmerName) {
        this.farmerName = farmerName;
    }


    /**
     * Gets the farmerTelephone value for this PrepaidFarmerInfo.
     * 
     * @return farmerTelephone
     */
    public java.lang.String getFarmerTelephone() {
        return farmerTelephone;
    }


    /**
     * Sets the farmerTelephone value for this PrepaidFarmerInfo.
     * 
     * @param farmerTelephone
     */
    public void setFarmerTelephone(java.lang.String farmerTelephone) {
        this.farmerTelephone = farmerTelephone;
    }


    /**
     * Gets the prepaidLoss value for this PrepaidFarmerInfo.
     * 
     * @return prepaidLoss
     */
    public java.lang.Double getPrepaidLoss() {
        return prepaidLoss;
    }


    /**
     * Sets the prepaidLoss value for this PrepaidFarmerInfo.
     * 
     * @param prepaidLoss
     */
    public void setPrepaidLoss(java.lang.Double prepaidLoss) {
        this.prepaidLoss = prepaidLoss;
    }


    /**
     * Gets the prepayCaseNumber value for this PrepaidFarmerInfo.
     * 
     * @return prepayCaseNumber
     */
    public java.lang.String getPrepayCaseNumber() {
        return prepayCaseNumber;
    }


    /**
     * Sets the prepayCaseNumber value for this PrepaidFarmerInfo.
     * 
     * @param prepayCaseNumber
     */
    public void setPrepayCaseNumber(java.lang.String prepayCaseNumber) {
        this.prepayCaseNumber = prepayCaseNumber;
    }


    /**
     * Gets the serialNo value for this PrepaidFarmerInfo.
     * 
     * @return serialNo
     */
    public java.lang.Long getSerialNo() {
        return serialNo;
    }


    /**
     * Sets the serialNo value for this PrepaidFarmerInfo.
     * 
     * @param serialNo
     */
    public void setSerialNo(java.lang.Long serialNo) {
        this.serialNo = serialNo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PrepaidFarmerInfo)) return false;
        PrepaidFarmerInfo other = (PrepaidFarmerInfo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.farmerIDNumber==null && other.getFarmerIDNumber()==null) || 
             (this.farmerIDNumber!=null &&
              this.farmerIDNumber.equals(other.getFarmerIDNumber()))) &&
            ((this.farmerIDType==null && other.getFarmerIDType()==null) || 
             (this.farmerIDType!=null &&
              this.farmerIDType.equals(other.getFarmerIDType()))) &&
            ((this.farmerName==null && other.getFarmerName()==null) || 
             (this.farmerName!=null &&
              this.farmerName.equals(other.getFarmerName()))) &&
            ((this.farmerTelephone==null && other.getFarmerTelephone()==null) || 
             (this.farmerTelephone!=null &&
              this.farmerTelephone.equals(other.getFarmerTelephone()))) &&
            ((this.prepaidLoss==null && other.getPrepaidLoss()==null) || 
             (this.prepaidLoss!=null &&
              this.prepaidLoss.equals(other.getPrepaidLoss()))) &&
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
        if (getFarmerIDNumber() != null) {
            _hashCode += getFarmerIDNumber().hashCode();
        }
        if (getFarmerIDType() != null) {
            _hashCode += getFarmerIDType().hashCode();
        }
        if (getFarmerName() != null) {
            _hashCode += getFarmerName().hashCode();
        }
        if (getFarmerTelephone() != null) {
            _hashCode += getFarmerTelephone().hashCode();
        }
        if (getPrepaidLoss() != null) {
            _hashCode += getPrepaidLoss().hashCode();
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
        new org.apache.axis.description.TypeDesc(PrepaidFarmerInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "prepaidFarmerInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("farmerIDNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("", "farmerIDNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("farmerIDType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "farmerIDType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("farmerName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "farmerName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("farmerTelephone");
        elemField.setXmlName(new javax.xml.namespace.QName("", "farmerTelephone"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("prepaidLoss");
        elemField.setXmlName(new javax.xml.namespace.QName("", "prepaidLoss"));
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
