package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import java.util.Collection;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����WfNode�������ڵ㶨�������ݴ��������<br>
 * ������ 2004-08-09 19:54:50.610<br>
 * JToolpad(1.2.12-RC10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class SwfNodeDto extends SwfNodeDtoBase implements Serializable{
    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�WfNodeDto����
     */
    public SwfNodeDto(){
    }

    /** ������ʾ�б�*/
    private Collection nodeList ;
      /** ���Ե��Ⱥ��� */
    private int scheduleID = 0;
    /** ���Ա����� */
    private String lossItemCode = "";
    /** ���Գ��ƺ��� */
    private String lossItemName = "";
    /** �����Ƿ�Ϊ���������� */
    private String insureCarFlag = "";
    
    /** �������ͱ�־ */
    private String typeFlag = "";
    
    
    /** ���Կɲ���/����ļ��𻮷� */
    private String handlerRange = "";
    /** ���Խ����̶� */
    private String exigenceGree = "";
    
    
      /** ���Դ����� */
    private String handleDept = "";
    
    /** ���Դ��������� */
    private String deptName = "";
    
     /** ���Ա������� */
    private String policyNo = "";
    
    /** �������ִ��� */
    private String riskCode = "";

 /** ����ҵ��� */
    private String businessNo = "";
    
     /** ����������������ֵ */
    private String keyIn = "";
    
    
    /**
      * ��ȡ�б�
      * @return �����б�
      */
     public Collection getNodeList(){
       return nodeList;
     }
     /**
      * �����б�
      * @param nodeList �����õ��б�
      */
     public void setNodeList(Collection nodeList) {
       this.nodeList = nodeList;
     }
     
         /**
     * �������Ե��Ⱥ���
     * @param scheduleID �����õ����Ե��Ⱥ����ֵ
     */
    public void setScheduleID(int scheduleID){
        this.scheduleID = scheduleID;
    }

    /**
     * ��ȡ���Ե��Ⱥ���
     * @return ���Ե��Ⱥ����ֵ
     */
    public int getScheduleID(){
        return scheduleID;
    }

    /**
     * �������Ա�����
     * @param lossItemCode �����õ����Ա����ŵ�ֵ
     */
    public void setLossItemCode(String lossItemCode){
        this.lossItemCode = StringUtils.rightTrim(lossItemCode);
    }

    /**
     * ��ȡ���Ա�����
     * @return ���Ա����ŵ�ֵ
     */
    public String getLossItemCode(){
        return lossItemCode;
    }

    /**
     * �������Գ��ƺ���
     * @param lossItemName �����õ����Գ��ƺ����ֵ
     */
    public void setLossItemName(String lossItemName){
        this.lossItemName = StringUtils.rightTrim(lossItemName);
    }

    /**
     * ��ȡ���Գ��ƺ���
     * @return ���Գ��ƺ����ֵ
     */
    public String getLossItemName(){
        return lossItemName;
    }

    /**
     * ���������Ƿ�Ϊ����������
     * @param insureCarFlag �����õ������Ƿ�Ϊ������������ֵ
     */
    public void setInsureCarFlag(String insureCarFlag){
        this.insureCarFlag = StringUtils.rightTrim(insureCarFlag);
    }

    /**
     * ��ȡ�����Ƿ�Ϊ����������
     * @return �����Ƿ�Ϊ������������ֵ
     */
    public String getInsureCarFlag(){
        return insureCarFlag;
    }
     /**
     * �����������ͱ�־
     * @param typeFlag �����õ��������ͱ�־��ֵ
     */
    public void setTypeFlag(String typeFlag){
        this.typeFlag = StringUtils.rightTrim(typeFlag);
    }

    /**
     * ��ȡ�������ͱ�־
     * @return �������ͱ�־��ֵ
     */
    public String getTypeFlag(){
        return typeFlag;
    }
   /**
     * �������Կɲ���/����ļ���
     * @param handlerRange �����õ����Կɲ���/����ļ����ֵ
     */
    public void setHandlerRange(String handlerRange){
        this.handlerRange = StringUtils.rightTrim(handlerRange);
    }

    /**
     * ��ȡ���Կɲ���/����ļ���
     * @return ���Կɲ���/����ļ����ֵ
     */
    public String getHandlerRange(){
        return handlerRange;
    }

    /**
     * �������Խ����̶�
     * @param exigenceGree �����õ����Խ����̶ȵ�ֵ
     */
    public void setExigenceGree(String exigenceGree){
        this.exigenceGree = StringUtils.rightTrim(exigenceGree);
    }

    /**
     * ��ȡ���Խ����̶�
     * @return ���Խ����̶ȵ�ֵ
     */
    public String getExigenceGree(){
        return exigenceGree;
    }
    
      /**
     * �������Դ�����
     * @param handleDept �����õ����Դ����ŵ�ֵ
     */
    public void setHandleDept(String handleDept){
        this.handleDept = StringUtils.rightTrim(handleDept);
    }

    /**
     * ��ȡ���Դ�����
     * @return ���Դ����ŵ�ֵ
     */
    public String getHandleDept(){
        return handleDept;
    }
    
    /**
     * �������Դ���������
     * @param DeptName �����õ����Դ��������Ƶ�ֵ
     */
    public void setDeptName(String deptName){
        this.deptName = StringUtils.rightTrim(deptName);
    }

    /**
     * ��ȡ���Դ���������
     * @return ���Դ��������Ƶ�ֵ
     */
    public String getDeptName(){
        return deptName;
    }
    
      /**
     * �������Ա�������
     * @param policyNo �����õ����Ա��������ֵ
     */
    public void setPolicyNo(String policyNo){
        this.policyNo = StringUtils.rightTrim(policyNo);
    }

    /**
     * ��ȡ���Ա�������
     * @return ���Ա��������ֵ
     */
    public String getPolicyNo(){
        return policyNo;
    }
    
     /**
     * �����������ִ���
     * @param riskCode �����õ��������ִ����ֵ
     */
    public void setRiskCode(String riskCode){
        this.riskCode = StringUtils.rightTrim(riskCode);
    }

    /**
     * ��ȡ�������ִ���
     * @return �������ִ����ֵ
     */
    public String getRiskCode(){
        return riskCode;
    }
    
    
      /**
     * ��������������������ֵ
     * @param keyIn �����õ�����������������ֵ��ֵ
     */
    public void setKeyIn(String keyIn){
        this.keyIn = StringUtils.rightTrim(keyIn);
    }

    /**
     * ��ȡ����������������ֵ
     * @return ����������������ֵ��ֵ
     */
    public String getKeyIn(){
        return keyIn;
    }
    
    
      /**
     * ��������ҵ���
     * @param businessNo �����õ�����ҵ��ŵ�ֵ
     */
    public void setBusinessNo(String businessNo){
        this.businessNo = StringUtils.rightTrim(businessNo);
    }

    /**
     * ��ȡ����ҵ���
     * @return ����ҵ��ŵ�ֵ
     */
    public String getBusinessNo(){
        return businessNo;
    }


}
