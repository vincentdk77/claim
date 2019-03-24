package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prpdagent�����˴��������ݴ���������<br>
 * ������ 2004-4-5 15:33:39<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDagentDtoBase implements Serializable{
    /** ���Դ����˴��� */
    private String agentCode = "";
    /** ���Դ��������� */
    private String agentName = "";
    /** ���Դ����˵�ַ */
    private String addressName = "";
    /** ������������ */
    private String postCode = "";
    /** ���Դ��������� */
    private String agentType = "";
    /** �������֤�� */
    private String permitNo = "";
    /** ������ϵ�� */
    private String linkerName = "";
    /** ���Ժ�ͬ�� */
    private DateTime bargainDate = new DateTime();
    /** ���Ե绰 */
    private String phoneNumber = "";
    /** ���Դ��� */
    private String faxNumber = "";
    /** ���Թ����������� */
    private String comCode = "";
    /** �����ϼ������˴��� */
    private String upperAgentCode = "";
    /** �����µĴ����˴��� */
    private String newAgentCode = "";
    /** ����Ч��״̬(0ʧЧ/1��Ч) */
    private String validStatus = "";
    /** ����ר�����(��Ӧ��ƿ�Ŀ) */
    private String articleCode = "";
    /** ���Ա�־�ֶ� */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpDagentDtoBase����
     */
    public PrpDagentDtoBase(){
    }

    /**
     * �������Դ����˴���
     * @param agentCode �����õ����Դ����˴����ֵ
     */
    public void setAgentCode(String agentCode){
        this.agentCode = StringUtils.rightTrim(agentCode);
    }

    /**
     * ��ȡ���Դ����˴���
     * @return ���Դ����˴����ֵ
     */
    public String getAgentCode(){
        return agentCode;
    }

    /**
     * �������Դ���������
     * @param agentName �����õ����Դ��������Ƶ�ֵ
     */
    public void setAgentName(String agentName){
        this.agentName = StringUtils.rightTrim(agentName);
    }

    /**
     * ��ȡ���Դ���������
     * @return ���Դ��������Ƶ�ֵ
     */
    public String getAgentName(){
        return agentName;
    }

    /**
     * �������Դ����˵�ַ
     * @param addressName �����õ����Դ����˵�ַ��ֵ
     */
    public void setAddressName(String addressName){
        this.addressName = StringUtils.rightTrim(addressName);
    }

    /**
     * ��ȡ���Դ����˵�ַ
     * @return ���Դ����˵�ַ��ֵ
     */
    public String getAddressName(){
        return addressName;
    }

    /**
     * ����������������
     * @param postCode �����õ��������������ֵ
     */
    public void setPostCode(String postCode){
        this.postCode = StringUtils.rightTrim(postCode);
    }

    /**
     * ��ȡ������������
     * @return �������������ֵ
     */
    public String getPostCode(){
        return postCode;
    }

    /**
     * �������Դ���������
     * @param agentType �����õ����Դ��������͵�ֵ
     */
    public void setAgentType(String agentType){
        this.agentType = StringUtils.rightTrim(agentType);
    }

    /**
     * ��ȡ���Դ���������
     * @return ���Դ��������͵�ֵ
     */
    public String getAgentType(){
        return agentType;
    }

    /**
     * �����������֤��
     * @param permitNo �����õ��������֤�ŵ�ֵ
     */
    public void setPermitNo(String permitNo){
        this.permitNo = StringUtils.rightTrim(permitNo);
    }

    /**
     * ��ȡ�������֤��
     * @return �������֤�ŵ�ֵ
     */
    public String getPermitNo(){
        return permitNo;
    }

    /**
     * ����������ϵ��
     * @param linkerName �����õ�������ϵ�˵�ֵ
     */
    public void setLinkerName(String linkerName){
        this.linkerName = StringUtils.rightTrim(linkerName);
    }

    /**
     * ��ȡ������ϵ��
     * @return ������ϵ�˵�ֵ
     */
    public String getLinkerName(){
        return linkerName;
    }

    /**
     * �������Ժ�ͬ��
     * @param bargainDate �����õ����Ժ�ͬ�ڵ�ֵ
     */
    public void setBargainDate(DateTime bargainDate){
        this.bargainDate = bargainDate;
    }

    /**
     * ��ȡ���Ժ�ͬ��
     * @return ���Ժ�ͬ�ڵ�ֵ
     */
    public DateTime getBargainDate(){
        return bargainDate;
    }

    /**
     * �������Ե绰
     * @param phoneNumber �����õ����Ե绰��ֵ
     */
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = StringUtils.rightTrim(phoneNumber);
    }

    /**
     * ��ȡ���Ե绰
     * @return ���Ե绰��ֵ
     */
    public String getPhoneNumber(){
        return phoneNumber;
    }

    /**
     * �������Դ���
     * @param faxNumber �����õ����Դ����ֵ
     */
    public void setFaxNumber(String faxNumber){
        this.faxNumber = StringUtils.rightTrim(faxNumber);
    }

    /**
     * ��ȡ���Դ���
     * @return ���Դ����ֵ
     */
    public String getFaxNumber(){
        return faxNumber;
    }

    /**
     * �������Թ�����������
     * @param comCode �����õ����Թ������������ֵ
     */
    public void setComCode(String comCode){
        this.comCode = StringUtils.rightTrim(comCode);
    }

    /**
     * ��ȡ���Թ�����������
     * @return ���Թ������������ֵ
     */
    public String getComCode(){
        return comCode;
    }

    /**
     * ���������ϼ������˴���
     * @param upperAgentCode �����õ������ϼ������˴����ֵ
     */
    public void setUpperAgentCode(String upperAgentCode){
        this.upperAgentCode = StringUtils.rightTrim(upperAgentCode);
    }

    /**
     * ��ȡ�����ϼ������˴���
     * @return �����ϼ������˴����ֵ
     */
    public String getUpperAgentCode(){
        return upperAgentCode;
    }

    /**
     * ���������µĴ����˴���
     * @param newAgentCode �����õ������µĴ����˴����ֵ
     */
    public void setNewAgentCode(String newAgentCode){
        this.newAgentCode = StringUtils.rightTrim(newAgentCode);
    }

    /**
     * ��ȡ�����µĴ����˴���
     * @return �����µĴ����˴����ֵ
     */
    public String getNewAgentCode(){
        return newAgentCode;
    }

    /**
     * ��������Ч��״̬(0ʧЧ/1��Ч)
     * @param validStatus �����õ�����Ч��״̬(0ʧЧ/1��Ч)��ֵ
     */
    public void setValidStatus(String validStatus){
        this.validStatus = StringUtils.rightTrim(validStatus);
    }

    /**
     * ��ȡ����Ч��״̬(0ʧЧ/1��Ч)
     * @return ����Ч��״̬(0ʧЧ/1��Ч)��ֵ
     */
    public String getValidStatus(){
        return validStatus;
    }

    /**
     * ��������ר�����(��Ӧ��ƿ�Ŀ)
     * @param articleCode �����õ�����ר�����(��Ӧ��ƿ�Ŀ)��ֵ
     */
    public void setArticleCode(String articleCode){
        this.articleCode = StringUtils.rightTrim(articleCode);
    }

    /**
     * ��ȡ����ר�����(��Ӧ��ƿ�Ŀ)
     * @return ����ר�����(��Ӧ��ƿ�Ŀ)��ֵ
     */
    public String getArticleCode(){
        return articleCode;
    }

    /**
     * �������Ա�־�ֶ�
     * @param flag �����õ����Ա�־�ֶε�ֵ
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * ��ȡ���Ա�־�ֶ�
     * @return ���Ա�־�ֶε�ֵ
     */
    public String getFlag(){
        return flag;
    }
}
