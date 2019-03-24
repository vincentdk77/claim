/**
 * InsuredObject.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.sinosoft.aip.webservice.server;

public class InsuredObject  implements java.io.Serializable {
    private java.lang.String insuredObjectCode;

    private java.lang.Double insuredObjectNumber;

    private java.lang.String measuremantUnit;

    private java.lang.Double unitAmountInsured;

    public InsuredObject() {
    }

    public InsuredObject(
           java.lang.String insuredObjectCode,
           java.lang.Double insuredObjectNumber,
           java.lang.String measuremantUnit,
           java.lang.Double unitAmountInsured) {
           this.insuredObjectCode = insuredObjectCode;
           this.insuredObjectNumber = insuredObjectNumber;
           this.measuremantUnit = measuremantUnit;
           this.unitAmountInsured = unitAmountInsured;
    }


    /**
     * Gets the insuredObjectCode value for this InsuredObject.
     * 
     * @return insuredObjectCode
     */
    public java.lang.String getInsuredObjectCode() {
        return insuredObjectCode;
    }


    /**
     * Sets the insuredObjectCode value for this InsuredObject.
     * 
     * @param insuredObjectCode
     */
    public void setInsuredObjectCode(java.lang.String insuredObjectCode) {
        this.insuredObjectCode = insuredObjectCode;
    }


    /**
     * Gets the insuredObjectNumber value for this InsuredObject.
     * 
     * @return insuredObjectNumber
     */
    public java.lang.Double getInsuredObjectNumber() {
        return insuredObjectNumber;
    }


    /**
     * Sets the insuredObjectNumber value for this InsuredObject.
     * 
     * @param insuredObjectNumber
     */
    public void setInsuredObjectNumber(java.lang.Double insuredObjectNumber) {
        this.insuredObjectNumber = insuredObjectNumber;
    }


    /**
     * Gets the measuremantUnit value for this InsuredObject.
     * 
     * @return measuremantUnit
     */
    public java.lang.String getMeasuremantUnit() {
        return measuremantUnit;
    }


    /**
     * Sets the measuremantUnit value for this InsuredObject.
     * 
     * @param measuremantUnit
     */
    public void setMeasuremantUnit(java.lang.String measuremantUnit) {
        this.measuremantUnit = measuremantUnit;
    }


    /**
     * Gets the unitAmountInsured value for this InsuredObject.
     * 
     * @return unitAmountInsured
     */
    public java.lang.Double getUnitAmountInsured() {
        return unitAmountInsured;
    }


    /**
     * Sets the unitAmountInsured value for this InsuredObject.
     * 
     * @param unitAmountInsured
     */
    public void setUnitAmountInsured(java.lang.Double unitAmountInsured) {
        this.unitAmountInsured = unitAmountInsured;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof InsuredObject)) return false;
        InsuredObject other = (InsuredObject) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.insuredObjectCode==null && other.getInsuredObjectCode()==null) || 
             (this.insuredObjectCode!=null &&
              this.insuredObjectCode.equals(other.getInsuredObjectCode()))) &&
            ((this.insuredObjectNumber==null && other.getInsuredObjectNumber()==null) || 
             (this.insuredObjectNumber!=null &&
              this.insuredObjectNumber.equals(other.getInsuredObjectNumber()))) &&
            ((this.measuremantUnit==null && other.getMeasuremantUnit()==null) || 
             (this.measuremantUnit!=null &&
              this.measuremantUnit.equals(other.getMeasuremantUnit()))) &&
            ((this.unitAmountInsured==null && other.getUnitAmountInsured()==null) || 
             (this.unitAmountInsured!=null &&
              this.unitAmountInsured.equals(other.getUnitAmountInsured())));
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
        if (getInsuredObjectCode() != null) {
            _hashCode += getInsuredObjectCode().hashCode();
        }
        if (getInsuredObjectNumber() != null) {
            _hashCode += getInsuredObjectNumber().hashCode();
        }
        if (getMeasuremantUnit() != null) {
            _hashCode += getMeasuremantUnit().hashCode();
        }
        if (getUnitAmountInsured() != null) {
            _hashCode += getUnitAmountInsured().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(InsuredObject.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "insuredObject"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("insuredObjectCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "insuredObjectCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("insuredObjectNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("", "insuredObjectNumber"));
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
        elemField.setFieldName("unitAmountInsured");
        elemField.setXmlName(new javax.xml.namespace.QName("", "unitAmountInsured"));
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
