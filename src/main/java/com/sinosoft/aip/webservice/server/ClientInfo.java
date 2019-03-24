/**
 * ClientInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.sinosoft.aip.webservice.server;

public class ClientInfo  implements java.io.Serializable {
    private java.lang.String async;

    private java.lang.String batchNo;

    private java.lang.String dataType;

    private java.lang.String insuranceCompanyCode;

    private java.lang.Integer listSize;

    private java.lang.String password;

    private java.lang.String requestType;

    private java.lang.String user;

    public ClientInfo() {
    }

    public ClientInfo(
           java.lang.String async,
           java.lang.String batchNo,
           java.lang.String dataType,
           java.lang.String insuranceCompanyCode,
           java.lang.Integer listSize,
           java.lang.String password,
           java.lang.String requestType,
           java.lang.String user) {
           this.async = async;
           this.batchNo = batchNo;
           this.dataType = dataType;
           this.insuranceCompanyCode = insuranceCompanyCode;
           this.listSize = listSize;
           this.password = password;
           this.requestType = requestType;
           this.user = user;
    }


    /**
     * Gets the async value for this ClientInfo.
     * 
     * @return async
     */
    public java.lang.String getAsync() {
        return async;
    }


    /**
     * Sets the async value for this ClientInfo.
     * 
     * @param async
     */
    public void setAsync(java.lang.String async) {
        this.async = async;
    }


    /**
     * Gets the batchNo value for this ClientInfo.
     * 
     * @return batchNo
     */
    public java.lang.String getBatchNo() {
        return batchNo;
    }


    /**
     * Sets the batchNo value for this ClientInfo.
     * 
     * @param batchNo
     */
    public void setBatchNo(java.lang.String batchNo) {
        this.batchNo = batchNo;
    }


    /**
     * Gets the dataType value for this ClientInfo.
     * 
     * @return dataType
     */
    public java.lang.String getDataType() {
        return dataType;
    }


    /**
     * Sets the dataType value for this ClientInfo.
     * 
     * @param dataType
     */
    public void setDataType(java.lang.String dataType) {
        this.dataType = dataType;
    }


    /**
     * Gets the insuranceCompanyCode value for this ClientInfo.
     * 
     * @return insuranceCompanyCode
     */
    public java.lang.String getInsuranceCompanyCode() {
        return insuranceCompanyCode;
    }


    /**
     * Sets the insuranceCompanyCode value for this ClientInfo.
     * 
     * @param insuranceCompanyCode
     */
    public void setInsuranceCompanyCode(java.lang.String insuranceCompanyCode) {
        this.insuranceCompanyCode = insuranceCompanyCode;
    }


    /**
     * Gets the listSize value for this ClientInfo.
     * 
     * @return listSize
     */
    public java.lang.Integer getListSize() {
        return listSize;
    }


    /**
     * Sets the listSize value for this ClientInfo.
     * 
     * @param listSize
     */
    public void setListSize(java.lang.Integer listSize) {
        this.listSize = listSize;
    }


    /**
     * Gets the password value for this ClientInfo.
     * 
     * @return password
     */
    public java.lang.String getPassword() {
        return password;
    }


    /**
     * Sets the password value for this ClientInfo.
     * 
     * @param password
     */
    public void setPassword(java.lang.String password) {
        this.password = password;
    }


    /**
     * Gets the requestType value for this ClientInfo.
     * 
     * @return requestType
     */
    public java.lang.String getRequestType() {
        return requestType;
    }


    /**
     * Sets the requestType value for this ClientInfo.
     * 
     * @param requestType
     */
    public void setRequestType(java.lang.String requestType) {
        this.requestType = requestType;
    }


    /**
     * Gets the user value for this ClientInfo.
     * 
     * @return user
     */
    public java.lang.String getUser() {
        return user;
    }


    /**
     * Sets the user value for this ClientInfo.
     * 
     * @param user
     */
    public void setUser(java.lang.String user) {
        this.user = user;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ClientInfo)) return false;
        ClientInfo other = (ClientInfo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.async==null && other.getAsync()==null) || 
             (this.async!=null &&
              this.async.equals(other.getAsync()))) &&
            ((this.batchNo==null && other.getBatchNo()==null) || 
             (this.batchNo!=null &&
              this.batchNo.equals(other.getBatchNo()))) &&
            ((this.dataType==null && other.getDataType()==null) || 
             (this.dataType!=null &&
              this.dataType.equals(other.getDataType()))) &&
            ((this.insuranceCompanyCode==null && other.getInsuranceCompanyCode()==null) || 
             (this.insuranceCompanyCode!=null &&
              this.insuranceCompanyCode.equals(other.getInsuranceCompanyCode()))) &&
            ((this.listSize==null && other.getListSize()==null) || 
             (this.listSize!=null &&
              this.listSize.equals(other.getListSize()))) &&
            ((this.password==null && other.getPassword()==null) || 
             (this.password!=null &&
              this.password.equals(other.getPassword()))) &&
            ((this.requestType==null && other.getRequestType()==null) || 
             (this.requestType!=null &&
              this.requestType.equals(other.getRequestType()))) &&
            ((this.user==null && other.getUser()==null) || 
             (this.user!=null &&
              this.user.equals(other.getUser())));
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
        if (getAsync() != null) {
            _hashCode += getAsync().hashCode();
        }
        if (getBatchNo() != null) {
            _hashCode += getBatchNo().hashCode();
        }
        if (getDataType() != null) {
            _hashCode += getDataType().hashCode();
        }
        if (getInsuranceCompanyCode() != null) {
            _hashCode += getInsuranceCompanyCode().hashCode();
        }
        if (getListSize() != null) {
            _hashCode += getListSize().hashCode();
        }
        if (getPassword() != null) {
            _hashCode += getPassword().hashCode();
        }
        if (getRequestType() != null) {
            _hashCode += getRequestType().hashCode();
        }
        if (getUser() != null) {
            _hashCode += getUser().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ClientInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "clientInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("async");
        elemField.setXmlName(new javax.xml.namespace.QName("", "async"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("batchNo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "batchNo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dataType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dataType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("insuranceCompanyCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "insuranceCompanyCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listSize");
        elemField.setXmlName(new javax.xml.namespace.QName("", "listSize"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("password");
        elemField.setXmlName(new javax.xml.namespace.QName("", "password"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("requestType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "requestType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("user");
        elemField.setXmlName(new javax.xml.namespace.QName("", "user"));
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
