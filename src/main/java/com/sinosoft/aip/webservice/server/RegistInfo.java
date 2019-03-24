/**
 * RegistInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.sinosoft.aip.webservice.server;

import com.sinosoft.sysframework.common.datatype.DateTime;

public class RegistInfo  implements java.io.Serializable {
    private java.lang.String lossReason;

    private java.lang.String notificationNumber;

    private DateTime notificationTime;

    private java.lang.String notifier;

    private java.lang.String notifierTelephone;

    public RegistInfo() {
    }

    public RegistInfo(
           java.lang.String lossReason,
           java.lang.String notificationNumber,
           DateTime notificationTime,
           java.lang.String notifier,
           java.lang.String notifierTelephone) {
           this.lossReason = lossReason;
           this.notificationNumber = notificationNumber;
           this.notificationTime = notificationTime;
           this.notifier = notifier;
           this.notifierTelephone = notifierTelephone;
    }


    /**
     * Gets the lossReason value for this RegistInfo.
     * 
     * @return lossReason
     */
    public java.lang.String getLossReason() {
        return lossReason;
    }


    /**
     * Sets the lossReason value for this RegistInfo.
     * 
     * @param lossReason
     */
    public void setLossReason(java.lang.String lossReason) {
        this.lossReason = lossReason;
    }


    /**
     * Gets the notificationNumber value for this RegistInfo.
     * 
     * @return notificationNumber
     */
    public java.lang.String getNotificationNumber() {
        return notificationNumber;
    }


    /**
     * Sets the notificationNumber value for this RegistInfo.
     * 
     * @param notificationNumber
     */
    public void setNotificationNumber(java.lang.String notificationNumber) {
        this.notificationNumber = notificationNumber;
    }


    /**
     * Gets the notificationTime value for this RegistInfo.
     * 
     * @return notificationTime
     */
    public DateTime getNotificationTime() {
        return notificationTime;
    }


    /**
     * Sets the notificationTime value for this RegistInfo.
     * 
     * @param dateTime
     */
    public void setNotificationTime(DateTime dateTime) {
        this.notificationTime = dateTime;
    }


    /**
     * Gets the notifier value for this RegistInfo.
     * 
     * @return notifier
     */
    public java.lang.String getNotifier() {
        return notifier;
    }


    /**
     * Sets the notifier value for this RegistInfo.
     * 
     * @param notifier
     */
    public void setNotifier(java.lang.String notifier) {
        this.notifier = notifier;
    }


    /**
     * Gets the notifierTelephone value for this RegistInfo.
     * 
     * @return notifierTelephone
     */
    public java.lang.String getNotifierTelephone() {
        return notifierTelephone;
    }


    /**
     * Sets the notifierTelephone value for this RegistInfo.
     * 
     * @param notifierTelephone
     */
    public void setNotifierTelephone(java.lang.String notifierTelephone) {
        this.notifierTelephone = notifierTelephone;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof RegistInfo)) return false;
        RegistInfo other = (RegistInfo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.lossReason==null && other.getLossReason()==null) || 
             (this.lossReason!=null &&
              this.lossReason.equals(other.getLossReason()))) &&
            ((this.notificationNumber==null && other.getNotificationNumber()==null) || 
             (this.notificationNumber!=null &&
              this.notificationNumber.equals(other.getNotificationNumber()))) &&
            ((this.notificationTime==null && other.getNotificationTime()==null) || 
             (this.notificationTime!=null &&
              this.notificationTime.equals(other.getNotificationTime()))) &&
            ((this.notifier==null && other.getNotifier()==null) || 
             (this.notifier!=null &&
              this.notifier.equals(other.getNotifier()))) &&
            ((this.notifierTelephone==null && other.getNotifierTelephone()==null) || 
             (this.notifierTelephone!=null &&
              this.notifierTelephone.equals(other.getNotifierTelephone())));
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
        if (getLossReason() != null) {
            _hashCode += getLossReason().hashCode();
        }
        if (getNotificationNumber() != null) {
            _hashCode += getNotificationNumber().hashCode();
        }
        if (getNotificationTime() != null) {
            _hashCode += getNotificationTime().hashCode();
        }
        if (getNotifier() != null) {
            _hashCode += getNotifier().hashCode();
        }
        if (getNotifierTelephone() != null) {
            _hashCode += getNotifierTelephone().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(RegistInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "registInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lossReason");
        elemField.setXmlName(new javax.xml.namespace.QName("", "lossReason"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("notificationNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("", "notificationNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("notificationTime");
        elemField.setXmlName(new javax.xml.namespace.QName("", "notificationTime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("notifier");
        elemField.setXmlName(new javax.xml.namespace.QName("", "notifier"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("notifierTelephone");
        elemField.setXmlName(new javax.xml.namespace.QName("", "notifierTelephone"));
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
