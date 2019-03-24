/**
 * EndorsementDto.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.sinosoft.aip.webservice.server;

public class EndorsementDto  implements java.io.Serializable {
    private com.sinosoft.aip.webservice.server.ApplicantInfo[] applicantInfoList;

    private com.sinosoft.aip.webservice.server.EndorsementInfo endorsementInfo;

    private com.sinosoft.aip.webservice.server.PolicyFarmerInfo[] farmerInfoList;

    private com.sinosoft.aip.webservice.server.InsurantInfo[] insurantInfoList;

    private com.sinosoft.aip.webservice.server.InsuredObject[] insuredObjectList;

    private com.sinosoft.aip.webservice.server.OrganizerInfo[] organizerInfoList;

    private com.sinosoft.aip.webservice.server.PolicyMainInfo policyMainInfo;

    private com.sinosoft.aip.webservice.server.PremiumInfo[] premiumInfoList;

    private com.sinosoft.aip.webservice.server.ProductInfo[] productInfoList;

    public EndorsementDto() {
    }

    public EndorsementDto(
           com.sinosoft.aip.webservice.server.ApplicantInfo[] applicantInfoList,
           com.sinosoft.aip.webservice.server.EndorsementInfo endorsementInfo,
           com.sinosoft.aip.webservice.server.PolicyFarmerInfo[] farmerInfoList,
           com.sinosoft.aip.webservice.server.InsurantInfo[] insurantInfoList,
           com.sinosoft.aip.webservice.server.InsuredObject[] insuredObjectList,
           com.sinosoft.aip.webservice.server.OrganizerInfo[] organizerInfoList,
           com.sinosoft.aip.webservice.server.PolicyMainInfo policyMainInfo,
           com.sinosoft.aip.webservice.server.PremiumInfo[] premiumInfoList,
           com.sinosoft.aip.webservice.server.ProductInfo[] productInfoList) {
           this.applicantInfoList = applicantInfoList;
           this.endorsementInfo = endorsementInfo;
           this.farmerInfoList = farmerInfoList;
           this.insurantInfoList = insurantInfoList;
           this.insuredObjectList = insuredObjectList;
           this.organizerInfoList = organizerInfoList;
           this.policyMainInfo = policyMainInfo;
           this.premiumInfoList = premiumInfoList;
           this.productInfoList = productInfoList;
    }


    /**
     * Gets the applicantInfoList value for this EndorsementDto.
     * 
     * @return applicantInfoList
     */
    public com.sinosoft.aip.webservice.server.ApplicantInfo[] getApplicantInfoList() {
        return applicantInfoList;
    }


    /**
     * Sets the applicantInfoList value for this EndorsementDto.
     * 
     * @param applicantInfoList
     */
    public void setApplicantInfoList(com.sinosoft.aip.webservice.server.ApplicantInfo[] applicantInfoList) {
        this.applicantInfoList = applicantInfoList;
    }

    public com.sinosoft.aip.webservice.server.ApplicantInfo getApplicantInfoList(int i) {
        return this.applicantInfoList[i];
    }

    public void setApplicantInfoList(int i, com.sinosoft.aip.webservice.server.ApplicantInfo _value) {
        this.applicantInfoList[i] = _value;
    }


    /**
     * Gets the endorsementInfo value for this EndorsementDto.
     * 
     * @return endorsementInfo
     */
    public com.sinosoft.aip.webservice.server.EndorsementInfo getEndorsementInfo() {
        return endorsementInfo;
    }


    /**
     * Sets the endorsementInfo value for this EndorsementDto.
     * 
     * @param endorsementInfo
     */
    public void setEndorsementInfo(com.sinosoft.aip.webservice.server.EndorsementInfo endorsementInfo) {
        this.endorsementInfo = endorsementInfo;
    }


    /**
     * Gets the farmerInfoList value for this EndorsementDto.
     * 
     * @return farmerInfoList
     */
    public com.sinosoft.aip.webservice.server.PolicyFarmerInfo[] getFarmerInfoList() {
        return farmerInfoList;
    }


    /**
     * Sets the farmerInfoList value for this EndorsementDto.
     * 
     * @param farmerInfoList
     */
    public void setFarmerInfoList(com.sinosoft.aip.webservice.server.PolicyFarmerInfo[] farmerInfoList) {
        this.farmerInfoList = farmerInfoList;
    }

    public com.sinosoft.aip.webservice.server.PolicyFarmerInfo getFarmerInfoList(int i) {
        return this.farmerInfoList[i];
    }

    public void setFarmerInfoList(int i, com.sinosoft.aip.webservice.server.PolicyFarmerInfo _value) {
        this.farmerInfoList[i] = _value;
    }


    /**
     * Gets the insurantInfoList value for this EndorsementDto.
     * 
     * @return insurantInfoList
     */
    public com.sinosoft.aip.webservice.server.InsurantInfo[] getInsurantInfoList() {
        return insurantInfoList;
    }


    /**
     * Sets the insurantInfoList value for this EndorsementDto.
     * 
     * @param insurantInfoList
     */
    public void setInsurantInfoList(com.sinosoft.aip.webservice.server.InsurantInfo[] insurantInfoList) {
        this.insurantInfoList = insurantInfoList;
    }

    public com.sinosoft.aip.webservice.server.InsurantInfo getInsurantInfoList(int i) {
        return this.insurantInfoList[i];
    }

    public void setInsurantInfoList(int i, com.sinosoft.aip.webservice.server.InsurantInfo _value) {
        this.insurantInfoList[i] = _value;
    }


    /**
     * Gets the insuredObjectList value for this EndorsementDto.
     * 
     * @return insuredObjectList
     */
    public com.sinosoft.aip.webservice.server.InsuredObject[] getInsuredObjectList() {
        return insuredObjectList;
    }


    /**
     * Sets the insuredObjectList value for this EndorsementDto.
     * 
     * @param insuredObjectList
     */
    public void setInsuredObjectList(com.sinosoft.aip.webservice.server.InsuredObject[] insuredObjectList) {
        this.insuredObjectList = insuredObjectList;
    }

    public com.sinosoft.aip.webservice.server.InsuredObject getInsuredObjectList(int i) {
        return this.insuredObjectList[i];
    }

    public void setInsuredObjectList(int i, com.sinosoft.aip.webservice.server.InsuredObject _value) {
        this.insuredObjectList[i] = _value;
    }


    /**
     * Gets the organizerInfoList value for this EndorsementDto.
     * 
     * @return organizerInfoList
     */
    public com.sinosoft.aip.webservice.server.OrganizerInfo[] getOrganizerInfoList() {
        return organizerInfoList;
    }


    /**
     * Sets the organizerInfoList value for this EndorsementDto.
     * 
     * @param organizerInfoList
     */
    public void setOrganizerInfoList(com.sinosoft.aip.webservice.server.OrganizerInfo[] organizerInfoList) {
        this.organizerInfoList = organizerInfoList;
    }

    public com.sinosoft.aip.webservice.server.OrganizerInfo getOrganizerInfoList(int i) {
        return this.organizerInfoList[i];
    }

    public void setOrganizerInfoList(int i, com.sinosoft.aip.webservice.server.OrganizerInfo _value) {
        this.organizerInfoList[i] = _value;
    }


    /**
     * Gets the policyMainInfo value for this EndorsementDto.
     * 
     * @return policyMainInfo
     */
    public com.sinosoft.aip.webservice.server.PolicyMainInfo getPolicyMainInfo() {
        return policyMainInfo;
    }


    /**
     * Sets the policyMainInfo value for this EndorsementDto.
     * 
     * @param policyMainInfo
     */
    public void setPolicyMainInfo(com.sinosoft.aip.webservice.server.PolicyMainInfo policyMainInfo) {
        this.policyMainInfo = policyMainInfo;
    }


    /**
     * Gets the premiumInfoList value for this EndorsementDto.
     * 
     * @return premiumInfoList
     */
    public com.sinosoft.aip.webservice.server.PremiumInfo[] getPremiumInfoList() {
        return premiumInfoList;
    }


    /**
     * Sets the premiumInfoList value for this EndorsementDto.
     * 
     * @param premiumInfoList
     */
    public void setPremiumInfoList(com.sinosoft.aip.webservice.server.PremiumInfo[] premiumInfoList) {
        this.premiumInfoList = premiumInfoList;
    }

    public com.sinosoft.aip.webservice.server.PremiumInfo getPremiumInfoList(int i) {
        return this.premiumInfoList[i];
    }

    public void setPremiumInfoList(int i, com.sinosoft.aip.webservice.server.PremiumInfo _value) {
        this.premiumInfoList[i] = _value;
    }


    /**
     * Gets the productInfoList value for this EndorsementDto.
     * 
     * @return productInfoList
     */
    public com.sinosoft.aip.webservice.server.ProductInfo[] getProductInfoList() {
        return productInfoList;
    }


    /**
     * Sets the productInfoList value for this EndorsementDto.
     * 
     * @param productInfoList
     */
    public void setProductInfoList(com.sinosoft.aip.webservice.server.ProductInfo[] productInfoList) {
        this.productInfoList = productInfoList;
    }

    public com.sinosoft.aip.webservice.server.ProductInfo getProductInfoList(int i) {
        return this.productInfoList[i];
    }

    public void setProductInfoList(int i, com.sinosoft.aip.webservice.server.ProductInfo _value) {
        this.productInfoList[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof EndorsementDto)) return false;
        EndorsementDto other = (EndorsementDto) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.applicantInfoList==null && other.getApplicantInfoList()==null) || 
             (this.applicantInfoList!=null &&
              java.util.Arrays.equals(this.applicantInfoList, other.getApplicantInfoList()))) &&
            ((this.endorsementInfo==null && other.getEndorsementInfo()==null) || 
             (this.endorsementInfo!=null &&
              this.endorsementInfo.equals(other.getEndorsementInfo()))) &&
            ((this.farmerInfoList==null && other.getFarmerInfoList()==null) || 
             (this.farmerInfoList!=null &&
              java.util.Arrays.equals(this.farmerInfoList, other.getFarmerInfoList()))) &&
            ((this.insurantInfoList==null && other.getInsurantInfoList()==null) || 
             (this.insurantInfoList!=null &&
              java.util.Arrays.equals(this.insurantInfoList, other.getInsurantInfoList()))) &&
            ((this.insuredObjectList==null && other.getInsuredObjectList()==null) || 
             (this.insuredObjectList!=null &&
              java.util.Arrays.equals(this.insuredObjectList, other.getInsuredObjectList()))) &&
            ((this.organizerInfoList==null && other.getOrganizerInfoList()==null) || 
             (this.organizerInfoList!=null &&
              java.util.Arrays.equals(this.organizerInfoList, other.getOrganizerInfoList()))) &&
            ((this.policyMainInfo==null && other.getPolicyMainInfo()==null) || 
             (this.policyMainInfo!=null &&
              this.policyMainInfo.equals(other.getPolicyMainInfo()))) &&
            ((this.premiumInfoList==null && other.getPremiumInfoList()==null) || 
             (this.premiumInfoList!=null &&
              java.util.Arrays.equals(this.premiumInfoList, other.getPremiumInfoList()))) &&
            ((this.productInfoList==null && other.getProductInfoList()==null) || 
             (this.productInfoList!=null &&
              java.util.Arrays.equals(this.productInfoList, other.getProductInfoList())));
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
        if (getApplicantInfoList() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getApplicantInfoList());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getApplicantInfoList(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getEndorsementInfo() != null) {
            _hashCode += getEndorsementInfo().hashCode();
        }
        if (getFarmerInfoList() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getFarmerInfoList());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getFarmerInfoList(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getInsurantInfoList() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getInsurantInfoList());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getInsurantInfoList(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getInsuredObjectList() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getInsuredObjectList());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getInsuredObjectList(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getOrganizerInfoList() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOrganizerInfoList());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOrganizerInfoList(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getPolicyMainInfo() != null) {
            _hashCode += getPolicyMainInfo().hashCode();
        }
        if (getPremiumInfoList() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPremiumInfoList());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPremiumInfoList(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getProductInfoList() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getProductInfoList());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getProductInfoList(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(EndorsementDto.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "endorsementDto"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("applicantInfoList");
        elemField.setXmlName(new javax.xml.namespace.QName("", "applicantInfoList"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "applicantInfo"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("endorsementInfo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "endorsementInfo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "endorsementInfo"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("farmerInfoList");
        elemField.setXmlName(new javax.xml.namespace.QName("", "farmerInfoList"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "policyFarmerInfo"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("insurantInfoList");
        elemField.setXmlName(new javax.xml.namespace.QName("", "insurantInfoList"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "insurantInfo"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("insuredObjectList");
        elemField.setXmlName(new javax.xml.namespace.QName("", "insuredObjectList"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "insuredObject"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("organizerInfoList");
        elemField.setXmlName(new javax.xml.namespace.QName("", "organizerInfoList"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "organizerInfo"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("policyMainInfo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "policyMainInfo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "policyMainInfo"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("premiumInfoList");
        elemField.setXmlName(new javax.xml.namespace.QName("", "premiumInfoList"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "premiumInfo"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("productInfoList");
        elemField.setXmlName(new javax.xml.namespace.QName("", "productInfoList"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://server.webservice.aip.sinosoft.com/", "productInfo"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
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
